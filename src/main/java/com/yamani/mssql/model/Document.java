package com.yamani.mssql.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;
	
	@Column(name = "titre")
	private String titre;
	
	@Column(name = "prix")
	private float prix;
	
	@Column(name = "nbrExpl")
	private int nbrExpl;
	
	@Column(name = "auteur")
	private String auteur;
	
	@Column(name = "typeDoc")
	private String typeDoc;
	
	@Column(name = "disponible")
	private Boolean disponible;
	
	
	public Document(String titre, float prix, int nbrExpl, String auteur, String typeDoc ,Boolean disponible) {
		
		this.titre = titre;
		this.prix = prix;
		this.nbrExpl = nbrExpl;
		this.auteur = auteur;
		this.typeDoc = typeDoc;
		this.disponible = disponible;
	}
	
	public Document() {
	}

	
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getNbrExpl() {
		return nbrExpl;
	}

	public void setNbrExpl(int nbrExpl) {
		this.nbrExpl = nbrExpl;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getTypeDoc() {
		return typeDoc;
	}

	public void setTypeDoc(String typeDoc) {
		this.typeDoc = typeDoc;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", titre=" + titre + ", prix=" + prix + ", nbrExpl=" + nbrExpl + ", auteur="
				+ auteur + ", typeDoc=" + typeDoc + ", disponible=" + disponible + "]";
	}
	
	
}
