package com.dao;

public class EmployeeDAOFactory {

	public static EmployeeDAO getEmployeeFactory() {
		return new EmployeeDAOImpl();
	}
	
}
