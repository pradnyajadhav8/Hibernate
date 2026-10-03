package com.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CC")

public class CreditCard extends Payment{
	
	private int ccNo;
	private String ccType;
	
	public CreditCard() {
		
	}
	
	public CreditCard(int ccNo, String ccType) {
		super();
		this.ccNo = ccNo;
		this.ccType = ccType;
	}

	public int getCcNo() {
		return ccNo;
	}

	public void setCcNo(int ccNo) {
		this.ccNo = ccNo;
	}

	public String getCcType() {
		return ccType;
	}

	public void setCcType(String ccType) {
		this.ccType = ccType;
	}

	@Override
	public String toString() {
		return "CreditCard [ccNo=" + ccNo + ", ccType=" + ccType + "]";
	}
	
}
