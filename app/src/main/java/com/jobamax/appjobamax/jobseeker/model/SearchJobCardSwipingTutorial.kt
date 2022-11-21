package com.jobamax.appjobamax.jobseeker.model

import com.jobamax.appjobamax.enums.LearnSwipeCardName
import com.jobamax.appjobamax.jobseeker.search.SWIPE_LEFT
import com.jobamax.appjobamax.jobseeker.search.SWIPE_RIGHT
import com.jobamax.appjobamax.jobseeker.search.SWIPE_TOP

data class SearchJobCardSwipingTutorial(val title: String, val description: String, val action: String, val actionType: Int, val cardName: String) {
    companion object {
        fun getSearchJobCardSwipingTutorial() : ArrayList<SearchJobCardSwipingTutorial> {
            return arrayListOf(
                SearchJobCardSwipingTutorial("Swipe à droite pour postuler ✅", "Seulement pour les offres", "SWIPE MOI ! ", SWIPE_RIGHT, LearnSwipeCardName.A.value),
                SearchJobCardSwipingTutorial("Swipe à droite pour enregistrer ✅", "Toutes les offres qui n’ont pas la mention                sont enregistrées dans ta Wishlist.", "SWIPE MOI ! ", SWIPE_RIGHT, LearnSwipeCardName.B.value),
                SearchJobCardSwipingTutorial("Swipe up pour partager \uD83D\uDC46", "Envoie les offres qui pourraient correspondre à tes potes !", "SWIPE MOI ! ", SWIPE_TOP, LearnSwipeCardName.C.value),
                SearchJobCardSwipingTutorial("Swipe à gauche pour passer ❌", "Tu pourras toujours revenir en arrière en appuyant sur le bouton retour        si tu changes d’avis.", "SWIPE MOI ! ", SWIPE_LEFT, LearnSwipeCardName.D.value),
                SearchJobCardSwipingTutorial("1 Interview décrochée \n=\n1 Masterclass offerte \uD83C\uDF89", "On te récompense de tes succès ! Reçois une masterclass exclusive produite en partenariat avec les meilleurs speakers au monde. ", "JE NOTE !", -1, LearnSwipeCardName.E.value),
            )
        }
    }
}