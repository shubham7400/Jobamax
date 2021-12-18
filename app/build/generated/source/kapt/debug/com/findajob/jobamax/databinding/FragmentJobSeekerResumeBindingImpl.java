package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentJobSeekerResumeBindingImpl extends FragmentJobSeekerResumeBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.cl_action_bar, 6);
        sViewsWithIds.put(R.id.cl_main_body, 7);
        sViewsWithIds.put(R.id.sv_main_body, 8);
        sViewsWithIds.put(R.id.tv_educations_label, 9);
        sViewsWithIds.put(R.id.educationRecycler, 10);
        sViewsWithIds.put(R.id.tv_experiences_label, 11);
        sViewsWithIds.put(R.id.experienceRecycler, 12);
        sViewsWithIds.put(R.id.tv_skills_label, 13);
        sViewsWithIds.put(R.id.skillsField, 14);
        sViewsWithIds.put(R.id.skillChipGroup, 15);
        sViewsWithIds.put(R.id.tv_activities_label, 16);
        sViewsWithIds.put(R.id.activityField, 17);
        sViewsWithIds.put(R.id.activityChipGroup, 18);
        sViewsWithIds.put(R.id.tv_about_me_label, 19);
        sViewsWithIds.put(R.id.aboutMeField, 20);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final android.widget.ImageView mboundView2;
    @NonNull
    private final android.widget.ImageView mboundView3;
    @NonNull
    private final android.widget.LinearLayout mboundView4;
    @NonNull
    private final android.widget.LinearLayout mboundView5;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback17;
    @Nullable
    private final android.view.View.OnClickListener mCallback15;
    @Nullable
    private final android.view.View.OnClickListener mCallback16;
    @Nullable
    private final android.view.View.OnClickListener mCallback14;
    @Nullable
    private final android.view.View.OnClickListener mCallback18;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentJobSeekerResumeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 21, sIncludes, sViewsWithIds));
    }
    private FragmentJobSeekerResumeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.EditText) bindings[20]
            , (com.google.android.material.chip.ChipGroup) bindings[18]
            , (android.widget.EditText) bindings[17]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[6]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[7]
            , (androidx.recyclerview.widget.RecyclerView) bindings[10]
            , (androidx.recyclerview.widget.RecyclerView) bindings[12]
            , (android.widget.ImageView) bindings[1]
            , (com.google.android.material.chip.ChipGroup) bindings[15]
            , (android.widget.EditText) bindings[14]
            , (android.widget.ScrollView) bindings[8]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[13]
            );
        this.ivBackButton.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.ImageView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.ImageView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.LinearLayout) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.LinearLayout) bindings[5];
        this.mboundView5.setTag(null);
        setRootTag(root);
        // listeners
        mCallback17 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 4);
        mCallback15 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
        mCallback16 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 3);
        mCallback14 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
        mCallback18 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 5);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.documentFlag == variableId) {
            setDocumentFlag((java.lang.Boolean) variable);
        }
        else if (BR.handler == variableId) {
            setHandler((com.findajob.jobamax.jobseeker.profile.cv.JobSeekerResumeHandler) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setDocumentFlag(@Nullable java.lang.Boolean DocumentFlag) {
        this.mDocumentFlag = DocumentFlag;
    }
    public void setHandler(@Nullable com.findajob.jobamax.jobseeker.profile.cv.JobSeekerResumeHandler Handler) {
        this.mHandler = Handler;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.findajob.jobamax.jobseeker.profile.cv.JobSeekerResumeHandler handler = mHandler;
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.ivBackButton.setOnClickListener(mCallback14);
            this.mboundView2.setOnClickListener(mCallback15);
            this.mboundView3.setOnClickListener(mCallback16);
            this.mboundView4.setOnClickListener(mCallback17);
            this.mboundView5.setOnClickListener(mCallback18);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 4: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.cv.JobSeekerResumeHandler handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onAddSkillsClicked();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.cv.JobSeekerResumeHandler handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onAddEducationClicked();
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.cv.JobSeekerResumeHandler handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onAddExperienceClicked();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.cv.JobSeekerResumeHandler handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onBackButtonClicked();
                }
                break;
            }
            case 5: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.cv.JobSeekerResumeHandler handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onAddActivityClicked();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): documentFlag
        flag 1 (0x2L): handler
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}