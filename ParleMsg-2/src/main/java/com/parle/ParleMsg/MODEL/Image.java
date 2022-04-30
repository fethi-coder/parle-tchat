package com.parle.ParleMsg.MODEL;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name="image")
public class Image {
	
	@Id
	private Long image_id;
	private String nom;
	private String url;
	
	public Image() {
		super();
	}

	public Image(String nom, String url) {
		super();
		this.nom = nom;
		this.url = url;
	}

	public Long getImage_id() {
		return image_id;
	}

	public void setImage_id(Long image_id) {
		this.image_id = image_id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}



	
}
