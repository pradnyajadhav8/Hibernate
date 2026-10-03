package com.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Cheque")

public class Cheque extends Payment {

	private int chNo;
	private String chType;
	
	public Cheque() {
		
	}
	
	public Cheque(int chNo, String chType) {
		super();
		this.chNo = chNo;
		this.chType = chType;
	}

	public int getChNo() {
		return chNo;
	}

	public void setChNo(int chNo) {
		this.chNo = chNo;
	}
	
	public String getChType() {
		return chType;
	}
	
	public void setChType(String chType) {
		this.chType = chType;
	}
	
	@Override
	public String toString() {
		return "Cheque [chNo=" + chNo + ", chType=" + chType + "]";
	}
	
}
