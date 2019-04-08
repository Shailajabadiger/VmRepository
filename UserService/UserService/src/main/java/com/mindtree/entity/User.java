package com.mindtree.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
@Entity
@Table(name="userdetails")
/*@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) */
@Proxy(lazy=false)
public class User implements Serializable {
	@Id
	private String userName;
	@Column
	private String name;
	@Column
	private String emial;
	@Column
	private String password;
	
	public User() {
		super();
	}

	public User(String userName, String name, String emial, String password) {
		super();
		this.userName = userName;
		this.name = name;
		this.emial = emial;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmial() {
		return emial;
	}

	public void setEmial(String emial) {
		this.emial = emial;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [getUserName()=" + getUserName() + ", getName()=" + getName() + ", getEmial()=" + getEmial()
				+ ", getPassword()=" + getPassword() + "]";
	}
}
