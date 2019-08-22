package com.lismart.urbanisme.model;

public enum TypeProjet {

		BAT_ADMIN("Batiment administratif"), 
		CENTRE_SOCIAL("Centre à caractère social"),         
		EQUIPEMENT_SOCIAL("Equipement à caractère social à réaliser par organisme étatiques au profit de leurs personnels"),  
		CENTRE_REPOS("Centre de repos et de loisirs publics"),
		EQUIPEMENT_COMMERCIAUX ("Equipement commerciaux à réaliser sur une surface de plancher hors œuvres =>500 m²"),
		EQUIPEMENT_CULTUREL("Equipement culturel"), 
		EQUIPEMENT_PRIVE("Equipement de loisirs privé"),                                                                                                          
		EQUIPEMENT_SANTE("Equipement de santé publique"),  
		EQUIPEMENT_SPORTIF("Equipement sportif"),                                                            
		EQUIPEMENT_TOURISTIQUE("Equipement touristique"), 
		ETABLISSEMENT_ENSEIGNEMENT("Etablissement d’enseignement étatique"),
		EQUIPEMENT_INDUSTRIEL("Equipement industriel à l’exception des établissements de troisième catégorie"),
		GROUPE_HABITATIONS("Groupe d’habitations"), 
		IMMEUBLE_SUP("Immeuble supérieur à 15.5 m²");

	    private String text;

	    TypeProjet(String text) {
	        this.text = text;
	    }

	    public String getText() {
	        return this.text;
	    }

	    public static TypeProjet fromString(String text) {
	        for (TypeProjet b : TypeProjet.values()) {
	            if (b.text.equalsIgnoreCase(text)) {
	                return b;
	            }
	        }
	        return null;
	    }
}
