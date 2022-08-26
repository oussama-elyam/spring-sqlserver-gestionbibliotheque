package com.yamani.mssql.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dictionnaire")
public class Dictionnaire extends Document {
	
	private String langue;
	
	public Dictionnaire(String titre, float prix, int nbrExpl, String auteur,Boolean disponible ,String langue) {
		super(titre, prix, nbrExpl, auteur ,disponible);
		this.langue = langue;
		}
	
	public Dictionnaire() {
		super();
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}


}