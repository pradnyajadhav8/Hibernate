package com.app;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.entity.Address;
import com.entity.Employee;

public class App {

	public static void main(String[] args) {
		
		Address address=new Address("FC ROAD", "PUNE", "MH", "413520");
		Employee employee = new Employee();
		employee.setName("Raju");
		employee.setSalary(100000);
		employee.setAddress(address);
		
		EmployeeDAO dao=new EmployeeDAOImpl();
		dao.saveEmployee(employee);
		
		System.out.println("_____________________");
	}
}
