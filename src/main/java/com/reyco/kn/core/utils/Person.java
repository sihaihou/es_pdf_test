package com.reyco.kn.core.utils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
/**
 * @author reyco
 * @date 2022.01.06
 * @version v1.0.1
 */
public class Person implements Serializable{
	private Integer id;
	private String name;
	private Integer age;
	private Boolean gender;
	private String address;
	private String gmtCreate;
	private String location;
	private BigDecimal distance;
	private List<String> suggestion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(String gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public BigDecimal getDistance() {
		return distance;
	}

	public void setDistance(BigDecimal distance) {
		this.distance = distance;
	}
	
	public List<String> getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(List<String> suggestion) {
		this.suggestion = suggestion;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", address=" + address
				+ ", gmtCreate=" + gmtCreate + ", location=" + location + ", distance=" + distance + ", suggestion="
				+ suggestion + "]";
	}

}
