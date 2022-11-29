package com.guptha.springdataJpqlandanativesql.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "fName")
	private String firstName;
	@Column(name = "lName")
	private String lastName;
	private int score;

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public int getScore() {
		return score;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [Id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", score=" + score + "]";
	}

}
