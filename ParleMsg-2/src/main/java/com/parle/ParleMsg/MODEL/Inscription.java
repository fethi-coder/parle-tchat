package com.parle.ParleMsg.MODEL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long inscription_id;

	
	private String username;
	private String name;
	private String pseudo;
	private String mail;
	private String mdp;
	private String confirme;
	private String roles = "USER";
	private Boolean active= true;

	public Inscription() {

	}

	public Inscription(String mdp) {
		super();
		this.mdp = mdp;
	}

	public Inscription(String username, String name, String pseudo, String mail, String mdp, String confirme) {
		this.username = username;
		this.name = name;
		this.pseudo = pseudo;
		this.mail = mail;
		this.mdp = mdp;
		this.confirme = confirme;

	}

	public Long getInscription_id() {
		return inscription_id;
	}

	public void setInscription_id(Long inscription_id) {
		this.inscription_id = inscription_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getConfirme() {
		return confirme;
	}

	public void setConfirme(String confirme) {
		this.confirme = confirme;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	
}