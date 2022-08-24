package com.yamani.mssql.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "revue")
public class Revue extends Document {
	
	
	public Revue( String titre, float prix, int nbrExpl, String auteur , String typeDoc,Boolean disponible) {
		super( titre, prix, nbrExpl, auteur, typeDoc, disponible);
		}
	
	public Revue() {
		super();
	}

	
}