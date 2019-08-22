package com.lismart.urbanisme.model;

public enum Qualite {

	GERANT_SOCIETE("Gérant de Société"),
	LOCATAIRE("Locataire"),
	MANDATAIRE("Mandataire"),
	PROPRIETAIRE_MAJEUR("Propriétaire Majeur"),
	PROPRIETAIRE_MINEUR("Propriétaire Mineur"),    
	PROPRIETAIRE_ORPHELIN_MINEUR("Propriétaire Orphelin Mineur"); 
	                                   
	 private String text;

    Qualite(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static Qualite fromString(String text) {
        for (Qualite b : Qualite.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }


}
