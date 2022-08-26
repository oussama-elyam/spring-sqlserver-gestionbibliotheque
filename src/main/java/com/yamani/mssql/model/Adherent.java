package com.yamani.mssql.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
//@Table(name = "adherent")
public class Adherent {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "nom")
  private String nom;

  @Column(name = "prenom")
  private String prenom;

  @Column(name = "adresse")
  private String adresse;
  
  @Column(name = "cin")
  private String cin;
  
  @JsonFormat(pattern="yyyy-MM-dd")
  @Column(name = "date_naiss")
  private Date date_naiss;
  
  @OneToOne(mappedBy = "adherent")
  private Emprunte emprunte;

  public Adherent() {

  }

  public String getNom() {
	return nom;
}

public Adherent(String nom, String prenom, String adresse, String cin, Date date_naiss) {
	
	this.nom = nom;
	this.prenom = prenom;
	this.adresse = adresse;
	this.cin = cin;
	this.date_naiss = date_naiss;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getAdresse() {
	return adresse;
}

public void setAdresse(String adresse) {
	this.adresse = adresse;
}

public String getCin() {
	return cin;
}

public void setCin(String cin) {
	this.cin = cin;
}

public Date getDate_naiss() {
	return date_naiss;
}

public void setDate_naiss(Date date_naiss) {
	this.date_naiss = date_naiss;
}

@Override
public String toString() {
	return "Adherent [adresse=" + adresse + ", cin=" + cin + ", date_naiss=" + date_naiss + ", nom=" + nom + ", prenom="
			+ prenom + ", toString()=" + super.toString() + "]";
}

public long getId() {
    return id;
  }

  

}
