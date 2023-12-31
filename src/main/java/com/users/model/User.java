package com.users.model;

import javax.persistence.*;

@Entity
public class User {
	@Id
	private Long accountNo;

	/*@OneToMany(mappedBy = "senderNo")
	private List<TransactionHistory> transactions;*/

	private String name;
	private Long balance;
	private String email;
	private String address;
	private int active = 1;

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
}
