package com.jobamax.appjobamax;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jobamax.appjobamax.databinding.ActivityBuildProfileBindingImpl;
import com.jobamax.appjobamax.databinding.ActivityJobSeekerHomeBindingImpl;
import com.jobamax.appjobamax.databinding.ActivityManualAndPersonalizeBindingImpl;
import com.jobamax.appjobamax.databinding.ActivityNewSplashBindingImpl;
import com.jobamax.appjobamax.databinding.ActivityRecruiterChatBoardBindingImpl;
import com.jobamax.appjobamax.databinding.ActivityRecruiterHomeBindingImpl;
import com.jobamax.appjobamax.databinding.ActivityRecruiterSettingBindingImpl;
import com.jobamax.appjobamax.databinding.ActivitySeekerChatBoardBindingImpl;
import com.jobamax.appjobamax.databinding.ActivitySeekerCoachingBindingImpl;
import com.jobamax.appjobamax.databinding.ActivitySeekerCreateCvBindingImpl;
import com.jobamax.appjobamax.databinding.ActivitySeekerSettingBindingImpl;
import com.jobamax.appjobamax.databinding.ActivityVideoPlayBindingImpl;
import com.jobamax.appjobamax.databinding.ActivityWebViewBindingImpl;
import com.jobamax.appjobamax.databinding.DailogChangeUniversityBindingImpl;
import com.jobamax.appjobamax.databinding.DailogWishlistFilterBindingImpl;
import com.jobamax.appjobamax.databinding.DialogAddDocumentBindingImpl;
import com.jobamax.appjobamax.databinding.DialogAddLinkBindingImpl;
import com.jobamax.appjobamax.databinding.DialogAddOrTakeVideoBindingImpl;
import com.jobamax.appjobamax.databinding.DialogAddToFolderOrOfferBindingImpl;
import com.jobamax.appjobamax.databinding.DialogBuildProfileSuggestionBindingImpl;
import com.jobamax.appjobamax.databinding.DialogDeleteAccountBindingImpl;
import com.jobamax.appjobamax.databinding.DialogFilterJobRoleWiseBindingImpl;
import com.jobamax.appjobamax.databinding.DialogJobMatchedBindingImpl;
import com.jobamax.appjobamax.databinding.DialogJobSeekerThreadFilterBindingImpl;
import com.jobamax.appjobamax.databinding.DialogQualifyingStepBindingImpl;
import com.jobamax.appjobamax.databinding.DialogReportBindingImpl;
import com.jobamax.appjobamax.databinding.DialogRepostJobBindingImpl;
import com.jobamax.appjobamax.databinding.DialogSeePostJobOfferInfoBindingImpl;
import com.jobamax.appjobamax.databinding.DialogSeekerFolderBindingImpl;
import com.jobamax.appjobamax.databinding.DialogSimpleYesNoBindingImpl;
import com.jobamax.appjobamax.databinding.DialogSkillSuggestionBindingImpl;
import com.jobamax.appjobamax.databinding.DialogTitleMessageBindingImpl;
import com.jobamax.appjobamax.databinding.DialogWorkExperienceBindingImpl;
import com.jobamax.appjobamax.databinding.DialogWorkTypeBindingImpl;
import com.jobamax.appjobamax.databinding.DialogYesNoBindingImpl;
import com.jobamax.appjobamax.databinding.DialogYesNoSimpleBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentAddAudioBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentAddNewEducationBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentAddNewExperienceBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentAddNewVolunteeringBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentAddVideoBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentAudioDemoBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentCreateCVBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentCreateProfileOptionBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentFilterJobSearchTagBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentForgetPasswordBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentImportProfileFromLinkedInBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentJobMatchInfoDialogBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentJobSeekerAccountBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentJobSeekerManageReadReceiptsBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentJobSeekerNewsletterBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentJobSeekerPersonalInformationBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentLoginRegistrationOptionBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentManualFilterBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentManualFilterMainBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentModifyCVBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentModifyProfileBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentPersonalizeFilterBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentPersonalizeFilterDialogBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentPickAudioBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentPickVideoBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentPrivacyPolicyBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentProfilePreviewBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentRecruiterAddJobSourcingCriteriaBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentRecruiterChangePasswordBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentRecruiterChatListBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentRecruiterHomeBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentRecruiterImportSeekerToQualifyingStepDialogBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentRecruiterNewsLatterBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentRecruiterPersonalInfoBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentRecruiterProfileBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentRecruiterRecruitmentSeekerProfileDialogBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentRecruiterSearchBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentRecruiterSettingBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerChangePasswordBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerChatListBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerDeleteAccountBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerDeleteAccountFinalBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerDownloadCvBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerFormatCvBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerLearnJobCardSwipingDialogBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerProfileBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerSearchJobBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerWishlistBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentTakeAgeBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentTakeEmailBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentTakeNameBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentTakePasswordBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentTakeUniversityBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentTakeWorkExperienceBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentUserLoginBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentUserRoleBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentVideoDemoBindingImpl;
import com.jobamax.appjobamax.databinding.ItemEducationAdapterBindingImpl;
import com.jobamax.appjobamax.databinding.ItemFolderSeekerBindingImpl;
import com.jobamax.appjobamax.databinding.ItemImageBindingImpl;
import com.jobamax.appjobamax.databinding.ItemJobCriteriaCategoryBindingImpl;
import com.jobamax.appjobamax.databinding.ItemJobSeekerChatListBindingImpl;
import com.jobamax.appjobamax.databinding.ItemLearnJobCardSwipingBindingImpl;
import com.jobamax.appjobamax.databinding.ItemLearnSwipeABindingImpl;
import com.jobamax.appjobamax.databinding.ItemLeavingReasonBindingImpl;
import com.jobamax.appjobamax.databinding.ItemMessageAudioBindingImpl;
import com.jobamax.appjobamax.databinding.ItemMessageImageBindingImpl;
import com.jobamax.appjobamax.databinding.ItemMessageTextBindingImpl;
import com.jobamax.appjobamax.databinding.ItemNewWishlistBindingImpl;
import com.jobamax.appjobamax.databinding.ItemPhotoBindingImpl;
import com.jobamax.appjobamax.databinding.ItemPortfolioImage2BindingImpl;
import com.jobamax.appjobamax.databinding.ItemPortfolioLinkBindingImpl;
import com.jobamax.appjobamax.databinding.ItemProfileAudioVideoBindingImpl;
import com.jobamax.appjobamax.databinding.ItemProfileBioBindingImpl;
import com.jobamax.appjobamax.databinding.ItemProfileEducationBindingImpl;
import com.jobamax.appjobamax.databinding.ItemProfileExperienceBindingImpl;
import com.jobamax.appjobamax.databinding.ItemProfileIdealWorkspaceBindingImpl;
import com.jobamax.appjobamax.databinding.ItemProfileImagesBindingImpl;
import com.jobamax.appjobamax.databinding.ItemProfileInterestBindingImpl;
import com.jobamax.appjobamax.databinding.ItemProfilePortfolioBindingImpl;
import com.jobamax.appjobamax.databinding.ItemProfileSkillBindingImpl;
import com.jobamax.appjobamax.databinding.ItemProfileVolunteeringBindingImpl;
import com.jobamax.appjobamax.databinding.ItemRecruiterChatListBindingImpl;
import com.jobamax.appjobamax.databinding.ItemRecruiterJobCardBindingImpl;
import com.jobamax.appjobamax.databinding.ItemSearchQueryCompanyBindingImpl;
import com.jobamax.appjobamax.databinding.ItemSeekerEducationBindingImpl;
import com.jobamax.appjobamax.databinding.ItemSeekerExperienceBindingImpl;
import com.jobamax.appjobamax.databinding.ItemSeekerHardSkillBindingImpl;
import com.jobamax.appjobamax.databinding.ItemSeekerJobCardBindingImpl;
import com.jobamax.appjobamax.databinding.ItemSeekerSearchUniversityBindingImpl;
import com.jobamax.appjobamax.databinding.ItemSeekerVolunteeringBindingImpl;
import com.jobamax.appjobamax.databinding.LayoutImagePickerBindingImpl;
import com.jobamax.appjobamax.databinding.TabBottomRecruiterNavigationBindingImpl;
import com.jobamax.appjobamax.databinding.TabBottomSeekerNavigationBindingImpl;
import com.jobamax.appjobamax.databinding.TabManualFilterBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYBUILDPROFILE = 1;

  private static final int LAYOUT_ACTIVITYJOBSEEKERHOME = 2;

  private static final int LAYOUT_ACTIVITYMANUALANDPERSONALIZE = 3;

  private static final int LAYOUT_ACTIVITYNEWSPLASH = 4;

  private static final int LAYOUT_ACTIVITYRECRUITERCHATBOARD = 5;

  private static final int LAYOUT_ACTIVITYRECRUITERHOME = 6;

  private static final int LAYOUT_ACTIVITYRECRUITERSETTING = 7;

  private static final int LAYOUT_ACTIVITYSEEKERCHATBOARD = 8;

  private static final int LAYOUT_ACTIVITYSEEKERCOACHING = 9;

  private static final int LAYOUT_ACTIVITYSEEKERCREATECV = 10;

  private static final int LAYOUT_ACTIVITYSEEKERSETTING = 11;

  private static final int LAYOUT_ACTIVITYVIDEOPLAY = 12;

  private static final int LAYOUT_ACTIVITYWEBVIEW = 13;

  private static final int LAYOUT_DAILOGCHANGEUNIVERSITY = 14;

  private static final int LAYOUT_DAILOGWISHLISTFILTER = 15;

  private static final int LAYOUT_DIALOGADDDOCUMENT = 16;

  private static final int LAYOUT_DIALOGADDLINK = 17;

  private static final int LAYOUT_DIALOGADDORTAKEVIDEO = 18;

  private static final int LAYOUT_DIALOGADDTOFOLDEROROFFER = 19;

  private static final int LAYOUT_DIALOGBUILDPROFILESUGGESTION = 20;

  private static final int LAYOUT_DIALOGDELETEACCOUNT = 21;

  private static final int LAYOUT_DIALOGFILTERJOBROLEWISE = 22;

  private static final int LAYOUT_DIALOGJOBMATCHED = 23;

  private static final int LAYOUT_DIALOGJOBSEEKERTHREADFILTER = 24;

  private static final int LAYOUT_DIALOGQUALIFYINGSTEP = 25;

  private static final int LAYOUT_DIALOGREPORT = 26;

  private static final int LAYOUT_DIALOGREPOSTJOB = 27;

  private static final int LAYOUT_DIALOGSEEPOSTJOBOFFERINFO = 28;

  private static final int LAYOUT_DIALOGSEEKERFOLDER = 29;

  private static final int LAYOUT_DIALOGSIMPLEYESNO = 30;

  private static final int LAYOUT_DIALOGSKILLSUGGESTION = 31;

  private static final int LAYOUT_DIALOGTITLEMESSAGE = 32;

  private static final int LAYOUT_DIALOGWORKEXPERIENCE = 33;

  private static final int LAYOUT_DIALOGWORKTYPE = 34;

  private static final int LAYOUT_DIALOGYESNO = 35;

  private static final int LAYOUT_DIALOGYESNOSIMPLE = 36;

  private static final int LAYOUT_FRAGMENTADDAUDIO = 37;

  private static final int LAYOUT_FRAGMENTADDNEWEDUCATION = 38;

  private static final int LAYOUT_FRAGMENTADDNEWEXPERIENCE = 39;

  private static final int LAYOUT_FRAGMENTADDNEWVOLUNTEERING = 40;

  private static final int LAYOUT_FRAGMENTADDVIDEO = 41;

  private static final int LAYOUT_FRAGMENTAUDIODEMO = 42;

  private static final int LAYOUT_FRAGMENTCREATECV = 43;

  private static final int LAYOUT_FRAGMENTCREATEPROFILEOPTION = 44;

  private static final int LAYOUT_FRAGMENTFILTERJOBSEARCHTAG = 45;

  private static final int LAYOUT_FRAGMENTFORGETPASSWORD = 46;

  private static final int LAYOUT_FRAGMENTIMPORTPROFILEFROMLINKEDIN = 47;

  private static final int LAYOUT_FRAGMENTJOBMATCHINFODIALOG = 48;

  private static final int LAYOUT_FRAGMENTJOBSEEKERACCOUNT = 49;

  private static final int LAYOUT_FRAGMENTJOBSEEKERMANAGEREADRECEIPTS = 50;

  private static final int LAYOUT_FRAGMENTJOBSEEKERNEWSLETTER = 51;

  private static final int LAYOUT_FRAGMENTJOBSEEKERPERSONALINFORMATION = 52;

  private static final int LAYOUT_FRAGMENTLOGINREGISTRATIONOPTION = 53;

  private static final int LAYOUT_FRAGMENTMANUALFILTER = 54;

  private static final int LAYOUT_FRAGMENTMANUALFILTERMAIN = 55;

  private static final int LAYOUT_FRAGMENTMODIFYCV = 56;

  private static final int LAYOUT_FRAGMENTMODIFYPROFILE = 57;

  private static final int LAYOUT_FRAGMENTPERSONALIZEFILTER = 58;

  private static final int LAYOUT_FRAGMENTPERSONALIZEFILTERDIALOG = 59;

  private static final int LAYOUT_FRAGMENTPICKAUDIO = 60;

  private static final int LAYOUT_FRAGMENTPICKVIDEO = 61;

  private static final int LAYOUT_FRAGMENTPRIVACYPOLICY = 62;

  private static final int LAYOUT_FRAGMENTPROFILEPREVIEW = 63;

  private static final int LAYOUT_FRAGMENTRECRUITERADDJOBSOURCINGCRITERIA = 64;

  private static final int LAYOUT_FRAGMENTRECRUITERCHANGEPASSWORD = 65;

  private static final int LAYOUT_FRAGMENTRECRUITERCHATLIST = 66;

  private static final int LAYOUT_FRAGMENTRECRUITERHOME = 67;

  private static final int LAYOUT_FRAGMENTRECRUITERIMPORTSEEKERTOQUALIFYINGSTEPDIALOG = 68;

  private static final int LAYOUT_FRAGMENTRECRUITERNEWSLATTER = 69;

  private static final int LAYOUT_FRAGMENTRECRUITERPERSONALINFO = 70;

  private static final int LAYOUT_FRAGMENTRECRUITERPROFILE = 71;

  private static final int LAYOUT_FRAGMENTRECRUITERRECRUITMENTSEEKERPROFILEDIALOG = 72;

  private static final int LAYOUT_FRAGMENTRECRUITERSEARCH = 73;

  private static final int LAYOUT_FRAGMENTRECRUITERSETTING = 74;

  private static final int LAYOUT_FRAGMENTSEEKERCHANGEPASSWORD = 75;

  private static final int LAYOUT_FRAGMENTSEEKERCHATLIST = 76;

  private static final int LAYOUT_FRAGMENTSEEKERDELETEACCOUNT = 77;

  private static final int LAYOUT_FRAGMENTSEEKERDELETEACCOUNTFINAL = 78;

  private static final int LAYOUT_FRAGMENTSEEKERDOWNLOADCV = 79;

  private static final int LAYOUT_FRAGMENTSEEKERFORMATCV = 80;

  private static final int LAYOUT_FRAGMENTSEEKERLEARNJOBCARDSWIPINGDIALOG = 81;

  private static final int LAYOUT_FRAGMENTSEEKERPROFILE = 82;

  private static final int LAYOUT_FRAGMENTSEEKERSEARCHJOB = 83;

  private static final int LAYOUT_FRAGMENTSEEKERWISHLIST = 84;

  private static final int LAYOUT_FRAGMENTTAKEAGE = 85;

  private static final int LAYOUT_FRAGMENTTAKEEMAIL = 86;

  private static final int LAYOUT_FRAGMENTTAKENAME = 87;

  private static final int LAYOUT_FRAGMENTTAKEPASSWORD = 88;

  private static final int LAYOUT_FRAGMENTTAKEUNIVERSITY = 89;

  private static final int LAYOUT_FRAGMENTTAKEWORKEXPERIENCE = 90;

  private static final int LAYOUT_FRAGMENTUSERLOGIN = 91;

  private static final int LAYOUT_FRAGMENTUSERROLE = 92;

  private static final int LAYOUT_FRAGMENTVIDEODEMO = 93;

  private static final int LAYOUT_ITEMEDUCATIONADAPTER = 94;

  private static final int LAYOUT_ITEMFOLDERSEEKER = 95;

  private static final int LAYOUT_ITEMIMAGE = 96;

  private static final int LAYOUT_ITEMJOBCRITERIACATEGORY = 97;

  private static final int LAYOUT_ITEMJOBSEEKERCHATLIST = 98;

  private static final int LAYOUT_ITEMLEARNJOBCARDSWIPING = 99;

  private static final int LAYOUT_ITEMLEARNSWIPEA = 100;

  private static final int LAYOUT_ITEMLEAVINGREASON = 101;

  private static final int LAYOUT_ITEMMESSAGEAUDIO = 102;

  private static final int LAYOUT_ITEMMESSAGEIMAGE = 103;

  private static final int LAYOUT_ITEMMESSAGETEXT = 104;

  private static final int LAYOUT_ITEMNEWWISHLIST = 105;

  private static final int LAYOUT_ITEMPHOTO = 106;

  private static final int LAYOUT_ITEMPORTFOLIOIMAGE2 = 107;

  private static final int LAYOUT_ITEMPORTFOLIOLINK = 108;

  private static final int LAYOUT_ITEMPROFILEAUDIOVIDEO = 109;

  private static final int LAYOUT_ITEMPROFILEBIO = 110;

  private static final int LAYOUT_ITEMPROFILEEDUCATION = 111;

  private static final int LAYOUT_ITEMPROFILEEXPERIENCE = 112;

  private static final int LAYOUT_ITEMPROFILEIDEALWORKSPACE = 113;

  private static final int LAYOUT_ITEMPROFILEIMAGES = 114;

  private static final int LAYOUT_ITEMPROFILEINTEREST = 115;

  private static final int LAYOUT_ITEMPROFILEPORTFOLIO = 116;

  private static final int LAYOUT_ITEMPROFILESKILL = 117;

  private static final int LAYOUT_ITEMPROFILEVOLUNTEERING = 118;

  private static final int LAYOUT_ITEMRECRUITERCHATLIST = 119;

  private static final int LAYOUT_ITEMRECRUITERJOBCARD = 120;

  private static final int LAYOUT_ITEMSEARCHQUERYCOMPANY = 121;

  private static final int LAYOUT_ITEMSEEKEREDUCATION = 122;

  private static final int LAYOUT_ITEMSEEKEREXPERIENCE = 123;

  private static final int LAYOUT_ITEMSEEKERHARDSKILL = 124;

  private static final int LAYOUT_ITEMSEEKERJOBCARD = 125;

  private static final int LAYOUT_ITEMSEEKERSEARCHUNIVERSITY = 126;

  private static final int LAYOUT_ITEMSEEKERVOLUNTEERING = 127;

  private static final int LAYOUT_LAYOUTIMAGEPICKER = 128;

  private static final int LAYOUT_TABBOTTOMRECRUITERNAVIGATION = 129;

  private static final int LAYOUT_TABBOTTOMSEEKERNAVIGATION = 130;

  private static final int LAYOUT_TABMANUALFILTER = 131;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(131);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.activity_build_profile, LAYOUT_ACTIVITYBUILDPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.activity_job_seeker_home, LAYOUT_ACTIVITYJOBSEEKERHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.activity_manual_and_personalize, LAYOUT_ACTIVITYMANUALANDPERSONALIZE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.activity_new_splash, LAYOUT_ACTIVITYNEWSPLASH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.activity_recruiter_chat_board, LAYOUT_ACTIVITYRECRUITERCHATBOARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.activity_recruiter_home, LAYOUT_ACTIVITYRECRUITERHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.activity_recruiter_setting, LAYOUT_ACTIVITYRECRUITERSETTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.activity_seeker_chat_board, LAYOUT_ACTIVITYSEEKERCHATBOARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.activity_seeker_coaching, LAYOUT_ACTIVITYSEEKERCOACHING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.activity_seeker_create_cv, LAYOUT_ACTIVITYSEEKERCREATECV);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.activity_seeker_setting, LAYOUT_ACTIVITYSEEKERSETTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.activity_video_play, LAYOUT_ACTIVITYVIDEOPLAY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.activity_web_view, LAYOUT_ACTIVITYWEBVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dailog_change_university, LAYOUT_DAILOGCHANGEUNIVERSITY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dailog_wishlist_filter, LAYOUT_DAILOGWISHLISTFILTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dialog_add_document, LAYOUT_DIALOGADDDOCUMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dialog_add_link, LAYOUT_DIALOGADDLINK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dialog_add_or_take_video, LAYOUT_DIALOGADDORTAKEVIDEO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dialog_add_to_folder_or_offer, LAYOUT_DIALOGADDTOFOLDEROROFFER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dialog_build_profile_suggestion, LAYOUT_DIALOGBUILDPROFILESUGGESTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dialog_delete_account, LAYOUT_DIALOGDELETEACCOUNT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dialog_filter_job_role_wise, LAYOUT_DIALOGFILTERJOBROLEWISE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dialog_job_matched, LAYOUT_DIALOGJOBMATCHED);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dialog_job_seeker_thread_filter, LAYOUT_DIALOGJOBSEEKERTHREADFILTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dialog_qualifying_step, LAYOUT_DIALOGQUALIFYINGSTEP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dialog_report, LAYOUT_DIALOGREPORT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dialog_repost_job, LAYOUT_DIALOGREPOSTJOB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dialog_see_post_job_offer_info, LAYOUT_DIALOGSEEPOSTJOBOFFERINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dialog_seeker_folder, LAYOUT_DIALOGSEEKERFOLDER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dialog_simple_yes_no, LAYOUT_DIALOGSIMPLEYESNO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dialog_skill_suggestion, LAYOUT_DIALOGSKILLSUGGESTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dialog_title_message, LAYOUT_DIALOGTITLEMESSAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dialog_work_experience, LAYOUT_DIALOGWORKEXPERIENCE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dialog_work_type, LAYOUT_DIALOGWORKTYPE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dialog_yes_no, LAYOUT_DIALOGYESNO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dialog_yes_no_simple, LAYOUT_DIALOGYESNOSIMPLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_add_audio, LAYOUT_FRAGMENTADDAUDIO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_add_new_education, LAYOUT_FRAGMENTADDNEWEDUCATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_add_new_experience, LAYOUT_FRAGMENTADDNEWEXPERIENCE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_add_new_volunteering, LAYOUT_FRAGMENTADDNEWVOLUNTEERING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_add_video, LAYOUT_FRAGMENTADDVIDEO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_audio_demo, LAYOUT_FRAGMENTAUDIODEMO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_create_c_v, LAYOUT_FRAGMENTCREATECV);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_create_profile_option, LAYOUT_FRAGMENTCREATEPROFILEOPTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_filter_job_search_tag, LAYOUT_FRAGMENTFILTERJOBSEARCHTAG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_forget_password, LAYOUT_FRAGMENTFORGETPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_import_profile_from_linked_in, LAYOUT_FRAGMENTIMPORTPROFILEFROMLINKEDIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_job_match_info_dialog, LAYOUT_FRAGMENTJOBMATCHINFODIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_job_seeker_account, LAYOUT_FRAGMENTJOBSEEKERACCOUNT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_job_seeker_manage_read_receipts, LAYOUT_FRAGMENTJOBSEEKERMANAGEREADRECEIPTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_job_seeker_newsletter, LAYOUT_FRAGMENTJOBSEEKERNEWSLETTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_job_seeker_personal_information, LAYOUT_FRAGMENTJOBSEEKERPERSONALINFORMATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_login_registration_option, LAYOUT_FRAGMENTLOGINREGISTRATIONOPTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_manual_filter, LAYOUT_FRAGMENTMANUALFILTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_manual_filter_main, LAYOUT_FRAGMENTMANUALFILTERMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_modify_c_v, LAYOUT_FRAGMENTMODIFYCV);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_modify_profile, LAYOUT_FRAGMENTMODIFYPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_personalize_filter, LAYOUT_FRAGMENTPERSONALIZEFILTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_personalize_filter_dialog, LAYOUT_FRAGMENTPERSONALIZEFILTERDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_pick_audio, LAYOUT_FRAGMENTPICKAUDIO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_pick_video, LAYOUT_FRAGMENTPICKVIDEO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_privacy_policy, LAYOUT_FRAGMENTPRIVACYPOLICY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_profile_preview, LAYOUT_FRAGMENTPROFILEPREVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_recruiter_add_job_sourcing_criteria, LAYOUT_FRAGMENTRECRUITERADDJOBSOURCINGCRITERIA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_recruiter_change_password, LAYOUT_FRAGMENTRECRUITERCHANGEPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_recruiter_chat_list, LAYOUT_FRAGMENTRECRUITERCHATLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_recruiter_home, LAYOUT_FRAGMENTRECRUITERHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_recruiter_import_seeker_to_qualifying_step_dialog, LAYOUT_FRAGMENTRECRUITERIMPORTSEEKERTOQUALIFYINGSTEPDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_recruiter_news_latter, LAYOUT_FRAGMENTRECRUITERNEWSLATTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_recruiter_personal_info, LAYOUT_FRAGMENTRECRUITERPERSONALINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_recruiter_profile, LAYOUT_FRAGMENTRECRUITERPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_recruiter_recruitment_seeker_profile_dialog, LAYOUT_FRAGMENTRECRUITERRECRUITMENTSEEKERPROFILEDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_recruiter_search, LAYOUT_FRAGMENTRECRUITERSEARCH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_recruiter_setting, LAYOUT_FRAGMENTRECRUITERSETTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_change_password, LAYOUT_FRAGMENTSEEKERCHANGEPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_chat_list, LAYOUT_FRAGMENTSEEKERCHATLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_delete_account, LAYOUT_FRAGMENTSEEKERDELETEACCOUNT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_delete_account_final, LAYOUT_FRAGMENTSEEKERDELETEACCOUNTFINAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_download_cv, LAYOUT_FRAGMENTSEEKERDOWNLOADCV);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_format_cv, LAYOUT_FRAGMENTSEEKERFORMATCV);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_learn_job_card_swiping_dialog, LAYOUT_FRAGMENTSEEKERLEARNJOBCARDSWIPINGDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_profile, LAYOUT_FRAGMENTSEEKERPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_search_job, LAYOUT_FRAGMENTSEEKERSEARCHJOB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_wishlist, LAYOUT_FRAGMENTSEEKERWISHLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_take_age, LAYOUT_FRAGMENTTAKEAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_take_email, LAYOUT_FRAGMENTTAKEEMAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_take_name, LAYOUT_FRAGMENTTAKENAME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_take_password, LAYOUT_FRAGMENTTAKEPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_take_university, LAYOUT_FRAGMENTTAKEUNIVERSITY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_take_work_experience, LAYOUT_FRAGMENTTAKEWORKEXPERIENCE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_user_login, LAYOUT_FRAGMENTUSERLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_user_role, LAYOUT_FRAGMENTUSERROLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_video_demo, LAYOUT_FRAGMENTVIDEODEMO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_education_adapter, LAYOUT_ITEMEDUCATIONADAPTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_folder_seeker, LAYOUT_ITEMFOLDERSEEKER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_image, LAYOUT_ITEMIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_job_criteria_category, LAYOUT_ITEMJOBCRITERIACATEGORY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_job_seeker_chat_list, LAYOUT_ITEMJOBSEEKERCHATLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_learn_job_card_swiping, LAYOUT_ITEMLEARNJOBCARDSWIPING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_learn_swipe_a, LAYOUT_ITEMLEARNSWIPEA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_leaving_reason, LAYOUT_ITEMLEAVINGREASON);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_message_audio, LAYOUT_ITEMMESSAGEAUDIO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_message_image, LAYOUT_ITEMMESSAGEIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_message_text, LAYOUT_ITEMMESSAGETEXT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_new_wishlist, LAYOUT_ITEMNEWWISHLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_photo, LAYOUT_ITEMPHOTO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_portfolio_image2, LAYOUT_ITEMPORTFOLIOIMAGE2);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_portfolio_link, LAYOUT_ITEMPORTFOLIOLINK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_profile_audio_video, LAYOUT_ITEMPROFILEAUDIOVIDEO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_profile_bio, LAYOUT_ITEMPROFILEBIO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_profile_education, LAYOUT_ITEMPROFILEEDUCATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_profile_experience, LAYOUT_ITEMPROFILEEXPERIENCE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_profile_ideal_workspace, LAYOUT_ITEMPROFILEIDEALWORKSPACE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_profile_images, LAYOUT_ITEMPROFILEIMAGES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_profile_interest, LAYOUT_ITEMPROFILEINTEREST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_profile_portfolio, LAYOUT_ITEMPROFILEPORTFOLIO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_profile_skill, LAYOUT_ITEMPROFILESKILL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_profile_volunteering, LAYOUT_ITEMPROFILEVOLUNTEERING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_recruiter_chat_list, LAYOUT_ITEMRECRUITERCHATLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_recruiter_job_card, LAYOUT_ITEMRECRUITERJOBCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_search_query_company, LAYOUT_ITEMSEARCHQUERYCOMPANY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_seeker_education, LAYOUT_ITEMSEEKEREDUCATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_seeker_experience, LAYOUT_ITEMSEEKEREXPERIENCE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_seeker_hard_skill, LAYOUT_ITEMSEEKERHARDSKILL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_seeker_job_card, LAYOUT_ITEMSEEKERJOBCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_seeker_search_university, LAYOUT_ITEMSEEKERSEARCHUNIVERSITY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_seeker_volunteering, LAYOUT_ITEMSEEKERVOLUNTEERING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.layout_image_picker, LAYOUT_LAYOUTIMAGEPICKER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.tab_bottom_recruiter_navigation, LAYOUT_TABBOTTOMRECRUITERNAVIGATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.tab_bottom_seeker_navigation, LAYOUT_TABBOTTOMSEEKERNAVIGATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.tab_manual_filter, LAYOUT_TABMANUALFILTER);
  }

  private final ViewDataBinding internalGetViewDataBinding0(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_ACTIVITYBUILDPROFILE: {
        if ("layout/activity_build_profile_0".equals(tag)) {
          return new ActivityBuildProfileBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_build_profile is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYJOBSEEKERHOME: {
        if ("layout/activity_job_seeker_home_0".equals(tag)) {
          return new ActivityJobSeekerHomeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_job_seeker_home is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMANUALANDPERSONALIZE: {
        if ("layout/activity_manual_and_personalize_0".equals(tag)) {
          return new ActivityManualAndPersonalizeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_manual_and_personalize is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYNEWSPLASH: {
        if ("layout/activity_new_splash_0".equals(tag)) {
          return new ActivityNewSplashBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_new_splash is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYRECRUITERCHATBOARD: {
        if ("layout/activity_recruiter_chat_board_0".equals(tag)) {
          return new ActivityRecruiterChatBoardBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_recruiter_chat_board is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYRECRUITERHOME: {
        if ("layout/activity_recruiter_home_0".equals(tag)) {
          return new ActivityRecruiterHomeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_recruiter_home is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYRECRUITERSETTING: {
        if ("layout/activity_recruiter_setting_0".equals(tag)) {
          return new ActivityRecruiterSettingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_recruiter_setting is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSEEKERCHATBOARD: {
        if ("layout/activity_seeker_chat_board_0".equals(tag)) {
          return new ActivitySeekerChatBoardBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_seeker_chat_board is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSEEKERCOACHING: {
        if ("layout/activity_seeker_coaching_0".equals(tag)) {
          return new ActivitySeekerCoachingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_seeker_coaching is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSEEKERCREATECV: {
        if ("layout/activity_seeker_create_cv_0".equals(tag)) {
          return new ActivitySeekerCreateCvBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_seeker_create_cv is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSEEKERSETTING: {
        if ("layout/activity_seeker_setting_0".equals(tag)) {
          return new ActivitySeekerSettingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_seeker_setting is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYVIDEOPLAY: {
        if ("layout/activity_video_play_0".equals(tag)) {
          return new ActivityVideoPlayBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_video_play is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYWEBVIEW: {
        if ("layout/activity_web_view_0".equals(tag)) {
          return new ActivityWebViewBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_web_view is invalid. Received: " + tag);
      }
      case  LAYOUT_DAILOGCHANGEUNIVERSITY: {
        if ("layout/dailog_change_university_0".equals(tag)) {
          return new DailogChangeUniversityBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dailog_change_university is invalid. Received: " + tag);
      }
      case  LAYOUT_DAILOGWISHLISTFILTER: {
        if ("layout/dailog_wishlist_filter_0".equals(tag)) {
          return new DailogWishlistFilterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dailog_wishlist_filter is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGADDDOCUMENT: {
        if ("layout/dialog_add_document_0".equals(tag)) {
          return new DialogAddDocumentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_add_document is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGADDLINK: {
        if ("layout/dialog_add_link_0".equals(tag)) {
          return new DialogAddLinkBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_add_link is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGADDORTAKEVIDEO: {
        if ("layout/dialog_add_or_take_video_0".equals(tag)) {
          return new DialogAddOrTakeVideoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_add_or_take_video is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGADDTOFOLDEROROFFER: {
        if ("layout/dialog_add_to_folder_or_offer_0".equals(tag)) {
          return new DialogAddToFolderOrOfferBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_add_to_folder_or_offer is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGBUILDPROFILESUGGESTION: {
        if ("layout/dialog_build_profile_suggestion_0".equals(tag)) {
          return new DialogBuildProfileSuggestionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_build_profile_suggestion is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGDELETEACCOUNT: {
        if ("layout/dialog_delete_account_0".equals(tag)) {
          return new DialogDeleteAccountBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_delete_account is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGFILTERJOBROLEWISE: {
        if ("layout/dialog_filter_job_role_wise_0".equals(tag)) {
          return new DialogFilterJobRoleWiseBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_filter_job_role_wise is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGJOBMATCHED: {
        if ("layout/dialog_job_matched_0".equals(tag)) {
          return new DialogJobMatchedBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_job_matched is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGJOBSEEKERTHREADFILTER: {
        if ("layout/dialog_job_seeker_thread_filter_0".equals(tag)) {
          return new DialogJobSeekerThreadFilterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_job_seeker_thread_filter is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGQUALIFYINGSTEP: {
        if ("layout/dialog_qualifying_step_0".equals(tag)) {
          return new DialogQualifyingStepBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_qualifying_step is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGREPORT: {
        if ("layout/dialog_report_0".equals(tag)) {
          return new DialogReportBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_report is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGREPOSTJOB: {
        if ("layout/dialog_repost_job_0".equals(tag)) {
          return new DialogRepostJobBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_repost_job is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGSEEPOSTJOBOFFERINFO: {
        if ("layout/dialog_see_post_job_offer_info_0".equals(tag)) {
          return new DialogSeePostJobOfferInfoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_see_post_job_offer_info is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGSEEKERFOLDER: {
        if ("layout/dialog_seeker_folder_0".equals(tag)) {
          return new DialogSeekerFolderBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_seeker_folder is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGSIMPLEYESNO: {
        if ("layout/dialog_simple_yes_no_0".equals(tag)) {
          return new DialogSimpleYesNoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_simple_yes_no is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGSKILLSUGGESTION: {
        if ("layout/dialog_skill_suggestion_0".equals(tag)) {
          return new DialogSkillSuggestionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_skill_suggestion is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGTITLEMESSAGE: {
        if ("layout/dialog_title_message_0".equals(tag)) {
          return new DialogTitleMessageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_title_message is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGWORKEXPERIENCE: {
        if ("layout/dialog_work_experience_0".equals(tag)) {
          return new DialogWorkExperienceBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_work_experience is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGWORKTYPE: {
        if ("layout/dialog_work_type_0".equals(tag)) {
          return new DialogWorkTypeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_work_type is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGYESNO: {
        if ("layout/dialog_yes_no_0".equals(tag)) {
          return new DialogYesNoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_yes_no is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGYESNOSIMPLE: {
        if ("layout/dialog_yes_no_simple_0".equals(tag)) {
          return new DialogYesNoSimpleBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_yes_no_simple is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTADDAUDIO: {
        if ("layout/fragment_add_audio_0".equals(tag)) {
          return new FragmentAddAudioBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_add_audio is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTADDNEWEDUCATION: {
        if ("layout/fragment_add_new_education_0".equals(tag)) {
          return new FragmentAddNewEducationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_add_new_education is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTADDNEWEXPERIENCE: {
        if ("layout/fragment_add_new_experience_0".equals(tag)) {
          return new FragmentAddNewExperienceBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_add_new_experience is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTADDNEWVOLUNTEERING: {
        if ("layout/fragment_add_new_volunteering_0".equals(tag)) {
          return new FragmentAddNewVolunteeringBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_add_new_volunteering is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTADDVIDEO: {
        if ("layout/fragment_add_video_0".equals(tag)) {
          return new FragmentAddVideoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_add_video is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTAUDIODEMO: {
        if ("layout/fragment_audio_demo_0".equals(tag)) {
          return new FragmentAudioDemoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_audio_demo is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCREATECV: {
        if ("layout/fragment_create_c_v_0".equals(tag)) {
          return new FragmentCreateCVBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_create_c_v is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCREATEPROFILEOPTION: {
        if ("layout/fragment_create_profile_option_0".equals(tag)) {
          return new FragmentCreateProfileOptionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_create_profile_option is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTFILTERJOBSEARCHTAG: {
        if ("layout/fragment_filter_job_search_tag_0".equals(tag)) {
          return new FragmentFilterJobSearchTagBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_filter_job_search_tag is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTFORGETPASSWORD: {
        if ("layout/fragment_forget_password_0".equals(tag)) {
          return new FragmentForgetPasswordBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_forget_password is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTIMPORTPROFILEFROMLINKEDIN: {
        if ("layout/fragment_import_profile_from_linked_in_0".equals(tag)) {
          return new FragmentImportProfileFromLinkedInBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_import_profile_from_linked_in is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTJOBMATCHINFODIALOG: {
        if ("layout/fragment_job_match_info_dialog_0".equals(tag)) {
          return new FragmentJobMatchInfoDialogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_job_match_info_dialog is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTJOBSEEKERACCOUNT: {
        if ("layout/fragment_job_seeker_account_0".equals(tag)) {
          return new FragmentJobSeekerAccountBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_job_seeker_account is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTJOBSEEKERMANAGEREADRECEIPTS: {
        if ("layout/fragment_job_seeker_manage_read_receipts_0".equals(tag)) {
          return new FragmentJobSeekerManageReadReceiptsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_job_seeker_manage_read_receipts is invalid. Received: " + tag);
      }
    }
    return null;
  }

  private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_FRAGMENTJOBSEEKERNEWSLETTER: {
        if ("layout/fragment_job_seeker_newsletter_0".equals(tag)) {
          return new FragmentJobSeekerNewsletterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_job_seeker_newsletter is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTJOBSEEKERPERSONALINFORMATION: {
        if ("layout/fragment_job_seeker_personal_information_0".equals(tag)) {
          return new FragmentJobSeekerPersonalInformationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_job_seeker_personal_information is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTLOGINREGISTRATIONOPTION: {
        if ("layout/fragment_login_registration_option_0".equals(tag)) {
          return new FragmentLoginRegistrationOptionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_login_registration_option is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTMANUALFILTER: {
        if ("layout/fragment_manual_filter_0".equals(tag)) {
          return new FragmentManualFilterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_manual_filter is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTMANUALFILTERMAIN: {
        if ("layout/fragment_manual_filter_main_0".equals(tag)) {
          return new FragmentManualFilterMainBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_manual_filter_main is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTMODIFYCV: {
        if ("layout/fragment_modify_c_v_0".equals(tag)) {
          return new FragmentModifyCVBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_modify_c_v is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTMODIFYPROFILE: {
        if ("layout/fragment_modify_profile_0".equals(tag)) {
          return new FragmentModifyProfileBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_modify_profile is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTPERSONALIZEFILTER: {
        if ("layout/fragment_personalize_filter_0".equals(tag)) {
          return new FragmentPersonalizeFilterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_personalize_filter is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTPERSONALIZEFILTERDIALOG: {
        if ("layout/fragment_personalize_filter_dialog_0".equals(tag)) {
          return new FragmentPersonalizeFilterDialogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_personalize_filter_dialog is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTPICKAUDIO: {
        if ("layout/fragment_pick_audio_0".equals(tag)) {
          return new FragmentPickAudioBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_pick_audio is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTPICKVIDEO: {
        if ("layout/fragment_pick_video_0".equals(tag)) {
          return new FragmentPickVideoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_pick_video is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTPRIVACYPOLICY: {
        if ("layout/fragment_privacy_policy_0".equals(tag)) {
          return new FragmentPrivacyPolicyBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_privacy_policy is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTPROFILEPREVIEW: {
        if ("layout/fragment_profile_preview_0".equals(tag)) {
          return new FragmentProfilePreviewBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_profile_preview is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERADDJOBSOURCINGCRITERIA: {
        if ("layout/fragment_recruiter_add_job_sourcing_criteria_0".equals(tag)) {
          return new FragmentRecruiterAddJobSourcingCriteriaBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_add_job_sourcing_criteria is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERCHANGEPASSWORD: {
        if ("layout/fragment_recruiter_change_password_0".equals(tag)) {
          return new FragmentRecruiterChangePasswordBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_change_password is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERCHATLIST: {
        if ("layout/fragment_recruiter_chat_list_0".equals(tag)) {
          return new FragmentRecruiterChatListBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_chat_list is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERHOME: {
        if ("layout/fragment_recruiter_home_0".equals(tag)) {
          return new FragmentRecruiterHomeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_home is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERIMPORTSEEKERTOQUALIFYINGSTEPDIALOG: {
        if ("layout/fragment_recruiter_import_seeker_to_qualifying_step_dialog_0".equals(tag)) {
          return new FragmentRecruiterImportSeekerToQualifyingStepDialogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_import_seeker_to_qualifying_step_dialog is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERNEWSLATTER: {
        if ("layout/fragment_recruiter_news_latter_0".equals(tag)) {
          return new FragmentRecruiterNewsLatterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_news_latter is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERPERSONALINFO: {
        if ("layout/fragment_recruiter_personal_info_0".equals(tag)) {
          return new FragmentRecruiterPersonalInfoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_personal_info is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERPROFILE: {
        if ("layout/fragment_recruiter_profile_0".equals(tag)) {
          return new FragmentRecruiterProfileBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_profile is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERRECRUITMENTSEEKERPROFILEDIALOG: {
        if ("layout/fragment_recruiter_recruitment_seeker_profile_dialog_0".equals(tag)) {
          return new FragmentRecruiterRecruitmentSeekerProfileDialogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_recruitment_seeker_profile_dialog is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERSEARCH: {
        if ("layout/fragment_recruiter_search_0".equals(tag)) {
          return new FragmentRecruiterSearchBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_search is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERSETTING: {
        if ("layout/fragment_recruiter_setting_0".equals(tag)) {
          return new FragmentRecruiterSettingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_setting is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERCHANGEPASSWORD: {
        if ("layout/fragment_seeker_change_password_0".equals(tag)) {
          return new FragmentSeekerChangePasswordBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_change_password is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERCHATLIST: {
        if ("layout/fragment_seeker_chat_list_0".equals(tag)) {
          return new FragmentSeekerChatListBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_chat_list is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERDELETEACCOUNT: {
        if ("layout/fragment_seeker_delete_account_0".equals(tag)) {
          return new FragmentSeekerDeleteAccountBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_delete_account is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERDELETEACCOUNTFINAL: {
        if ("layout/fragment_seeker_delete_account_final_0".equals(tag)) {
          return new FragmentSeekerDeleteAccountFinalBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_delete_account_final is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERDOWNLOADCV: {
        if ("layout/fragment_seeker_download_cv_0".equals(tag)) {
          return new FragmentSeekerDownloadCvBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_download_cv is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERFORMATCV: {
        if ("layout/fragment_seeker_format_cv_0".equals(tag)) {
          return new FragmentSeekerFormatCvBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_format_cv is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERLEARNJOBCARDSWIPINGDIALOG: {
        if ("layout/fragment_seeker_learn_job_card_swiping_dialog_0".equals(tag)) {
          return new FragmentSeekerLearnJobCardSwipingDialogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_learn_job_card_swiping_dialog is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERPROFILE: {
        if ("layout/fragment_seeker_profile_0".equals(tag)) {
          return new FragmentSeekerProfileBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_profile is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERSEARCHJOB: {
        if ("layout/fragment_seeker_search_job_0".equals(tag)) {
          return new FragmentSeekerSearchJobBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_search_job is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERWISHLIST: {
        if ("layout/fragment_seeker_wishlist_0".equals(tag)) {
          return new FragmentSeekerWishlistBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_wishlist is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTTAKEAGE: {
        if ("layout/fragment_take_age_0".equals(tag)) {
          return new FragmentTakeAgeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_take_age is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTTAKEEMAIL: {
        if ("layout/fragment_take_email_0".equals(tag)) {
          return new FragmentTakeEmailBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_take_email is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTTAKENAME: {
        if ("layout/fragment_take_name_0".equals(tag)) {
          return new FragmentTakeNameBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_take_name is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTTAKEPASSWORD: {
        if ("layout/fragment_take_password_0".equals(tag)) {
          return new FragmentTakePasswordBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_take_password is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTTAKEUNIVERSITY: {
        if ("layout/fragment_take_university_0".equals(tag)) {
          return new FragmentTakeUniversityBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_take_university is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTTAKEWORKEXPERIENCE: {
        if ("layout/fragment_take_work_experience_0".equals(tag)) {
          return new FragmentTakeWorkExperienceBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_take_work_experience is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTUSERLOGIN: {
        if ("layout/fragment_user_login_0".equals(tag)) {
          return new FragmentUserLoginBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_user_login is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTUSERROLE: {
        if ("layout/fragment_user_role_0".equals(tag)) {
          return new FragmentUserRoleBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_user_role is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTVIDEODEMO: {
        if ("layout/fragment_video_demo_0".equals(tag)) {
          return new FragmentVideoDemoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_video_demo is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMEDUCATIONADAPTER: {
        if ("layout/item_education_adapter_0".equals(tag)) {
          return new ItemEducationAdapterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_education_adapter is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMFOLDERSEEKER: {
        if ("layout/item_folder_seeker_0".equals(tag)) {
          return new ItemFolderSeekerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_folder_seeker is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMIMAGE: {
        if ("layout/item_image_0".equals(tag)) {
          return new ItemImageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_image is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMJOBCRITERIACATEGORY: {
        if ("layout/item_job_criteria_category_0".equals(tag)) {
          return new ItemJobCriteriaCategoryBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_job_criteria_category is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMJOBSEEKERCHATLIST: {
        if ("layout/item_job_seeker_chat_list_0".equals(tag)) {
          return new ItemJobSeekerChatListBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_job_seeker_chat_list is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMLEARNJOBCARDSWIPING: {
        if ("layout/item_learn_job_card_swiping_0".equals(tag)) {
          return new ItemLearnJobCardSwipingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_learn_job_card_swiping is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMLEARNSWIPEA: {
        if ("layout/item_learn_swipe_a_0".equals(tag)) {
          return new ItemLearnSwipeABindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_learn_swipe_a is invalid. Received: " + tag);
      }
    }
    return null;
  }

  private final ViewDataBinding internalGetViewDataBinding2(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_ITEMLEAVINGREASON: {
        if ("layout/item_leaving_reason_0".equals(tag)) {
          return new ItemLeavingReasonBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_leaving_reason is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMESSAGEAUDIO: {
        if ("layout/item_message_audio_0".equals(tag)) {
          return new ItemMessageAudioBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_message_audio is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMESSAGEIMAGE: {
        if ("layout/item_message_image_0".equals(tag)) {
          return new ItemMessageImageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_message_image is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMESSAGETEXT: {
        if ("layout/item_message_text_0".equals(tag)) {
          return new ItemMessageTextBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_message_text is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMNEWWISHLIST: {
        if ("layout/item_new_wishlist_0".equals(tag)) {
          return new ItemNewWishlistBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_new_wishlist is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMPHOTO: {
        if ("layout/item_photo_0".equals(tag)) {
          return new ItemPhotoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_photo is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMPORTFOLIOIMAGE2: {
        if ("layout/item_portfolio_image2_0".equals(tag)) {
          return new ItemPortfolioImage2BindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_portfolio_image2 is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMPORTFOLIOLINK: {
        if ("layout/item_portfolio_link_0".equals(tag)) {
          return new ItemPortfolioLinkBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_portfolio_link is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMPROFILEAUDIOVIDEO: {
        if ("layout/item_profile_audio_video_0".equals(tag)) {
          return new ItemProfileAudioVideoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_profile_audio_video is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMPROFILEBIO: {
        if ("layout/item_profile_bio_0".equals(tag)) {
          return new ItemProfileBioBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_profile_bio is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMPROFILEEDUCATION: {
        if ("layout/item_profile_education_0".equals(tag)) {
          return new ItemProfileEducationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_profile_education is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMPROFILEEXPERIENCE: {
        if ("layout/item_profile_experience_0".equals(tag)) {
          return new ItemProfileExperienceBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_profile_experience is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMPROFILEIDEALWORKSPACE: {
        if ("layout/item_profile_ideal_workspace_0".equals(tag)) {
          return new ItemProfileIdealWorkspaceBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_profile_ideal_workspace is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMPROFILEIMAGES: {
        if ("layout/item_profile_images_0".equals(tag)) {
          return new ItemProfileImagesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_profile_images is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMPROFILEINTEREST: {
        if ("layout/item_profile_interest_0".equals(tag)) {
          return new ItemProfileInterestBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_profile_interest is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMPROFILEPORTFOLIO: {
        if ("layout/item_profile_portfolio_0".equals(tag)) {
          return new ItemProfilePortfolioBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_profile_portfolio is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMPROFILESKILL: {
        if ("layout/item_profile_skill_0".equals(tag)) {
          return new ItemProfileSkillBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_profile_skill is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMPROFILEVOLUNTEERING: {
        if ("layout/item_profile_volunteering_0".equals(tag)) {
          return new ItemProfileVolunteeringBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_profile_volunteering is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMRECRUITERCHATLIST: {
        if ("layout/item_recruiter_chat_list_0".equals(tag)) {
          return new ItemRecruiterChatListBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_recruiter_chat_list is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMRECRUITERJOBCARD: {
        if ("layout/item_recruiter_job_card_0".equals(tag)) {
          return new ItemRecruiterJobCardBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_recruiter_job_card is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMSEARCHQUERYCOMPANY: {
        if ("layout/item_search_query_company_0".equals(tag)) {
          return new ItemSearchQueryCompanyBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_search_query_company is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMSEEKEREDUCATION: {
        if ("layout/item_seeker_education_0".equals(tag)) {
          return new ItemSeekerEducationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_seeker_education is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMSEEKEREXPERIENCE: {
        if ("layout/item_seeker_experience_0".equals(tag)) {
          return new ItemSeekerExperienceBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_seeker_experience is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMSEEKERHARDSKILL: {
        if ("layout/item_seeker_hard_skill_0".equals(tag)) {
          return new ItemSeekerHardSkillBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_seeker_hard_skill is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMSEEKERJOBCARD: {
        if ("layout/item_seeker_job_card_0".equals(tag)) {
          return new ItemSeekerJobCardBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_seeker_job_card is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMSEEKERSEARCHUNIVERSITY: {
        if ("layout/item_seeker_search_university_0".equals(tag)) {
          return new ItemSeekerSearchUniversityBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_seeker_search_university is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMSEEKERVOLUNTEERING: {
        if ("layout/item_seeker_volunteering_0".equals(tag)) {
          return new ItemSeekerVolunteeringBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_seeker_volunteering is invalid. Received: " + tag);
      }
      case  LAYOUT_LAYOUTIMAGEPICKER: {
        if ("layout/layout_image_picker_0".equals(tag)) {
          return new LayoutImagePickerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for layout_image_picker is invalid. Received: " + tag);
      }
      case  LAYOUT_TABBOTTOMRECRUITERNAVIGATION: {
        if ("layout/tab_bottom_recruiter_navigation_0".equals(tag)) {
          return new TabBottomRecruiterNavigationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for tab_bottom_recruiter_navigation is invalid. Received: " + tag);
      }
      case  LAYOUT_TABBOTTOMSEEKERNAVIGATION: {
        if ("layout/tab_bottom_seeker_navigation_0".equals(tag)) {
          return new TabBottomSeekerNavigationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for tab_bottom_seeker_navigation is invalid. Received: " + tag);
      }
      case  LAYOUT_TABMANUALFILTER: {
        if ("layout/tab_manual_filter_0".equals(tag)) {
          return new TabManualFilterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for tab_manual_filter is invalid. Received: " + tag);
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      // find which method will have it. -1 is necessary becausefirst id starts with 1;
      int methodIndex = (localizedLayoutId - 1) / 50;
      switch(methodIndex) {
        case 0: {
          return internalGetViewDataBinding0(component, view, localizedLayoutId, tag);
        }
        case 1: {
          return internalGetViewDataBinding1(component, view, localizedLayoutId, tag);
        }
        case 2: {
          return internalGetViewDataBinding2(component, view, localizedLayoutId, tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(4);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "data");
      sKeys.put(2, "handler");
      sKeys.put(3, "jobSeeker");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(131);

    static {
      sKeys.put("layout/activity_build_profile_0", com.jobamax.appjobamax.R.layout.activity_build_profile);
      sKeys.put("layout/activity_job_seeker_home_0", com.jobamax.appjobamax.R.layout.activity_job_seeker_home);
      sKeys.put("layout/activity_manual_and_personalize_0", com.jobamax.appjobamax.R.layout.activity_manual_and_personalize);
      sKeys.put("layout/activity_new_splash_0", com.jobamax.appjobamax.R.layout.activity_new_splash);
      sKeys.put("layout/activity_recruiter_chat_board_0", com.jobamax.appjobamax.R.layout.activity_recruiter_chat_board);
      sKeys.put("layout/activity_recruiter_home_0", com.jobamax.appjobamax.R.layout.activity_recruiter_home);
      sKeys.put("layout/activity_recruiter_setting_0", com.jobamax.appjobamax.R.layout.activity_recruiter_setting);
      sKeys.put("layout/activity_seeker_chat_board_0", com.jobamax.appjobamax.R.layout.activity_seeker_chat_board);
      sKeys.put("layout/activity_seeker_coaching_0", com.jobamax.appjobamax.R.layout.activity_seeker_coaching);
      sKeys.put("layout/activity_seeker_create_cv_0", com.jobamax.appjobamax.R.layout.activity_seeker_create_cv);
      sKeys.put("layout/activity_seeker_setting_0", com.jobamax.appjobamax.R.layout.activity_seeker_setting);
      sKeys.put("layout/activity_video_play_0", com.jobamax.appjobamax.R.layout.activity_video_play);
      sKeys.put("layout/activity_web_view_0", com.jobamax.appjobamax.R.layout.activity_web_view);
      sKeys.put("layout/dailog_change_university_0", com.jobamax.appjobamax.R.layout.dailog_change_university);
      sKeys.put("layout/dailog_wishlist_filter_0", com.jobamax.appjobamax.R.layout.dailog_wishlist_filter);
      sKeys.put("layout/dialog_add_document_0", com.jobamax.appjobamax.R.layout.dialog_add_document);
      sKeys.put("layout/dialog_add_link_0", com.jobamax.appjobamax.R.layout.dialog_add_link);
      sKeys.put("layout/dialog_add_or_take_video_0", com.jobamax.appjobamax.R.layout.dialog_add_or_take_video);
      sKeys.put("layout/dialog_add_to_folder_or_offer_0", com.jobamax.appjobamax.R.layout.dialog_add_to_folder_or_offer);
      sKeys.put("layout/dialog_build_profile_suggestion_0", com.jobamax.appjobamax.R.layout.dialog_build_profile_suggestion);
      sKeys.put("layout/dialog_delete_account_0", com.jobamax.appjobamax.R.layout.dialog_delete_account);
      sKeys.put("layout/dialog_filter_job_role_wise_0", com.jobamax.appjobamax.R.layout.dialog_filter_job_role_wise);
      sKeys.put("layout/dialog_job_matched_0", com.jobamax.appjobamax.R.layout.dialog_job_matched);
      sKeys.put("layout/dialog_job_seeker_thread_filter_0", com.jobamax.appjobamax.R.layout.dialog_job_seeker_thread_filter);
      sKeys.put("layout/dialog_qualifying_step_0", com.jobamax.appjobamax.R.layout.dialog_qualifying_step);
      sKeys.put("layout/dialog_report_0", com.jobamax.appjobamax.R.layout.dialog_report);
      sKeys.put("layout/dialog_repost_job_0", com.jobamax.appjobamax.R.layout.dialog_repost_job);
      sKeys.put("layout/dialog_see_post_job_offer_info_0", com.jobamax.appjobamax.R.layout.dialog_see_post_job_offer_info);
      sKeys.put("layout/dialog_seeker_folder_0", com.jobamax.appjobamax.R.layout.dialog_seeker_folder);
      sKeys.put("layout/dialog_simple_yes_no_0", com.jobamax.appjobamax.R.layout.dialog_simple_yes_no);
      sKeys.put("layout/dialog_skill_suggestion_0", com.jobamax.appjobamax.R.layout.dialog_skill_suggestion);
      sKeys.put("layout/dialog_title_message_0", com.jobamax.appjobamax.R.layout.dialog_title_message);
      sKeys.put("layout/dialog_work_experience_0", com.jobamax.appjobamax.R.layout.dialog_work_experience);
      sKeys.put("layout/dialog_work_type_0", com.jobamax.appjobamax.R.layout.dialog_work_type);
      sKeys.put("layout/dialog_yes_no_0", com.jobamax.appjobamax.R.layout.dialog_yes_no);
      sKeys.put("layout/dialog_yes_no_simple_0", com.jobamax.appjobamax.R.layout.dialog_yes_no_simple);
      sKeys.put("layout/fragment_add_audio_0", com.jobamax.appjobamax.R.layout.fragment_add_audio);
      sKeys.put("layout/fragment_add_new_education_0", com.jobamax.appjobamax.R.layout.fragment_add_new_education);
      sKeys.put("layout/fragment_add_new_experience_0", com.jobamax.appjobamax.R.layout.fragment_add_new_experience);
      sKeys.put("layout/fragment_add_new_volunteering_0", com.jobamax.appjobamax.R.layout.fragment_add_new_volunteering);
      sKeys.put("layout/fragment_add_video_0", com.jobamax.appjobamax.R.layout.fragment_add_video);
      sKeys.put("layout/fragment_audio_demo_0", com.jobamax.appjobamax.R.layout.fragment_audio_demo);
      sKeys.put("layout/fragment_create_c_v_0", com.jobamax.appjobamax.R.layout.fragment_create_c_v);
      sKeys.put("layout/fragment_create_profile_option_0", com.jobamax.appjobamax.R.layout.fragment_create_profile_option);
      sKeys.put("layout/fragment_filter_job_search_tag_0", com.jobamax.appjobamax.R.layout.fragment_filter_job_search_tag);
      sKeys.put("layout/fragment_forget_password_0", com.jobamax.appjobamax.R.layout.fragment_forget_password);
      sKeys.put("layout/fragment_import_profile_from_linked_in_0", com.jobamax.appjobamax.R.layout.fragment_import_profile_from_linked_in);
      sKeys.put("layout/fragment_job_match_info_dialog_0", com.jobamax.appjobamax.R.layout.fragment_job_match_info_dialog);
      sKeys.put("layout/fragment_job_seeker_account_0", com.jobamax.appjobamax.R.layout.fragment_job_seeker_account);
      sKeys.put("layout/fragment_job_seeker_manage_read_receipts_0", com.jobamax.appjobamax.R.layout.fragment_job_seeker_manage_read_receipts);
      sKeys.put("layout/fragment_job_seeker_newsletter_0", com.jobamax.appjobamax.R.layout.fragment_job_seeker_newsletter);
      sKeys.put("layout/fragment_job_seeker_personal_information_0", com.jobamax.appjobamax.R.layout.fragment_job_seeker_personal_information);
      sKeys.put("layout/fragment_login_registration_option_0", com.jobamax.appjobamax.R.layout.fragment_login_registration_option);
      sKeys.put("layout/fragment_manual_filter_0", com.jobamax.appjobamax.R.layout.fragment_manual_filter);
      sKeys.put("layout/fragment_manual_filter_main_0", com.jobamax.appjobamax.R.layout.fragment_manual_filter_main);
      sKeys.put("layout/fragment_modify_c_v_0", com.jobamax.appjobamax.R.layout.fragment_modify_c_v);
      sKeys.put("layout/fragment_modify_profile_0", com.jobamax.appjobamax.R.layout.fragment_modify_profile);
      sKeys.put("layout/fragment_personalize_filter_0", com.jobamax.appjobamax.R.layout.fragment_personalize_filter);
      sKeys.put("layout/fragment_personalize_filter_dialog_0", com.jobamax.appjobamax.R.layout.fragment_personalize_filter_dialog);
      sKeys.put("layout/fragment_pick_audio_0", com.jobamax.appjobamax.R.layout.fragment_pick_audio);
      sKeys.put("layout/fragment_pick_video_0", com.jobamax.appjobamax.R.layout.fragment_pick_video);
      sKeys.put("layout/fragment_privacy_policy_0", com.jobamax.appjobamax.R.layout.fragment_privacy_policy);
      sKeys.put("layout/fragment_profile_preview_0", com.jobamax.appjobamax.R.layout.fragment_profile_preview);
      sKeys.put("layout/fragment_recruiter_add_job_sourcing_criteria_0", com.jobamax.appjobamax.R.layout.fragment_recruiter_add_job_sourcing_criteria);
      sKeys.put("layout/fragment_recruiter_change_password_0", com.jobamax.appjobamax.R.layout.fragment_recruiter_change_password);
      sKeys.put("layout/fragment_recruiter_chat_list_0", com.jobamax.appjobamax.R.layout.fragment_recruiter_chat_list);
      sKeys.put("layout/fragment_recruiter_home_0", com.jobamax.appjobamax.R.layout.fragment_recruiter_home);
      sKeys.put("layout/fragment_recruiter_import_seeker_to_qualifying_step_dialog_0", com.jobamax.appjobamax.R.layout.fragment_recruiter_import_seeker_to_qualifying_step_dialog);
      sKeys.put("layout/fragment_recruiter_news_latter_0", com.jobamax.appjobamax.R.layout.fragment_recruiter_news_latter);
      sKeys.put("layout/fragment_recruiter_personal_info_0", com.jobamax.appjobamax.R.layout.fragment_recruiter_personal_info);
      sKeys.put("layout/fragment_recruiter_profile_0", com.jobamax.appjobamax.R.layout.fragment_recruiter_profile);
      sKeys.put("layout/fragment_recruiter_recruitment_seeker_profile_dialog_0", com.jobamax.appjobamax.R.layout.fragment_recruiter_recruitment_seeker_profile_dialog);
      sKeys.put("layout/fragment_recruiter_search_0", com.jobamax.appjobamax.R.layout.fragment_recruiter_search);
      sKeys.put("layout/fragment_recruiter_setting_0", com.jobamax.appjobamax.R.layout.fragment_recruiter_setting);
      sKeys.put("layout/fragment_seeker_change_password_0", com.jobamax.appjobamax.R.layout.fragment_seeker_change_password);
      sKeys.put("layout/fragment_seeker_chat_list_0", com.jobamax.appjobamax.R.layout.fragment_seeker_chat_list);
      sKeys.put("layout/fragment_seeker_delete_account_0", com.jobamax.appjobamax.R.layout.fragment_seeker_delete_account);
      sKeys.put("layout/fragment_seeker_delete_account_final_0", com.jobamax.appjobamax.R.layout.fragment_seeker_delete_account_final);
      sKeys.put("layout/fragment_seeker_download_cv_0", com.jobamax.appjobamax.R.layout.fragment_seeker_download_cv);
      sKeys.put("layout/fragment_seeker_format_cv_0", com.jobamax.appjobamax.R.layout.fragment_seeker_format_cv);
      sKeys.put("layout/fragment_seeker_learn_job_card_swiping_dialog_0", com.jobamax.appjobamax.R.layout.fragment_seeker_learn_job_card_swiping_dialog);
      sKeys.put("layout/fragment_seeker_profile_0", com.jobamax.appjobamax.R.layout.fragment_seeker_profile);
      sKeys.put("layout/fragment_seeker_search_job_0", com.jobamax.appjobamax.R.layout.fragment_seeker_search_job);
      sKeys.put("layout/fragment_seeker_wishlist_0", com.jobamax.appjobamax.R.layout.fragment_seeker_wishlist);
      sKeys.put("layout/fragment_take_age_0", com.jobamax.appjobamax.R.layout.fragment_take_age);
      sKeys.put("layout/fragment_take_email_0", com.jobamax.appjobamax.R.layout.fragment_take_email);
      sKeys.put("layout/fragment_take_name_0", com.jobamax.appjobamax.R.layout.fragment_take_name);
      sKeys.put("layout/fragment_take_password_0", com.jobamax.appjobamax.R.layout.fragment_take_password);
      sKeys.put("layout/fragment_take_university_0", com.jobamax.appjobamax.R.layout.fragment_take_university);
      sKeys.put("layout/fragment_take_work_experience_0", com.jobamax.appjobamax.R.layout.fragment_take_work_experience);
      sKeys.put("layout/fragment_user_login_0", com.jobamax.appjobamax.R.layout.fragment_user_login);
      sKeys.put("layout/fragment_user_role_0", com.jobamax.appjobamax.R.layout.fragment_user_role);
      sKeys.put("layout/fragment_video_demo_0", com.jobamax.appjobamax.R.layout.fragment_video_demo);
      sKeys.put("layout/item_education_adapter_0", com.jobamax.appjobamax.R.layout.item_education_adapter);
      sKeys.put("layout/item_folder_seeker_0", com.jobamax.appjobamax.R.layout.item_folder_seeker);
      sKeys.put("layout/item_image_0", com.jobamax.appjobamax.R.layout.item_image);
      sKeys.put("layout/item_job_criteria_category_0", com.jobamax.appjobamax.R.layout.item_job_criteria_category);
      sKeys.put("layout/item_job_seeker_chat_list_0", com.jobamax.appjobamax.R.layout.item_job_seeker_chat_list);
      sKeys.put("layout/item_learn_job_card_swiping_0", com.jobamax.appjobamax.R.layout.item_learn_job_card_swiping);
      sKeys.put("layout/item_learn_swipe_a_0", com.jobamax.appjobamax.R.layout.item_learn_swipe_a);
      sKeys.put("layout/item_leaving_reason_0", com.jobamax.appjobamax.R.layout.item_leaving_reason);
      sKeys.put("layout/item_message_audio_0", com.jobamax.appjobamax.R.layout.item_message_audio);
      sKeys.put("layout/item_message_image_0", com.jobamax.appjobamax.R.layout.item_message_image);
      sKeys.put("layout/item_message_text_0", com.jobamax.appjobamax.R.layout.item_message_text);
      sKeys.put("layout/item_new_wishlist_0", com.jobamax.appjobamax.R.layout.item_new_wishlist);
      sKeys.put("layout/item_photo_0", com.jobamax.appjobamax.R.layout.item_photo);
      sKeys.put("layout/item_portfolio_image2_0", com.jobamax.appjobamax.R.layout.item_portfolio_image2);
      sKeys.put("layout/item_portfolio_link_0", com.jobamax.appjobamax.R.layout.item_portfolio_link);
      sKeys.put("layout/item_profile_audio_video_0", com.jobamax.appjobamax.R.layout.item_profile_audio_video);
      sKeys.put("layout/item_profile_bio_0", com.jobamax.appjobamax.R.layout.item_profile_bio);
      sKeys.put("layout/item_profile_education_0", com.jobamax.appjobamax.R.layout.item_profile_education);
      sKeys.put("layout/item_profile_experience_0", com.jobamax.appjobamax.R.layout.item_profile_experience);
      sKeys.put("layout/item_profile_ideal_workspace_0", com.jobamax.appjobamax.R.layout.item_profile_ideal_workspace);
      sKeys.put("layout/item_profile_images_0", com.jobamax.appjobamax.R.layout.item_profile_images);
      sKeys.put("layout/item_profile_interest_0", com.jobamax.appjobamax.R.layout.item_profile_interest);
      sKeys.put("layout/item_profile_portfolio_0", com.jobamax.appjobamax.R.layout.item_profile_portfolio);
      sKeys.put("layout/item_profile_skill_0", com.jobamax.appjobamax.R.layout.item_profile_skill);
      sKeys.put("layout/item_profile_volunteering_0", com.jobamax.appjobamax.R.layout.item_profile_volunteering);
      sKeys.put("layout/item_recruiter_chat_list_0", com.jobamax.appjobamax.R.layout.item_recruiter_chat_list);
      sKeys.put("layout/item_recruiter_job_card_0", com.jobamax.appjobamax.R.layout.item_recruiter_job_card);
      sKeys.put("layout/item_search_query_company_0", com.jobamax.appjobamax.R.layout.item_search_query_company);
      sKeys.put("layout/item_seeker_education_0", com.jobamax.appjobamax.R.layout.item_seeker_education);
      sKeys.put("layout/item_seeker_experience_0", com.jobamax.appjobamax.R.layout.item_seeker_experience);
      sKeys.put("layout/item_seeker_hard_skill_0", com.jobamax.appjobamax.R.layout.item_seeker_hard_skill);
      sKeys.put("layout/item_seeker_job_card_0", com.jobamax.appjobamax.R.layout.item_seeker_job_card);
      sKeys.put("layout/item_seeker_search_university_0", com.jobamax.appjobamax.R.layout.item_seeker_search_university);
      sKeys.put("layout/item_seeker_volunteering_0", com.jobamax.appjobamax.R.layout.item_seeker_volunteering);
      sKeys.put("layout/layout_image_picker_0", com.jobamax.appjobamax.R.layout.layout_image_picker);
      sKeys.put("layout/tab_bottom_recruiter_navigation_0", com.jobamax.appjobamax.R.layout.tab_bottom_recruiter_navigation);
      sKeys.put("layout/tab_bottom_seeker_navigation_0", com.jobamax.appjobamax.R.layout.tab_bottom_seeker_navigation);
      sKeys.put("layout/tab_manual_filter_0", com.jobamax.appjobamax.R.layout.tab_manual_filter);
    }
  }
}
