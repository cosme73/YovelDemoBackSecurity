package com.example.api_examen_final_20211c49220231.security;
import java.io.Serializable;

/*
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

clase 5
@AllArgsConstructor
@Getter*/
public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String ycqtjwttoken;

	public String getJwttoken() {
		return ycqtjwttoken;
	}

	public JwtResponse(String jwttoken) {
		super();
		this.ycqtjwttoken = jwttoken;
	}

}