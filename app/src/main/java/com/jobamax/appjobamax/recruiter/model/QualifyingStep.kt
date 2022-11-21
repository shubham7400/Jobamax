package com.jobamax.appjobamax.recruiter.model

data class QualifyingStep(val key: String, var title: String, val selectionValue: Int){
    companion object {
    fun getQualifyingSteps() : ArrayList<QualifyingStep> {
            return arrayListOf(
                QualifyingStep("", "Vos étapes :", -1),
                QualifyingStep("selection0", "Candidatures reçues", 0),
                QualifyingStep("selection1", "Pré-qualification", 1),
                QualifyingStep("selection2", "Prise de contact", 2),
                QualifyingStep("selection3", "Entretien RH", 3),
                QualifyingStep("selection4", "Entretien Manager", 4),
                QualifyingStep("selection5", "Sélection", 5),
                QualifyingStep("selection6", "Refus", 6),
                QualifyingStep("selection7", "Recrutement", 7),
            )
        }
    }
}
