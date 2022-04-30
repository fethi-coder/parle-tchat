package com.parle.ParleMsg.MODEL;

import java.sql.Date;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Forum {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long forum_id;

	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date date;

	@Column(name = "time", columnDefinition = "TIME")
	@CreationTimestamp
	private LocalTime time;

	private String msg;
	private String name;
	private String pseudo;
	private String image;


	public Forum() {
		super();
	}

	public Forum(LocalTime time, Date date, String msg, String name, String pseudo,String image) {
		super();
		this.time = time;
		this.date = date;
		this.msg = msg;
		this.name = name;
		this.pseudo = pseudo;
		this.image = image;

	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getForum_id() {
		return forum_id;
	}

	public void setForum_id(Long forum_id) {
		this.forum_id = forum_id;
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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	

}
