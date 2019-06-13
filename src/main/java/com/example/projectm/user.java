package com.example.projectm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema ="1fQc5ZhkUX")
public class user{

	public user(){}


@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name = "user_id")
    private int user_id;

	public int getUser_id() {
		return this.user_id;
	}

	public void getUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Column(name="user_name")
	private String user_name;

	public String getUser_name() {
		return this.user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	@Column(name="password")
	private String password;

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}




	@Column(name="user_type")
	private String user_type;

	public String getUser_type() {
		return this.user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}




	
}