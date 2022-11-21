package com.jobamax.appjobamax.jobseeker.search

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentSeekerLearnJobCardSwipingDialogBinding
import com.jobamax.appjobamax.databinding.ItemLearnJobCardSwipingBinding
import com.jobamax.appjobamax.enums.LearnSwipeCardName
import com.jobamax.appjobamax.jobseeker.model.SearchJobCardSwipingTutorial
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.Direction
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting


const val SWIPE_LEFT = 1
const val SWIPE_TOP = 2
const val SWIPE_RIGHT = 3
class SeekerLearnJobCardSwipingDialogFragment : DialogFragment() {
     lateinit var binding: FragmentSeekerLearnJobCardSwipingDialogBinding

     var onFinish: () -> Unit = {}

    lateinit var adapter: SeekerLearnJobCardSwipingAdapter
    lateinit var cardStackLayoutManager: CardStackLayoutManager
    lateinit var cardStackListener: CardStackListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerLearnJobCardSwipingDialogBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        setCardStackListener()
        setCardStackView()

    }

    private fun setClickListeners() {

    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.apply {
            dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

    private fun setCardStackView() {
        adapter = SeekerLearnJobCardSwipingAdapter(SearchJobCardSwipingTutorial.getSearchJobCardSwipingTutorial(), requireContext())
        cardStackLayoutManager = CardStackLayoutManager(requireContext(), cardStackListener)
        cardStackLayoutManager.setDirections(listOf(Direction.Left, Direction.Top, Direction.Right))
        cardStackLayoutManager.setSwipeThreshold(0.4f)
        cardStackLayoutManager.setOverlayInterpolator(LinearInterpolator())
        cardStackLayoutManager.setCanScrollHorizontal(false)
        cardStackLayoutManager.setCanScrollVertical(false)
        binding.csvJob.layoutManager = cardStackLayoutManager
        binding.csvJob.adapter = adapter
        adapter.onSwipeClick = {
            when(it){
                SWIPE_LEFT -> {
                    val setting = SwipeAnimationSetting.Builder().setDirection(Direction.Left).setDuration(200).setInterpolator(AccelerateInterpolator()).build()
                    cardStackLayoutManager.setSwipeAnimationSetting(setting)
                    binding.csvJob.swipe()
                }
                SWIPE_TOP -> {
                    val setting = SwipeAnimationSetting.Builder().setDirection(Direction.Top).setDuration(200).setInterpolator(AccelerateInterpolator()).build()
                    cardStackLayoutManager.setSwipeAnimationSetting(setting)
                    binding.csvJob.swipe()
                }
                SWIPE_RIGHT -> {
                    val setting = SwipeAnimationSetting.Builder().setDirection(Direction.Right).setDuration(200).setInterpolator(AccelerateInterpolator()).build()
                    cardStackLayoutManager.setSwipeAnimationSetting(setting)
                    binding.csvJob.swipe()
                }
                else -> {
                    onFinish()
                    dismiss()
                }
            }
        }
    }


    private fun setCardStackListener() {
        cardStackListener = object : CardStackListener {
            override fun onCardDragging(direction: Direction?, ratio: Float) {}
            override fun onCardSwiped(direction: Direction?) {}
            override fun onCardRewound() {}
            override fun onCardCanceled() {}
            override fun onCardAppeared(view: View?, position: Int) {}
            override fun onCardDisappeared(view: View?, position: Int) {}
        }
    }


}


class SeekerLearnJobCardSwipingAdapter(
    var list: ArrayList<SearchJobCardSwipingTutorial>,
   val requireContext: Context
)  : RecyclerView.Adapter<SeekerLearnJobCardSwipingAdapter.ViewHolder>(){
    var onSwipeClick: (Int) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemLearnJobCardSwipingBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.apply {
            this.tvTitle.text = item.title
            when(item.cardName){
                LearnSwipeCardName.A.value ->{
                    this.tv1.text = "Seulement pour les offres"
                    this.ll1.visibility = View.GONE
                    this.tv3.visibility = View.GONE
                }
                LearnSwipeCardName.B.value ->{
                    this.tv1.text = "Toutes les offres qui n’ont\n pas la mention"
                    this.iv1.visibility = View.GONE
                    this.tv2.text = "sont enregistrées"
                    this.tv3.text = "dans ta Wishlist."
                }
                LearnSwipeCardName.C.value ->{
                    this.tv1.text = "Envoie les offres qui pourraient correspondre à tes potes !"
                    this.iv1.visibility = View.GONE
                    this.ll1.visibility = View.GONE
                    this.tv3.visibility = View.GONE
                }
                LearnSwipeCardName.D.value ->{
                    this.tv1.text = "Tu pourras toujours revenir en arrière en appuyant sur le bouton retour si tu changes d’avis."
                    this.ll1.visibility = View.GONE
                    this.iv1.setImageDrawable(requireContext.resources.getDrawable(R.drawable.ic_load_yellow, null))
                    this.tv3.text = item.description
                    this.tv3.visibility = View.GONE
                }
                LearnSwipeCardName.E.value ->{
                    this.tv1.text = "On te récompense de tes succès ! Reçois une masterclass exclusive produite en partenariat avec les meilleurs speakers au monde. "
                    this.ll1.visibility = View.GONE
                    this.tv3.visibility = View.GONE
                    this.iv1.visibility = View.GONE
                }
            }
            this.btnSwipeAction.text = item.action
        }
        holder.binding.btnSwipeAction.setOnClickListener {
            onSwipeClick(item.actionType)
        }
    }
    override fun getItemCount(): Int = list.size
    class ViewHolder(val binding: ItemLearnJobCardSwipingBinding) : RecyclerView.ViewHolder(binding.root)
}