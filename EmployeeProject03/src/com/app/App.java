package com.app;

import java.util.List;
import java.util.Scanner;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOFactory;
import com.entity.Employee;
import com.validator.EmployeeValidator;

public class App {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int option;

		do {
			showMenu();
			System.out.println("Enter Option:");
			option = scanner.nextInt();

			switch (option) {
			case 1:
				addEmployee();
				break;
			case 2:
				deleteEmployee();
				break;
			case 3:
				updateEmployee();
				break;
			case 4:
				readEmployee();
				break;
			case 5:
				System.out.println("Thankyouuuuuuuuuuuuuuuuuuuuu.....!");
				System.exit(-1);
			default:
				System.out.println("Invalid Input...!");
			}

		} while (true);
	}

	private static void showMenu() {

		System.out.println("______________________________________________________________________");
		System.out.println("          Employee Option");
		System.out.println("______________________________________________________________________");
		System.out.println(" 1. ADD STUDENT");
		System.out.println(" 2. DELETE STUDENT");
		System.out.println(" 3. UPDATE STUDENT");
		System.out.println(" 4. SHOW STUDENT");
		System.out.println(" 5. EXIT");
		System.out.println("______________________________________________________________________");
	}

	private static Employee input() {

		System.out.println("Enter Name:");
		String name = scanner.next();
		scanner.nextLine();
		System.out.println("Enter Salary:");
		Double salary = scanner.nextDouble();
		scanner.nextLine();
		
		Employee employee=new Employee(name, salary);
		
		if(! EmployeeValidator.isEmployeeValid(employee)) {
			System.out.println("Not Valid Employee..!");
			System.err.println(EmployeeValidator.msg.toUpperCase());
			System.exit(0);
		}
		return employee;
	}

	private static void addEmployee() {

		Employee emp = input();
		EmployeeDAO employee = EmployeeDAOFactory.getEmployeeFactory();
		if (EmployeeValidator.isEmployeeValid(emp)) {
			employee.saveEmployee(emp);
			System.out.println(emp);
		} else {
			System.err.println(EmployeeValidator.msg.toUpperCase());
		}
	}

	private static void deleteEmployee() {

		System.out.println("Enter id:");
		int id = scanner.nextInt();
		EmployeeDAO employee = EmployeeDAOFactory.getEmployeeFactory();
		employee.deleteEmployee(id);
	}

	private static void updateEmployee() {

		System.out.println("Enter id:");
		int id = scanner.nextInt();
		
		EmployeeDAO employee = EmployeeDAOFactory.getEmployeeFactory();
		Employee employee1 = input();
		
		if (EmployeeValidator.isEmployeeValid(employee1)) {
			employee.updateEmployee(id, employee1);
			System.out.println(employee1);
		} else {
			System.err.println(EmployeeValidator.msg.toUpperCase());
		}
	}

	private static void readEmployee() {

		EmployeeDAO employee = EmployeeDAOFactory.getEmployeeFactory();
		List<Employee> list = employee.getAllEmployee();

		System.out.println("=============================================================");
		System.out.println("                 DISPLAY EMPLOYEE	");
		System.out.println("=============================================================");

		for (Employee emp : list) {

			System.out.printf("%4d", emp.getId());
			System.out.printf("%18s", emp.getName());
			System.out.printf("%15.2f", emp.getSalary());

			System.out.println();

		}
	}
}
