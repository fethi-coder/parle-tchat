package com.parle.ParleMsg.MODEL;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Authentication {

	@Id
	private Long auth_id;
	private String username;
	private String name;
	private String pseudo;
	private String password;
	private String img;
	private Boolean active;
	private String roles;
	private String confirme;
	private String message;
	
	
	public Authentication() {
		super();
	}

	public Authentication(String username, String pseudo, String password, String img, Boolean active,
			String roles,String name,String confirme,Long auth_id) {
		super();
		this.username = username;
		this.pseudo = pseudo;
		this.password = password;
		this.img = img;
		this.active = active;
		this.roles = roles;
		this.name = name;
		this.confirme = confirme;
		this.auth_id = auth_id;
	}

	public Long getAuth_id() {
		return auth_id;
	}

	public void setAuth_id(Long auth_id) {
		this.auth_id = auth_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getConfirme() {
		return confirme;
	}

	public void setConfirme(String confirme) {
		this.confirme = confirme;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
