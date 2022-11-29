package com.guptha.compositekey.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.IdClass;

@Entity
//@IdClass(CustomerId.class)
public class Customers {
//
//	@Id
//	private int id;
//	@Id
//	private String email;

	@EmbeddedId
	private CustomerId id;
	private String name;

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CustomerId getId() {
		return id;
	}

	public void setId(CustomerId id) {
		this.id = id;
	}

}
