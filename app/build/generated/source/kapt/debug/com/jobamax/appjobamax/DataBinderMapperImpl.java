package com.jobamax.appjobamax;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jobamax.appjobamax.databinding.ActivityJobSeekerHomeBindingImpl;
import com.jobamax.appjobamax.databinding.ActivityJobSeekerPasswordBindingImpl;
import com.jobamax.appjobamax.databinding.ActivityJobSeekerPersonalIntroInfoBindingImpl;
import com.jobamax.appjobamax.databinding.ActivityLicenseBindingImpl;
import com.jobamax.appjobamax.databinding.ActivityLoginBindingImpl;
import com.jobamax.appjobamax.databinding.ActivityMainBindingImpl;
import com.jobamax.appjobamax.databinding.ActivityMapsBindingImpl;
import com.jobamax.appjobamax.databinding.ActivityPrivacyPreferenceBindingImpl;
import com.jobamax.appjobamax.databinding.ActivitySeekerJobSearchBindingImpl;
import com.jobamax.appjobamax.databinding.ActivitySeekerJobWebBindingImpl;
import com.jobamax.appjobamax.databinding.ActivitySplashBindingImpl;
import com.jobamax.appjobamax.databinding.ActivityVideoPlayBindingImpl;
import com.jobamax.appjobamax.databinding.ActivityWebViewBindingImpl;
import com.jobamax.appjobamax.databinding.CalendarCellBindingImpl;
import com.jobamax.appjobamax.databinding.DialogAddTrackingJobPhaseBindingImpl;
import com.jobamax.appjobamax.databinding.DialogDeleteAccountBindingImpl;
import com.jobamax.appjobamax.databinding.DialogRepostJobBindingImpl;
import com.jobamax.appjobamax.databinding.DialogSimpleYesNoBindingImpl;
import com.jobamax.appjobamax.databinding.DialogYesNoBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentIdealJobAudioBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentIdealJobDescriptionBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentIdealJobImagesBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentIdealJobVideoBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentJobSeekerAccountBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentJobSeekerChangeLanguageBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentJobSeekerHomeBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentJobSeekerManageReadReceiptsBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentJobSeekerNewsletterBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentJobSeekerPersonalInformationBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentJobSeekerPushNotificationBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentKeepMePostedBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentLocationPermissionBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentLoginBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentMeetNearbyPeopleBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentPortfolioDescriptionBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentPortfolioImageBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentPortfolioVideoBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentRegisterBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerAboutMeBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerAboutMeScannerBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerAddExperienceBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerAddPersonalTrackJobBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerAddVolunteeringBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerCalenderBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerChangePasswordBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerCoachingBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerDeleteAccountBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerDeleteAccountFinalBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerEducationBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerExperienceListBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerFilterJobBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerImportResumeBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerInterestBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerJobMatchInfoDialogBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerJobSearchFilterCategoriesBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerJobsBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerJobsFilterBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerMySkillBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerNewEducationBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerPreviewBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerProfileBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerSocialMediaIdsBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerTrackingJobBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerTrackingJobDescriptionBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerTrackingJobDetailsBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerTrackingJobFilterDialogBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerVolunteeringListBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentSeekerWishListBindingImpl;
import com.jobamax.appjobamax.databinding.FragmentValuePrivacyBindingImpl;
import com.jobamax.appjobamax.databinding.ItemCalenderEventCardBindingImpl;
import com.jobamax.appjobamax.databinding.ItemCategoryChipBindingImpl;
import com.jobamax.appjobamax.databinding.ItemCheapBindingImpl;
import com.jobamax.appjobamax.databinding.ItemImageBindingImpl;
import com.jobamax.appjobamax.databinding.ItemJobSearchFilterCategoryBindingImpl;
import com.jobamax.appjobamax.databinding.ItemJobTitleBindingImpl;
import com.jobamax.appjobamax.databinding.ItemLeavingReasonBindingImpl;
import com.jobamax.appjobamax.databinding.ItemLinkBindingImpl;
import com.jobamax.appjobamax.databinding.ItemPortfolioImageBindingImpl;
import com.jobamax.appjobamax.databinding.ItemPortfolioLinkBindingImpl;
import com.jobamax.appjobamax.databinding.ItemSearchQueryCompanyBindingImpl;
import com.jobamax.appjobamax.databinding.ItemSeekerEducationBindingImpl;
import com.jobamax.appjobamax.databinding.ItemSeekerExperienceBindingImpl;
import com.jobamax.appjobamax.databinding.ItemSeekerHardSkillBindingImpl;
import com.jobamax.appjobamax.databinding.ItemSeekerJobCardBindingImpl;
import com.jobamax.appjobamax.databinding.ItemSeekerOtherJobBindingImpl;
import com.jobamax.appjobamax.databinding.ItemSeekerPreviewExperienceBindingImpl;
import com.jobamax.appjobamax.databinding.ItemSeekerPreviewHardSkillBindingImpl;
import com.jobamax.appjobamax.databinding.ItemSeekerPreviewSchoolBindingImpl;
import com.jobamax.appjobamax.databinding.ItemSeekerPreviewVolunteeringBindingImpl;
import com.jobamax.appjobamax.databinding.ItemSeekerSearchUniversityBindingImpl;
import com.jobamax.appjobamax.databinding.ItemSeekerTrackBindingImpl;
import com.jobamax.appjobamax.databinding.ItemSeekerTrackingJobDetailCardBindingImpl;
import com.jobamax.appjobamax.databinding.ItemSeekerVolunteeringBindingImpl;
import com.jobamax.appjobamax.databinding.ItemWishlistJobBindingImpl;
import com.jobamax.appjobamax.databinding.PopupAddJobToTrackBindingImpl;
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
  private static final int LAYOUT_ACTIVITYJOBSEEKERHOME = 1;

  private static final int LAYOUT_ACTIVITYJOBSEEKERPASSWORD = 2;

  private static final int LAYOUT_ACTIVITYJOBSEEKERPERSONALINTROINFO = 3;

  private static final int LAYOUT_ACTIVITYLICENSE = 4;

  private static final int LAYOUT_ACTIVITYLOGIN = 5;

  private static final int LAYOUT_ACTIVITYMAIN = 6;

  private static final int LAYOUT_ACTIVITYMAPS = 7;

  private static final int LAYOUT_ACTIVITYPRIVACYPREFERENCE = 8;

  private static final int LAYOUT_ACTIVITYSEEKERJOBSEARCH = 9;

  private static final int LAYOUT_ACTIVITYSEEKERJOBWEB = 10;

  private static final int LAYOUT_ACTIVITYSPLASH = 11;

  private static final int LAYOUT_ACTIVITYVIDEOPLAY = 12;

  private static final int LAYOUT_ACTIVITYWEBVIEW = 13;

  private static final int LAYOUT_CALENDARCELL = 14;

  private static final int LAYOUT_DIALOGADDTRACKINGJOBPHASE = 15;

  private static final int LAYOUT_DIALOGDELETEACCOUNT = 16;

  private static final int LAYOUT_DIALOGREPOSTJOB = 17;

  private static final int LAYOUT_DIALOGSIMPLEYESNO = 18;

  private static final int LAYOUT_DIALOGYESNO = 19;

  private static final int LAYOUT_FRAGMENTIDEALJOBAUDIO = 20;

  private static final int LAYOUT_FRAGMENTIDEALJOBDESCRIPTION = 21;

  private static final int LAYOUT_FRAGMENTIDEALJOBIMAGES = 22;

  private static final int LAYOUT_FRAGMENTIDEALJOBVIDEO = 23;

  private static final int LAYOUT_FRAGMENTJOBSEEKERACCOUNT = 24;

  private static final int LAYOUT_FRAGMENTJOBSEEKERCHANGELANGUAGE = 25;

  private static final int LAYOUT_FRAGMENTJOBSEEKERHOME = 26;

  private static final int LAYOUT_FRAGMENTJOBSEEKERMANAGEREADRECEIPTS = 27;

  private static final int LAYOUT_FRAGMENTJOBSEEKERNEWSLETTER = 28;

  private static final int LAYOUT_FRAGMENTJOBSEEKERPERSONALINFORMATION = 29;

  private static final int LAYOUT_FRAGMENTJOBSEEKERPUSHNOTIFICATION = 30;

  private static final int LAYOUT_FRAGMENTKEEPMEPOSTED = 31;

  private static final int LAYOUT_FRAGMENTLOCATIONPERMISSION = 32;

  private static final int LAYOUT_FRAGMENTLOGIN = 33;

  private static final int LAYOUT_FRAGMENTMEETNEARBYPEOPLE = 34;

  private static final int LAYOUT_FRAGMENTPORTFOLIODESCRIPTION = 35;

  private static final int LAYOUT_FRAGMENTPORTFOLIOIMAGE = 36;

  private static final int LAYOUT_FRAGMENTPORTFOLIOVIDEO = 37;

  private static final int LAYOUT_FRAGMENTREGISTER = 38;

  private static final int LAYOUT_FRAGMENTSEEKERABOUTME = 39;

  private static final int LAYOUT_FRAGMENTSEEKERABOUTMESCANNER = 40;

  private static final int LAYOUT_FRAGMENTSEEKERADDEXPERIENCE = 41;

  private static final int LAYOUT_FRAGMENTSEEKERADDPERSONALTRACKJOB = 42;

  private static final int LAYOUT_FRAGMENTSEEKERADDVOLUNTEERING = 43;

  private static final int LAYOUT_FRAGMENTSEEKERCALENDER = 44;

  private static final int LAYOUT_FRAGMENTSEEKERCHANGEPASSWORD = 45;

  private static final int LAYOUT_FRAGMENTSEEKERCOACHING = 46;

  private static final int LAYOUT_FRAGMENTSEEKERDELETEACCOUNT = 47;

  private static final int LAYOUT_FRAGMENTSEEKERDELETEACCOUNTFINAL = 48;

  private static final int LAYOUT_FRAGMENTSEEKEREDUCATION = 49;

  private static final int LAYOUT_FRAGMENTSEEKEREXPERIENCELIST = 50;

  private static final int LAYOUT_FRAGMENTSEEKERFILTERJOB = 51;

  private static final int LAYOUT_FRAGMENTSEEKERIMPORTRESUME = 52;

  private static final int LAYOUT_FRAGMENTSEEKERINTEREST = 53;

  private static final int LAYOUT_FRAGMENTSEEKERJOBMATCHINFODIALOG = 54;

  private static final int LAYOUT_FRAGMENTSEEKERJOBSEARCHFILTERCATEGORIES = 55;

  private static final int LAYOUT_FRAGMENTSEEKERJOBS = 56;

  private static final int LAYOUT_FRAGMENTSEEKERJOBSFILTER = 57;

  private static final int LAYOUT_FRAGMENTSEEKERMYSKILL = 58;

  private static final int LAYOUT_FRAGMENTSEEKERNEWEDUCATION = 59;

  private static final int LAYOUT_FRAGMENTSEEKERPREVIEW = 60;

  private static final int LAYOUT_FRAGMENTSEEKERPROFILE = 61;

  private static final int LAYOUT_FRAGMENTSEEKERSOCIALMEDIAIDS = 62;

  private static final int LAYOUT_FRAGMENTSEEKERTRACKINGJOB = 63;

  private static final int LAYOUT_FRAGMENTSEEKERTRACKINGJOBDESCRIPTION = 64;

  private static final int LAYOUT_FRAGMENTSEEKERTRACKINGJOBDETAILS = 65;

  private static final int LAYOUT_FRAGMENTSEEKERTRACKINGJOBFILTERDIALOG = 66;

  private static final int LAYOUT_FRAGMENTSEEKERVOLUNTEERINGLIST = 67;

  private static final int LAYOUT_FRAGMENTSEEKERWISHLIST = 68;

  private static final int LAYOUT_FRAGMENTVALUEPRIVACY = 69;

  private static final int LAYOUT_ITEMCALENDEREVENTCARD = 70;

  private static final int LAYOUT_ITEMCATEGORYCHIP = 71;

  private static final int LAYOUT_ITEMCHEAP = 72;

  private static final int LAYOUT_ITEMIMAGE = 73;

  private static final int LAYOUT_ITEMJOBSEARCHFILTERCATEGORY = 74;

  private static final int LAYOUT_ITEMJOBTITLE = 75;

  private static final int LAYOUT_ITEMLEAVINGREASON = 76;

  private static final int LAYOUT_ITEMLINK = 77;

  private static final int LAYOUT_ITEMPORTFOLIOIMAGE = 78;

  private static final int LAYOUT_ITEMPORTFOLIOLINK = 79;

  private static final int LAYOUT_ITEMSEARCHQUERYCOMPANY = 80;

  private static final int LAYOUT_ITEMSEEKEREDUCATION = 81;

  private static final int LAYOUT_ITEMSEEKEREXPERIENCE = 82;

  private static final int LAYOUT_ITEMSEEKERHARDSKILL = 83;

  private static final int LAYOUT_ITEMSEEKERJOBCARD = 84;

  private static final int LAYOUT_ITEMSEEKEROTHERJOB = 85;

  private static final int LAYOUT_ITEMSEEKERPREVIEWEXPERIENCE = 86;

  private static final int LAYOUT_ITEMSEEKERPREVIEWHARDSKILL = 87;

  private static final int LAYOUT_ITEMSEEKERPREVIEWSCHOOL = 88;

  private static final int LAYOUT_ITEMSEEKERPREVIEWVOLUNTEERING = 89;

  private static final int LAYOUT_ITEMSEEKERSEARCHUNIVERSITY = 90;

  private static final int LAYOUT_ITEMSEEKERTRACK = 91;

  private static final int LAYOUT_ITEMSEEKERTRACKINGJOBDETAILCARD = 92;

  private static final int LAYOUT_ITEMSEEKERVOLUNTEERING = 93;

  private static final int LAYOUT_ITEMWISHLISTJOB = 94;

  private static final int LAYOUT_POPUPADDJOBTOTRACK = 95;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(95);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.activity_job_seeker_home, LAYOUT_ACTIVITYJOBSEEKERHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.activity_job_seeker_password, LAYOUT_ACTIVITYJOBSEEKERPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.activity_job_seeker_personal_intro_info, LAYOUT_ACTIVITYJOBSEEKERPERSONALINTROINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.activity_license, LAYOUT_ACTIVITYLICENSE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.activity_maps, LAYOUT_ACTIVITYMAPS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.activity_privacy_preference, LAYOUT_ACTIVITYPRIVACYPREFERENCE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.activity_seeker_job_search, LAYOUT_ACTIVITYSEEKERJOBSEARCH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.activity_seeker_job_web, LAYOUT_ACTIVITYSEEKERJOBWEB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.activity_splash, LAYOUT_ACTIVITYSPLASH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.activity_video_play, LAYOUT_ACTIVITYVIDEOPLAY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.activity_web_view, LAYOUT_ACTIVITYWEBVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.calendar_cell, LAYOUT_CALENDARCELL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dialog_add_tracking_job_phase, LAYOUT_DIALOGADDTRACKINGJOBPHASE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dialog_delete_account, LAYOUT_DIALOGDELETEACCOUNT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dialog_repost_job, LAYOUT_DIALOGREPOSTJOB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dialog_simple_yes_no, LAYOUT_DIALOGSIMPLEYESNO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.dialog_yes_no, LAYOUT_DIALOGYESNO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_ideal_job_audio, LAYOUT_FRAGMENTIDEALJOBAUDIO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_ideal_job_description, LAYOUT_FRAGMENTIDEALJOBDESCRIPTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_ideal_job_images, LAYOUT_FRAGMENTIDEALJOBIMAGES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_ideal_job_video, LAYOUT_FRAGMENTIDEALJOBVIDEO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_job_seeker_account, LAYOUT_FRAGMENTJOBSEEKERACCOUNT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_job_seeker_change_language, LAYOUT_FRAGMENTJOBSEEKERCHANGELANGUAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_job_seeker_home, LAYOUT_FRAGMENTJOBSEEKERHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_job_seeker_manage_read_receipts, LAYOUT_FRAGMENTJOBSEEKERMANAGEREADRECEIPTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_job_seeker_newsletter, LAYOUT_FRAGMENTJOBSEEKERNEWSLETTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_job_seeker_personal_information, LAYOUT_FRAGMENTJOBSEEKERPERSONALINFORMATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_job_seeker_push_notification, LAYOUT_FRAGMENTJOBSEEKERPUSHNOTIFICATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_keep_me_posted, LAYOUT_FRAGMENTKEEPMEPOSTED);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_location_permission, LAYOUT_FRAGMENTLOCATIONPERMISSION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_login, LAYOUT_FRAGMENTLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_meet_nearby_people, LAYOUT_FRAGMENTMEETNEARBYPEOPLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_portfolio_description, LAYOUT_FRAGMENTPORTFOLIODESCRIPTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_portfolio_image, LAYOUT_FRAGMENTPORTFOLIOIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_portfolio_video, LAYOUT_FRAGMENTPORTFOLIOVIDEO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_register, LAYOUT_FRAGMENTREGISTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_about_me, LAYOUT_FRAGMENTSEEKERABOUTME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_about_me_scanner, LAYOUT_FRAGMENTSEEKERABOUTMESCANNER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_add_experience, LAYOUT_FRAGMENTSEEKERADDEXPERIENCE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_add_personal_track_job, LAYOUT_FRAGMENTSEEKERADDPERSONALTRACKJOB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_add_volunteering, LAYOUT_FRAGMENTSEEKERADDVOLUNTEERING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_calender, LAYOUT_FRAGMENTSEEKERCALENDER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_change_password, LAYOUT_FRAGMENTSEEKERCHANGEPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_coaching, LAYOUT_FRAGMENTSEEKERCOACHING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_delete_account, LAYOUT_FRAGMENTSEEKERDELETEACCOUNT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_delete_account_final, LAYOUT_FRAGMENTSEEKERDELETEACCOUNTFINAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_education, LAYOUT_FRAGMENTSEEKEREDUCATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_experience_list, LAYOUT_FRAGMENTSEEKEREXPERIENCELIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_filter_job, LAYOUT_FRAGMENTSEEKERFILTERJOB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_import_resume, LAYOUT_FRAGMENTSEEKERIMPORTRESUME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_interest, LAYOUT_FRAGMENTSEEKERINTEREST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_job_match_info_dialog, LAYOUT_FRAGMENTSEEKERJOBMATCHINFODIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_job_search_filter_categories, LAYOUT_FRAGMENTSEEKERJOBSEARCHFILTERCATEGORIES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_jobs, LAYOUT_FRAGMENTSEEKERJOBS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_jobs_filter, LAYOUT_FRAGMENTSEEKERJOBSFILTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_my_skill, LAYOUT_FRAGMENTSEEKERMYSKILL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_new_education, LAYOUT_FRAGMENTSEEKERNEWEDUCATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_preview, LAYOUT_FRAGMENTSEEKERPREVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_profile, LAYOUT_FRAGMENTSEEKERPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_social_media_ids, LAYOUT_FRAGMENTSEEKERSOCIALMEDIAIDS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_tracking_job, LAYOUT_FRAGMENTSEEKERTRACKINGJOB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_tracking_job_description, LAYOUT_FRAGMENTSEEKERTRACKINGJOBDESCRIPTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_tracking_job_details, LAYOUT_FRAGMENTSEEKERTRACKINGJOBDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_tracking_job_filter_dialog, LAYOUT_FRAGMENTSEEKERTRACKINGJOBFILTERDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_volunteering_list, LAYOUT_FRAGMENTSEEKERVOLUNTEERINGLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_seeker_wish_list, LAYOUT_FRAGMENTSEEKERWISHLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.fragment_value_privacy, LAYOUT_FRAGMENTVALUEPRIVACY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_calender_event_card, LAYOUT_ITEMCALENDEREVENTCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_category_chip, LAYOUT_ITEMCATEGORYCHIP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_cheap, LAYOUT_ITEMCHEAP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_image, LAYOUT_ITEMIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_job_search_filter_category, LAYOUT_ITEMJOBSEARCHFILTERCATEGORY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_job_title, LAYOUT_ITEMJOBTITLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_leaving_reason, LAYOUT_ITEMLEAVINGREASON);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_link, LAYOUT_ITEMLINK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_portfolio_image, LAYOUT_ITEMPORTFOLIOIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_portfolio_link, LAYOUT_ITEMPORTFOLIOLINK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_search_query_company, LAYOUT_ITEMSEARCHQUERYCOMPANY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_seeker_education, LAYOUT_ITEMSEEKEREDUCATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_seeker_experience, LAYOUT_ITEMSEEKEREXPERIENCE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_seeker_hard_skill, LAYOUT_ITEMSEEKERHARDSKILL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_seeker_job_card, LAYOUT_ITEMSEEKERJOBCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_seeker_other_job, LAYOUT_ITEMSEEKEROTHERJOB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_seeker_preview_experience, LAYOUT_ITEMSEEKERPREVIEWEXPERIENCE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_seeker_preview_hard_skill, LAYOUT_ITEMSEEKERPREVIEWHARDSKILL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_seeker_preview_school, LAYOUT_ITEMSEEKERPREVIEWSCHOOL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_seeker_preview_volunteering, LAYOUT_ITEMSEEKERPREVIEWVOLUNTEERING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_seeker_search_university, LAYOUT_ITEMSEEKERSEARCHUNIVERSITY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_seeker_track, LAYOUT_ITEMSEEKERTRACK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_seeker_tracking_job_detail_card, LAYOUT_ITEMSEEKERTRACKINGJOBDETAILCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_seeker_volunteering, LAYOUT_ITEMSEEKERVOLUNTEERING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.item_wishlist_job, LAYOUT_ITEMWISHLISTJOB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jobamax.appjobamax.R.layout.popup_add_job_to_track, LAYOUT_POPUPADDJOBTOTRACK);
  }

  private final ViewDataBinding internalGetViewDataBinding0(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_ACTIVITYJOBSEEKERHOME: {
        if ("layout/activity_job_seeker_home_0".equals(tag)) {
          return new ActivityJobSeekerHomeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_job_seeker_home is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYJOBSEEKERPASSWORD: {
        if ("layout/activity_job_seeker_password_0".equals(tag)) {
          return new ActivityJobSeekerPasswordBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_job_seeker_password is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYJOBSEEKERPERSONALINTROINFO: {
        if ("layout/activity_job_seeker_personal_intro_info_0".equals(tag)) {
          return new ActivityJobSeekerPersonalIntroInfoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_job_seeker_personal_intro_info is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYLICENSE: {
        if ("layout/activity_license_0".equals(tag)) {
          return new ActivityLicenseBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_license is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYLOGIN: {
        if ("layout/activity_login_0".equals(tag)) {
          return new ActivityLoginBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMAIN: {
        if ("layout/activity_main_0".equals(tag)) {
          return new ActivityMainBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMAPS: {
        if ("layout/activity_maps_0".equals(tag)) {
          return new ActivityMapsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_maps is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPRIVACYPREFERENCE: {
        if ("layout/activity_privacy_preference_0".equals(tag)) {
          return new ActivityPrivacyPreferenceBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_privacy_preference is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSEEKERJOBSEARCH: {
        if ("layout/activity_seeker_job_search_0".equals(tag)) {
          return new ActivitySeekerJobSearchBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_seeker_job_search is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSEEKERJOBWEB: {
        if ("layout/activity_seeker_job_web_0".equals(tag)) {
          return new ActivitySeekerJobWebBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_seeker_job_web is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSPLASH: {
        if ("layout/activity_splash_0".equals(tag)) {
          return new ActivitySplashBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_splash is invalid. Received: " + tag);
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
      case  LAYOUT_CALENDARCELL: {
        if ("layout/calendar_cell_0".equals(tag)) {
          return new CalendarCellBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for calendar_cell is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGADDTRACKINGJOBPHASE: {
        if ("layout/dialog_add_tracking_job_phase_0".equals(tag)) {
          return new DialogAddTrackingJobPhaseBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_add_tracking_job_phase is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGDELETEACCOUNT: {
        if ("layout/dialog_delete_account_0".equals(tag)) {
          return new DialogDeleteAccountBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_delete_account is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGREPOSTJOB: {
        if ("layout/dialog_repost_job_0".equals(tag)) {
          return new DialogRepostJobBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_repost_job is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGSIMPLEYESNO: {
        if ("layout/dialog_simple_yes_no_0".equals(tag)) {
          return new DialogSimpleYesNoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_simple_yes_no is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGYESNO: {
        if ("layout/dialog_yes_no_0".equals(tag)) {
          return new DialogYesNoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_yes_no is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTIDEALJOBAUDIO: {
        if ("layout/fragment_ideal_job_audio_0".equals(tag)) {
          return new FragmentIdealJobAudioBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_ideal_job_audio is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTIDEALJOBDESCRIPTION: {
        if ("layout/fragment_ideal_job_description_0".equals(tag)) {
          return new FragmentIdealJobDescriptionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_ideal_job_description is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTIDEALJOBIMAGES: {
        if ("layout/fragment_ideal_job_images_0".equals(tag)) {
          return new FragmentIdealJobImagesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_ideal_job_images is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTIDEALJOBVIDEO: {
        if ("layout/fragment_ideal_job_video_0".equals(tag)) {
          return new FragmentIdealJobVideoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_ideal_job_video is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTJOBSEEKERACCOUNT: {
        if ("layout/fragment_job_seeker_account_0".equals(tag)) {
          return new FragmentJobSeekerAccountBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_job_seeker_account is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTJOBSEEKERCHANGELANGUAGE: {
        if ("layout/fragment_job_seeker_change_language_0".equals(tag)) {
          return new FragmentJobSeekerChangeLanguageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_job_seeker_change_language is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTJOBSEEKERHOME: {
        if ("layout/fragment_job_seeker_home_0".equals(tag)) {
          return new FragmentJobSeekerHomeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_job_seeker_home is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTJOBSEEKERMANAGEREADRECEIPTS: {
        if ("layout/fragment_job_seeker_manage_read_receipts_0".equals(tag)) {
          return new FragmentJobSeekerManageReadReceiptsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_job_seeker_manage_read_receipts is invalid. Received: " + tag);
      }
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
      case  LAYOUT_FRAGMENTJOBSEEKERPUSHNOTIFICATION: {
        if ("layout/fragment_job_seeker_push_notification_0".equals(tag)) {
          return new FragmentJobSeekerPushNotificationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_job_seeker_push_notification is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTKEEPMEPOSTED: {
        if ("layout/fragment_keep_me_posted_0".equals(tag)) {
          return new FragmentKeepMePostedBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_keep_me_posted is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTLOCATIONPERMISSION: {
        if ("layout/fragment_location_permission_0".equals(tag)) {
          return new FragmentLocationPermissionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_location_permission is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTLOGIN: {
        if ("layout/fragment_login_0".equals(tag)) {
          return new FragmentLoginBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_login is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTMEETNEARBYPEOPLE: {
        if ("layout/fragment_meet_nearby_people_0".equals(tag)) {
          return new FragmentMeetNearbyPeopleBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_meet_nearby_people is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTPORTFOLIODESCRIPTION: {
        if ("layout/fragment_portfolio_description_0".equals(tag)) {
          return new FragmentPortfolioDescriptionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_portfolio_description is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTPORTFOLIOIMAGE: {
        if ("layout/fragment_portfolio_image_0".equals(tag)) {
          return new FragmentPortfolioImageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_portfolio_image is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTPORTFOLIOVIDEO: {
        if ("layout/fragment_portfolio_video_0".equals(tag)) {
          return new FragmentPortfolioVideoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_portfolio_video is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTREGISTER: {
        if ("layout/fragment_register_0".equals(tag)) {
          return new FragmentRegisterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_register is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERABOUTME: {
        if ("layout/fragment_seeker_about_me_0".equals(tag)) {
          return new FragmentSeekerAboutMeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_about_me is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERABOUTMESCANNER: {
        if ("layout/fragment_seeker_about_me_scanner_0".equals(tag)) {
          return new FragmentSeekerAboutMeScannerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_about_me_scanner is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERADDEXPERIENCE: {
        if ("layout/fragment_seeker_add_experience_0".equals(tag)) {
          return new FragmentSeekerAddExperienceBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_add_experience is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERADDPERSONALTRACKJOB: {
        if ("layout/fragment_seeker_add_personal_track_job_0".equals(tag)) {
          return new FragmentSeekerAddPersonalTrackJobBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_add_personal_track_job is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERADDVOLUNTEERING: {
        if ("layout/fragment_seeker_add_volunteering_0".equals(tag)) {
          return new FragmentSeekerAddVolunteeringBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_add_volunteering is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERCALENDER: {
        if ("layout/fragment_seeker_calender_0".equals(tag)) {
          return new FragmentSeekerCalenderBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_calender is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERCHANGEPASSWORD: {
        if ("layout/fragment_seeker_change_password_0".equals(tag)) {
          return new FragmentSeekerChangePasswordBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_change_password is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERCOACHING: {
        if ("layout/fragment_seeker_coaching_0".equals(tag)) {
          return new FragmentSeekerCoachingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_coaching is invalid. Received: " + tag);
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
      case  LAYOUT_FRAGMENTSEEKEREDUCATION: {
        if ("layout/fragment_seeker_education_0".equals(tag)) {
          return new FragmentSeekerEducationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_education is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKEREXPERIENCELIST: {
        if ("layout/fragment_seeker_experience_list_0".equals(tag)) {
          return new FragmentSeekerExperienceListBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_experience_list is invalid. Received: " + tag);
      }
    }
    return null;
  }

  private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_FRAGMENTSEEKERFILTERJOB: {
        if ("layout/fragment_seeker_filter_job_0".equals(tag)) {
          return new FragmentSeekerFilterJobBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_filter_job is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERIMPORTRESUME: {
        if ("layout/fragment_seeker_import_resume_0".equals(tag)) {
          return new FragmentSeekerImportResumeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_import_resume is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERINTEREST: {
        if ("layout/fragment_seeker_interest_0".equals(tag)) {
          return new FragmentSeekerInterestBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_interest is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERJOBMATCHINFODIALOG: {
        if ("layout/fragment_seeker_job_match_info_dialog_0".equals(tag)) {
          return new FragmentSeekerJobMatchInfoDialogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_job_match_info_dialog is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERJOBSEARCHFILTERCATEGORIES: {
        if ("layout/fragment_seeker_job_search_filter_categories_0".equals(tag)) {
          return new FragmentSeekerJobSearchFilterCategoriesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_job_search_filter_categories is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERJOBS: {
        if ("layout/fragment_seeker_jobs_0".equals(tag)) {
          return new FragmentSeekerJobsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_jobs is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERJOBSFILTER: {
        if ("layout/fragment_seeker_jobs_filter_0".equals(tag)) {
          return new FragmentSeekerJobsFilterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_jobs_filter is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERMYSKILL: {
        if ("layout/fragment_seeker_my_skill_0".equals(tag)) {
          return new FragmentSeekerMySkillBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_my_skill is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERNEWEDUCATION: {
        if ("layout/fragment_seeker_new_education_0".equals(tag)) {
          return new FragmentSeekerNewEducationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_new_education is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERPREVIEW: {
        if ("layout/fragment_seeker_preview_0".equals(tag)) {
          return new FragmentSeekerPreviewBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_preview is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERPROFILE: {
        if ("layout/fragment_seeker_profile_0".equals(tag)) {
          return new FragmentSeekerProfileBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_profile is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERSOCIALMEDIAIDS: {
        if ("layout/fragment_seeker_social_media_ids_0".equals(tag)) {
          return new FragmentSeekerSocialMediaIdsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_social_media_ids is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERTRACKINGJOB: {
        if ("layout/fragment_seeker_tracking_job_0".equals(tag)) {
          return new FragmentSeekerTrackingJobBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_tracking_job is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERTRACKINGJOBDESCRIPTION: {
        if ("layout/fragment_seeker_tracking_job_description_0".equals(tag)) {
          return new FragmentSeekerTrackingJobDescriptionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_tracking_job_description is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERTRACKINGJOBDETAILS: {
        if ("layout/fragment_seeker_tracking_job_details_0".equals(tag)) {
          return new FragmentSeekerTrackingJobDetailsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_tracking_job_details is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERTRACKINGJOBFILTERDIALOG: {
        if ("layout/fragment_seeker_tracking_job_filter_dialog_0".equals(tag)) {
          return new FragmentSeekerTrackingJobFilterDialogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_tracking_job_filter_dialog is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERVOLUNTEERINGLIST: {
        if ("layout/fragment_seeker_volunteering_list_0".equals(tag)) {
          return new FragmentSeekerVolunteeringListBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_volunteering_list is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERWISHLIST: {
        if ("layout/fragment_seeker_wish_list_0".equals(tag)) {
          return new FragmentSeekerWishListBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_wish_list is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTVALUEPRIVACY: {
        if ("layout/fragment_value_privacy_0".equals(tag)) {
          return new FragmentValuePrivacyBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_value_privacy is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCALENDEREVENTCARD: {
        if ("layout/item_calender_event_card_0".equals(tag)) {
          return new ItemCalenderEventCardBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_calender_event_card is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCATEGORYCHIP: {
        if ("layout/item_category_chip_0".equals(tag)) {
          return new ItemCategoryChipBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_category_chip is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCHEAP: {
        if ("layout/item_cheap_0".equals(tag)) {
          return new ItemCheapBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_cheap is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMIMAGE: {
        if ("layout/item_image_0".equals(tag)) {
          return new ItemImageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_image is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMJOBSEARCHFILTERCATEGORY: {
        if ("layout/item_job_search_filter_category_0".equals(tag)) {
          return new ItemJobSearchFilterCategoryBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_job_search_filter_category is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMJOBTITLE: {
        if ("layout/item_job_title_0".equals(tag)) {
          return new ItemJobTitleBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_job_title is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMLEAVINGREASON: {
        if ("layout/item_leaving_reason_0".equals(tag)) {
          return new ItemLeavingReasonBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_leaving_reason is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMLINK: {
        if ("layout/item_link_0".equals(tag)) {
          return new ItemLinkBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_link is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMPORTFOLIOIMAGE: {
        if ("layout/item_portfolio_image_0".equals(tag)) {
          return new ItemPortfolioImageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_portfolio_image is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMPORTFOLIOLINK: {
        if ("layout/item_portfolio_link_0".equals(tag)) {
          return new ItemPortfolioLinkBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_portfolio_link is invalid. Received: " + tag);
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
      case  LAYOUT_ITEMSEEKEROTHERJOB: {
        if ("layout/item_seeker_other_job_0".equals(tag)) {
          return new ItemSeekerOtherJobBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_seeker_other_job is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMSEEKERPREVIEWEXPERIENCE: {
        if ("layout/item_seeker_preview_experience_0".equals(tag)) {
          return new ItemSeekerPreviewExperienceBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_seeker_preview_experience is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMSEEKERPREVIEWHARDSKILL: {
        if ("layout/item_seeker_preview_hard_skill_0".equals(tag)) {
          return new ItemSeekerPreviewHardSkillBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_seeker_preview_hard_skill is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMSEEKERPREVIEWSCHOOL: {
        if ("layout/item_seeker_preview_school_0".equals(tag)) {
          return new ItemSeekerPreviewSchoolBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_seeker_preview_school is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMSEEKERPREVIEWVOLUNTEERING: {
        if ("layout/item_seeker_preview_volunteering_0".equals(tag)) {
          return new ItemSeekerPreviewVolunteeringBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_seeker_preview_volunteering is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMSEEKERSEARCHUNIVERSITY: {
        if ("layout/item_seeker_search_university_0".equals(tag)) {
          return new ItemSeekerSearchUniversityBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_seeker_search_university is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMSEEKERTRACK: {
        if ("layout/item_seeker_track_0".equals(tag)) {
          return new ItemSeekerTrackBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_seeker_track is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMSEEKERTRACKINGJOBDETAILCARD: {
        if ("layout/item_seeker_tracking_job_detail_card_0".equals(tag)) {
          return new ItemSeekerTrackingJobDetailCardBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_seeker_tracking_job_detail_card is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMSEEKERVOLUNTEERING: {
        if ("layout/item_seeker_volunteering_0".equals(tag)) {
          return new ItemSeekerVolunteeringBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_seeker_volunteering is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMWISHLISTJOB: {
        if ("layout/item_wishlist_job_0".equals(tag)) {
          return new ItemWishlistJobBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_wishlist_job is invalid. Received: " + tag);
      }
      case  LAYOUT_POPUPADDJOBTOTRACK: {
        if ("layout/popup_add_job_to_track_0".equals(tag)) {
          return new PopupAddJobToTrackBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for popup_add_job_to_track is invalid. Received: " + tag);
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
    static final SparseArray<String> sKeys = new SparseArray<String>(6);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "data");
      sKeys.put(2, "handler");
      sKeys.put(3, "jobSeeker");
      sKeys.put(4, "state");
      sKeys.put(5, "trackToggleFlag");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(95);

    static {
      sKeys.put("layout/activity_job_seeker_home_0", com.jobamax.appjobamax.R.layout.activity_job_seeker_home);
      sKeys.put("layout/activity_job_seeker_password_0", com.jobamax.appjobamax.R.layout.activity_job_seeker_password);
      sKeys.put("layout/activity_job_seeker_personal_intro_info_0", com.jobamax.appjobamax.R.layout.activity_job_seeker_personal_intro_info);
      sKeys.put("layout/activity_license_0", com.jobamax.appjobamax.R.layout.activity_license);
      sKeys.put("layout/activity_login_0", com.jobamax.appjobamax.R.layout.activity_login);
      sKeys.put("layout/activity_main_0", com.jobamax.appjobamax.R.layout.activity_main);
      sKeys.put("layout/activity_maps_0", com.jobamax.appjobamax.R.layout.activity_maps);
      sKeys.put("layout/activity_privacy_preference_0", com.jobamax.appjobamax.R.layout.activity_privacy_preference);
      sKeys.put("layout/activity_seeker_job_search_0", com.jobamax.appjobamax.R.layout.activity_seeker_job_search);
      sKeys.put("layout/activity_seeker_job_web_0", com.jobamax.appjobamax.R.layout.activity_seeker_job_web);
      sKeys.put("layout/activity_splash_0", com.jobamax.appjobamax.R.layout.activity_splash);
      sKeys.put("layout/activity_video_play_0", com.jobamax.appjobamax.R.layout.activity_video_play);
      sKeys.put("layout/activity_web_view_0", com.jobamax.appjobamax.R.layout.activity_web_view);
      sKeys.put("layout/calendar_cell_0", com.jobamax.appjobamax.R.layout.calendar_cell);
      sKeys.put("layout/dialog_add_tracking_job_phase_0", com.jobamax.appjobamax.R.layout.dialog_add_tracking_job_phase);
      sKeys.put("layout/dialog_delete_account_0", com.jobamax.appjobamax.R.layout.dialog_delete_account);
      sKeys.put("layout/dialog_repost_job_0", com.jobamax.appjobamax.R.layout.dialog_repost_job);
      sKeys.put("layout/dialog_simple_yes_no_0", com.jobamax.appjobamax.R.layout.dialog_simple_yes_no);
      sKeys.put("layout/dialog_yes_no_0", com.jobamax.appjobamax.R.layout.dialog_yes_no);
      sKeys.put("layout/fragment_ideal_job_audio_0", com.jobamax.appjobamax.R.layout.fragment_ideal_job_audio);
      sKeys.put("layout/fragment_ideal_job_description_0", com.jobamax.appjobamax.R.layout.fragment_ideal_job_description);
      sKeys.put("layout/fragment_ideal_job_images_0", com.jobamax.appjobamax.R.layout.fragment_ideal_job_images);
      sKeys.put("layout/fragment_ideal_job_video_0", com.jobamax.appjobamax.R.layout.fragment_ideal_job_video);
      sKeys.put("layout/fragment_job_seeker_account_0", com.jobamax.appjobamax.R.layout.fragment_job_seeker_account);
      sKeys.put("layout/fragment_job_seeker_change_language_0", com.jobamax.appjobamax.R.layout.fragment_job_seeker_change_language);
      sKeys.put("layout/fragment_job_seeker_home_0", com.jobamax.appjobamax.R.layout.fragment_job_seeker_home);
      sKeys.put("layout/fragment_job_seeker_manage_read_receipts_0", com.jobamax.appjobamax.R.layout.fragment_job_seeker_manage_read_receipts);
      sKeys.put("layout/fragment_job_seeker_newsletter_0", com.jobamax.appjobamax.R.layout.fragment_job_seeker_newsletter);
      sKeys.put("layout/fragment_job_seeker_personal_information_0", com.jobamax.appjobamax.R.layout.fragment_job_seeker_personal_information);
      sKeys.put("layout/fragment_job_seeker_push_notification_0", com.jobamax.appjobamax.R.layout.fragment_job_seeker_push_notification);
      sKeys.put("layout/fragment_keep_me_posted_0", com.jobamax.appjobamax.R.layout.fragment_keep_me_posted);
      sKeys.put("layout/fragment_location_permission_0", com.jobamax.appjobamax.R.layout.fragment_location_permission);
      sKeys.put("layout/fragment_login_0", com.jobamax.appjobamax.R.layout.fragment_login);
      sKeys.put("layout/fragment_meet_nearby_people_0", com.jobamax.appjobamax.R.layout.fragment_meet_nearby_people);
      sKeys.put("layout/fragment_portfolio_description_0", com.jobamax.appjobamax.R.layout.fragment_portfolio_description);
      sKeys.put("layout/fragment_portfolio_image_0", com.jobamax.appjobamax.R.layout.fragment_portfolio_image);
      sKeys.put("layout/fragment_portfolio_video_0", com.jobamax.appjobamax.R.layout.fragment_portfolio_video);
      sKeys.put("layout/fragment_register_0", com.jobamax.appjobamax.R.layout.fragment_register);
      sKeys.put("layout/fragment_seeker_about_me_0", com.jobamax.appjobamax.R.layout.fragment_seeker_about_me);
      sKeys.put("layout/fragment_seeker_about_me_scanner_0", com.jobamax.appjobamax.R.layout.fragment_seeker_about_me_scanner);
      sKeys.put("layout/fragment_seeker_add_experience_0", com.jobamax.appjobamax.R.layout.fragment_seeker_add_experience);
      sKeys.put("layout/fragment_seeker_add_personal_track_job_0", com.jobamax.appjobamax.R.layout.fragment_seeker_add_personal_track_job);
      sKeys.put("layout/fragment_seeker_add_volunteering_0", com.jobamax.appjobamax.R.layout.fragment_seeker_add_volunteering);
      sKeys.put("layout/fragment_seeker_calender_0", com.jobamax.appjobamax.R.layout.fragment_seeker_calender);
      sKeys.put("layout/fragment_seeker_change_password_0", com.jobamax.appjobamax.R.layout.fragment_seeker_change_password);
      sKeys.put("layout/fragment_seeker_coaching_0", com.jobamax.appjobamax.R.layout.fragment_seeker_coaching);
      sKeys.put("layout/fragment_seeker_delete_account_0", com.jobamax.appjobamax.R.layout.fragment_seeker_delete_account);
      sKeys.put("layout/fragment_seeker_delete_account_final_0", com.jobamax.appjobamax.R.layout.fragment_seeker_delete_account_final);
      sKeys.put("layout/fragment_seeker_education_0", com.jobamax.appjobamax.R.layout.fragment_seeker_education);
      sKeys.put("layout/fragment_seeker_experience_list_0", com.jobamax.appjobamax.R.layout.fragment_seeker_experience_list);
      sKeys.put("layout/fragment_seeker_filter_job_0", com.jobamax.appjobamax.R.layout.fragment_seeker_filter_job);
      sKeys.put("layout/fragment_seeker_import_resume_0", com.jobamax.appjobamax.R.layout.fragment_seeker_import_resume);
      sKeys.put("layout/fragment_seeker_interest_0", com.jobamax.appjobamax.R.layout.fragment_seeker_interest);
      sKeys.put("layout/fragment_seeker_job_match_info_dialog_0", com.jobamax.appjobamax.R.layout.fragment_seeker_job_match_info_dialog);
      sKeys.put("layout/fragment_seeker_job_search_filter_categories_0", com.jobamax.appjobamax.R.layout.fragment_seeker_job_search_filter_categories);
      sKeys.put("layout/fragment_seeker_jobs_0", com.jobamax.appjobamax.R.layout.fragment_seeker_jobs);
      sKeys.put("layout/fragment_seeker_jobs_filter_0", com.jobamax.appjobamax.R.layout.fragment_seeker_jobs_filter);
      sKeys.put("layout/fragment_seeker_my_skill_0", com.jobamax.appjobamax.R.layout.fragment_seeker_my_skill);
      sKeys.put("layout/fragment_seeker_new_education_0", com.jobamax.appjobamax.R.layout.fragment_seeker_new_education);
      sKeys.put("layout/fragment_seeker_preview_0", com.jobamax.appjobamax.R.layout.fragment_seeker_preview);
      sKeys.put("layout/fragment_seeker_profile_0", com.jobamax.appjobamax.R.layout.fragment_seeker_profile);
      sKeys.put("layout/fragment_seeker_social_media_ids_0", com.jobamax.appjobamax.R.layout.fragment_seeker_social_media_ids);
      sKeys.put("layout/fragment_seeker_tracking_job_0", com.jobamax.appjobamax.R.layout.fragment_seeker_tracking_job);
      sKeys.put("layout/fragment_seeker_tracking_job_description_0", com.jobamax.appjobamax.R.layout.fragment_seeker_tracking_job_description);
      sKeys.put("layout/fragment_seeker_tracking_job_details_0", com.jobamax.appjobamax.R.layout.fragment_seeker_tracking_job_details);
      sKeys.put("layout/fragment_seeker_tracking_job_filter_dialog_0", com.jobamax.appjobamax.R.layout.fragment_seeker_tracking_job_filter_dialog);
      sKeys.put("layout/fragment_seeker_volunteering_list_0", com.jobamax.appjobamax.R.layout.fragment_seeker_volunteering_list);
      sKeys.put("layout/fragment_seeker_wish_list_0", com.jobamax.appjobamax.R.layout.fragment_seeker_wish_list);
      sKeys.put("layout/fragment_value_privacy_0", com.jobamax.appjobamax.R.layout.fragment_value_privacy);
      sKeys.put("layout/item_calender_event_card_0", com.jobamax.appjobamax.R.layout.item_calender_event_card);
      sKeys.put("layout/item_category_chip_0", com.jobamax.appjobamax.R.layout.item_category_chip);
      sKeys.put("layout/item_cheap_0", com.jobamax.appjobamax.R.layout.item_cheap);
      sKeys.put("layout/item_image_0", com.jobamax.appjobamax.R.layout.item_image);
      sKeys.put("layout/item_job_search_filter_category_0", com.jobamax.appjobamax.R.layout.item_job_search_filter_category);
      sKeys.put("layout/item_job_title_0", com.jobamax.appjobamax.R.layout.item_job_title);
      sKeys.put("layout/item_leaving_reason_0", com.jobamax.appjobamax.R.layout.item_leaving_reason);
      sKeys.put("layout/item_link_0", com.jobamax.appjobamax.R.layout.item_link);
      sKeys.put("layout/item_portfolio_image_0", com.jobamax.appjobamax.R.layout.item_portfolio_image);
      sKeys.put("layout/item_portfolio_link_0", com.jobamax.appjobamax.R.layout.item_portfolio_link);
      sKeys.put("layout/item_search_query_company_0", com.jobamax.appjobamax.R.layout.item_search_query_company);
      sKeys.put("layout/item_seeker_education_0", com.jobamax.appjobamax.R.layout.item_seeker_education);
      sKeys.put("layout/item_seeker_experience_0", com.jobamax.appjobamax.R.layout.item_seeker_experience);
      sKeys.put("layout/item_seeker_hard_skill_0", com.jobamax.appjobamax.R.layout.item_seeker_hard_skill);
      sKeys.put("layout/item_seeker_job_card_0", com.jobamax.appjobamax.R.layout.item_seeker_job_card);
      sKeys.put("layout/item_seeker_other_job_0", com.jobamax.appjobamax.R.layout.item_seeker_other_job);
      sKeys.put("layout/item_seeker_preview_experience_0", com.jobamax.appjobamax.R.layout.item_seeker_preview_experience);
      sKeys.put("layout/item_seeker_preview_hard_skill_0", com.jobamax.appjobamax.R.layout.item_seeker_preview_hard_skill);
      sKeys.put("layout/item_seeker_preview_school_0", com.jobamax.appjobamax.R.layout.item_seeker_preview_school);
      sKeys.put("layout/item_seeker_preview_volunteering_0", com.jobamax.appjobamax.R.layout.item_seeker_preview_volunteering);
      sKeys.put("layout/item_seeker_search_university_0", com.jobamax.appjobamax.R.layout.item_seeker_search_university);
      sKeys.put("layout/item_seeker_track_0", com.jobamax.appjobamax.R.layout.item_seeker_track);
      sKeys.put("layout/item_seeker_tracking_job_detail_card_0", com.jobamax.appjobamax.R.layout.item_seeker_tracking_job_detail_card);
      sKeys.put("layout/item_seeker_volunteering_0", com.jobamax.appjobamax.R.layout.item_seeker_volunteering);
      sKeys.put("layout/item_wishlist_job_0", com.jobamax.appjobamax.R.layout.item_wishlist_job);
      sKeys.put("layout/popup_add_job_to_track_0", com.jobamax.appjobamax.R.layout.popup_add_job_to_track);
    }
  }
}
