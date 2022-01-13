package com.findajob.jobamax.jobseeker.profile.account.home

interface JobSeekerAccountInterface {
	
	fun onBackButtonClicked()
	
	fun onPersonalInformationClicked()
	
	fun onManageReadReceiptsClicked()
	
	fun onPushNotificationsClicked()
	
	fun onNewsletterClicked()
	
	fun onPaymentMethodsClicked()
	
	fun onRestorePurchaseClicked()
	
	fun onShareJobamaxClicked()
	
	fun onHelpAndSupportClicked()
	fun onEmailUsClicked()
	
	fun onCommunityGuidelinesClicked()
	
	fun onSafetyTipsClicked()
	
	fun onPrivacyPolicyClicked()
	
	fun onTermsOfServiceClicked()
	
	fun onLicensesClicked()
	
	fun onPrivacyPreferencesClicked()
	
	fun onLogoutClicked()

    fun onTemporaryDisableAccountClicked()

    fun onDeleteAccountClicked()

    fun toggleHideMe(flag: Boolean)

    fun onPasswordClicked()


    fun onSocialLayoutClicked()
}