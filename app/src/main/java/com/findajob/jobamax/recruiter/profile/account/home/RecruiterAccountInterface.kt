package com.findajob.jobamax.recruiter.profile.account.home

interface RecruiterAccountInterface {

    fun onBackButtonClicked()

    fun onPersonalInformationClicked()


    fun onPasswordClicked()

    fun onManageReadReceiptsClicked()

    fun onPushNotificationsClicked()

    fun onNewsletterClicked()

    fun onPaymentMethodsClicked()

    fun onCompanyInformationClicked()

    fun onInvoicesClicked()

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

    fun onSocialLayoutClicked()

    fun toggleHideMe(flag: Boolean)

}