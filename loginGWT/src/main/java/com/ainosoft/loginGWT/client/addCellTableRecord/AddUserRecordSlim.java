package com.ainosoft.loginGWT.client.addCellTableRecord;

import java.io.Serializable;

public class AddUserRecordSlim implements Serializable{

	String  name,surname,city,country;
	int id;
	
//	  public AddUserRecordSlim(String name, String surname,String city,String country) {
//	      this.name = name;
//	      this.surname = surname;
//	      this.city=city;
//	      this.country=country;
//	    }
	  

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
