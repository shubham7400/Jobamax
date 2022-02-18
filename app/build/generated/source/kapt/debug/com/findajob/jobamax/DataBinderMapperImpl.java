package com.findajob.jobamax;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.findajob.jobamax.databinding.ActivityChatBindingImpl;
import com.findajob.jobamax.databinding.ActivityCompanyIntroInfoBindingImpl;
import com.findajob.jobamax.databinding.ActivityDashboardBindingImpl;
import com.findajob.jobamax.databinding.ActivityHomeBindingImpl;
import com.findajob.jobamax.databinding.ActivityJobSeekerAccountBindingImpl;
import com.findajob.jobamax.databinding.ActivityJobSeekerApplyBindingImpl;
import com.findajob.jobamax.databinding.ActivityJobSeekerCourseBindingImpl;
import com.findajob.jobamax.databinding.ActivityJobSeekerHomeBindingImpl;
import com.findajob.jobamax.databinding.ActivityJobSeekerPasswordBindingImpl;
import com.findajob.jobamax.databinding.ActivityJobSeekerPersonalIntroInfoBindingImpl;
import com.findajob.jobamax.databinding.ActivityLicenseBindingImpl;
import com.findajob.jobamax.databinding.ActivityLoginBindingImpl;
import com.findajob.jobamax.databinding.ActivityMainBindingImpl;
import com.findajob.jobamax.databinding.ActivityMainChatBindingImpl;
import com.findajob.jobamax.databinding.ActivityManageLocationBindingImpl;
import com.findajob.jobamax.databinding.ActivityManageRoomBindingImpl;
import com.findajob.jobamax.databinding.ActivityMapsBindingImpl;
import com.findajob.jobamax.databinding.ActivityMasterClassBindingImpl;
import com.findajob.jobamax.databinding.ActivityMasterClassDetailsBindingImpl;
import com.findajob.jobamax.databinding.ActivityMasterClassGuestDetailsBindingImpl;
import com.findajob.jobamax.databinding.ActivityOnlineCourseBindingImpl;
import com.findajob.jobamax.databinding.ActivityOnlineCourseDetailsBindingImpl;
import com.findajob.jobamax.databinding.ActivityPaymentBindingImpl;
import com.findajob.jobamax.databinding.ActivityPreviewImageBindingImpl;
import com.findajob.jobamax.databinding.ActivityPrivacyPreferenceBindingImpl;
import com.findajob.jobamax.databinding.ActivityProfileBindingImpl;
import com.findajob.jobamax.databinding.ActivityRecruiterHomeBindingImpl;
import com.findajob.jobamax.databinding.ActivityRecruiterPersonalInfoIntroBindingImpl;
import com.findajob.jobamax.databinding.ActivityRecruiterSubscriptionBindingImpl;
import com.findajob.jobamax.databinding.ActivitySeekerCalenderBindingImpl;
import com.findajob.jobamax.databinding.ActivitySeekerJobSearchBindingImpl;
import com.findajob.jobamax.databinding.ActivitySeekerJobTrackingBindingImpl;
import com.findajob.jobamax.databinding.ActivitySeekerProfileBindingImpl;
import com.findajob.jobamax.databinding.ActivitySeekerWishListBindingImpl;
import com.findajob.jobamax.databinding.ActivitySelectLocationBindingImpl;
import com.findajob.jobamax.databinding.ActivitySplashBindingImpl;
import com.findajob.jobamax.databinding.ActivityVideoChatViewBindingImpl;
import com.findajob.jobamax.databinding.ActivityVideoPlayBindingImpl;
import com.findajob.jobamax.databinding.ActivityWebViewBindingImpl;
import com.findajob.jobamax.databinding.CalendarCellBindingImpl;
import com.findajob.jobamax.databinding.DialogAddLinkedinBindingImpl;
import com.findajob.jobamax.databinding.DialogAddTrackingJobPhaseBindingImpl;
import com.findajob.jobamax.databinding.DialogConfirmBindingImpl;
import com.findajob.jobamax.databinding.DialogConfirmationBindingImpl;
import com.findajob.jobamax.databinding.DialogLeaveRoomBindingImpl;
import com.findajob.jobamax.databinding.DialogMessagePopUpBindingImpl;
import com.findajob.jobamax.databinding.DialogReachBindingImpl;
import com.findajob.jobamax.databinding.DialogRequirementsBindingImpl;
import com.findajob.jobamax.databinding.DialogRequirementsOldBindingImpl;
import com.findajob.jobamax.databinding.FragmentAboutBindingImpl;
import com.findajob.jobamax.databinding.FragmentArchivedChatsBindingImpl;
import com.findajob.jobamax.databinding.FragmentChatMessageBoardBindingImpl;
import com.findajob.jobamax.databinding.FragmentChatUserListBindingImpl;
import com.findajob.jobamax.databinding.FragmentChatsBindingImpl;
import com.findajob.jobamax.databinding.FragmentCompanyInformationBindingImpl;
import com.findajob.jobamax.databinding.FragmentConfirm1SeekerBindingImpl;
import com.findajob.jobamax.databinding.FragmentConfirm2SeekerBindingImpl;
import com.findajob.jobamax.databinding.FragmentConfirm3SeekerBindingImpl;
import com.findajob.jobamax.databinding.FragmentConfirmRecruiterBindingImpl;
import com.findajob.jobamax.databinding.FragmentCoursesBindingImpl;
import com.findajob.jobamax.databinding.FragmentCreateEducationBindingImpl;
import com.findajob.jobamax.databinding.FragmentCreateExperienceBindingImpl;
import com.findajob.jobamax.databinding.FragmentDisplayChatItemDialogBindingImpl;
import com.findajob.jobamax.databinding.FragmentEventCalendarBindingImpl;
import com.findajob.jobamax.databinding.FragmentIdealJobAudioBindingImpl;
import com.findajob.jobamax.databinding.FragmentIdealJobDescriptionBindingImpl;
import com.findajob.jobamax.databinding.FragmentIdealJobImagesBindingImpl;
import com.findajob.jobamax.databinding.FragmentIdealJobVideoBindingImpl;
import com.findajob.jobamax.databinding.FragmentInstructorsBindingImpl;
import com.findajob.jobamax.databinding.FragmentJobListingBindingImpl;
import com.findajob.jobamax.databinding.FragmentJobOfferCardInfoBindingImpl;
import com.findajob.jobamax.databinding.FragmentJobOfferDetailsBindingImpl;
import com.findajob.jobamax.databinding.FragmentJobSearchBindingImpl;
import com.findajob.jobamax.databinding.FragmentJobSeekerAccountBindingImpl;
import com.findajob.jobamax.databinding.FragmentJobSeekerApplyBindingImpl;
import com.findajob.jobamax.databinding.FragmentJobSeekerManageReadReceiptsBindingImpl;
import com.findajob.jobamax.databinding.FragmentJobSeekerMediaBindingImpl;
import com.findajob.jobamax.databinding.FragmentJobSeekerNewsletterBindingImpl;
import com.findajob.jobamax.databinding.FragmentJobSeekerPaymentMethodsBindingImpl;
import com.findajob.jobamax.databinding.FragmentJobSeekerPersonalInformationBindingImpl;
import com.findajob.jobamax.databinding.FragmentJobSeekerProfileBindingImpl;
import com.findajob.jobamax.databinding.FragmentJobSeekerPushNotificationBindingImpl;
import com.findajob.jobamax.databinding.FragmentJobSeekerResumeBindingImpl;
import com.findajob.jobamax.databinding.FragmentJobSeekerSocialLinksBindingImpl;
import com.findajob.jobamax.databinding.FragmentJobSeekerTrackBindingImpl;
import com.findajob.jobamax.databinding.FragmentJobSourceBindingImpl;
import com.findajob.jobamax.databinding.FragmentJobamaxClubBindingImpl;
import com.findajob.jobamax.databinding.FragmentKeepMePostedBindingImpl;
import com.findajob.jobamax.databinding.FragmentKeynotesBindingImpl;
import com.findajob.jobamax.databinding.FragmentLikeDislikeDialogBindingImpl;
import com.findajob.jobamax.databinding.FragmentLiveRoomBindingImpl;
import com.findajob.jobamax.databinding.FragmentLiveRoomInterestsBindingImpl;
import com.findajob.jobamax.databinding.FragmentLiveRoomParticipantsBindingImpl;
import com.findajob.jobamax.databinding.FragmentLiveRoomWelcomeBindingImpl;
import com.findajob.jobamax.databinding.FragmentLocationPermissionBindingImpl;
import com.findajob.jobamax.databinding.FragmentLoginBindingImpl;
import com.findajob.jobamax.databinding.FragmentManageRoomBindingImpl;
import com.findajob.jobamax.databinding.FragmentMasterClassBindingImpl;
import com.findajob.jobamax.databinding.FragmentMasterclassDetailsBindingImpl;
import com.findajob.jobamax.databinding.FragmentMeetNearbyPeopleBindingImpl;
import com.findajob.jobamax.databinding.FragmentMessagesBindingImpl;
import com.findajob.jobamax.databinding.FragmentNetworkingChatsBindingImpl;
import com.findajob.jobamax.databinding.FragmentNewLoginSelectRoleBindingImpl;
import com.findajob.jobamax.databinding.FragmentNoReactionBindingImpl;
import com.findajob.jobamax.databinding.FragmentNoReactionDropEmailBindingImpl;
import com.findajob.jobamax.databinding.FragmentOnlineCoursesListBindingImpl;
import com.findajob.jobamax.databinding.FragmentPortfolioDescriptionBindingImpl;
import com.findajob.jobamax.databinding.FragmentPortfolioImageBindingImpl;
import com.findajob.jobamax.databinding.FragmentPortfolioVideoBindingImpl;
import com.findajob.jobamax.databinding.FragmentProfileBindingImpl;
import com.findajob.jobamax.databinding.FragmentProfileRecruiterBindingImpl;
import com.findajob.jobamax.databinding.FragmentRecruiterAccountBindingImpl;
import com.findajob.jobamax.databinding.FragmentRecruiterChatsBindingImpl;
import com.findajob.jobamax.databinding.FragmentRecruiterCourseBindingImpl;
import com.findajob.jobamax.databinding.FragmentRecruiterCurrentSubscriptionBindingImpl;
import com.findajob.jobamax.databinding.FragmentRecruiterDeleteAccountBindingImpl;
import com.findajob.jobamax.databinding.FragmentRecruiterDeleteAccountFinalBindingImpl;
import com.findajob.jobamax.databinding.FragmentRecruiterInvoicesBindingImpl;
import com.findajob.jobamax.databinding.FragmentRecruiterManageReadReceiptsBindingImpl;
import com.findajob.jobamax.databinding.FragmentRecruiterMediaBindingImpl;
import com.findajob.jobamax.databinding.FragmentRecruiterMessagesBindingImpl;
import com.findajob.jobamax.databinding.FragmentRecruiterNewsletterBindingImpl;
import com.findajob.jobamax.databinding.FragmentRecruiterPaymentMethodsBindingImpl;
import com.findajob.jobamax.databinding.FragmentRecruiterPersonalInformationBindingImpl;
import com.findajob.jobamax.databinding.FragmentRecruiterPushNotificationBindingImpl;
import com.findajob.jobamax.databinding.FragmentRecruiterRecruitBindingImpl;
import com.findajob.jobamax.databinding.FragmentRecruiterSocialLinksBindingImpl;
import com.findajob.jobamax.databinding.FragmentRecruiterSourceBindingImpl;
import com.findajob.jobamax.databinding.FragmentRegisterBindingImpl;
import com.findajob.jobamax.databinding.FragmentReviewsBindingImpl;
import com.findajob.jobamax.databinding.FragmentSearchBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerAboutMeBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerAddExperienceBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerAddVolunteeringBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerCalenderBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerChangePasswordBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerDeleteAccountBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerDeleteAccountFinalBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerEducationBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerExperienceListBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerFilterJobBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerImportResumeBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerInterestBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerJobsBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerJobsFilterBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerMySkillBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerNewEducationBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerPreviewBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerProfileBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerSearchUniversityDialogBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerSocialMediaIdsBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerTrackingJobBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerTrackingJobDetailsBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerTrackingJobFilterDialogBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerVolunteeringListBindingImpl;
import com.findajob.jobamax.databinding.FragmentSeekerWishListBindingImpl;
import com.findajob.jobamax.databinding.FragmentSelectRoleBindingImpl;
import com.findajob.jobamax.databinding.FragmentSplashBindingImpl;
import com.findajob.jobamax.databinding.FragmentSyllabusBindingImpl;
import com.findajob.jobamax.databinding.FragmentValuePrivacyBindingImpl;
import com.findajob.jobamax.databinding.FragmentVerificationCodeBindingImpl;
import com.findajob.jobamax.databinding.FragmentViewJobOfferBindingImpl;
import com.findajob.jobamax.databinding.FragmentWelcomeAsSeekerBindingImpl;
import com.findajob.jobamax.databinding.ItemArchivedMessagesBindingImpl;
import com.findajob.jobamax.databinding.ItemCalenderEventCardBindingImpl;
import com.findajob.jobamax.databinding.ItemChatBindingImpl;
import com.findajob.jobamax.databinding.ItemChatReceiverBindingImpl;
import com.findajob.jobamax.databinding.ItemChatSenderBindingImpl;
import com.findajob.jobamax.databinding.ItemChatUserHorizontalBindingImpl;
import com.findajob.jobamax.databinding.ItemChatUserVerticalBindingImpl;
import com.findajob.jobamax.databinding.ItemCompanyProfileBindingImpl;
import com.findajob.jobamax.databinding.ItemCompanySizeBindingImpl;
import com.findajob.jobamax.databinding.ItemCurrentOnlineBindingImpl;
import com.findajob.jobamax.databinding.ItemEventBindingImpl;
import com.findajob.jobamax.databinding.ItemImageBindingImpl;
import com.findajob.jobamax.databinding.ItemInfoBindingImpl;
import com.findajob.jobamax.databinding.ItemJobOfferBindingImpl;
import com.findajob.jobamax.databinding.ItemJobOfferCardBindingImpl;
import com.findajob.jobamax.databinding.ItemJobSeekerRecruitCardBindingImpl;
import com.findajob.jobamax.databinding.ItemJobSeekerSourceCardBindingImpl;
import com.findajob.jobamax.databinding.ItemJobSeekerTrackOfferBindingImpl;
import com.findajob.jobamax.databinding.ItemLeavingReasonBindingImpl;
import com.findajob.jobamax.databinding.ItemLocationBindingImpl;
import com.findajob.jobamax.databinding.ItemMasterClassBindingImpl;
import com.findajob.jobamax.databinding.ItemMasterClassSessionGuestBindingImpl;
import com.findajob.jobamax.databinding.ItemMasterclassVideoBindingImpl;
import com.findajob.jobamax.databinding.ItemMessageImageBindingImpl;
import com.findajob.jobamax.databinding.ItemMessageTextBindingImpl;
import com.findajob.jobamax.databinding.ItemMessageVideoBindingImpl;
import com.findajob.jobamax.databinding.ItemMessagesBindingImpl;
import com.findajob.jobamax.databinding.ItemMyListBindingImpl;
import com.findajob.jobamax.databinding.ItemOfferBindingImpl;
import com.findajob.jobamax.databinding.ItemOnlineCourseInstructorBindingImpl;
import com.findajob.jobamax.databinding.ItemOnlineCourseReviewBindingImpl;
import com.findajob.jobamax.databinding.ItemOnlineCourseSyllabusBindingImpl;
import com.findajob.jobamax.databinding.ItemOnlineCoursesBindingImpl;
import com.findajob.jobamax.databinding.ItemOurCategoriesBindingImpl;
import com.findajob.jobamax.databinding.ItemPortfolioImageBindingImpl;
import com.findajob.jobamax.databinding.ItemRecruiterInfoBindingImpl;
import com.findajob.jobamax.databinding.ItemRecruiterJobOffersBindingImpl;
import com.findajob.jobamax.databinding.ItemRequirementCheckBindingImpl;
import com.findajob.jobamax.databinding.ItemSeekerEducationBindingImpl;
import com.findajob.jobamax.databinding.ItemSeekerExperienceBindingImpl;
import com.findajob.jobamax.databinding.ItemSeekerHardSkillBindingImpl;
import com.findajob.jobamax.databinding.ItemSeekerJobCardBindingImpl;
import com.findajob.jobamax.databinding.ItemSeekerPreviewExperienceBindingImpl;
import com.findajob.jobamax.databinding.ItemSeekerPreviewHardSkillBindingImpl;
import com.findajob.jobamax.databinding.ItemSeekerPreviewSchoolBindingImpl;
import com.findajob.jobamax.databinding.ItemSeekerPreviewVolunteeringBindingImpl;
import com.findajob.jobamax.databinding.ItemSeekerSearchUniversityBindingImpl;
import com.findajob.jobamax.databinding.ItemSeekerTrackBindingImpl;
import com.findajob.jobamax.databinding.ItemSeekerTrackingJobDetailCardBindingImpl;
import com.findajob.jobamax.databinding.ItemSeekerVolunteeringBindingImpl;
import com.findajob.jobamax.databinding.ItemSubscriptionDetailsBindingImpl;
import com.findajob.jobamax.databinding.ItemTrainingCoursesBindingImpl;
import com.findajob.jobamax.databinding.ItemUpcomingEventsBindingImpl;
import com.findajob.jobamax.databinding.ItemVideoThumbnailBindingImpl;
import com.findajob.jobamax.databinding.ItemWishlistJobBindingImpl;
import com.findajob.jobamax.databinding.ListItemNewPeopleBindingImpl;
import com.findajob.jobamax.databinding.ListItemParticipantsBindingImpl;
import com.findajob.jobamax.databinding.Profile6BindingImpl;
import com.findajob.jobamax.databinding.Profile7BindingImpl;
import com.findajob.jobamax.databinding.RecruiterHomeBindingImpl;
import com.findajob.jobamax.databinding.TabItemSubscriptionBindingImpl;
import com.findajob.jobamax.databinding.TracktestuiBindingImpl;
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
  private static final int LAYOUT_ACTIVITYCHAT = 1;

  private static final int LAYOUT_ACTIVITYCOMPANYINTROINFO = 2;

  private static final int LAYOUT_ACTIVITYDASHBOARD = 3;

  private static final int LAYOUT_ACTIVITYHOME = 4;

  private static final int LAYOUT_ACTIVITYJOBSEEKERACCOUNT = 5;

  private static final int LAYOUT_ACTIVITYJOBSEEKERAPPLY = 6;

  private static final int LAYOUT_ACTIVITYJOBSEEKERCOURSE = 7;

  private static final int LAYOUT_ACTIVITYJOBSEEKERHOME = 8;

  private static final int LAYOUT_ACTIVITYJOBSEEKERPASSWORD = 9;

  private static final int LAYOUT_ACTIVITYJOBSEEKERPERSONALINTROINFO = 10;

  private static final int LAYOUT_ACTIVITYLICENSE = 11;

  private static final int LAYOUT_ACTIVITYLOGIN = 12;

  private static final int LAYOUT_ACTIVITYMAIN = 13;

  private static final int LAYOUT_ACTIVITYMAINCHAT = 14;

  private static final int LAYOUT_ACTIVITYMANAGELOCATION = 15;

  private static final int LAYOUT_ACTIVITYMANAGEROOM = 16;

  private static final int LAYOUT_ACTIVITYMAPS = 17;

  private static final int LAYOUT_ACTIVITYMASTERCLASS = 18;

  private static final int LAYOUT_ACTIVITYMASTERCLASSDETAILS = 19;

  private static final int LAYOUT_ACTIVITYMASTERCLASSGUESTDETAILS = 20;

  private static final int LAYOUT_ACTIVITYONLINECOURSE = 21;

  private static final int LAYOUT_ACTIVITYONLINECOURSEDETAILS = 22;

  private static final int LAYOUT_ACTIVITYPAYMENT = 23;

  private static final int LAYOUT_ACTIVITYPREVIEWIMAGE = 24;

  private static final int LAYOUT_ACTIVITYPRIVACYPREFERENCE = 25;

  private static final int LAYOUT_ACTIVITYPROFILE = 26;

  private static final int LAYOUT_ACTIVITYRECRUITERHOME = 27;

  private static final int LAYOUT_ACTIVITYRECRUITERPERSONALINFOINTRO = 28;

  private static final int LAYOUT_ACTIVITYRECRUITERSUBSCRIPTION = 29;

  private static final int LAYOUT_ACTIVITYSEEKERCALENDER = 30;

  private static final int LAYOUT_ACTIVITYSEEKERJOBSEARCH = 31;

  private static final int LAYOUT_ACTIVITYSEEKERJOBTRACKING = 32;

  private static final int LAYOUT_ACTIVITYSEEKERPROFILE = 33;

  private static final int LAYOUT_ACTIVITYSEEKERWISHLIST = 34;

  private static final int LAYOUT_ACTIVITYSELECTLOCATION = 35;

  private static final int LAYOUT_ACTIVITYSPLASH = 36;

  private static final int LAYOUT_ACTIVITYVIDEOCHATVIEW = 37;

  private static final int LAYOUT_ACTIVITYVIDEOPLAY = 38;

  private static final int LAYOUT_ACTIVITYWEBVIEW = 39;

  private static final int LAYOUT_CALENDARCELL = 40;

  private static final int LAYOUT_DIALOGADDLINKEDIN = 41;

  private static final int LAYOUT_DIALOGADDTRACKINGJOBPHASE = 42;

  private static final int LAYOUT_DIALOGCONFIRM = 43;

  private static final int LAYOUT_DIALOGCONFIRMATION = 44;

  private static final int LAYOUT_DIALOGLEAVEROOM = 45;

  private static final int LAYOUT_DIALOGMESSAGEPOPUP = 46;

  private static final int LAYOUT_DIALOGREACH = 47;

  private static final int LAYOUT_DIALOGREQUIREMENTS = 48;

  private static final int LAYOUT_DIALOGREQUIREMENTSOLD = 49;

  private static final int LAYOUT_FRAGMENTABOUT = 50;

  private static final int LAYOUT_FRAGMENTARCHIVEDCHATS = 51;

  private static final int LAYOUT_FRAGMENTCHATMESSAGEBOARD = 52;

  private static final int LAYOUT_FRAGMENTCHATUSERLIST = 53;

  private static final int LAYOUT_FRAGMENTCHATS = 54;

  private static final int LAYOUT_FRAGMENTCOMPANYINFORMATION = 55;

  private static final int LAYOUT_FRAGMENTCONFIRM1SEEKER = 56;

  private static final int LAYOUT_FRAGMENTCONFIRM2SEEKER = 57;

  private static final int LAYOUT_FRAGMENTCONFIRM3SEEKER = 58;

  private static final int LAYOUT_FRAGMENTCONFIRMRECRUITER = 59;

  private static final int LAYOUT_FRAGMENTCOURSES = 60;

  private static final int LAYOUT_FRAGMENTCREATEEDUCATION = 61;

  private static final int LAYOUT_FRAGMENTCREATEEXPERIENCE = 62;

  private static final int LAYOUT_FRAGMENTDISPLAYCHATITEMDIALOG = 63;

  private static final int LAYOUT_FRAGMENTEVENTCALENDAR = 64;

  private static final int LAYOUT_FRAGMENTIDEALJOBAUDIO = 65;

  private static final int LAYOUT_FRAGMENTIDEALJOBDESCRIPTION = 66;

  private static final int LAYOUT_FRAGMENTIDEALJOBIMAGES = 67;

  private static final int LAYOUT_FRAGMENTIDEALJOBVIDEO = 68;

  private static final int LAYOUT_FRAGMENTINSTRUCTORS = 69;

  private static final int LAYOUT_FRAGMENTJOBLISTING = 70;

  private static final int LAYOUT_FRAGMENTJOBOFFERCARDINFO = 71;

  private static final int LAYOUT_FRAGMENTJOBOFFERDETAILS = 72;

  private static final int LAYOUT_FRAGMENTJOBSEARCH = 73;

  private static final int LAYOUT_FRAGMENTJOBSEEKERACCOUNT = 74;

  private static final int LAYOUT_FRAGMENTJOBSEEKERAPPLY = 75;

  private static final int LAYOUT_FRAGMENTJOBSEEKERMANAGEREADRECEIPTS = 76;

  private static final int LAYOUT_FRAGMENTJOBSEEKERMEDIA = 77;

  private static final int LAYOUT_FRAGMENTJOBSEEKERNEWSLETTER = 78;

  private static final int LAYOUT_FRAGMENTJOBSEEKERPAYMENTMETHODS = 79;

  private static final int LAYOUT_FRAGMENTJOBSEEKERPERSONALINFORMATION = 80;

  private static final int LAYOUT_FRAGMENTJOBSEEKERPROFILE = 81;

  private static final int LAYOUT_FRAGMENTJOBSEEKERPUSHNOTIFICATION = 82;

  private static final int LAYOUT_FRAGMENTJOBSEEKERRESUME = 83;

  private static final int LAYOUT_FRAGMENTJOBSEEKERSOCIALLINKS = 84;

  private static final int LAYOUT_FRAGMENTJOBSEEKERTRACK = 85;

  private static final int LAYOUT_FRAGMENTJOBSOURCE = 86;

  private static final int LAYOUT_FRAGMENTJOBAMAXCLUB = 87;

  private static final int LAYOUT_FRAGMENTKEEPMEPOSTED = 88;

  private static final int LAYOUT_FRAGMENTKEYNOTES = 89;

  private static final int LAYOUT_FRAGMENTLIKEDISLIKEDIALOG = 90;

  private static final int LAYOUT_FRAGMENTLIVEROOM = 91;

  private static final int LAYOUT_FRAGMENTLIVEROOMINTERESTS = 92;

  private static final int LAYOUT_FRAGMENTLIVEROOMPARTICIPANTS = 93;

  private static final int LAYOUT_FRAGMENTLIVEROOMWELCOME = 94;

  private static final int LAYOUT_FRAGMENTLOCATIONPERMISSION = 95;

  private static final int LAYOUT_FRAGMENTLOGIN = 96;

  private static final int LAYOUT_FRAGMENTMANAGEROOM = 97;

  private static final int LAYOUT_FRAGMENTMASTERCLASS = 98;

  private static final int LAYOUT_FRAGMENTMASTERCLASSDETAILS = 99;

  private static final int LAYOUT_FRAGMENTMEETNEARBYPEOPLE = 100;

  private static final int LAYOUT_FRAGMENTMESSAGES = 101;

  private static final int LAYOUT_FRAGMENTNETWORKINGCHATS = 102;

  private static final int LAYOUT_FRAGMENTNEWLOGINSELECTROLE = 103;

  private static final int LAYOUT_FRAGMENTNOREACTION = 104;

  private static final int LAYOUT_FRAGMENTNOREACTIONDROPEMAIL = 105;

  private static final int LAYOUT_FRAGMENTONLINECOURSESLIST = 106;

  private static final int LAYOUT_FRAGMENTPORTFOLIODESCRIPTION = 107;

  private static final int LAYOUT_FRAGMENTPORTFOLIOIMAGE = 108;

  private static final int LAYOUT_FRAGMENTPORTFOLIOVIDEO = 109;

  private static final int LAYOUT_FRAGMENTPROFILE = 110;

  private static final int LAYOUT_FRAGMENTPROFILERECRUITER = 111;

  private static final int LAYOUT_FRAGMENTRECRUITERACCOUNT = 112;

  private static final int LAYOUT_FRAGMENTRECRUITERCHATS = 113;

  private static final int LAYOUT_FRAGMENTRECRUITERCOURSE = 114;

  private static final int LAYOUT_FRAGMENTRECRUITERCURRENTSUBSCRIPTION = 115;

  private static final int LAYOUT_FRAGMENTRECRUITERDELETEACCOUNT = 116;

  private static final int LAYOUT_FRAGMENTRECRUITERDELETEACCOUNTFINAL = 117;

  private static final int LAYOUT_FRAGMENTRECRUITERINVOICES = 118;

  private static final int LAYOUT_FRAGMENTRECRUITERMANAGEREADRECEIPTS = 119;

  private static final int LAYOUT_FRAGMENTRECRUITERMEDIA = 120;

  private static final int LAYOUT_FRAGMENTRECRUITERMESSAGES = 121;

  private static final int LAYOUT_FRAGMENTRECRUITERNEWSLETTER = 122;

  private static final int LAYOUT_FRAGMENTRECRUITERPAYMENTMETHODS = 123;

  private static final int LAYOUT_FRAGMENTRECRUITERPERSONALINFORMATION = 124;

  private static final int LAYOUT_FRAGMENTRECRUITERPUSHNOTIFICATION = 125;

  private static final int LAYOUT_FRAGMENTRECRUITERRECRUIT = 126;

  private static final int LAYOUT_FRAGMENTRECRUITERSOCIALLINKS = 127;

  private static final int LAYOUT_FRAGMENTRECRUITERSOURCE = 128;

  private static final int LAYOUT_FRAGMENTREGISTER = 129;

  private static final int LAYOUT_FRAGMENTREVIEWS = 130;

  private static final int LAYOUT_FRAGMENTSEARCH = 131;

  private static final int LAYOUT_FRAGMENTSEEKERABOUTME = 132;

  private static final int LAYOUT_FRAGMENTSEEKERADDEXPERIENCE = 133;

  private static final int LAYOUT_FRAGMENTSEEKERADDVOLUNTEERING = 134;

  private static final int LAYOUT_FRAGMENTSEEKERCALENDER = 135;

  private static final int LAYOUT_FRAGMENTSEEKERCHANGEPASSWORD = 136;

  private static final int LAYOUT_FRAGMENTSEEKERDELETEACCOUNT = 137;

  private static final int LAYOUT_FRAGMENTSEEKERDELETEACCOUNTFINAL = 138;

  private static final int LAYOUT_FRAGMENTSEEKEREDUCATION = 139;

  private static final int LAYOUT_FRAGMENTSEEKEREXPERIENCELIST = 140;

  private static final int LAYOUT_FRAGMENTSEEKERFILTERJOB = 141;

  private static final int LAYOUT_FRAGMENTSEEKERIMPORTRESUME = 142;

  private static final int LAYOUT_FRAGMENTSEEKERINTEREST = 143;

  private static final int LAYOUT_FRAGMENTSEEKERJOBS = 144;

  private static final int LAYOUT_FRAGMENTSEEKERJOBSFILTER = 145;

  private static final int LAYOUT_FRAGMENTSEEKERMYSKILL = 146;

  private static final int LAYOUT_FRAGMENTSEEKERNEWEDUCATION = 147;

  private static final int LAYOUT_FRAGMENTSEEKERPREVIEW = 148;

  private static final int LAYOUT_FRAGMENTSEEKERPROFILE = 149;

  private static final int LAYOUT_FRAGMENTSEEKERSEARCHUNIVERSITYDIALOG = 150;

  private static final int LAYOUT_FRAGMENTSEEKERSOCIALMEDIAIDS = 151;

  private static final int LAYOUT_FRAGMENTSEEKERTRACKINGJOB = 152;

  private static final int LAYOUT_FRAGMENTSEEKERTRACKINGJOBDETAILS = 153;

  private static final int LAYOUT_FRAGMENTSEEKERTRACKINGJOBFILTERDIALOG = 154;

  private static final int LAYOUT_FRAGMENTSEEKERVOLUNTEERINGLIST = 155;

  private static final int LAYOUT_FRAGMENTSEEKERWISHLIST = 156;

  private static final int LAYOUT_FRAGMENTSELECTROLE = 157;

  private static final int LAYOUT_FRAGMENTSPLASH = 158;

  private static final int LAYOUT_FRAGMENTSYLLABUS = 159;

  private static final int LAYOUT_FRAGMENTVALUEPRIVACY = 160;

  private static final int LAYOUT_FRAGMENTVERIFICATIONCODE = 161;

  private static final int LAYOUT_FRAGMENTVIEWJOBOFFER = 162;

  private static final int LAYOUT_FRAGMENTWELCOMEASSEEKER = 163;

  private static final int LAYOUT_ITEMARCHIVEDMESSAGES = 164;

  private static final int LAYOUT_ITEMCALENDEREVENTCARD = 165;

  private static final int LAYOUT_ITEMCHAT = 166;

  private static final int LAYOUT_ITEMCHATRECEIVER = 167;

  private static final int LAYOUT_ITEMCHATSENDER = 168;

  private static final int LAYOUT_ITEMCHATUSERHORIZONTAL = 169;

  private static final int LAYOUT_ITEMCHATUSERVERTICAL = 170;

  private static final int LAYOUT_ITEMCOMPANYPROFILE = 171;

  private static final int LAYOUT_ITEMCOMPANYSIZE = 172;

  private static final int LAYOUT_ITEMCURRENTONLINE = 173;

  private static final int LAYOUT_ITEMEVENT = 174;

  private static final int LAYOUT_ITEMIMAGE = 175;

  private static final int LAYOUT_ITEMINFO = 176;

  private static final int LAYOUT_ITEMJOBOFFER = 177;

  private static final int LAYOUT_ITEMJOBOFFERCARD = 178;

  private static final int LAYOUT_ITEMJOBSEEKERRECRUITCARD = 179;

  private static final int LAYOUT_ITEMJOBSEEKERSOURCECARD = 180;

  private static final int LAYOUT_ITEMJOBSEEKERTRACKOFFER = 181;

  private static final int LAYOUT_ITEMLEAVINGREASON = 182;

  private static final int LAYOUT_ITEMLOCATION = 183;

  private static final int LAYOUT_ITEMMASTERCLASS = 184;

  private static final int LAYOUT_ITEMMASTERCLASSSESSIONGUEST = 185;

  private static final int LAYOUT_ITEMMASTERCLASSVIDEO = 186;

  private static final int LAYOUT_ITEMMESSAGEIMAGE = 187;

  private static final int LAYOUT_ITEMMESSAGETEXT = 188;

  private static final int LAYOUT_ITEMMESSAGEVIDEO = 189;

  private static final int LAYOUT_ITEMMESSAGES = 190;

  private static final int LAYOUT_ITEMMYLIST = 191;

  private static final int LAYOUT_ITEMOFFER = 192;

  private static final int LAYOUT_ITEMONLINECOURSEINSTRUCTOR = 193;

  private static final int LAYOUT_ITEMONLINECOURSEREVIEW = 194;

  private static final int LAYOUT_ITEMONLINECOURSESYLLABUS = 195;

  private static final int LAYOUT_ITEMONLINECOURSES = 196;

  private static final int LAYOUT_ITEMOURCATEGORIES = 197;

  private static final int LAYOUT_ITEMPORTFOLIOIMAGE = 198;

  private static final int LAYOUT_ITEMRECRUITERINFO = 199;

  private static final int LAYOUT_ITEMRECRUITERJOBOFFERS = 200;

  private static final int LAYOUT_ITEMREQUIREMENTCHECK = 201;

  private static final int LAYOUT_ITEMSEEKEREDUCATION = 202;

  private static final int LAYOUT_ITEMSEEKEREXPERIENCE = 203;

  private static final int LAYOUT_ITEMSEEKERHARDSKILL = 204;

  private static final int LAYOUT_ITEMSEEKERJOBCARD = 205;

  private static final int LAYOUT_ITEMSEEKERPREVIEWEXPERIENCE = 206;

  private static final int LAYOUT_ITEMSEEKERPREVIEWHARDSKILL = 207;

  private static final int LAYOUT_ITEMSEEKERPREVIEWSCHOOL = 208;

  private static final int LAYOUT_ITEMSEEKERPREVIEWVOLUNTEERING = 209;

  private static final int LAYOUT_ITEMSEEKERSEARCHUNIVERSITY = 210;

  private static final int LAYOUT_ITEMSEEKERTRACK = 211;

  private static final int LAYOUT_ITEMSEEKERTRACKINGJOBDETAILCARD = 212;

  private static final int LAYOUT_ITEMSEEKERVOLUNTEERING = 213;

  private static final int LAYOUT_ITEMSUBSCRIPTIONDETAILS = 214;

  private static final int LAYOUT_ITEMTRAININGCOURSES = 215;

  private static final int LAYOUT_ITEMUPCOMINGEVENTS = 216;

  private static final int LAYOUT_ITEMVIDEOTHUMBNAIL = 217;

  private static final int LAYOUT_ITEMWISHLISTJOB = 218;

  private static final int LAYOUT_LISTITEMNEWPEOPLE = 219;

  private static final int LAYOUT_LISTITEMPARTICIPANTS = 220;

  private static final int LAYOUT_PROFILE6 = 221;

  private static final int LAYOUT_PROFILE7 = 222;

  private static final int LAYOUT_RECRUITERHOME = 223;

  private static final int LAYOUT_TABITEMSUBSCRIPTION = 224;

  private static final int LAYOUT_TRACKTESTUI = 225;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(225);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_chat, LAYOUT_ACTIVITYCHAT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_company_intro_info, LAYOUT_ACTIVITYCOMPANYINTROINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_dashboard, LAYOUT_ACTIVITYDASHBOARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_home, LAYOUT_ACTIVITYHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_job_seeker_account, LAYOUT_ACTIVITYJOBSEEKERACCOUNT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_job_seeker_apply, LAYOUT_ACTIVITYJOBSEEKERAPPLY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_job_seeker_course, LAYOUT_ACTIVITYJOBSEEKERCOURSE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_job_seeker_home, LAYOUT_ACTIVITYJOBSEEKERHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_job_seeker_password, LAYOUT_ACTIVITYJOBSEEKERPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_job_seeker_personal_intro_info, LAYOUT_ACTIVITYJOBSEEKERPERSONALINTROINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_license, LAYOUT_ACTIVITYLICENSE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_main_chat, LAYOUT_ACTIVITYMAINCHAT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_manage_location, LAYOUT_ACTIVITYMANAGELOCATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_manage_room, LAYOUT_ACTIVITYMANAGEROOM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_maps, LAYOUT_ACTIVITYMAPS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_master_class, LAYOUT_ACTIVITYMASTERCLASS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_master_class_details, LAYOUT_ACTIVITYMASTERCLASSDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_master_class_guest_details, LAYOUT_ACTIVITYMASTERCLASSGUESTDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_online_course, LAYOUT_ACTIVITYONLINECOURSE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_online_course_details, LAYOUT_ACTIVITYONLINECOURSEDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_payment, LAYOUT_ACTIVITYPAYMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_preview_image, LAYOUT_ACTIVITYPREVIEWIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_privacy_preference, LAYOUT_ACTIVITYPRIVACYPREFERENCE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_profile, LAYOUT_ACTIVITYPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_recruiter_home, LAYOUT_ACTIVITYRECRUITERHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_recruiter_personal_info_intro, LAYOUT_ACTIVITYRECRUITERPERSONALINFOINTRO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_recruiter_subscription, LAYOUT_ACTIVITYRECRUITERSUBSCRIPTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_seeker_calender, LAYOUT_ACTIVITYSEEKERCALENDER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_seeker_job_search, LAYOUT_ACTIVITYSEEKERJOBSEARCH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_seeker_job_tracking, LAYOUT_ACTIVITYSEEKERJOBTRACKING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_seeker_profile, LAYOUT_ACTIVITYSEEKERPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_seeker_wish_list, LAYOUT_ACTIVITYSEEKERWISHLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_select_location, LAYOUT_ACTIVITYSELECTLOCATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_splash, LAYOUT_ACTIVITYSPLASH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_video_chat_view, LAYOUT_ACTIVITYVIDEOCHATVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_video_play, LAYOUT_ACTIVITYVIDEOPLAY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.activity_web_view, LAYOUT_ACTIVITYWEBVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.calendar_cell, LAYOUT_CALENDARCELL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.dialog_add_linkedin, LAYOUT_DIALOGADDLINKEDIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.dialog_add_tracking_job_phase, LAYOUT_DIALOGADDTRACKINGJOBPHASE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.dialog_confirm, LAYOUT_DIALOGCONFIRM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.dialog_confirmation, LAYOUT_DIALOGCONFIRMATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.dialog_leave_room, LAYOUT_DIALOGLEAVEROOM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.dialog_message_pop_up, LAYOUT_DIALOGMESSAGEPOPUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.dialog_reach, LAYOUT_DIALOGREACH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.dialog_requirements, LAYOUT_DIALOGREQUIREMENTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.dialog_requirements_old, LAYOUT_DIALOGREQUIREMENTSOLD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_about, LAYOUT_FRAGMENTABOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_archived_chats, LAYOUT_FRAGMENTARCHIVEDCHATS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_chat_message_board, LAYOUT_FRAGMENTCHATMESSAGEBOARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_chat_user_list, LAYOUT_FRAGMENTCHATUSERLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_chats, LAYOUT_FRAGMENTCHATS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_company_information, LAYOUT_FRAGMENTCOMPANYINFORMATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_confirm1_seeker, LAYOUT_FRAGMENTCONFIRM1SEEKER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_confirm2_seeker, LAYOUT_FRAGMENTCONFIRM2SEEKER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_confirm3_seeker, LAYOUT_FRAGMENTCONFIRM3SEEKER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_confirm_recruiter, LAYOUT_FRAGMENTCONFIRMRECRUITER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_courses, LAYOUT_FRAGMENTCOURSES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_create_education, LAYOUT_FRAGMENTCREATEEDUCATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_create_experience, LAYOUT_FRAGMENTCREATEEXPERIENCE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_display_chat_item_dialog, LAYOUT_FRAGMENTDISPLAYCHATITEMDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_event_calendar, LAYOUT_FRAGMENTEVENTCALENDAR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_ideal_job_audio, LAYOUT_FRAGMENTIDEALJOBAUDIO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_ideal_job_description, LAYOUT_FRAGMENTIDEALJOBDESCRIPTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_ideal_job_images, LAYOUT_FRAGMENTIDEALJOBIMAGES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_ideal_job_video, LAYOUT_FRAGMENTIDEALJOBVIDEO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_instructors, LAYOUT_FRAGMENTINSTRUCTORS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_job_listing, LAYOUT_FRAGMENTJOBLISTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_job_offer_card_info, LAYOUT_FRAGMENTJOBOFFERCARDINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_job_offer_details, LAYOUT_FRAGMENTJOBOFFERDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_job_search, LAYOUT_FRAGMENTJOBSEARCH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_job_seeker_account, LAYOUT_FRAGMENTJOBSEEKERACCOUNT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_job_seeker_apply, LAYOUT_FRAGMENTJOBSEEKERAPPLY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_job_seeker_manage_read_receipts, LAYOUT_FRAGMENTJOBSEEKERMANAGEREADRECEIPTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_job_seeker_media, LAYOUT_FRAGMENTJOBSEEKERMEDIA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_job_seeker_newsletter, LAYOUT_FRAGMENTJOBSEEKERNEWSLETTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_job_seeker_payment_methods, LAYOUT_FRAGMENTJOBSEEKERPAYMENTMETHODS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_job_seeker_personal_information, LAYOUT_FRAGMENTJOBSEEKERPERSONALINFORMATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_job_seeker_profile, LAYOUT_FRAGMENTJOBSEEKERPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_job_seeker_push_notification, LAYOUT_FRAGMENTJOBSEEKERPUSHNOTIFICATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_job_seeker_resume, LAYOUT_FRAGMENTJOBSEEKERRESUME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_job_seeker_social_links, LAYOUT_FRAGMENTJOBSEEKERSOCIALLINKS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_job_seeker_track, LAYOUT_FRAGMENTJOBSEEKERTRACK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_job_source, LAYOUT_FRAGMENTJOBSOURCE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_jobamax_club, LAYOUT_FRAGMENTJOBAMAXCLUB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_keep_me_posted, LAYOUT_FRAGMENTKEEPMEPOSTED);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_keynotes, LAYOUT_FRAGMENTKEYNOTES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_like_dislike_dialog, LAYOUT_FRAGMENTLIKEDISLIKEDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_live_room, LAYOUT_FRAGMENTLIVEROOM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_live_room_interests, LAYOUT_FRAGMENTLIVEROOMINTERESTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_live_room_participants, LAYOUT_FRAGMENTLIVEROOMPARTICIPANTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_live_room_welcome, LAYOUT_FRAGMENTLIVEROOMWELCOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_location_permission, LAYOUT_FRAGMENTLOCATIONPERMISSION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_login, LAYOUT_FRAGMENTLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_manage_room, LAYOUT_FRAGMENTMANAGEROOM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_master_class, LAYOUT_FRAGMENTMASTERCLASS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_masterclass_details, LAYOUT_FRAGMENTMASTERCLASSDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_meet_nearby_people, LAYOUT_FRAGMENTMEETNEARBYPEOPLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_messages, LAYOUT_FRAGMENTMESSAGES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_networking_chats, LAYOUT_FRAGMENTNETWORKINGCHATS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_new_login_select_role, LAYOUT_FRAGMENTNEWLOGINSELECTROLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_no_reaction, LAYOUT_FRAGMENTNOREACTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_no_reaction_drop_email, LAYOUT_FRAGMENTNOREACTIONDROPEMAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_online_courses_list, LAYOUT_FRAGMENTONLINECOURSESLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_portfolio_description, LAYOUT_FRAGMENTPORTFOLIODESCRIPTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_portfolio_image, LAYOUT_FRAGMENTPORTFOLIOIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_portfolio_video, LAYOUT_FRAGMENTPORTFOLIOVIDEO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_profile, LAYOUT_FRAGMENTPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_profile_recruiter, LAYOUT_FRAGMENTPROFILERECRUITER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_recruiter_account, LAYOUT_FRAGMENTRECRUITERACCOUNT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_recruiter_chats, LAYOUT_FRAGMENTRECRUITERCHATS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_recruiter_course, LAYOUT_FRAGMENTRECRUITERCOURSE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_recruiter_current_subscription, LAYOUT_FRAGMENTRECRUITERCURRENTSUBSCRIPTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_recruiter_delete_account, LAYOUT_FRAGMENTRECRUITERDELETEACCOUNT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_recruiter_delete_account_final, LAYOUT_FRAGMENTRECRUITERDELETEACCOUNTFINAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_recruiter_invoices, LAYOUT_FRAGMENTRECRUITERINVOICES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_recruiter_manage_read_receipts, LAYOUT_FRAGMENTRECRUITERMANAGEREADRECEIPTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_recruiter_media, LAYOUT_FRAGMENTRECRUITERMEDIA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_recruiter_messages, LAYOUT_FRAGMENTRECRUITERMESSAGES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_recruiter_newsletter, LAYOUT_FRAGMENTRECRUITERNEWSLETTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_recruiter_payment_methods, LAYOUT_FRAGMENTRECRUITERPAYMENTMETHODS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_recruiter_personal_information, LAYOUT_FRAGMENTRECRUITERPERSONALINFORMATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_recruiter_push_notification, LAYOUT_FRAGMENTRECRUITERPUSHNOTIFICATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_recruiter_recruit, LAYOUT_FRAGMENTRECRUITERRECRUIT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_recruiter_social_links, LAYOUT_FRAGMENTRECRUITERSOCIALLINKS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_recruiter_source, LAYOUT_FRAGMENTRECRUITERSOURCE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_register, LAYOUT_FRAGMENTREGISTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_reviews, LAYOUT_FRAGMENTREVIEWS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_search, LAYOUT_FRAGMENTSEARCH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_about_me, LAYOUT_FRAGMENTSEEKERABOUTME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_add_experience, LAYOUT_FRAGMENTSEEKERADDEXPERIENCE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_add_volunteering, LAYOUT_FRAGMENTSEEKERADDVOLUNTEERING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_calender, LAYOUT_FRAGMENTSEEKERCALENDER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_change_password, LAYOUT_FRAGMENTSEEKERCHANGEPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_delete_account, LAYOUT_FRAGMENTSEEKERDELETEACCOUNT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_delete_account_final, LAYOUT_FRAGMENTSEEKERDELETEACCOUNTFINAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_education, LAYOUT_FRAGMENTSEEKEREDUCATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_experience_list, LAYOUT_FRAGMENTSEEKEREXPERIENCELIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_filter_job, LAYOUT_FRAGMENTSEEKERFILTERJOB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_import_resume, LAYOUT_FRAGMENTSEEKERIMPORTRESUME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_interest, LAYOUT_FRAGMENTSEEKERINTEREST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_jobs, LAYOUT_FRAGMENTSEEKERJOBS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_jobs_filter, LAYOUT_FRAGMENTSEEKERJOBSFILTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_my_skill, LAYOUT_FRAGMENTSEEKERMYSKILL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_new_education, LAYOUT_FRAGMENTSEEKERNEWEDUCATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_preview, LAYOUT_FRAGMENTSEEKERPREVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_profile, LAYOUT_FRAGMENTSEEKERPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_search_university_dialog, LAYOUT_FRAGMENTSEEKERSEARCHUNIVERSITYDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_social_media_ids, LAYOUT_FRAGMENTSEEKERSOCIALMEDIAIDS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_tracking_job, LAYOUT_FRAGMENTSEEKERTRACKINGJOB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_tracking_job_details, LAYOUT_FRAGMENTSEEKERTRACKINGJOBDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_tracking_job_filter_dialog, LAYOUT_FRAGMENTSEEKERTRACKINGJOBFILTERDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_volunteering_list, LAYOUT_FRAGMENTSEEKERVOLUNTEERINGLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_seeker_wish_list, LAYOUT_FRAGMENTSEEKERWISHLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_select_role, LAYOUT_FRAGMENTSELECTROLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_splash, LAYOUT_FRAGMENTSPLASH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_syllabus, LAYOUT_FRAGMENTSYLLABUS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_value_privacy, LAYOUT_FRAGMENTVALUEPRIVACY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_verification_code, LAYOUT_FRAGMENTVERIFICATIONCODE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_view_job_offer, LAYOUT_FRAGMENTVIEWJOBOFFER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.fragment_welcome_as_seeker, LAYOUT_FRAGMENTWELCOMEASSEEKER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_archived_messages, LAYOUT_ITEMARCHIVEDMESSAGES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_calender_event_card, LAYOUT_ITEMCALENDEREVENTCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_chat, LAYOUT_ITEMCHAT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_chat_receiver, LAYOUT_ITEMCHATRECEIVER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_chat_sender, LAYOUT_ITEMCHATSENDER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_chat_user_horizontal, LAYOUT_ITEMCHATUSERHORIZONTAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_chat_user_vertical, LAYOUT_ITEMCHATUSERVERTICAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_company_profile, LAYOUT_ITEMCOMPANYPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_company_size, LAYOUT_ITEMCOMPANYSIZE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_current_online, LAYOUT_ITEMCURRENTONLINE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_event, LAYOUT_ITEMEVENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_image, LAYOUT_ITEMIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_info, LAYOUT_ITEMINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_job_offer, LAYOUT_ITEMJOBOFFER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_job_offer_card, LAYOUT_ITEMJOBOFFERCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_job_seeker_recruit_card, LAYOUT_ITEMJOBSEEKERRECRUITCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_job_seeker_source_card, LAYOUT_ITEMJOBSEEKERSOURCECARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_job_seeker_track_offer, LAYOUT_ITEMJOBSEEKERTRACKOFFER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_leaving_reason, LAYOUT_ITEMLEAVINGREASON);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_location, LAYOUT_ITEMLOCATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_master_class, LAYOUT_ITEMMASTERCLASS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_master_class_session_guest, LAYOUT_ITEMMASTERCLASSSESSIONGUEST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_masterclass_video, LAYOUT_ITEMMASTERCLASSVIDEO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_message_image, LAYOUT_ITEMMESSAGEIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_message_text, LAYOUT_ITEMMESSAGETEXT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_message_video, LAYOUT_ITEMMESSAGEVIDEO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_messages, LAYOUT_ITEMMESSAGES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_my_list, LAYOUT_ITEMMYLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_offer, LAYOUT_ITEMOFFER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_online_course_instructor, LAYOUT_ITEMONLINECOURSEINSTRUCTOR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_online_course_review, LAYOUT_ITEMONLINECOURSEREVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_online_course_syllabus, LAYOUT_ITEMONLINECOURSESYLLABUS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_online_courses, LAYOUT_ITEMONLINECOURSES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_our_categories, LAYOUT_ITEMOURCATEGORIES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_portfolio_image, LAYOUT_ITEMPORTFOLIOIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_recruiter_info, LAYOUT_ITEMRECRUITERINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_recruiter_job_offers, LAYOUT_ITEMRECRUITERJOBOFFERS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_requirement_check, LAYOUT_ITEMREQUIREMENTCHECK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_seeker_education, LAYOUT_ITEMSEEKEREDUCATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_seeker_experience, LAYOUT_ITEMSEEKEREXPERIENCE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_seeker_hard_skill, LAYOUT_ITEMSEEKERHARDSKILL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_seeker_job_card, LAYOUT_ITEMSEEKERJOBCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_seeker_preview_experience, LAYOUT_ITEMSEEKERPREVIEWEXPERIENCE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_seeker_preview_hard_skill, LAYOUT_ITEMSEEKERPREVIEWHARDSKILL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_seeker_preview_school, LAYOUT_ITEMSEEKERPREVIEWSCHOOL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_seeker_preview_volunteering, LAYOUT_ITEMSEEKERPREVIEWVOLUNTEERING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_seeker_search_university, LAYOUT_ITEMSEEKERSEARCHUNIVERSITY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_seeker_track, LAYOUT_ITEMSEEKERTRACK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_seeker_tracking_job_detail_card, LAYOUT_ITEMSEEKERTRACKINGJOBDETAILCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_seeker_volunteering, LAYOUT_ITEMSEEKERVOLUNTEERING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_subscription_details, LAYOUT_ITEMSUBSCRIPTIONDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_training_courses, LAYOUT_ITEMTRAININGCOURSES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_upcoming_events, LAYOUT_ITEMUPCOMINGEVENTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_video_thumbnail, LAYOUT_ITEMVIDEOTHUMBNAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.item_wishlist_job, LAYOUT_ITEMWISHLISTJOB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.list_item_new_people, LAYOUT_LISTITEMNEWPEOPLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.list_item_participants, LAYOUT_LISTITEMPARTICIPANTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.profile6, LAYOUT_PROFILE6);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.profile7, LAYOUT_PROFILE7);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.recruiter_home, LAYOUT_RECRUITERHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.tab_item_subscription, LAYOUT_TABITEMSUBSCRIPTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.findajob.jobamax.R.layout.tracktestui, LAYOUT_TRACKTESTUI);
  }

  private final ViewDataBinding internalGetViewDataBinding0(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_ACTIVITYCHAT: {
        if ("layout/activity_chat_0".equals(tag)) {
          return new ActivityChatBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_chat is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCOMPANYINTROINFO: {
        if ("layout/activity_company_intro_info_0".equals(tag)) {
          return new ActivityCompanyIntroInfoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_company_intro_info is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYDASHBOARD: {
        if ("layout/activity_dashboard_0".equals(tag)) {
          return new ActivityDashboardBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_dashboard is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYHOME: {
        if ("layout/activity_home_0".equals(tag)) {
          return new ActivityHomeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_home is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYJOBSEEKERACCOUNT: {
        if ("layout/activity_job_seeker_account_0".equals(tag)) {
          return new ActivityJobSeekerAccountBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_job_seeker_account is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYJOBSEEKERAPPLY: {
        if ("layout/activity_job_seeker_apply_0".equals(tag)) {
          return new ActivityJobSeekerApplyBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_job_seeker_apply is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYJOBSEEKERCOURSE: {
        if ("layout/activity_job_seeker_course_0".equals(tag)) {
          return new ActivityJobSeekerCourseBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_job_seeker_course is invalid. Received: " + tag);
      }
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
      case  LAYOUT_ACTIVITYMAINCHAT: {
        if ("layout/activity_main_chat_0".equals(tag)) {
          return new ActivityMainChatBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_main_chat is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMANAGELOCATION: {
        if ("layout/activity_manage_location_0".equals(tag)) {
          return new ActivityManageLocationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_manage_location is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMANAGEROOM: {
        if ("layout/activity_manage_room_0".equals(tag)) {
          return new ActivityManageRoomBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_manage_room is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMAPS: {
        if ("layout/activity_maps_0".equals(tag)) {
          return new ActivityMapsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_maps is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMASTERCLASS: {
        if ("layout/activity_master_class_0".equals(tag)) {
          return new ActivityMasterClassBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_master_class is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMASTERCLASSDETAILS: {
        if ("layout/activity_master_class_details_0".equals(tag)) {
          return new ActivityMasterClassDetailsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_master_class_details is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMASTERCLASSGUESTDETAILS: {
        if ("layout/activity_master_class_guest_details_0".equals(tag)) {
          return new ActivityMasterClassGuestDetailsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_master_class_guest_details is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYONLINECOURSE: {
        if ("layout/activity_online_course_0".equals(tag)) {
          return new ActivityOnlineCourseBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_online_course is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYONLINECOURSEDETAILS: {
        if ("layout/activity_online_course_details_0".equals(tag)) {
          return new ActivityOnlineCourseDetailsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_online_course_details is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPAYMENT: {
        if ("layout/activity_payment_0".equals(tag)) {
          return new ActivityPaymentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_payment is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPREVIEWIMAGE: {
        if ("layout/activity_preview_image_0".equals(tag)) {
          return new ActivityPreviewImageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_preview_image is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPRIVACYPREFERENCE: {
        if ("layout/activity_privacy_preference_0".equals(tag)) {
          return new ActivityPrivacyPreferenceBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_privacy_preference is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPROFILE: {
        if ("layout/activity_profile_0".equals(tag)) {
          return new ActivityProfileBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_profile is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYRECRUITERHOME: {
        if ("layout/activity_recruiter_home_0".equals(tag)) {
          return new ActivityRecruiterHomeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_recruiter_home is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYRECRUITERPERSONALINFOINTRO: {
        if ("layout/activity_recruiter_personal_info_intro_0".equals(tag)) {
          return new ActivityRecruiterPersonalInfoIntroBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_recruiter_personal_info_intro is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYRECRUITERSUBSCRIPTION: {
        if ("layout/activity_recruiter_subscription_0".equals(tag)) {
          return new ActivityRecruiterSubscriptionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_recruiter_subscription is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSEEKERCALENDER: {
        if ("layout/activity_seeker_calender_0".equals(tag)) {
          return new ActivitySeekerCalenderBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_seeker_calender is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSEEKERJOBSEARCH: {
        if ("layout/activity_seeker_job_search_0".equals(tag)) {
          return new ActivitySeekerJobSearchBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_seeker_job_search is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSEEKERJOBTRACKING: {
        if ("layout/activity_seeker_job_tracking_0".equals(tag)) {
          return new ActivitySeekerJobTrackingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_seeker_job_tracking is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSEEKERPROFILE: {
        if ("layout/activity_seeker_profile_0".equals(tag)) {
          return new ActivitySeekerProfileBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_seeker_profile is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSEEKERWISHLIST: {
        if ("layout/activity_seeker_wish_list_0".equals(tag)) {
          return new ActivitySeekerWishListBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_seeker_wish_list is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSELECTLOCATION: {
        if ("layout/activity_select_location_0".equals(tag)) {
          return new ActivitySelectLocationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_select_location is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSPLASH: {
        if ("layout/activity_splash_0".equals(tag)) {
          return new ActivitySplashBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_splash is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYVIDEOCHATVIEW: {
        if ("layout/activity_video_chat_view_0".equals(tag)) {
          return new ActivityVideoChatViewBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_video_chat_view is invalid. Received: " + tag);
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
      case  LAYOUT_DIALOGADDLINKEDIN: {
        if ("layout/dialog_add_linkedin_0".equals(tag)) {
          return new DialogAddLinkedinBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_add_linkedin is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGADDTRACKINGJOBPHASE: {
        if ("layout/dialog_add_tracking_job_phase_0".equals(tag)) {
          return new DialogAddTrackingJobPhaseBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_add_tracking_job_phase is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGCONFIRM: {
        if ("layout/dialog_confirm_0".equals(tag)) {
          return new DialogConfirmBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_confirm is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGCONFIRMATION: {
        if ("layout/dialog_confirmation_0".equals(tag)) {
          return new DialogConfirmationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_confirmation is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGLEAVEROOM: {
        if ("layout/dialog_leave_room_0".equals(tag)) {
          return new DialogLeaveRoomBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_leave_room is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGMESSAGEPOPUP: {
        if ("layout/dialog_message_pop_up_0".equals(tag)) {
          return new DialogMessagePopUpBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_message_pop_up is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGREACH: {
        if ("layout/dialog_reach_0".equals(tag)) {
          return new DialogReachBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_reach is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGREQUIREMENTS: {
        if ("layout/dialog_requirements_0".equals(tag)) {
          return new DialogRequirementsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_requirements is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGREQUIREMENTSOLD: {
        if ("layout/dialog_requirements_old_0".equals(tag)) {
          return new DialogRequirementsOldBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_requirements_old is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTABOUT: {
        if ("layout/fragment_about_0".equals(tag)) {
          return new FragmentAboutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_about is invalid. Received: " + tag);
      }
    }
    return null;
  }

  private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_FRAGMENTARCHIVEDCHATS: {
        if ("layout/fragment_archived_chats_0".equals(tag)) {
          return new FragmentArchivedChatsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_archived_chats is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCHATMESSAGEBOARD: {
        if ("layout/fragment_chat_message_board_0".equals(tag)) {
          return new FragmentChatMessageBoardBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_chat_message_board is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCHATUSERLIST: {
        if ("layout/fragment_chat_user_list_0".equals(tag)) {
          return new FragmentChatUserListBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_chat_user_list is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCHATS: {
        if ("layout/fragment_chats_0".equals(tag)) {
          return new FragmentChatsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_chats is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCOMPANYINFORMATION: {
        if ("layout/fragment_company_information_0".equals(tag)) {
          return new FragmentCompanyInformationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_company_information is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCONFIRM1SEEKER: {
        if ("layout/fragment_confirm1_seeker_0".equals(tag)) {
          return new FragmentConfirm1SeekerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_confirm1_seeker is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCONFIRM2SEEKER: {
        if ("layout/fragment_confirm2_seeker_0".equals(tag)) {
          return new FragmentConfirm2SeekerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_confirm2_seeker is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCONFIRM3SEEKER: {
        if ("layout/fragment_confirm3_seeker_0".equals(tag)) {
          return new FragmentConfirm3SeekerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_confirm3_seeker is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCONFIRMRECRUITER: {
        if ("layout/fragment_confirm_recruiter_0".equals(tag)) {
          return new FragmentConfirmRecruiterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_confirm_recruiter is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCOURSES: {
        if ("layout/fragment_courses_0".equals(tag)) {
          return new FragmentCoursesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_courses is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCREATEEDUCATION: {
        if ("layout/fragment_create_education_0".equals(tag)) {
          return new FragmentCreateEducationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_create_education is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCREATEEXPERIENCE: {
        if ("layout/fragment_create_experience_0".equals(tag)) {
          return new FragmentCreateExperienceBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_create_experience is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTDISPLAYCHATITEMDIALOG: {
        if ("layout/fragment_display_chat_item_dialog_0".equals(tag)) {
          return new FragmentDisplayChatItemDialogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_display_chat_item_dialog is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTEVENTCALENDAR: {
        if ("layout/fragment_event_calendar_0".equals(tag)) {
          return new FragmentEventCalendarBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_event_calendar is invalid. Received: " + tag);
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
      case  LAYOUT_FRAGMENTINSTRUCTORS: {
        if ("layout/fragment_instructors_0".equals(tag)) {
          return new FragmentInstructorsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_instructors is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTJOBLISTING: {
        if ("layout/fragment_job_listing_0".equals(tag)) {
          return new FragmentJobListingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_job_listing is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTJOBOFFERCARDINFO: {
        if ("layout/fragment_job_offer_card_info_0".equals(tag)) {
          return new FragmentJobOfferCardInfoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_job_offer_card_info is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTJOBOFFERDETAILS: {
        if ("layout/fragment_job_offer_details_0".equals(tag)) {
          return new FragmentJobOfferDetailsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_job_offer_details is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTJOBSEARCH: {
        if ("layout/fragment_job_search_0".equals(tag)) {
          return new FragmentJobSearchBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_job_search is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTJOBSEEKERACCOUNT: {
        if ("layout/fragment_job_seeker_account_0".equals(tag)) {
          return new FragmentJobSeekerAccountBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_job_seeker_account is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTJOBSEEKERAPPLY: {
        if ("layout/fragment_job_seeker_apply_0".equals(tag)) {
          return new FragmentJobSeekerApplyBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_job_seeker_apply is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTJOBSEEKERMANAGEREADRECEIPTS: {
        if ("layout/fragment_job_seeker_manage_read_receipts_0".equals(tag)) {
          return new FragmentJobSeekerManageReadReceiptsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_job_seeker_manage_read_receipts is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTJOBSEEKERMEDIA: {
        if ("layout/fragment_job_seeker_media_0".equals(tag)) {
          return new FragmentJobSeekerMediaBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_job_seeker_media is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTJOBSEEKERNEWSLETTER: {
        if ("layout/fragment_job_seeker_newsletter_0".equals(tag)) {
          return new FragmentJobSeekerNewsletterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_job_seeker_newsletter is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTJOBSEEKERPAYMENTMETHODS: {
        if ("layout/fragment_job_seeker_payment_methods_0".equals(tag)) {
          return new FragmentJobSeekerPaymentMethodsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_job_seeker_payment_methods is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTJOBSEEKERPERSONALINFORMATION: {
        if ("layout/fragment_job_seeker_personal_information_0".equals(tag)) {
          return new FragmentJobSeekerPersonalInformationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_job_seeker_personal_information is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTJOBSEEKERPROFILE: {
        if ("layout/fragment_job_seeker_profile_0".equals(tag)) {
          return new FragmentJobSeekerProfileBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_job_seeker_profile is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTJOBSEEKERPUSHNOTIFICATION: {
        if ("layout/fragment_job_seeker_push_notification_0".equals(tag)) {
          return new FragmentJobSeekerPushNotificationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_job_seeker_push_notification is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTJOBSEEKERRESUME: {
        if ("layout/fragment_job_seeker_resume_0".equals(tag)) {
          return new FragmentJobSeekerResumeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_job_seeker_resume is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTJOBSEEKERSOCIALLINKS: {
        if ("layout/fragment_job_seeker_social_links_0".equals(tag)) {
          return new FragmentJobSeekerSocialLinksBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_job_seeker_social_links is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTJOBSEEKERTRACK: {
        if ("layout/fragment_job_seeker_track_0".equals(tag)) {
          return new FragmentJobSeekerTrackBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_job_seeker_track is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTJOBSOURCE: {
        if ("layout/fragment_job_source_0".equals(tag)) {
          return new FragmentJobSourceBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_job_source is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTJOBAMAXCLUB: {
        if ("layout/fragment_jobamax_club_0".equals(tag)) {
          return new FragmentJobamaxClubBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_jobamax_club is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTKEEPMEPOSTED: {
        if ("layout/fragment_keep_me_posted_0".equals(tag)) {
          return new FragmentKeepMePostedBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_keep_me_posted is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTKEYNOTES: {
        if ("layout/fragment_keynotes_0".equals(tag)) {
          return new FragmentKeynotesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_keynotes is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTLIKEDISLIKEDIALOG: {
        if ("layout/fragment_like_dislike_dialog_0".equals(tag)) {
          return new FragmentLikeDislikeDialogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_like_dislike_dialog is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTLIVEROOM: {
        if ("layout/fragment_live_room_0".equals(tag)) {
          return new FragmentLiveRoomBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_live_room is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTLIVEROOMINTERESTS: {
        if ("layout/fragment_live_room_interests_0".equals(tag)) {
          return new FragmentLiveRoomInterestsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_live_room_interests is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTLIVEROOMPARTICIPANTS: {
        if ("layout/fragment_live_room_participants_0".equals(tag)) {
          return new FragmentLiveRoomParticipantsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_live_room_participants is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTLIVEROOMWELCOME: {
        if ("layout/fragment_live_room_welcome_0".equals(tag)) {
          return new FragmentLiveRoomWelcomeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_live_room_welcome is invalid. Received: " + tag);
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
      case  LAYOUT_FRAGMENTMANAGEROOM: {
        if ("layout/fragment_manage_room_0".equals(tag)) {
          return new FragmentManageRoomBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_manage_room is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTMASTERCLASS: {
        if ("layout/fragment_master_class_0".equals(tag)) {
          return new FragmentMasterClassBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_master_class is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTMASTERCLASSDETAILS: {
        if ("layout/fragment_masterclass_details_0".equals(tag)) {
          return new FragmentMasterclassDetailsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_masterclass_details is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTMEETNEARBYPEOPLE: {
        if ("layout/fragment_meet_nearby_people_0".equals(tag)) {
          return new FragmentMeetNearbyPeopleBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_meet_nearby_people is invalid. Received: " + tag);
      }
    }
    return null;
  }

  private final ViewDataBinding internalGetViewDataBinding2(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_FRAGMENTMESSAGES: {
        if ("layout/fragment_messages_0".equals(tag)) {
          return new FragmentMessagesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_messages is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTNETWORKINGCHATS: {
        if ("layout/fragment_networking_chats_0".equals(tag)) {
          return new FragmentNetworkingChatsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_networking_chats is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTNEWLOGINSELECTROLE: {
        if ("layout/fragment_new_login_select_role_0".equals(tag)) {
          return new FragmentNewLoginSelectRoleBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_new_login_select_role is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTNOREACTION: {
        if ("layout/fragment_no_reaction_0".equals(tag)) {
          return new FragmentNoReactionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_no_reaction is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTNOREACTIONDROPEMAIL: {
        if ("layout/fragment_no_reaction_drop_email_0".equals(tag)) {
          return new FragmentNoReactionDropEmailBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_no_reaction_drop_email is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTONLINECOURSESLIST: {
        if ("layout/fragment_online_courses_list_0".equals(tag)) {
          return new FragmentOnlineCoursesListBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_online_courses_list is invalid. Received: " + tag);
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
      case  LAYOUT_FRAGMENTPROFILE: {
        if ("layout/fragment_profile_0".equals(tag)) {
          return new FragmentProfileBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_profile is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTPROFILERECRUITER: {
        if ("layout/fragment_profile_recruiter_0".equals(tag)) {
          return new FragmentProfileRecruiterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_profile_recruiter is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERACCOUNT: {
        if ("layout/fragment_recruiter_account_0".equals(tag)) {
          return new FragmentRecruiterAccountBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_account is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERCHATS: {
        if ("layout/fragment_recruiter_chats_0".equals(tag)) {
          return new FragmentRecruiterChatsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_chats is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERCOURSE: {
        if ("layout/fragment_recruiter_course_0".equals(tag)) {
          return new FragmentRecruiterCourseBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_course is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERCURRENTSUBSCRIPTION: {
        if ("layout/fragment_recruiter_current_subscription_0".equals(tag)) {
          return new FragmentRecruiterCurrentSubscriptionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_current_subscription is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERDELETEACCOUNT: {
        if ("layout/fragment_recruiter_delete_account_0".equals(tag)) {
          return new FragmentRecruiterDeleteAccountBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_delete_account is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERDELETEACCOUNTFINAL: {
        if ("layout/fragment_recruiter_delete_account_final_0".equals(tag)) {
          return new FragmentRecruiterDeleteAccountFinalBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_delete_account_final is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERINVOICES: {
        if ("layout/fragment_recruiter_invoices_0".equals(tag)) {
          return new FragmentRecruiterInvoicesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_invoices is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERMANAGEREADRECEIPTS: {
        if ("layout/fragment_recruiter_manage_read_receipts_0".equals(tag)) {
          return new FragmentRecruiterManageReadReceiptsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_manage_read_receipts is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERMEDIA: {
        if ("layout/fragment_recruiter_media_0".equals(tag)) {
          return new FragmentRecruiterMediaBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_media is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERMESSAGES: {
        if ("layout/fragment_recruiter_messages_0".equals(tag)) {
          return new FragmentRecruiterMessagesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_messages is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERNEWSLETTER: {
        if ("layout/fragment_recruiter_newsletter_0".equals(tag)) {
          return new FragmentRecruiterNewsletterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_newsletter is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERPAYMENTMETHODS: {
        if ("layout/fragment_recruiter_payment_methods_0".equals(tag)) {
          return new FragmentRecruiterPaymentMethodsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_payment_methods is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERPERSONALINFORMATION: {
        if ("layout/fragment_recruiter_personal_information_0".equals(tag)) {
          return new FragmentRecruiterPersonalInformationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_personal_information is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERPUSHNOTIFICATION: {
        if ("layout/fragment_recruiter_push_notification_0".equals(tag)) {
          return new FragmentRecruiterPushNotificationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_push_notification is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERRECRUIT: {
        if ("layout/fragment_recruiter_recruit_0".equals(tag)) {
          return new FragmentRecruiterRecruitBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_recruit is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERSOCIALLINKS: {
        if ("layout/fragment_recruiter_social_links_0".equals(tag)) {
          return new FragmentRecruiterSocialLinksBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_social_links is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECRUITERSOURCE: {
        if ("layout/fragment_recruiter_source_0".equals(tag)) {
          return new FragmentRecruiterSourceBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recruiter_source is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTREGISTER: {
        if ("layout/fragment_register_0".equals(tag)) {
          return new FragmentRegisterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_register is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTREVIEWS: {
        if ("layout/fragment_reviews_0".equals(tag)) {
          return new FragmentReviewsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_reviews is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEARCH: {
        if ("layout/fragment_search_0".equals(tag)) {
          return new FragmentSearchBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_search is invalid. Received: " + tag);
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
    }
    return null;
  }

  private final ViewDataBinding internalGetViewDataBinding3(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
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
      case  LAYOUT_FRAGMENTSELECTROLE: {
        if ("layout/fragment_select_role_0".equals(tag)) {
          return new FragmentSelectRoleBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_select_role is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSPLASH: {
        if ("layout/fragment_splash_0".equals(tag)) {
          return new FragmentSplashBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_splash is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSYLLABUS: {
        if ("layout/fragment_syllabus_0".equals(tag)) {
          return new FragmentSyllabusBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_syllabus is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTVALUEPRIVACY: {
        if ("layout/fragment_value_privacy_0".equals(tag)) {
          return new FragmentValuePrivacyBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_value_privacy is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTVERIFICATIONCODE: {
        if ("layout/fragment_verification_code_0".equals(tag)) {
          return new FragmentVerificationCodeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_verification_code is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTVIEWJOBOFFER: {
        if ("layout/fragment_view_job_offer_0".equals(tag)) {
          return new FragmentViewJobOfferBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_view_job_offer is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTWELCOMEASSEEKER: {
        if ("layout/fragment_welcome_as_seeker_0".equals(tag)) {
          return new FragmentWelcomeAsSeekerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_welcome_as_seeker is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMARCHIVEDMESSAGES: {
        if ("layout/item_archived_messages_0".equals(tag)) {
          return new ItemArchivedMessagesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_archived_messages is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCALENDEREVENTCARD: {
        if ("layout/item_calender_event_card_0".equals(tag)) {
          return new ItemCalenderEventCardBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_calender_event_card is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCHAT: {
        if ("layout/item_chat_0".equals(tag)) {
          return new ItemChatBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_chat is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCHATRECEIVER: {
        if ("layout/item_chat_receiver_0".equals(tag)) {
          return new ItemChatReceiverBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_chat_receiver is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCHATSENDER: {
        if ("layout/item_chat_sender_0".equals(tag)) {
          return new ItemChatSenderBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_chat_sender is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCHATUSERHORIZONTAL: {
        if ("layout/item_chat_user_horizontal_0".equals(tag)) {
          return new ItemChatUserHorizontalBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_chat_user_horizontal is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCHATUSERVERTICAL: {
        if ("layout/item_chat_user_vertical_0".equals(tag)) {
          return new ItemChatUserVerticalBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_chat_user_vertical is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCOMPANYPROFILE: {
        if ("layout/item_company_profile_0".equals(tag)) {
          return new ItemCompanyProfileBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_company_profile is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCOMPANYSIZE: {
        if ("layout/item_company_size_0".equals(tag)) {
          return new ItemCompanySizeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_company_size is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCURRENTONLINE: {
        if ("layout/item_current_online_0".equals(tag)) {
          return new ItemCurrentOnlineBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_current_online is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMEVENT: {
        if ("layout/item_event_0".equals(tag)) {
          return new ItemEventBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_event is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMIMAGE: {
        if ("layout/item_image_0".equals(tag)) {
          return new ItemImageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_image is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMINFO: {
        if ("layout/item_info_0".equals(tag)) {
          return new ItemInfoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_info is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMJOBOFFER: {
        if ("layout/item_job_offer_0".equals(tag)) {
          return new ItemJobOfferBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_job_offer is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMJOBOFFERCARD: {
        if ("layout/item_job_offer_card_0".equals(tag)) {
          return new ItemJobOfferCardBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_job_offer_card is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMJOBSEEKERRECRUITCARD: {
        if ("layout/item_job_seeker_recruit_card_0".equals(tag)) {
          return new ItemJobSeekerRecruitCardBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_job_seeker_recruit_card is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMJOBSEEKERSOURCECARD: {
        if ("layout/item_job_seeker_source_card_0".equals(tag)) {
          return new ItemJobSeekerSourceCardBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_job_seeker_source_card is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMJOBSEEKERTRACKOFFER: {
        if ("layout/item_job_seeker_track_offer_0".equals(tag)) {
          return new ItemJobSeekerTrackOfferBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_job_seeker_track_offer is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMLEAVINGREASON: {
        if ("layout/item_leaving_reason_0".equals(tag)) {
          return new ItemLeavingReasonBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_leaving_reason is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMLOCATION: {
        if ("layout/item_location_0".equals(tag)) {
          return new ItemLocationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_location is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMASTERCLASS: {
        if ("layout/item_master_class_0".equals(tag)) {
          return new ItemMasterClassBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_master_class is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMASTERCLASSSESSIONGUEST: {
        if ("layout/item_master_class_session_guest_0".equals(tag)) {
          return new ItemMasterClassSessionGuestBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_master_class_session_guest is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMASTERCLASSVIDEO: {
        if ("layout/item_masterclass_video_0".equals(tag)) {
          return new ItemMasterclassVideoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_masterclass_video is invalid. Received: " + tag);
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
      case  LAYOUT_ITEMMESSAGEVIDEO: {
        if ("layout/item_message_video_0".equals(tag)) {
          return new ItemMessageVideoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_message_video is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMESSAGES: {
        if ("layout/item_messages_0".equals(tag)) {
          return new ItemMessagesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_messages is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMYLIST: {
        if ("layout/item_my_list_0".equals(tag)) {
          return new ItemMyListBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_my_list is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMOFFER: {
        if ("layout/item_offer_0".equals(tag)) {
          return new ItemOfferBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_offer is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMONLINECOURSEINSTRUCTOR: {
        if ("layout/item_online_course_instructor_0".equals(tag)) {
          return new ItemOnlineCourseInstructorBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_online_course_instructor is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMONLINECOURSEREVIEW: {
        if ("layout/item_online_course_review_0".equals(tag)) {
          return new ItemOnlineCourseReviewBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_online_course_review is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMONLINECOURSESYLLABUS: {
        if ("layout/item_online_course_syllabus_0".equals(tag)) {
          return new ItemOnlineCourseSyllabusBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_online_course_syllabus is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMONLINECOURSES: {
        if ("layout/item_online_courses_0".equals(tag)) {
          return new ItemOnlineCoursesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_online_courses is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMOURCATEGORIES: {
        if ("layout/item_our_categories_0".equals(tag)) {
          return new ItemOurCategoriesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_our_categories is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMPORTFOLIOIMAGE: {
        if ("layout/item_portfolio_image_0".equals(tag)) {
          return new ItemPortfolioImageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_portfolio_image is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMRECRUITERINFO: {
        if ("layout/item_recruiter_info_0".equals(tag)) {
          return new ItemRecruiterInfoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_recruiter_info is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMRECRUITERJOBOFFERS: {
        if ("layout-v23/item_recruiter_job_offers_0".equals(tag)) {
          return new ItemRecruiterJobOffersBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_recruiter_job_offers is invalid. Received: " + tag);
      }
    }
    return null;
  }

  private final ViewDataBinding internalGetViewDataBinding4(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_ITEMREQUIREMENTCHECK: {
        if ("layout/item_requirement_check_0".equals(tag)) {
          return new ItemRequirementCheckBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_requirement_check is invalid. Received: " + tag);
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
      case  LAYOUT_ITEMSUBSCRIPTIONDETAILS: {
        if ("layout/item_subscription_details_0".equals(tag)) {
          return new ItemSubscriptionDetailsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_subscription_details is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMTRAININGCOURSES: {
        if ("layout/item_training_courses_0".equals(tag)) {
          return new ItemTrainingCoursesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_training_courses is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMUPCOMINGEVENTS: {
        if ("layout/item_upcoming_events_0".equals(tag)) {
          return new ItemUpcomingEventsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_upcoming_events is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMVIDEOTHUMBNAIL: {
        if ("layout/item_video_thumbnail_0".equals(tag)) {
          return new ItemVideoThumbnailBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_video_thumbnail is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMWISHLISTJOB: {
        if ("layout/item_wishlist_job_0".equals(tag)) {
          return new ItemWishlistJobBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_wishlist_job is invalid. Received: " + tag);
      }
      case  LAYOUT_LISTITEMNEWPEOPLE: {
        if ("layout/list_item_new_people_0".equals(tag)) {
          return new ListItemNewPeopleBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for list_item_new_people is invalid. Received: " + tag);
      }
      case  LAYOUT_LISTITEMPARTICIPANTS: {
        if ("layout/list_item_participants_0".equals(tag)) {
          return new ListItemParticipantsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for list_item_participants is invalid. Received: " + tag);
      }
      case  LAYOUT_PROFILE6: {
        if ("layout/profile6_0".equals(tag)) {
          return new Profile6BindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for profile6 is invalid. Received: " + tag);
      }
      case  LAYOUT_PROFILE7: {
        if ("layout/profile7_0".equals(tag)) {
          return new Profile7BindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for profile7 is invalid. Received: " + tag);
      }
      case  LAYOUT_RECRUITERHOME: {
        if ("layout/recruiter_home_0".equals(tag)) {
          return new RecruiterHomeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for recruiter_home is invalid. Received: " + tag);
      }
      case  LAYOUT_TABITEMSUBSCRIPTION: {
        if ("layout/tab_item_subscription_0".equals(tag)) {
          return new TabItemSubscriptionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for tab_item_subscription is invalid. Received: " + tag);
      }
      case  LAYOUT_TRACKTESTUI: {
        if ("layout/tracktestui_0".equals(tag)) {
          return new TracktestuiBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for tracktestui is invalid. Received: " + tag);
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
        case 3: {
          return internalGetViewDataBinding3(component, view, localizedLayoutId, tag);
        }
        case 4: {
          return internalGetViewDataBinding4(component, view, localizedLayoutId, tag);
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
    static final SparseArray<String> sKeys = new SparseArray<String>(32);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "btnLabel");
      sKeys.put(2, "buttonLabel");
      sKeys.put(3, "company");
      sKeys.put(4, "companyData");
      sKeys.put(5, "data");
      sKeys.put(6, "documentFlag");
      sKeys.put(7, "episode");
      sKeys.put(8, "event");
      sKeys.put(9, "forSubscription");
      sKeys.put(10, "guest");
      sKeys.put(11, "handler");
      sKeys.put(12, "infoValid");
      sKeys.put(13, "item");
      sKeys.put(14, "jobSeeker");
      sKeys.put(15, "jobsource");
      sKeys.put(16, "member");
      sKeys.put(17, "messageValid");
      sKeys.put(18, "offer");
      sKeys.put(19, "offers");
      sKeys.put(20, "parseUser");
      sKeys.put(21, "profilePictureUrl");
      sKeys.put(22, "recieverName");
      sKeys.put(23, "recruiter");
      sKeys.put(24, "senderProfilePic");
      sKeys.put(25, "showTemplate");
      sKeys.put(26, "state");
      sKeys.put(27, "subscriptionPrice");
      sKeys.put(28, "trackToggleFlag");
      sKeys.put(29, "viewPagerAdapter");
      sKeys.put(30, "viewmodel");
      sKeys.put(31, "vm");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(225);

    static {
      sKeys.put("layout/activity_chat_0", com.findajob.jobamax.R.layout.activity_chat);
      sKeys.put("layout/activity_company_intro_info_0", com.findajob.jobamax.R.layout.activity_company_intro_info);
      sKeys.put("layout/activity_dashboard_0", com.findajob.jobamax.R.layout.activity_dashboard);
      sKeys.put("layout/activity_home_0", com.findajob.jobamax.R.layout.activity_home);
      sKeys.put("layout/activity_job_seeker_account_0", com.findajob.jobamax.R.layout.activity_job_seeker_account);
      sKeys.put("layout/activity_job_seeker_apply_0", com.findajob.jobamax.R.layout.activity_job_seeker_apply);
      sKeys.put("layout/activity_job_seeker_course_0", com.findajob.jobamax.R.layout.activity_job_seeker_course);
      sKeys.put("layout/activity_job_seeker_home_0", com.findajob.jobamax.R.layout.activity_job_seeker_home);
      sKeys.put("layout/activity_job_seeker_password_0", com.findajob.jobamax.R.layout.activity_job_seeker_password);
      sKeys.put("layout/activity_job_seeker_personal_intro_info_0", com.findajob.jobamax.R.layout.activity_job_seeker_personal_intro_info);
      sKeys.put("layout/activity_license_0", com.findajob.jobamax.R.layout.activity_license);
      sKeys.put("layout/activity_login_0", com.findajob.jobamax.R.layout.activity_login);
      sKeys.put("layout/activity_main_0", com.findajob.jobamax.R.layout.activity_main);
      sKeys.put("layout/activity_main_chat_0", com.findajob.jobamax.R.layout.activity_main_chat);
      sKeys.put("layout/activity_manage_location_0", com.findajob.jobamax.R.layout.activity_manage_location);
      sKeys.put("layout/activity_manage_room_0", com.findajob.jobamax.R.layout.activity_manage_room);
      sKeys.put("layout/activity_maps_0", com.findajob.jobamax.R.layout.activity_maps);
      sKeys.put("layout/activity_master_class_0", com.findajob.jobamax.R.layout.activity_master_class);
      sKeys.put("layout/activity_master_class_details_0", com.findajob.jobamax.R.layout.activity_master_class_details);
      sKeys.put("layout/activity_master_class_guest_details_0", com.findajob.jobamax.R.layout.activity_master_class_guest_details);
      sKeys.put("layout/activity_online_course_0", com.findajob.jobamax.R.layout.activity_online_course);
      sKeys.put("layout/activity_online_course_details_0", com.findajob.jobamax.R.layout.activity_online_course_details);
      sKeys.put("layout/activity_payment_0", com.findajob.jobamax.R.layout.activity_payment);
      sKeys.put("layout/activity_preview_image_0", com.findajob.jobamax.R.layout.activity_preview_image);
      sKeys.put("layout/activity_privacy_preference_0", com.findajob.jobamax.R.layout.activity_privacy_preference);
      sKeys.put("layout/activity_profile_0", com.findajob.jobamax.R.layout.activity_profile);
      sKeys.put("layout/activity_recruiter_home_0", com.findajob.jobamax.R.layout.activity_recruiter_home);
      sKeys.put("layout/activity_recruiter_personal_info_intro_0", com.findajob.jobamax.R.layout.activity_recruiter_personal_info_intro);
      sKeys.put("layout/activity_recruiter_subscription_0", com.findajob.jobamax.R.layout.activity_recruiter_subscription);
      sKeys.put("layout/activity_seeker_calender_0", com.findajob.jobamax.R.layout.activity_seeker_calender);
      sKeys.put("layout/activity_seeker_job_search_0", com.findajob.jobamax.R.layout.activity_seeker_job_search);
      sKeys.put("layout/activity_seeker_job_tracking_0", com.findajob.jobamax.R.layout.activity_seeker_job_tracking);
      sKeys.put("layout/activity_seeker_profile_0", com.findajob.jobamax.R.layout.activity_seeker_profile);
      sKeys.put("layout/activity_seeker_wish_list_0", com.findajob.jobamax.R.layout.activity_seeker_wish_list);
      sKeys.put("layout/activity_select_location_0", com.findajob.jobamax.R.layout.activity_select_location);
      sKeys.put("layout/activity_splash_0", com.findajob.jobamax.R.layout.activity_splash);
      sKeys.put("layout/activity_video_chat_view_0", com.findajob.jobamax.R.layout.activity_video_chat_view);
      sKeys.put("layout/activity_video_play_0", com.findajob.jobamax.R.layout.activity_video_play);
      sKeys.put("layout/activity_web_view_0", com.findajob.jobamax.R.layout.activity_web_view);
      sKeys.put("layout/calendar_cell_0", com.findajob.jobamax.R.layout.calendar_cell);
      sKeys.put("layout/dialog_add_linkedin_0", com.findajob.jobamax.R.layout.dialog_add_linkedin);
      sKeys.put("layout/dialog_add_tracking_job_phase_0", com.findajob.jobamax.R.layout.dialog_add_tracking_job_phase);
      sKeys.put("layout/dialog_confirm_0", com.findajob.jobamax.R.layout.dialog_confirm);
      sKeys.put("layout/dialog_confirmation_0", com.findajob.jobamax.R.layout.dialog_confirmation);
      sKeys.put("layout/dialog_leave_room_0", com.findajob.jobamax.R.layout.dialog_leave_room);
      sKeys.put("layout/dialog_message_pop_up_0", com.findajob.jobamax.R.layout.dialog_message_pop_up);
      sKeys.put("layout/dialog_reach_0", com.findajob.jobamax.R.layout.dialog_reach);
      sKeys.put("layout/dialog_requirements_0", com.findajob.jobamax.R.layout.dialog_requirements);
      sKeys.put("layout/dialog_requirements_old_0", com.findajob.jobamax.R.layout.dialog_requirements_old);
      sKeys.put("layout/fragment_about_0", com.findajob.jobamax.R.layout.fragment_about);
      sKeys.put("layout/fragment_archived_chats_0", com.findajob.jobamax.R.layout.fragment_archived_chats);
      sKeys.put("layout/fragment_chat_message_board_0", com.findajob.jobamax.R.layout.fragment_chat_message_board);
      sKeys.put("layout/fragment_chat_user_list_0", com.findajob.jobamax.R.layout.fragment_chat_user_list);
      sKeys.put("layout/fragment_chats_0", com.findajob.jobamax.R.layout.fragment_chats);
      sKeys.put("layout/fragment_company_information_0", com.findajob.jobamax.R.layout.fragment_company_information);
      sKeys.put("layout/fragment_confirm1_seeker_0", com.findajob.jobamax.R.layout.fragment_confirm1_seeker);
      sKeys.put("layout/fragment_confirm2_seeker_0", com.findajob.jobamax.R.layout.fragment_confirm2_seeker);
      sKeys.put("layout/fragment_confirm3_seeker_0", com.findajob.jobamax.R.layout.fragment_confirm3_seeker);
      sKeys.put("layout/fragment_confirm_recruiter_0", com.findajob.jobamax.R.layout.fragment_confirm_recruiter);
      sKeys.put("layout/fragment_courses_0", com.findajob.jobamax.R.layout.fragment_courses);
      sKeys.put("layout/fragment_create_education_0", com.findajob.jobamax.R.layout.fragment_create_education);
      sKeys.put("layout/fragment_create_experience_0", com.findajob.jobamax.R.layout.fragment_create_experience);
      sKeys.put("layout/fragment_display_chat_item_dialog_0", com.findajob.jobamax.R.layout.fragment_display_chat_item_dialog);
      sKeys.put("layout/fragment_event_calendar_0", com.findajob.jobamax.R.layout.fragment_event_calendar);
      sKeys.put("layout/fragment_ideal_job_audio_0", com.findajob.jobamax.R.layout.fragment_ideal_job_audio);
      sKeys.put("layout/fragment_ideal_job_description_0", com.findajob.jobamax.R.layout.fragment_ideal_job_description);
      sKeys.put("layout/fragment_ideal_job_images_0", com.findajob.jobamax.R.layout.fragment_ideal_job_images);
      sKeys.put("layout/fragment_ideal_job_video_0", com.findajob.jobamax.R.layout.fragment_ideal_job_video);
      sKeys.put("layout/fragment_instructors_0", com.findajob.jobamax.R.layout.fragment_instructors);
      sKeys.put("layout/fragment_job_listing_0", com.findajob.jobamax.R.layout.fragment_job_listing);
      sKeys.put("layout/fragment_job_offer_card_info_0", com.findajob.jobamax.R.layout.fragment_job_offer_card_info);
      sKeys.put("layout/fragment_job_offer_details_0", com.findajob.jobamax.R.layout.fragment_job_offer_details);
      sKeys.put("layout/fragment_job_search_0", com.findajob.jobamax.R.layout.fragment_job_search);
      sKeys.put("layout/fragment_job_seeker_account_0", com.findajob.jobamax.R.layout.fragment_job_seeker_account);
      sKeys.put("layout/fragment_job_seeker_apply_0", com.findajob.jobamax.R.layout.fragment_job_seeker_apply);
      sKeys.put("layout/fragment_job_seeker_manage_read_receipts_0", com.findajob.jobamax.R.layout.fragment_job_seeker_manage_read_receipts);
      sKeys.put("layout/fragment_job_seeker_media_0", com.findajob.jobamax.R.layout.fragment_job_seeker_media);
      sKeys.put("layout/fragment_job_seeker_newsletter_0", com.findajob.jobamax.R.layout.fragment_job_seeker_newsletter);
      sKeys.put("layout/fragment_job_seeker_payment_methods_0", com.findajob.jobamax.R.layout.fragment_job_seeker_payment_methods);
      sKeys.put("layout/fragment_job_seeker_personal_information_0", com.findajob.jobamax.R.layout.fragment_job_seeker_personal_information);
      sKeys.put("layout/fragment_job_seeker_profile_0", com.findajob.jobamax.R.layout.fragment_job_seeker_profile);
      sKeys.put("layout/fragment_job_seeker_push_notification_0", com.findajob.jobamax.R.layout.fragment_job_seeker_push_notification);
      sKeys.put("layout/fragment_job_seeker_resume_0", com.findajob.jobamax.R.layout.fragment_job_seeker_resume);
      sKeys.put("layout/fragment_job_seeker_social_links_0", com.findajob.jobamax.R.layout.fragment_job_seeker_social_links);
      sKeys.put("layout/fragment_job_seeker_track_0", com.findajob.jobamax.R.layout.fragment_job_seeker_track);
      sKeys.put("layout/fragment_job_source_0", com.findajob.jobamax.R.layout.fragment_job_source);
      sKeys.put("layout/fragment_jobamax_club_0", com.findajob.jobamax.R.layout.fragment_jobamax_club);
      sKeys.put("layout/fragment_keep_me_posted_0", com.findajob.jobamax.R.layout.fragment_keep_me_posted);
      sKeys.put("layout/fragment_keynotes_0", com.findajob.jobamax.R.layout.fragment_keynotes);
      sKeys.put("layout/fragment_like_dislike_dialog_0", com.findajob.jobamax.R.layout.fragment_like_dislike_dialog);
      sKeys.put("layout/fragment_live_room_0", com.findajob.jobamax.R.layout.fragment_live_room);
      sKeys.put("layout/fragment_live_room_interests_0", com.findajob.jobamax.R.layout.fragment_live_room_interests);
      sKeys.put("layout/fragment_live_room_participants_0", com.findajob.jobamax.R.layout.fragment_live_room_participants);
      sKeys.put("layout/fragment_live_room_welcome_0", com.findajob.jobamax.R.layout.fragment_live_room_welcome);
      sKeys.put("layout/fragment_location_permission_0", com.findajob.jobamax.R.layout.fragment_location_permission);
      sKeys.put("layout/fragment_login_0", com.findajob.jobamax.R.layout.fragment_login);
      sKeys.put("layout/fragment_manage_room_0", com.findajob.jobamax.R.layout.fragment_manage_room);
      sKeys.put("layout/fragment_master_class_0", com.findajob.jobamax.R.layout.fragment_master_class);
      sKeys.put("layout/fragment_masterclass_details_0", com.findajob.jobamax.R.layout.fragment_masterclass_details);
      sKeys.put("layout/fragment_meet_nearby_people_0", com.findajob.jobamax.R.layout.fragment_meet_nearby_people);
      sKeys.put("layout/fragment_messages_0", com.findajob.jobamax.R.layout.fragment_messages);
      sKeys.put("layout/fragment_networking_chats_0", com.findajob.jobamax.R.layout.fragment_networking_chats);
      sKeys.put("layout/fragment_new_login_select_role_0", com.findajob.jobamax.R.layout.fragment_new_login_select_role);
      sKeys.put("layout/fragment_no_reaction_0", com.findajob.jobamax.R.layout.fragment_no_reaction);
      sKeys.put("layout/fragment_no_reaction_drop_email_0", com.findajob.jobamax.R.layout.fragment_no_reaction_drop_email);
      sKeys.put("layout/fragment_online_courses_list_0", com.findajob.jobamax.R.layout.fragment_online_courses_list);
      sKeys.put("layout/fragment_portfolio_description_0", com.findajob.jobamax.R.layout.fragment_portfolio_description);
      sKeys.put("layout/fragment_portfolio_image_0", com.findajob.jobamax.R.layout.fragment_portfolio_image);
      sKeys.put("layout/fragment_portfolio_video_0", com.findajob.jobamax.R.layout.fragment_portfolio_video);
      sKeys.put("layout/fragment_profile_0", com.findajob.jobamax.R.layout.fragment_profile);
      sKeys.put("layout/fragment_profile_recruiter_0", com.findajob.jobamax.R.layout.fragment_profile_recruiter);
      sKeys.put("layout/fragment_recruiter_account_0", com.findajob.jobamax.R.layout.fragment_recruiter_account);
      sKeys.put("layout/fragment_recruiter_chats_0", com.findajob.jobamax.R.layout.fragment_recruiter_chats);
      sKeys.put("layout/fragment_recruiter_course_0", com.findajob.jobamax.R.layout.fragment_recruiter_course);
      sKeys.put("layout/fragment_recruiter_current_subscription_0", com.findajob.jobamax.R.layout.fragment_recruiter_current_subscription);
      sKeys.put("layout/fragment_recruiter_delete_account_0", com.findajob.jobamax.R.layout.fragment_recruiter_delete_account);
      sKeys.put("layout/fragment_recruiter_delete_account_final_0", com.findajob.jobamax.R.layout.fragment_recruiter_delete_account_final);
      sKeys.put("layout/fragment_recruiter_invoices_0", com.findajob.jobamax.R.layout.fragment_recruiter_invoices);
      sKeys.put("layout/fragment_recruiter_manage_read_receipts_0", com.findajob.jobamax.R.layout.fragment_recruiter_manage_read_receipts);
      sKeys.put("layout/fragment_recruiter_media_0", com.findajob.jobamax.R.layout.fragment_recruiter_media);
      sKeys.put("layout/fragment_recruiter_messages_0", com.findajob.jobamax.R.layout.fragment_recruiter_messages);
      sKeys.put("layout/fragment_recruiter_newsletter_0", com.findajob.jobamax.R.layout.fragment_recruiter_newsletter);
      sKeys.put("layout/fragment_recruiter_payment_methods_0", com.findajob.jobamax.R.layout.fragment_recruiter_payment_methods);
      sKeys.put("layout/fragment_recruiter_personal_information_0", com.findajob.jobamax.R.layout.fragment_recruiter_personal_information);
      sKeys.put("layout/fragment_recruiter_push_notification_0", com.findajob.jobamax.R.layout.fragment_recruiter_push_notification);
      sKeys.put("layout/fragment_recruiter_recruit_0", com.findajob.jobamax.R.layout.fragment_recruiter_recruit);
      sKeys.put("layout/fragment_recruiter_social_links_0", com.findajob.jobamax.R.layout.fragment_recruiter_social_links);
      sKeys.put("layout/fragment_recruiter_source_0", com.findajob.jobamax.R.layout.fragment_recruiter_source);
      sKeys.put("layout/fragment_register_0", com.findajob.jobamax.R.layout.fragment_register);
      sKeys.put("layout/fragment_reviews_0", com.findajob.jobamax.R.layout.fragment_reviews);
      sKeys.put("layout/fragment_search_0", com.findajob.jobamax.R.layout.fragment_search);
      sKeys.put("layout/fragment_seeker_about_me_0", com.findajob.jobamax.R.layout.fragment_seeker_about_me);
      sKeys.put("layout/fragment_seeker_add_experience_0", com.findajob.jobamax.R.layout.fragment_seeker_add_experience);
      sKeys.put("layout/fragment_seeker_add_volunteering_0", com.findajob.jobamax.R.layout.fragment_seeker_add_volunteering);
      sKeys.put("layout/fragment_seeker_calender_0", com.findajob.jobamax.R.layout.fragment_seeker_calender);
      sKeys.put("layout/fragment_seeker_change_password_0", com.findajob.jobamax.R.layout.fragment_seeker_change_password);
      sKeys.put("layout/fragment_seeker_delete_account_0", com.findajob.jobamax.R.layout.fragment_seeker_delete_account);
      sKeys.put("layout/fragment_seeker_delete_account_final_0", com.findajob.jobamax.R.layout.fragment_seeker_delete_account_final);
      sKeys.put("layout/fragment_seeker_education_0", com.findajob.jobamax.R.layout.fragment_seeker_education);
      sKeys.put("layout/fragment_seeker_experience_list_0", com.findajob.jobamax.R.layout.fragment_seeker_experience_list);
      sKeys.put("layout/fragment_seeker_filter_job_0", com.findajob.jobamax.R.layout.fragment_seeker_filter_job);
      sKeys.put("layout/fragment_seeker_import_resume_0", com.findajob.jobamax.R.layout.fragment_seeker_import_resume);
      sKeys.put("layout/fragment_seeker_interest_0", com.findajob.jobamax.R.layout.fragment_seeker_interest);
      sKeys.put("layout/fragment_seeker_jobs_0", com.findajob.jobamax.R.layout.fragment_seeker_jobs);
      sKeys.put("layout/fragment_seeker_jobs_filter_0", com.findajob.jobamax.R.layout.fragment_seeker_jobs_filter);
      sKeys.put("layout/fragment_seeker_my_skill_0", com.findajob.jobamax.R.layout.fragment_seeker_my_skill);
      sKeys.put("layout/fragment_seeker_new_education_0", com.findajob.jobamax.R.layout.fragment_seeker_new_education);
      sKeys.put("layout/fragment_seeker_preview_0", com.findajob.jobamax.R.layout.fragment_seeker_preview);
      sKeys.put("layout/fragment_seeker_profile_0", com.findajob.jobamax.R.layout.fragment_seeker_profile);
      sKeys.put("layout/fragment_seeker_search_university_dialog_0", com.findajob.jobamax.R.layout.fragment_seeker_search_university_dialog);
      sKeys.put("layout/fragment_seeker_social_media_ids_0", com.findajob.jobamax.R.layout.fragment_seeker_social_media_ids);
      sKeys.put("layout/fragment_seeker_tracking_job_0", com.findajob.jobamax.R.layout.fragment_seeker_tracking_job);
      sKeys.put("layout/fragment_seeker_tracking_job_details_0", com.findajob.jobamax.R.layout.fragment_seeker_tracking_job_details);
      sKeys.put("layout/fragment_seeker_tracking_job_filter_dialog_0", com.findajob.jobamax.R.layout.fragment_seeker_tracking_job_filter_dialog);
      sKeys.put("layout/fragment_seeker_volunteering_list_0", com.findajob.jobamax.R.layout.fragment_seeker_volunteering_list);
      sKeys.put("layout/fragment_seeker_wish_list_0", com.findajob.jobamax.R.layout.fragment_seeker_wish_list);
      sKeys.put("layout/fragment_select_role_0", com.findajob.jobamax.R.layout.fragment_select_role);
      sKeys.put("layout/fragment_splash_0", com.findajob.jobamax.R.layout.fragment_splash);
      sKeys.put("layout/fragment_syllabus_0", com.findajob.jobamax.R.layout.fragment_syllabus);
      sKeys.put("layout/fragment_value_privacy_0", com.findajob.jobamax.R.layout.fragment_value_privacy);
      sKeys.put("layout/fragment_verification_code_0", com.findajob.jobamax.R.layout.fragment_verification_code);
      sKeys.put("layout/fragment_view_job_offer_0", com.findajob.jobamax.R.layout.fragment_view_job_offer);
      sKeys.put("layout/fragment_welcome_as_seeker_0", com.findajob.jobamax.R.layout.fragment_welcome_as_seeker);
      sKeys.put("layout/item_archived_messages_0", com.findajob.jobamax.R.layout.item_archived_messages);
      sKeys.put("layout/item_calender_event_card_0", com.findajob.jobamax.R.layout.item_calender_event_card);
      sKeys.put("layout/item_chat_0", com.findajob.jobamax.R.layout.item_chat);
      sKeys.put("layout/item_chat_receiver_0", com.findajob.jobamax.R.layout.item_chat_receiver);
      sKeys.put("layout/item_chat_sender_0", com.findajob.jobamax.R.layout.item_chat_sender);
      sKeys.put("layout/item_chat_user_horizontal_0", com.findajob.jobamax.R.layout.item_chat_user_horizontal);
      sKeys.put("layout/item_chat_user_vertical_0", com.findajob.jobamax.R.layout.item_chat_user_vertical);
      sKeys.put("layout/item_company_profile_0", com.findajob.jobamax.R.layout.item_company_profile);
      sKeys.put("layout/item_company_size_0", com.findajob.jobamax.R.layout.item_company_size);
      sKeys.put("layout/item_current_online_0", com.findajob.jobamax.R.layout.item_current_online);
      sKeys.put("layout/item_event_0", com.findajob.jobamax.R.layout.item_event);
      sKeys.put("layout/item_image_0", com.findajob.jobamax.R.layout.item_image);
      sKeys.put("layout/item_info_0", com.findajob.jobamax.R.layout.item_info);
      sKeys.put("layout/item_job_offer_0", com.findajob.jobamax.R.layout.item_job_offer);
      sKeys.put("layout/item_job_offer_card_0", com.findajob.jobamax.R.layout.item_job_offer_card);
      sKeys.put("layout/item_job_seeker_recruit_card_0", com.findajob.jobamax.R.layout.item_job_seeker_recruit_card);
      sKeys.put("layout/item_job_seeker_source_card_0", com.findajob.jobamax.R.layout.item_job_seeker_source_card);
      sKeys.put("layout/item_job_seeker_track_offer_0", com.findajob.jobamax.R.layout.item_job_seeker_track_offer);
      sKeys.put("layout/item_leaving_reason_0", com.findajob.jobamax.R.layout.item_leaving_reason);
      sKeys.put("layout/item_location_0", com.findajob.jobamax.R.layout.item_location);
      sKeys.put("layout/item_master_class_0", com.findajob.jobamax.R.layout.item_master_class);
      sKeys.put("layout/item_master_class_session_guest_0", com.findajob.jobamax.R.layout.item_master_class_session_guest);
      sKeys.put("layout/item_masterclass_video_0", com.findajob.jobamax.R.layout.item_masterclass_video);
      sKeys.put("layout/item_message_image_0", com.findajob.jobamax.R.layout.item_message_image);
      sKeys.put("layout/item_message_text_0", com.findajob.jobamax.R.layout.item_message_text);
      sKeys.put("layout/item_message_video_0", com.findajob.jobamax.R.layout.item_message_video);
      sKeys.put("layout/item_messages_0", com.findajob.jobamax.R.layout.item_messages);
      sKeys.put("layout/item_my_list_0", com.findajob.jobamax.R.layout.item_my_list);
      sKeys.put("layout/item_offer_0", com.findajob.jobamax.R.layout.item_offer);
      sKeys.put("layout/item_online_course_instructor_0", com.findajob.jobamax.R.layout.item_online_course_instructor);
      sKeys.put("layout/item_online_course_review_0", com.findajob.jobamax.R.layout.item_online_course_review);
      sKeys.put("layout/item_online_course_syllabus_0", com.findajob.jobamax.R.layout.item_online_course_syllabus);
      sKeys.put("layout/item_online_courses_0", com.findajob.jobamax.R.layout.item_online_courses);
      sKeys.put("layout/item_our_categories_0", com.findajob.jobamax.R.layout.item_our_categories);
      sKeys.put("layout/item_portfolio_image_0", com.findajob.jobamax.R.layout.item_portfolio_image);
      sKeys.put("layout/item_recruiter_info_0", com.findajob.jobamax.R.layout.item_recruiter_info);
      sKeys.put("layout-v23/item_recruiter_job_offers_0", com.findajob.jobamax.R.layout.item_recruiter_job_offers);
      sKeys.put("layout/item_requirement_check_0", com.findajob.jobamax.R.layout.item_requirement_check);
      sKeys.put("layout/item_seeker_education_0", com.findajob.jobamax.R.layout.item_seeker_education);
      sKeys.put("layout/item_seeker_experience_0", com.findajob.jobamax.R.layout.item_seeker_experience);
      sKeys.put("layout/item_seeker_hard_skill_0", com.findajob.jobamax.R.layout.item_seeker_hard_skill);
      sKeys.put("layout/item_seeker_job_card_0", com.findajob.jobamax.R.layout.item_seeker_job_card);
      sKeys.put("layout/item_seeker_preview_experience_0", com.findajob.jobamax.R.layout.item_seeker_preview_experience);
      sKeys.put("layout/item_seeker_preview_hard_skill_0", com.findajob.jobamax.R.layout.item_seeker_preview_hard_skill);
      sKeys.put("layout/item_seeker_preview_school_0", com.findajob.jobamax.R.layout.item_seeker_preview_school);
      sKeys.put("layout/item_seeker_preview_volunteering_0", com.findajob.jobamax.R.layout.item_seeker_preview_volunteering);
      sKeys.put("layout/item_seeker_search_university_0", com.findajob.jobamax.R.layout.item_seeker_search_university);
      sKeys.put("layout/item_seeker_track_0", com.findajob.jobamax.R.layout.item_seeker_track);
      sKeys.put("layout/item_seeker_tracking_job_detail_card_0", com.findajob.jobamax.R.layout.item_seeker_tracking_job_detail_card);
      sKeys.put("layout/item_seeker_volunteering_0", com.findajob.jobamax.R.layout.item_seeker_volunteering);
      sKeys.put("layout/item_subscription_details_0", com.findajob.jobamax.R.layout.item_subscription_details);
      sKeys.put("layout/item_training_courses_0", com.findajob.jobamax.R.layout.item_training_courses);
      sKeys.put("layout/item_upcoming_events_0", com.findajob.jobamax.R.layout.item_upcoming_events);
      sKeys.put("layout/item_video_thumbnail_0", com.findajob.jobamax.R.layout.item_video_thumbnail);
      sKeys.put("layout/item_wishlist_job_0", com.findajob.jobamax.R.layout.item_wishlist_job);
      sKeys.put("layout/list_item_new_people_0", com.findajob.jobamax.R.layout.list_item_new_people);
      sKeys.put("layout/list_item_participants_0", com.findajob.jobamax.R.layout.list_item_participants);
      sKeys.put("layout/profile6_0", com.findajob.jobamax.R.layout.profile6);
      sKeys.put("layout/profile7_0", com.findajob.jobamax.R.layout.profile7);
      sKeys.put("layout/recruiter_home_0", com.findajob.jobamax.R.layout.recruiter_home);
      sKeys.put("layout/tab_item_subscription_0", com.findajob.jobamax.R.layout.tab_item_subscription);
      sKeys.put("layout/tracktestui_0", com.findajob.jobamax.R.layout.tracktestui);
    }
  }
}
