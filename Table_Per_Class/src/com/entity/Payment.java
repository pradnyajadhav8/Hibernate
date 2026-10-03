package com.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class Payment {
	@Id
	
	private int payId;
	private LocalDate date;
	private double amount;

	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public Payment(LocalDate date, double amount) {
		super();
		this.date = date;
		this.amount = amount;
	}

	public Payment(int payId, LocalDate date, double amount) {
		super();
		this.payId = payId;
		this.date = date;
		this.amount = amount;
	}

	public int getPayId() {
		return payId;
	}

	public void setPayId(int payId) {
		this.payId = payId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Payment [payId=" + payId + ", date=" + date + ", amount=" + amount + "]";
	}
	
}
