package com.validator;

import com.entity.Employee;

public class EmployeeValidator {

	public static String msg = "";

	public static boolean isEmployeeValid(Employee employee) {

		String pattern = "^[a-zA-Z]+$";

		if (employee.getName().trim().equals("") || employee.getName().trim().equals(null)) {
			msg = "Name Can not be Null or Empty";
			return false;
		}

		if (!employee.getName().matches(pattern)) {
			msg = "Name Contains Only Alphabets..!";
			return false;
		}

		if (employee.getSalary() <= 0) {
			msg = "Salary Must be Greater than 0";
			return false;
		}

		return true;
	}

	public String getMsg() {
		return msg;
	}

}
