package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;

public class UpdateData {

	public static void main(String[] args) {
		
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory=configuration.buildSessionFactory();
		
		Session session=factory.openSession();
		
		Employee employee=(Employee)session.get(Employee.class, 1);
		
		if(employee != null) {
			employee.setName("ramu");
			employee.setSalary(5666789);
			
			session.update(employee);
			
			Transaction tx=session.beginTransaction();
			tx.commit();
			
			System.out.println("Data Updated..!");
		}
		else {
			System.out.println("Employee not found...!");
		}
		
		session.close();
		factory.close();
		
		System.out.println("Thank youuuuuu!");
		
	}
}
