package com.esis.esempioSpring.dto;

import java.io.Serializable;

public class AccessiDTO implements Serializable{
	
	private String usr;
	private String pswd;
	
	public AccessiDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccessiDTO(String usr, String pswd) {
		super();
		this.usr = usr;
		this.pswd = pswd;
	}

	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
}
