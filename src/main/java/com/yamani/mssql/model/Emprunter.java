/*
package com.yamani.mssql.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "emprunter")
public class Emprunter {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "date_emprunt")
	private Date date_emprunt;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "date_retoure")
	private Date date_retoure;
	
	
	@OneToOne
	@JoinColumn(name = "titre")
	private Document document;
	
	@OneToOne
	@JoinColumn(name = "cin")
	private Adherent adherent;

	public Emprunter(Date date_emprunt, Adherent adherent, Document document) {
		this.date_emprunt = date_emprunt;
		this.adherent = adherent;
		this.document = document;
	}

	public Emprunter(Date date_emprunt, Date date_retoure, Adherent adherent, Document document) {
	
		this.date_emprunt = date_emprunt;
		this.date_retoure = date_retoure;
		this.adherent = adherent;
		this.document = document;
	}

	public Emprunter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emprunter(Date date_emprunt, Date date_retoure) {
		super();
		this.date_emprunt = date_emprunt;
		this.date_retoure = date_retoure;
	}

	public Date getDate_retoure() {
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

	public Date getDate_emprunt() {
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
*/