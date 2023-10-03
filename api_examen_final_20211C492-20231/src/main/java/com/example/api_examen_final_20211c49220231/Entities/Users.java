package com.example.api_examen_final_20211c49220231.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public class Users implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ycqtid;

	@Column(length = 30, unique = true)
	private String ycqtusername;
	@Column(length = 200)
	private String ycqtpassword;
	private Boolean ycqtenabled;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ycqtuser_id")
	private List<Role> ycqtroles;

	public Long getYcqtid() {
		return ycqtid;
	}

	public void setYcqtid(Long ycqtid) {
		this.ycqtid = ycqtid;
	}

	public String getYcqtusername() {
		return ycqtusername;
	}

	public void setYcqtusername(String ycqtusername) {
		this.ycqtusername = ycqtusername;
	}

	public String getYcqtpassword() {
		return ycqtpassword;
	}

	public void setYcqtpassword(String ycqtpassword) {
		this.ycqtpassword = ycqtpassword;
	}

	public Boolean getYcqtenabled() {
		return ycqtenabled;
	}

	public void setYcqtenabled(Boolean ycqtenabled) {
		this.ycqtenabled = ycqtenabled;
	}

	public List<Role> getYcqtroles() {
		return ycqtroles;
	}

	public void setYcqtroles(List<Role> ycqtroles) {
		this.ycqtroles = ycqtroles;
	}
}