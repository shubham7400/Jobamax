package com.jobamax.appjobamax.model


data class CriteriaCategory(val title: String, var tags: ArrayList<String>) {
    companion object {
        fun getCriteriaCategory(): ArrayList<CriteriaCategory> {
            return arrayListOf(
                CriteriaCategory(title = "Management", tags = arrayListOf(  "business developpment/sales", "business management/gestion de projet", "relation client", "service client/accueil")),
                CriteriaCategory(title = "Vente et distribution", tags = arrayListOf(  "conseiller de vente", "commercial", "Merchandising", "Logistique & Achats ( et gestion fournisseurs)", "Direction des ventes")),
                CriteriaCategory(title = "Marketing", tags = arrayListOf( "marketing stratégique", "Webmarketing & Marketing digital", "marketing developpement/produit", "marketing", "Social Media & Influence", "Marketing Opérationnel",)),
                CriteriaCategory(title = "Communication & média", tags = arrayListOf(  "Communication", "RP", "Journalisme ", "Evènementiel", "Gestion de projet média", "Publicité ", "Conception & Rédaction", "Tech")),
                CriteriaCategory(title = "Management", tags = arrayListOf( "Communication","Événementiel", "RP", "Journalisme", "Gestion de Projets Médias", "Publicité", "Conception & Rédaction")),
                CriteriaCategory(title = "Finance & audit", tags = arrayListOf(   "banque", "Comptabilité & Contrôle de Gestion", "fond d'investissement", "assurances", "audit", "Gestion de patrimoine", "finance de marché", "gestion d'actif", "analyste financier", "corporate finance")),
                CriteriaCategory(title = "Tech", tags = arrayListOf( "data", "Télécom/Réseaux", "Security", "DÉVELOPPEUR FULLSTACK", "support informatique", "support informatique", "FRONT", "R&D", "BACK", "Développeur Ops/Infra", "Gestion Projet IT/Product Manager")),
                CriteriaCategory(title = "Conseil", tags = arrayListOf( "Conseil Stratégique", "Conseil MOA/IT (informatique)", "Conseil RH", "Conseil Innovation", "autres", "Conseil en management et transformation digitale", "Conseil Marketing/Communication", "conseil scientifique / ingénierie/technique (transport, immobilier, urbanisme etc.), audit")),
                CriteriaCategory(title = "Design", tags = arrayListOf(  "UX/UI - Product Design", "Graphisme & Illustration", "Direction Créative/Artistique", "Motion Design", "Production Audiovisuelle", "artisan")),
                CriteriaCategory(title = "Administration, RH & Juridique", tags = arrayListOf(    "Juridique", "RH", "Administratif")),
                CriteriaCategory(title = "Restauration, hôtellerie et tourisme", tags = arrayListOf(  "restauration", "tourisme", "hôtellerie",)),
                CriteriaCategory(title = "immobilier", tags = arrayListOf(   "Conseiller débutant en immobilier", "Conseiller Immobilier", "Conseiller en investissement locatif", "foncier", "développement foncier", "immobilière", "gestion locative", "property manager")),
                CriteriaCategory(title = "Science, ingénieur et R&D", tags = arrayListOf(   "Chimie & Procédés", "Énergie, Matériaux & Mécanique", "autres", "R&D", "Statistiques & Maths", "travaux&chantier/BTP", "Génie Civil & Industriel", "environnement", "architecture & urbanisme")),
                CriteriaCategory(title = "Production et Logistique industrielle", tags = arrayListOf(     "autres", "production et exploitation", "Qualité, HSE & maintenance", "Logistique & supply chain", "transport")),
                CriteriaCategory(title = "Autres", tags = arrayListOf(  "éducation", "sport", "agroalimentaire", "social", "culture", "santé"))
            )
        }
    }
}