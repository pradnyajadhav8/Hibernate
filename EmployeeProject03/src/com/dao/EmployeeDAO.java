package com.dao;

import java.util.List;

import com.entity.Employee;

public interface EmployeeDAO {

	void saveEmployee(Employee employee);

	void deleteEmployee(int id);

	void updateEmployee( int id, Employee employee);

	void updateEmployee(int id, String name, Double salary);

	Employee getEmployee(int id);

	List<Employee> getAllEmployee();

}
