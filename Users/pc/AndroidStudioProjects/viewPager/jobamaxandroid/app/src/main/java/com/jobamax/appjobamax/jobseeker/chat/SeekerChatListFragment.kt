package com.jobamax.appjobamax.jobseeker.chat

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentSeekerChatListBinding
import com.jobamax.appjobamax.databinding.ItemJobSeekerChatListBinding
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.dialog.DialogJobSeekerThreadFilter
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.model.ChatThread
import com.jobamax.appjobamax.model.Recruiter
import com.jobamax.appjobamax.preference.getUserId
import com.jobamax.appjobamax.singletons.MyParseLiveQueryClient
import com.jobamax.appjobamax.util.loadImageFromUrl
import com.parse.ParseObject
import com.parse.ParseQuery
import com.parse.livequery.SubscriptionHandling
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SeekerChatListFragment : BaseFragment() {
    lateinit var binding: FragmentSeekerChatListBinding

    val viewModel: SeekerHomeViewModel by activityViewModels()

    private lateinit var subscriptionHandling: SubscriptionHandling<ParseObject>
    lateinit var chatThreadAdapter: SeekerChatThreadAdapter

    var appliedFilter: SeekerChatListFilter = SeekerChatListFilter.All

    var chatThreadList: ArrayList<ChatThread> = arrayListOf()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerChatListBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        setViewModelObserver()
        if (viewModel.chatThreadList.value.isNullOrEmpty()){
            getAllChatRecruiter()
        }else{
            updateChatThreadList()
        }
        setParseLiveQuery()
        setChatThreadAdapter()
    }

    private fun setViewModelObserver() {
        viewModel.chatThreadList.observe(viewLifecycleOwner){
            updateChatThreadList()
        }
    }

    private fun setChatThreadAdapter() {
         chatThreadAdapter = SeekerChatThreadAdapter(arrayListOf())
        binding.rvChatList.adapter = chatThreadAdapter
        chatThreadAdapter.onChatThreadClick = { chatThread ->
            val bundle = Bundle()
            bundle.putSerializable("chat_thread", chatThread)
            bundle.putParcelable(ParseTableFields.RECRUITER.value, chatThread.recruiterParseObject)
            val intent = Intent(requireContext(), SeekerChatBoardActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
         }
    }

    private fun getAllChatRecruiter() {
        val jobSeekerPQ = ParseQuery<ParseObject>(ParseTableName.JOB_SEEKER.value)
        jobSeekerPQ.whereEqualTo(ParseTableFields.JOB_SEEKER_ID.value, requireContext().getUserId())
        val chatThreadPQ = ParseQuery<ParseObject>(ParseTableName.CHAT_THREAD.value)
        chatThreadPQ.whereMatchesQuery(ParseTableFields.JOB_SEEKER.value, jobSeekerPQ)
        chatThreadPQ.include(ParseTableFields.RECRUITER.value)
        chatThreadPQ.include(ParseTableFields.RECRUITER.value+"."+ParseTableFields.COMPANY.value)
        chatThreadPQ.include(ParseTableFields.JOB_SEEKER.value)
        chatThreadPQ.findInBackground { result, e ->
            if (e != null){
                log("${e.message.toString()} Something went wrong")
            }else{
                val list = arrayListOf<ChatThread>()
                result.forEach { list.add(ChatThread(it)) }
                viewModel.setChatThreadList(list)
            }
        }
    }

    private fun updateChatThreadList() {
        viewModel.chatThreadList.value?.let {
            chatThreadList.clear()
            it.forEach { ct -> chatThreadList.add((ct)) }
            update()
        }
    }

    private fun update() {
        val filteredThreadList = arrayListOf<ChatThread>()
        when(appliedFilter){
            SeekerChatListFilter.All -> { chatThreadList.forEach { filteredThreadList.add(it) } }
            SeekerChatListFilter.UNOPENED -> { chatThreadList.forEach {
                if (it.jsFilter == SeekerChatListFilter.UNOPENED.value){
                    filteredThreadList.add(it)
                }
            } }
            SeekerChatListFilter.RECENT -> {
                chatThreadList.forEach {
                    val diff = System.currentTimeMillis() - it.chatThreadParseObject!!.getDate("updatedAt")!!.time
                    if (604800000 > diff) {
                        filteredThreadList.add(it)
                    }
                }
            }
        }
        chatThreadAdapter.submitList(filteredThreadList)
        chatThreadAdapter.notifyDataSetChanged()
    }

    private fun setParseLiveQuery() {
        val chatThreadPQ = ParseQuery<ParseObject>(ParseTableName.CHAT_THREAD.value)
        chatThreadPQ.whereEqualTo(ParseTableFields.JOB_SEEKER_ID.value, requireContext().getUserId())
        subscriptionHandling = MyParseLiveQueryClient.parseLiveQueryClient.subscribe(chatThreadPQ)
        subscriptionHandling.handleSubscribe { subscriptionHandling.handleEvent(SubscriptionHandling.Event.CREATE) { _: ParseQuery<ParseObject?>?, result: ParseObject? ->
                result?.let {
                    val chatThreadPQ2 = ParseQuery<ParseObject>(ParseTableName.CHAT_THREAD.value)
                    chatThreadPQ2.whereEqualTo(ParseTableFields.THREAD_ID.value, ChatThread(result).threadId)
                    chatThreadPQ2.include(ParseTableFields.RECRUITER.value)
                    chatThreadPQ2.include(ParseTableFields.RECRUITER.value+"."+ParseTableFields.COMPANY.value)
                    chatThreadPQ2.include(ParseTableFields.JOB_SEEKER.value)
                    chatThreadPQ2.getFirstInBackground { result2, e ->
                        if (e != null) {
                            toast( "${e.message.toString()} Something went wrong")
                        }
                        if (result2 != null) {
                            val newChatThread = ChatThread(result2)
                            viewModel.chatThreadList.value?.let {
                                val list = if (it.isNotEmpty()) {
                                    it as ArrayList<ChatThread>
                                }else{
                                    arrayListOf()
                                }
                                list.add(newChatThread)
                                lifecycleScope.launch(Dispatchers.Main){
                                    viewModel.setChatThreadList(list)
                                }
                            }
                        }
                    }
                }
            }
            subscriptionHandling.handleEvent(SubscriptionHandling.Event.DELETE) { _: ParseQuery<ParseObject?>?, result: ParseObject? ->

            }
            subscriptionHandling.handleEvent(SubscriptionHandling.Event.UPDATE) { _: ParseQuery<ParseObject?>?, result: ParseObject? ->
                log(" ${result?.get("latestText")}")
                result?.let { it1 ->
                    val updatedChatThread = ChatThread(it1)
                    viewModel.chatThreadList.value?.let { it ->
                        it.find { it.threadId == updatedChatThread.threadId }?.let { ct ->
                            val index = chatThreadAdapter.list.indexOf(ct)
                            ct.latestText = updatedChatThread.latestText
                            lifecycleScope.launch(Dispatchers.Main){
                                chatThreadAdapter.notifyItemChanged(index)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun setClickListeners() {
        binding.ivJobSeekerFilter.setOnClickListener {
            val filterDialog = DialogJobSeekerThreadFilter(requireActivity(), appliedFilter)
            filterDialog.onFilterOptionClick = {
                appliedFilter = it
            }
            val window: Window? = filterDialog.window
            window?.let {
                val wlp = it.attributes
                wlp.gravity = Gravity.TOP
                it.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                it.attributes = wlp
            }
            filterDialog.show()
        }
    }


    enum class SeekerChatListFilter(val value: Int){
        All(0),
        UNOPENED(1),
        RECENT(2)
    }

}

class SeekerChatThreadAdapter(var list: ArrayList<ChatThread>) : RecyclerView.Adapter<SeekerChatThreadAdapter.ViewHolder>() {
    var onChatThreadClick: (ChatThread) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemJobSeekerChatListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chatThreadItem = list[position]
        holder.binding.apply {
            val recruiter =  chatThreadItem.recruiterParseObject?.let { Recruiter(it) }
            recruiter?.let {
                this.tvRecruiterName.text = "${recruiter.firstName} ${recruiter.lastName}"
                loadImageFromUrl(this.civUser, recruiter.profilePicUrl, R.drawable.default_user_img)
                recruiter.company?.let {
                    this.tvCompanyName.text = it.get(ParseTableFields.NAME.value).toString()
                }
            }
            this.tvJobTitle.text = chatThreadItem.jobTitle
            this.tvLatestMessage.text = chatThreadItem.latestText
            this.clChatThread.setOnClickListener { onChatThreadClick(chatThreadItem) }
        }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(chatThreadList: ArrayList<ChatThread>) {
        list = chatThreadList
    }

    class ViewHolder(val binding: ItemJobSeekerChatListBinding) : RecyclerView.ViewHolder(binding.root)
}