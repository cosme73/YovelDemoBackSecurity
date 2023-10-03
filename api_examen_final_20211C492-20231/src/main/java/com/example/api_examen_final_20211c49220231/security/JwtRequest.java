package com.example.api_examen_final_20211c49220231.security;
import java.io.Serializable;

/*
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//Clase 4
@Data
@AllArgsConstructor
@NoArgsConstructor*/
public class JwtRequest implements Serializable {
	private static final long serialVersionUID = 5926468583005150707L;
	private String ycqtusername;
	private String ycqtpassword;
	public JwtRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JwtRequest(String ycqtusername, String ycqtpassword) {
		super();
		this.ycqtusername = ycqtusername;
		this.ycqtpassword = ycqtpassword;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getYcqtusername() {
		return ycqtusername;
	}
	public String getYcqtpassword() {
		return ycqtpassword;
	}
	public void setYcqtusername(String ycqtusername) {
		this.ycqtusername = ycqtusername;
	}
	public void setYcqtpassword(String ycqtpassword) {
		this.ycqtpassword = ycqtpassword;
	}
}