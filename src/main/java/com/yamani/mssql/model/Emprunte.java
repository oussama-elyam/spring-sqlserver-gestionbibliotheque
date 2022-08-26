
package com.yamani.mssql.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;




@Entity

//@Table(name = "emprunter")

public class Emprunte {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "date_emprunt")
	private java.util.Date date_emprunt;
	
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "date_retoure")
	private java.util.Date date_retoure;
	
	
	@OneToOne	
	private Document document;
	
	@OneToOne
	private Adherent adherent;

	public Emprunte(java.util.Date date_emprunte, java.util.Date date_retoure, Adherent adherent, Document document) {
	
		this.date_emprunt = date_emprunte;
		this.date_retoure = date_retoure;
		this.adherent = adherent;
		this.document = document;
	}

	public Emprunte() {
	}

	
	public java.util.Date getDate_retoure() {
		return date_retoure;
	}

	public void setDate_retoure(Date date_retoure) {
		this.date_retoure = date_retoure;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public java.util.Date getDate_emprunt() {
		return date_emprunt;
	}

	public void setDate_emprunt(Date date_emprunt) {
		this.date_emprunt = date_emprunt;
	}

	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	

}
