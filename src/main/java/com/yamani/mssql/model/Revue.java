package com.yamani.mssql.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "revue")
public class Revue extends Document {
	
	
	public Revue( String titre, float prix, int nbrExpl, String auteur ,Boolean disponible) {
		super( titre, prix, nbrExpl, auteur, disponible);
		}
	
	public Revue() {
		super();
	}

	
}