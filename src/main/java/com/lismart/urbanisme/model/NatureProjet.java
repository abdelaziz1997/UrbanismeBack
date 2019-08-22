package com.lismart.urbanisme.model;

public enum NatureProjet {

	AMENAGEMENT_INTERIEUR("Aménagement intérieur"), 
	CONSTRUCTION("Construction"),  
	GROUPEMENT_HABITATIONS("Groupement d’Habitations"),
	LOTISSEMENT("Lotissement"), 
	MODIFICATION_AMENAGEMENT ("Modification/Aménagement"),   
	MORCELLEMENT("Morcellement"),  
	SURELEVATION_BATIMENT_EXISTANT("Surélévation d’un bâtiment existant");

    private String text;

    NatureProjet(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static NatureProjet fromString(String text) {
        for (NatureProjet b : NatureProjet.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
       

}
