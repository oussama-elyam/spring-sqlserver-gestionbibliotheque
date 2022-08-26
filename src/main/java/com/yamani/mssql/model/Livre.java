package com.yamani.mssql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "livre")
public class Livre extends Document {
	
	@Column(name = "pages")
	private int pages;
	
	public Livre(String titre, float prix, int nbrExpl, String auteur ,Boolean disponible ,int pages) {
		super(titre, prix, nbrExpl, auteur ,disponible);
		this.setPages(pages);
		}
	
	public Livre() {
		super();
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "Livre ["+super.toString() + "pages =" + pages + "]";
	}


}