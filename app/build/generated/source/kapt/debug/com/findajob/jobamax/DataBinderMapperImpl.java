package com.findajob.jobamax;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.findajob.jobamax.databinding.ActivityJobSeekerHomeBindingImpl;
import com.findajob.jobamax.databinding.ActivityJobSeekerPasswordBindingImpl;
import com.findajob.jobamax.databinding.ActivityJobSeekerPersonalIntroInfoBindingImpl;
import com.findajob.jobamax.databinding.ActivityLicenseBindingImpl;
import com.findajob.jobamax.databinding.ActivityLoginBindingImpl;
import com.findajob.jobamax.databinding.ActivityMainBindingImpl;
import com.findajob.jobamax.databinding.ActivityMapsBindingImpl;
import com.findajob.jobamax.databinding.ActivityPrivacyPreferenceBindingImpl;
import com.findajob.jobamax.databinding.ActivitySeekerJobSearchBindingImpl;
import com.findajob.jobamax.databinding.ActivitySplashBindingImpl;
import com.findajob.jobamax.databinding.ActivityVideoPlayBindingImpl;
import com.findajob.jobamax.databinding.ActivityWebViewBindingImpl;
import com.findajob.jobamax.databinding.CalendarCellBindingImpl;
import com.findajob.jobamax.databinding.DialogAddTrackingJobPhaseBindingImpl;
import com.findajob.jobamax.databinding.DialogDeleteAccountBindingImpl;
import com.findajob.jobamax.databinding.DialogRepostJobBindingImpl;
import com.findajob.jobamax.databinding.DialogYesNoBindingImpl;
import com.findajob.jobamax.databinding.FragmentIdealJobAudioBindingImpl;
import com.findajob.jobamax.databinding.FragmentIdealJobDescriptionBindingImpl;
import com.findajob.jobamax.databinding.FragmentIdealJobImagesBindingImpl;
import com.findajob.jobamax.databinding.FragmentIdealJobVideoBindingImpl;
import com.findajob.jobamax.databinding.FragmentJobSeekerAccountBindingImpl;
import com.findajob.jobamax.databinding.FragmentJobSeekerChangeLanguageBindingImpl;
import com.findajob.jobamax.databinding.FragmentJobSeekerHomeBindingImpl;
import com.findajob.jobamax.databinding.FragmentJobSeekerManageReadReceiptsBindingImpl;
import com.findajob.jobamax.databinding.FragmentJobSeekerNewsletterBindingImpl;
import com.findajob.jobamax.databinding.FragmentJobSeekerPersonalInformationBindingImpl;
import com.findajob.jobamax.databinding.FragmentJobSeekerPushNotificationBindingImpl;
import com.findajob.jobamax.databinding.FragmentKeepMePostedBindingImpl;
import com.findajob.jobamax.databinding.FragmentLocationPermissionBindingImpl;
import com.findajob.jobamax.databinding.FragmentLoginBindingImpl;
import com.findajob.jobamax.databinding.FragmentMeetNearbyPeopleBindingImpl;
import com.findajob.jobamax.databinding.FragmentPortfolioDescriptionBindingImpl;
import com.findajob.jobamax.databinding.FragmentPortfolioImageBindingImpl;
import com.findajob.jobamax.databinding.FragmentPortfolioVideoBindingImpl;
import com.findajob.jobamax.databinding.FragmentRegisterBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerAboutMeBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerAddExperienceBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerAddPersonalTrackJobBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerAddVolunteeringBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerCalenderBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerChangePasswordBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerCoachingBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerDeleteAccountBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerDeleteAccountFinalBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerEducationBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerExperienceListBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerFilterJobBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerImportResumeBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerInterestBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerJobMatchInfoDialogBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerJobSearchFilterCategoriesDialogBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerJobWebDialogBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerJobsBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerJobsFilterBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerMySkillBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerNewEducationBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerPreviewBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerProfileBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerSearchUniversityDialogBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerSocialMediaIdsBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerTrackingJobBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerTrackingJobDescriptionBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerTrackingJobDetailsBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerTrackingJobFilterDialogBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerVolunteeringListBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerWishListBindingImpl;
import com.findajob.jobamax.databinding.FragmentValuePrivacyBindingImpl;
import com.findajob.jobamax.databinding.ItemCalenderEventCardBindingImpl;
import com.findajob.jobamax.databinding.ItemCategoryChipBindingImpl;
import com.findajob.jobamax.databinding.ItemCheapBindingImpl;
import com.findajob.jobamax.databinding.ItemImageBindingImpl;
import com.findajob.jobamax.databinding.ItemJobSearchFilterCategoryBindingImpl;
import com.findajob.jobamax.databinding.ItemJobTitleBindingImpl;
import com.findajob.jobamax.databinding.ItemLeavingReasonBindingImpl;
import com.findajob.jobamax.databinding.ItemLinkBindingImpl;
import com.findajob.jobamax.databinding.ItemPortfolioImageBindingImpl;
import com.findajob.jobamax.databinding.ItemPortfolioLinkBindingImpl;
import com.findajob.jobamax.databinding.ItemSearchQueryCompanyBindingImpl;
import com.findajob.jobamax.databinding.ItemSeekerEducationBindingImpl;
import com.findajob.jobamax.databinding.ItemSeekerExperienceBindingImpl;
import com.findajob.jobamax.databinding.ItemSeekerHardSkillBindingImpl;
import com.findajob.jobamax.databinding.ItemSeekerJobCardBindingImpl;
import com.findajob.jobamax.databinding.ItemSeekerOtherJobBindingImpl;
import com.findajob.jobamax.databinding.ItemSeekerPreviewExperienceBindingImpl;
import com.findajob.jobamax.databinding.ItemSeekerPreviewHardSkillBindingImpl;
import com.findajob.jobamax.databinding.ItemSeekerPreviewSchoolBindingImpl;
import com.findajob.jobamax.databinding.ItemSeekerPreviewVolunteeringBindingImpl;
import com.findajob.jobamax.databinding.ItemSeekerSearchUniversityBindingImpl;
import com.findajob.jobamax.databinding.ItemSeekerTrackBindingImpl;
import com.findajob.jobamax.databinding.ItemSeekerTrackingJobDetailCardBindingImpl;
import com.findajob.jobamax.databinding.ItemSeekerVolunteeringBindingImpl;
import com.findajob.jobamax.databinding.ItemWishlistJobBindingImpl;
import com.findajob.jobamax.databinding.PopupAddJobToTrackBindingImpl;
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

  private static final int LAYOUT_ACTIVITYSPLASH = 10;

  private static final int LAYOUT_ACTIVITYVIDEOPLAY = 11;

  private static final int LAYOUT_ACTIVITYWEBVIEW = 12;

  private static final int LAYOUT_CALENDARCELL = 13;

  private static final int LAYOUT_DIALOGADDTRACKINGJOBPHASE = 14;

  private static final int LAYOUT_DIALOGDELETEACCOUNT = 15;

  private static final int LAYOUT_DIALOGREPOSTJOB = 16;

  private static final int LAYOUT_DIALOGYESNO = 17;

  private static final int LAYOUT_FRAGMENTIDEALJOBAUDIO = 18;

  private static final int LAYOUT_FRAGMENTIDEALJOBDESCRIPTION = 19;

  private static final int LAYOUT_FRAGMENTIDEALJOBIMAGES = 20;

  private static final int LAYOUT_FRAGMENTIDEALJOBVIDEO = 21;

  private static final int LAYOUT_FRAGMENTJOBSEEKERACCOUNT = 22;

  private static final int LAYOUT_FRAGMENTJOBSEEKERCHANGELANGUAGE = 23;

  private static final int LAYOUT_FRAGMENTJOBSEEKERHOME = 24;

  private static final int LAYOUT_FRAGMENTJOBSEEKERMANAGEREADRECEIPTS = 25;

  private static final int LAYOUT_FRAGMENTJOBSEEKERNEWSLETTER = 26;

  private static final int LAYOUT_FRAGMENTJOBSEEKERPERSONALINFORMATION = 27;

  private static final int LAYOUT_FRAGMENTJOBSEEKERPUSHNOTIFICATION = 28;

  private static final int LAYOUT_FRAGMENTKEEPMEPOSTED = 29;

  private static final int LAYOUT_FRAGMENTLOCATIONPERMISSION = 30;

  private static final int LAYOUT_FRAGMENTLOGIN = 31;

  private static final int LAYOUT_FRAGMENTMEETNEARBYPEOPLE = 32;

  private static final int LAYOUT_FRAGMENTPORTFOLIODESCRIPTION = 33;

  private static final int LAYOUT_FRAGMENTPORTFOLIOIMAGE = 34;

  private static final int LAYOUT_FRAGMENTPORTFOLIOVIDEO = 35;

  private static final int LAYOUT_FRAGMENTREGISTER = 36;

  private static final int LAYOUT_FRAGMENTSEEKERABOUTME = 37;

  private static final int LAYOUT_FRAGMENTSEEKERADDEXPERIENCE = 38;

  private static final int LAYOUT_FRAGMENTSEEKERADDPERSONALTRACKJOB = 39;

  private static final int LAYOUT_FRAGMENTSEEKERADDVOLUNTEERING = 40;

  private static final int LAYOUT_FRAGMENTSEEKERCALENDER = 41;

  private static final int LAYOUT_FRAGMENTSEEKERCHANGEPASSWORD = 42;

  private static final int LAYOUT_FRAGMENTSEEKERCOACHING = 43;

  private static final int LAYOUT_FRAGMENTSEEKERDELETEACCOUNT = 44;

  private static final int LAYOUT_FRAGMENTSEEKERDELETEACCOUNTFINAL = 45;

  private static final int LAYOUT_FRAGMENTSEEKEREDUCATION = 46;

  private static final int LAYOUT_FRAGMENTSEEKEREXPERIENCELIST = 47;

  private static final int LAYOUT_FRAGMENTSEEKERFILTERJOB = 48;

  private static final int LAYOUT_FRAGMENTSEEKERIMPORTRESUME = 49;

  private static final int LAYOUT_FRAGMENTSEEKERINTEREST = 50;

  private static final int LAYOUT_FRAGMENTSEEKERJOBMATCHINFODIALOG = 51;

  private static final int LAYOUT_FRAGMENTSEEKERJOBSEARCHFILTERCATEGORIESDIALOG = 52;

  private static final int LAYOUT_FRAGMENTSEEKERJOBWEBDIALOG = 53;

  private static final int LAYOUT_FRAGMENTSEEKERJOBS = 54;

  private static final int LAYOUT_FRAGMENTSEEKERJOBSFILTER = 55;

  private static final int LAYOUT_FRAGMENTSEEKERMYSKILL = 56;

  private static final int LAYOUT_FRAGMENTSEEKERNEWEDUCATION = 57;

  private static final int LAYOUT_FRAGMENTSEEKERPREVIEW = 58;

  private static final int LAYOUT_FRAGMENTSEEKERPROFILE = 59;

  private static final int LAYOUT_FRAGMENTSEEKERSEARCHUNIVERSITYDIALOG = 60;

  private static final int LAYOUT_FRAGMENTSEEKERSOCIALMEDIAIDS = 61;

  private static final int LAYOUT_FRAGMENTSEEKERTRACKINGJOB = 62;

  private static final int LAYOUT_FRAGMENTSEEKERTRACKINGJOBDESCRIPTION = 63;

  private static final int LAYOUT_FRAGMENTSEEKERTRACKINGJOBDETAILS = 64;

  private static final int LAYOUT_FRAGMENTSEEKERTRACKINGJOBFILTERDIALOG = 65;

  private static final int LAYOUT_FRAGMENTSEEKERVOLUNTEERINGLIST = 66;

  private static final int LAYOUT_FRAGMENTSEEKERWISHLIST = 67;

  private static final int LAYOUT_FRAGMENTVALUEPRIVACY = 68;

  private static final int LAYOUT_ITEMCALENDEREVENTCARD = 69;

  private static final int LAYOUT_ITEMCATEGORYCHIP = 70;

  private static final int LAYOUT_ITEMCHEAP = 71;

  private static final int LAYOUT_ITEMIMAGE = 72;

  private static final int LAYOUT_ITEMJOBSEARCHFILTERCATEGORY = 73;

  private static final int LAYOUT_ITEMJOBTITLE = 74;

  private static final int LAYOUT_ITEMLEAVINGREASON = 75;

  private static final int LAYOUT_ITEMLINK = 76;

  private static final int LAYOUT_ITEMPORTFOLIOIMAGE = 77;

  private static final int LAYOUT_ITEMPORTFOLIOLINK = 78;

  private static final int LAYOUT_ITEMSEARCHQUERYCOMPANY = 79;

  private static final int LAYOUT_ITEMSEEKEREDUCATION = 80;

  private static final int LAYOUT_ITEMSEEKEREXPERIENCE = 81;

  private static final int LAYOUT_ITEMSEEKERHARDSKILL = 82;

  private static final int LAYOUT_ITEMSEEKERJOBCARD = 83;

  private static final int LAYOUT_ITEMSEEKEROTHERJOB = 84;

  private static final int LAYOUT_ITEMSEEKERPREVIEWEXPERIENCE = 85;

  private static final int LAYOUT_ITEMSEEKERPREVIEWHARDSKILL = 86;

  private static final int LAYOUT_ITEMSEEKERPREVIEWSCHOOL = 87;

  private static final int LAYOUT_ITEMSEEKERPREVIEWVOLUNTEERING = 88;

  private static final int LAYOUT_ITEMSEEKERSEARCHUNIVERSITY = 89;

  private static final int LAYOUT_ITEMSEEKERTRACK = 90;

  private static final int LAYOUT_ITEMSEEKERTRACKINGJOBDETAILCARD = 91;

  private static final int LAYOUT_ITEMSEEKERVOLUNTEERING = 92;

  private static final int LAYOUT_ITEMWISHLISTJOB = 93;

  private static final int LAYOUT_POPUPADDJOBTOTRACK = 94;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(94);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_job_seeker_home, LAYOUT_ACTIVITYJOBSEEKERHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_job_seeker_password, LAYOUT_ACTIVITYJOBSEEKERPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_job_seeker_personal_intro_info, LAYOUT_ACTIVITYJOBSEEKERPERSONALINTROINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_license, LAYOUT_ACTIVITYLICENSE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_maps, LAYOUT_ACTIVITYMAPS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_privacy_preference, LAYOUT_ACTIVITYPRIVACYPREFERENCE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_seeker_job_search, LAYOUT_ACTIVITYSEEKERJOBSEARCH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_splash, LAYOUT_ACTIVITYSPLASH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_video_play, LAYOUT_ACTIVITYVIDEOPLAY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_web_view, LAYOUT_ACTIVITYWEBVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.calendar_cell, LAYOUT_CALENDARCELL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.dialog_add_tracking_job_phase, LAYOUT_DIALOGADDTRACKINGJOBPHASE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.dialog_delete_account, LAYOUT_DIALOGDELETEACCOUNT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.dialog_repost_job, LAYOUT_DIALOGREPOSTJOB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.dialog_yes_no, LAYOUT_DIALOGYESNO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_ideal_job_audio, LAYOUT_FRAGMENTIDEALJOBAUDIO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_ideal_job_description, LAYOUT_FRAGMENTIDEALJOBDESCRIPTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_ideal_job_images, LAYOUT_FRAGMENTIDEALJOBIMAGES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_ideal_job_video, LAYOUT_FRAGMENTIDEALJOBVIDEO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_job_seeker_account, LAYOUT_FRAGMENTJOBSEEKERACCOUNT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_job_seeker_change_language, LAYOUT_FRAGMENTJOBSEEKERCHANGELANGUAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_job_seeker_home, LAYOUT_FRAGMENTJOBSEEKERHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_job_seeker_manage_read_receipts, LAYOUT_FRAGMENTJOBSEEKERMANAGEREADRECEIPTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_job_seeker_newsletter, LAYOUT_FRAGMENTJOBSEEKERNEWSLETTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_job_seeker_personal_information, LAYOUT_FRAGMENTJOBSEEKERPERSONALINFORMATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_job_seeker_push_notification, LAYOUT_FRAGMENTJOBSEEKERPUSHNOTIFICATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_keep_me_posted, LAYOUT_FRAGMENTKEEPMEPOSTED);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_location_permission, LAYOUT_FRAGMENTLOCATIONPERMISSION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_login, LAYOUT_FRAGMENTLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_meet_nearby_people, LAYOUT_FRAGMENTMEETNEARBYPEOPLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_portfolio_description, LAYOUT_FRAGMENTPORTFOLIODESCRIPTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_portfolio_image, LAYOUT_FRAGMENTPORTFOLIOIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_portfolio_video, LAYOUT_FRAGMENTPORTFOLIOVIDEO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_register, LAYOUT_FRAGMENTREGISTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_about_me, LAYOUT_FRAGMENTSEEKERABOUTME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_add_experience, LAYOUT_FRAGMENTSEEKERADDEXPERIENCE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_add_personal_track_job, LAYOUT_FRAGMENTSEEKERADDPERSONALTRACKJOB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_add_volunteering, LAYOUT_FRAGMENTSEEKERADDVOLUNTEERING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_calender, LAYOUT_FRAGMENTSEEKERCALENDER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_change_password, LAYOUT_FRAGMENTSEEKERCHANGEPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_coaching, LAYOUT_FRAGMENTSEEKERCOACHING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_delete_account, LAYOUT_FRAGMENTSEEKERDELETEACCOUNT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_delete_account_final, LAYOUT_FRAGMENTSEEKERDELETEACCOUNTFINAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_education, LAYOUT_FRAGMENTSEEKEREDUCATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_experience_list, LAYOUT_FRAGMENTSEEKEREXPERIENCELIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_filter_job, LAYOUT_FRAGMENTSEEKERFILTERJOB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_import_resume, LAYOUT_FRAGMENTSEEKERIMPORTRESUME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_interest, LAYOUT_FRAGMENTSEEKERINTEREST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_job_match_info_dialog, LAYOUT_FRAGMENTSEEKERJOBMATCHINFODIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_job_search_filter_categories_dialog, LAYOUT_FRAGMENTSEEKERJOBSEARCHFILTERCATEGORIESDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_job_web_dialog, LAYOUT_FRAGMENTSEEKERJOBWEBDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_jobs, LAYOUT_FRAGMENTSEEKERJOBS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_jobs_filter, LAYOUT_FRAGMENTSEEKERJOBSFILTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_my_skill, LAYOUT_FRAGMENTSEEKERMYSKILL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_new_education, LAYOUT_FRAGMENTSEEKERNEWEDUCATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_preview, LAYOUT_FRAGMENTSEEKERPREVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_profile, LAYOUT_FRAGMENTSEEKERPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_search_university_dialog, LAYOUT_FRAGMENTSEEKERSEARCHUNIVERSITYDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_social_media_ids, LAYOUT_FRAGMENTSEEKERSOCIALMEDIAIDS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_tracking_job, LAYOUT_FRAGMENTSEEKERTRACKINGJOB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_tracking_job_description, LAYOUT_FRAGMENTSEEKERTRACKINGJOBDESCRIPTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_tracking_job_details, LAYOUT_FRAGMENTSEEKERTRACKINGJOBDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_tracking_job_filter_dialog, LAYOUT_FRAGMENTSEEKERTRACKINGJOBFILTERDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_volunteering_list, LAYOUT_FRAGMENTSEEKERVOLUNTEERINGLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_wish_list, LAYOUT_FRAGMENTSEEKERWISHLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_value_privacy, LAYOUT_FRAGMENTVALUEPRIVACY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_calender_event_card, LAYOUT_ITEMCALENDEREVENTCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_category_chip, LAYOUT_ITEMCATEGORYCHIP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_cheap, LAYOUT_ITEMCHEAP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_image, LAYOUT_ITEMIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_job_search_filter_category, LAYOUT_ITEMJOBSEARCHFILTERCATEGORY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_job_title, LAYOUT_ITEMJOBTITLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_leaving_reason, LAYOUT_ITEMLEAVINGREASON);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_link, LAYOUT_ITEMLINK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_portfolio_image, LAYOUT_ITEMPORTFOLIOIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_portfolio_link, LAYOUT_ITEMPORTFOLIOLINK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_search_query_company, LAYOUT_ITEMSEARCHQUERYCOMPANY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_seeker_education, LAYOUT_ITEMSEEKEREDUCATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_seeker_experience, LAYOUT_ITEMSEEKEREXPERIENCE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_seeker_hard_skill, LAYOUT_ITEMSEEKERHARDSKILL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_seeker_job_card, LAYOUT_ITEMSEEKERJOBCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_seeker_other_job, LAYOUT_ITEMSEEKEROTHERJOB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_seeker_preview_experience, LAYOUT_ITEMSEEKERPREVIEWEXPERIENCE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_seeker_preview_hard_skill, LAYOUT_ITEMSEEKERPREVIEWHARDSKILL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_seeker_preview_school, LAYOUT_ITEMSEEKERPREVIEWSCHOOL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_seeker_preview_volunteering, LAYOUT_ITEMSEEKERPREVIEWVOLUNTEERING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_seeker_search_university, LAYOUT_ITEMSEEKERSEARCHUNIVERSITY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_seeker_track, LAYOUT_ITEMSEEKERTRACK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_seeker_tracking_job_detail_card, LAYOUT_ITEMSEEKERTRACKINGJOBDETAILCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_seeker_volunteering, LAYOUT_ITEMSEEKERVOLUNTEERING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_wishlist_job, LAYOUT_ITEMWISHLISTJOB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.popup_add_job_to_track, LAYOUT_POPUPADDJOBTOTRACK);
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
    }
    return null;
  }

  private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_FRAGMENTSEEKERJOBMATCHINFODIALOG: {
        if ("layout/fragment_seeker_job_match_info_dialog_0".equals(tag)) {
          return new FragmentSeekerJobMatchInfoDialogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_job_match_info_dialog is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERJOBSEARCHFILTERCATEGORIESDIALOG: {
        if ("layout/fragment_seeker_job_search_filter_categories_dialog_0".equals(tag)) {
          return new FragmentSeekerJobSearchFilterCategoriesDialogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_job_search_filter_categories_dialog is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEEKERJOBWEBDIALOG: {
        if ("layout/fragment_seeker_job_web_dialog_0".equals(tag)) {
          return new FragmentSeekerJobWebDialogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_job_web_dialog is invalid. Received: " + tag);
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
      case  LAYOUT_FRAGMENTSEEKERSEARCHUNIVERSITYDIALOG: {
        if ("layout/fragment_seeker_search_university_dialog_0".equals(tag)) {
          return new FragmentSeekerSearchUniversityDialogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_seeker_search_university_dialog is invalid. Received: " + tag);
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
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(94);

    static {
      sKeys.put("layout/activity_job_seeker_home_0", com.findajob.jobamax.R.layout.activity_job_seeker_home);
      sKeys.put("layout/activity_job_seeker_password_0", com.findajob.jobamax.R.layout.activity_job_seeker_password);
      sKeys.put("layout/activity_job_seeker_personal_intro_info_0", com.findajob.jobamax.R.layout.activity_job_seeker_personal_intro_info);
      sKeys.put("layout/activity_license_0", com.findajob.jobamax.R.layout.activity_license);
      sKeys.put("layout/activity_login_0", com.findajob.jobamax.R.layout.activity_login);
      sKeys.put("layout/activity_main_0", com.findajob.jobamax.R.layout.activity_main);
      sKeys.put("layout/activity_maps_0", com.findajob.jobamax.R.layout.activity_maps);
      sKeys.put("layout/activity_privacy_preference_0", com.findajob.jobamax.R.layout.activity_privacy_preference);
      sKeys.put("layout/activity_seeker_job_search_0", com.findajob.jobamax.R.layout.activity_seeker_job_search);
      sKeys.put("layout/activity_splash_0", com.findajob.jobamax.R.layout.activity_splash);
      sKeys.put("layout/activity_video_play_0", com.findajob.jobamax.R.layout.activity_video_play);
      sKeys.put("layout/activity_web_view_0", com.findajob.jobamax.R.layout.activity_web_view);
      sKeys.put("layout/calendar_cell_0", com.findajob.jobamax.R.layout.calendar_cell);
      sKeys.put("layout/dialog_add_tracking_job_phase_0", com.findajob.jobamax.R.layout.dialog_add_tracking_job_phase);
      sKeys.put("layout/dialog_delete_account_0", com.findajob.jobamax.R.layout.dialog_delete_account);
      sKeys.put("layout/dialog_repost_job_0", com.findajob.jobamax.R.layout.dialog_repost_job);
      sKeys.put("layout/dialog_yes_no_0", com.findajob.jobamax.R.layout.dialog_yes_no);
      sKeys.put("layout/fragment_ideal_job_audio_0", com.findajob.jobamax.R.layout.fragment_ideal_job_audio);
      sKeys.put("layout/fragment_ideal_job_description_0", com.findajob.jobamax.R.layout.fragment_ideal_job_description);
      sKeys.put("layout/fragment_ideal_job_images_0", com.findajob.jobamax.R.layout.fragment_ideal_job_images);
      sKeys.put("layout/fragment_ideal_job_video_0", com.findajob.jobamax.R.layout.fragment_ideal_job_video);
      sKeys.put("layout/fragment_job_seeker_account_0", com.findajob.jobamax.R.layout.fragment_job_seeker_account);
      sKeys.put("layout/fragment_job_seeker_change_language_0", com.findajob.jobamax.R.layout.fragment_job_seeker_change_language);
      sKeys.put("layout/fragment_job_seeker_home_0", com.findajob.jobamax.R.layout.fragment_job_seeker_home);
      sKeys.put("layout/fragment_job_seeker_manage_read_receipts_0", com.findajob.jobamax.R.layout.fragment_job_seeker_manage_read_receipts);
      sKeys.put("layout/fragment_job_seeker_newsletter_0", com.findajob.jobamax.R.layout.fragment_job_seeker_newsletter);
      sKeys.put("layout/fragment_job_seeker_personal_information_0", com.findajob.jobamax.R.layout.fragment_job_seeker_personal_information);
      sKeys.put("layout/fragment_job_seeker_push_notification_0", com.findajob.jobamax.R.layout.fragment_job_seeker_push_notification);
      sKeys.put("layout/fragment_keep_me_posted_0", com.findajob.jobamax.R.layout.fragment_keep_me_posted);
      sKeys.put("layout/fragment_location_permission_0", com.findajob.jobamax.R.layout.fragment_location_permission);
      sKeys.put("layout/fragment_login_0", com.findajob.jobamax.R.layout.fragment_login);
      sKeys.put("layout/fragment_meet_nearby_people_0", com.findajob.jobamax.R.layout.fragment_meet_nearby_people);
      sKeys.put("layout/fragment_portfolio_description_0", com.findajob.jobamax.R.layout.fragment_portfolio_description);
      sKeys.put("layout/fragment_portfolio_image_0", com.findajob.jobamax.R.layout.fragment_portfolio_image);
      sKeys.put("layout/fragment_portfolio_video_0", com.findajob.jobamax.R.layout.fragment_portfolio_video);
      sKeys.put("layout/fragment_register_0", com.findajob.jobamax.R.layout.fragment_register);
      sKeys.put("layout/fragment_seeker_about_me_0", com.findajob.jobamax.R.layout.fragment_seeker_about_me);
      sKeys.put("layout/fragment_seeker_add_experience_0", com.findajob.jobamax.R.layout.fragment_seeker_add_experience);
      sKeys.put("layout/fragment_seeker_add_personal_track_job_0", com.findajob.jobamax.R.layout.fragment_seeker_add_personal_track_job);
      sKeys.put("layout/fragment_seeker_add_volunteering_0", com.findajob.jobamax.R.layout.fragment_seeker_add_volunteering);
      sKeys.put("layout/fragment_seeker_calender_0", com.findajob.jobamax.R.layout.fragment_seeker_calender);
      sKeys.put("layout/fragment_seeker_change_password_0", com.findajob.jobamax.R.layout.fragment_seeker_change_password);
      sKeys.put("layout/fragment_seeker_coaching_0", com.findajob.jobamax.R.layout.fragment_seeker_coaching);
      sKeys.put("layout/fragment_seeker_delete_account_0", com.findajob.jobamax.R.layout.fragment_seeker_delete_account);
      sKeys.put("layout/fragment_seeker_delete_account_final_0", com.findajob.jobamax.R.layout.fragment_seeker_delete_account_final);
      sKeys.put("layout/fragment_seeker_education_0", com.findajob.jobamax.R.layout.fragment_seeker_education);
      sKeys.put("layout/fragment_seeker_experience_list_0", com.findajob.jobamax.R.layout.fragment_seeker_experience_list);
      sKeys.put("layout/fragment_seeker_filter_job_0", com.findajob.jobamax.R.layout.fragment_seeker_filter_job);
      sKeys.put("layout/fragment_seeker_import_resume_0", com.findajob.jobamax.R.layout.fragment_seeker_import_resume);
      sKeys.put("layout/fragment_seeker_interest_0", com.findajob.jobamax.R.layout.fragment_seeker_interest);
      sKeys.put("layout/fragment_seeker_job_match_info_dialog_0", com.findajob.jobamax.R.layout.fragment_seeker_job_match_info_dialog);
      sKeys.put("layout/fragment_seeker_job_search_filter_categories_dialog_0", com.findajob.jobamax.R.layout.fragment_seeker_job_search_filter_categories_dialog);
      sKeys.put("layout/fragment_seeker_job_web_dialog_0", com.findajob.jobamax.R.layout.fragment_seeker_job_web_dialog);
      sKeys.put("layout/fragment_seeker_jobs_0", com.findajob.jobamax.R.layout.fragment_seeker_jobs);
      sKeys.put("layout/fragment_seeker_jobs_filter_0", com.findajob.jobamax.R.layout.fragment_seeker_jobs_filter);
      sKeys.put("layout/fragment_seeker_my_skill_0", com.findajob.jobamax.R.layout.fragment_seeker_my_skill);
      sKeys.put("layout/fragment_seeker_new_education_0", com.findajob.jobamax.R.layout.fragment_seeker_new_education);
      sKeys.put("layout/fragment_seeker_preview_0", com.findajob.jobamax.R.layout.fragment_seeker_preview);
      sKeys.put("layout/fragment_seeker_profile_0", com.findajob.jobamax.R.layout.fragment_seeker_profile);
      sKeys.put("layout/fragment_seeker_search_university_dialog_0", com.findajob.jobamax.R.layout.fragment_seeker_search_university_dialog);
      sKeys.put("layout/fragment_seeker_social_media_ids_0", com.findajob.jobamax.R.layout.fragment_seeker_social_media_ids);
      sKeys.put("layout/fragment_seeker_tracking_job_0", com.findajob.jobamax.R.layout.fragment_seeker_tracking_job);
      sKeys.put("layout/fragment_seeker_tracking_job_description_0", com.findajob.jobamax.R.layout.fragment_seeker_tracking_job_description);
      sKeys.put("layout/fragment_seeker_tracking_job_details_0", com.findajob.jobamax.R.layout.fragment_seeker_tracking_job_details);
      sKeys.put("layout/fragment_seeker_tracking_job_filter_dialog_0", com.findajob.jobamax.R.layout.fragment_seeker_tracking_job_filter_dialog);
      sKeys.put("layout/fragment_seeker_volunteering_list_0", com.findajob.jobamax.R.layout.fragment_seeker_volunteering_list);
      sKeys.put("layout/fragment_seeker_wish_list_0", com.findajob.jobamax.R.layout.fragment_seeker_wish_list);
      sKeys.put("layout/fragment_value_privacy_0", com.findajob.jobamax.R.layout.fragment_value_privacy);
      sKeys.put("layout/item_calender_event_card_0", com.findajob.jobamax.R.layout.item_calender_event_card);
      sKeys.put("layout/item_category_chip_0", com.findajob.jobamax.R.layout.item_category_chip);
      sKeys.put("layout/item_cheap_0", com.findajob.jobamax.R.layout.item_cheap);
      sKeys.put("layout/item_image_0", com.findajob.jobamax.R.layout.item_image);
      sKeys.put("layout/item_job_search_filter_category_0", com.findajob.jobamax.R.layout.item_job_search_filter_category);
      sKeys.put("layout/item_job_title_0", com.findajob.jobamax.R.layout.item_job_title);
      sKeys.put("layout/item_leaving_reason_0", com.findajob.jobamax.R.layout.item_leaving_reason);
      sKeys.put("layout/item_link_0", com.findajob.jobamax.R.layout.item_link);
      sKeys.put("layout/item_portfolio_image_0", com.findajob.jobamax.R.layout.item_portfolio_image);
      sKeys.put("layout/item_portfolio_link_0", com.findajob.jobamax.R.layout.item_portfolio_link);
      sKeys.put("layout/item_search_query_company_0", com.findajob.jobamax.R.layout.item_search_query_company);
      sKeys.put("layout/item_seeker_education_0", com.findajob.jobamax.R.layout.item_seeker_education);
      sKeys.put("layout/item_seeker_experience_0", com.findajob.jobamax.R.layout.item_seeker_experience);
      sKeys.put("layout/item_seeker_hard_skill_0", com.findajob.jobamax.R.layout.item_seeker_hard_skill);
      sKeys.put("layout/item_seeker_job_card_0", com.findajob.jobamax.R.layout.item_seeker_job_card);
      sKeys.put("layout/item_seeker_other_job_0", com.findajob.jobamax.R.layout.item_seeker_other_job);
      sKeys.put("layout/item_seeker_preview_experience_0", com.findajob.jobamax.R.layout.item_seeker_preview_experience);
      sKeys.put("layout/item_seeker_preview_hard_skill_0", com.findajob.jobamax.R.layout.item_seeker_preview_hard_skill);
      sKeys.put("layout/item_seeker_preview_school_0", com.findajob.jobamax.R.layout.item_seeker_preview_school);
      sKeys.put("layout/item_seeker_preview_volunteering_0", com.findajob.jobamax.R.layout.item_seeker_preview_volunteering);
      sKeys.put("layout/item_seeker_search_university_0", com.findajob.jobamax.R.layout.item_seeker_search_university);
      sKeys.put("layout/item_seeker_track_0", com.findajob.jobamax.R.layout.item_seeker_track);
      sKeys.put("layout/item_seeker_tracking_job_detail_card_0", com.findajob.jobamax.R.layout.item_seeker_tracking_job_detail_card);
      sKeys.put("layout/item_seeker_volunteering_0", com.findajob.jobamax.R.layout.item_seeker_volunteering);
      sKeys.put("layout/item_wishlist_job_0", com.findajob.jobamax.R.layout.item_wishlist_job);
      sKeys.put("layout/popup_add_job_to_track_0", com.findajob.jobamax.R.layout.popup_add_job_to_track);
    }
  }
}
