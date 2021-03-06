package com.reyco.kn.core.domain;

import java.io.Serializable;

/** 
 * @author  reyco
 * @date    2022.03.14
 * @version v1.0.1 
 */
public class User implements Serializable{
	private String username;
	private String password;
	private Integer age;
	public User(String username, String password, Integer age) {
		this.username = username;
		this.password = password;
		this.age = age;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
} 
