package com.guptha.springdata.transactionmanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BankAccount {

	@Id
	private int accno;
	private String firstName;
	private String lastName;
	private int bal;

	public BankAccount(int accno, String firstName, String lastName, int bal) {
		super();
		this.accno = accno;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bal = bal;
	}

	public BankAccount() {
		super();
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getBal() {
		return bal;
	}

	public void setBal(int bal) {
		this.bal = bal;
	}

	@Override
	public String toString() {
		return "BankAccount [accno=" + accno + ", firstName=" + firstName + ", lastName=" + lastName + ", bal=" + bal
				+ "]";
	}

}
