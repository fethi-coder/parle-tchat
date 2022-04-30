package com.parle.ParleMsg.MODEL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PropertiesConfig {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Long id;
	
	private String host;
	private Long port;
	private String username;
	private String password;
	private Boolean auth;
	private String connectiontimeout;
	private Long timeout;
	private Long  writetimeout;
	private Boolean enable;
	
	
	public PropertiesConfig() {
		super();
	}
	
	
	
	


	public PropertiesConfig(Long id, String host, Long port, String username, String password, Boolean auth,
			String connectiontimeout, Long timeout, Long writetimeout, Boolean enable) {
		super();
		this.id = id;
		this.host = host;
		this.port = port;
		this.username = username;
		this.password = password;
		this.auth = auth;
		this.connectiontimeout = connectiontimeout;
		this.timeout = timeout;
		this.writetimeout = writetimeout;
		this.enable = enable;
	}






	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getHost() {
		return host;
	}


	public void setHost(String host) {
		this.host = host;
	}


	public Long getPort() {
		return port;
	}


	public void setPort(Long port) {
		this.port = port;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Boolean getAuth() {
		return auth;
	}


	public void setAuth(Boolean auth) {
		this.auth = auth;
	}


	public String getConnectiontimeout() {
		return connectiontimeout;
	}


	public void setConnectiontimeout(String connectiontimeout) {
		this.connectiontimeout = connectiontimeout;
	}


	public Long getTimeout() {
		return timeout;
	}


	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}


	public Long getWritetimeout() {
		return writetimeout;
	}


	public void setWritetimeout(Long writetimeout) {
		this.writetimeout = writetimeout;
	}


	public Boolean getEnable() {
		return enable;
	}


	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	
	
	



	
	
}
