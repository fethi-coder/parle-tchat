package com.parle.ParleMsg.MODEL;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Connecter {
	
	@Id
	private Long connecter_id;

	private String pseudo;
	private Boolean present = false;


	public Connecter() {
		super();
	}


	public Connecter(String pseudo, Boolean present) {
		super();
		this.pseudo = pseudo;
		this.present = present;
	}


	public Long getConnecter_id() {
		return connecter_id;
	}

	public void setConnecter_id(Long connecter_id) {
		this.connecter_id = connecter_id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Boolean getPresent() {
		return present;
	}

	public void setPresent(Boolean present) {
		this.present = present;
	}


	
	

}
