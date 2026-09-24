package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.Employee;
import com.utility.HibernateUtility;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void saveEmployee(Employee employee) {
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		session.save(employee);
		Transaction tx =session.beginTransaction();
		tx.commit();
		System.out.println("Added Succesfully..!");
	}

	@Override
	public void deleteEmployee(int id) {
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		Employee emp=getEmployee(id);
		session.delete(emp);
		Transaction tx =session.beginTransaction();
		tx.commit();
	}

	@Override
	public void updateEmployee(int id, Employee updateEmployee) {
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		
		Employee employee1=(Employee)session.get(Employee.class, id);
		
		if(employee1 != null) {
			employee1.setName(updateEmployee.getName());
			employee1.setSalary(updateEmployee.getSalary());
			session.update(employee1);
			
			Transaction tx=session.beginTransaction();
			tx.commit();
		}
		else {
			System.out.println("Employee Not found..!");
		}
		
	}

	@Override
	public void updateEmployee(int id, String name, Double salary) {
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		
		Employee employee1=(Employee)session.get(Employee.class, id);
		
		if(employee1 != null) {
			employee1.setName(name);
			employee1.setSalary(salary);
			session.update(employee1);
			
			Transaction tx=session.beginTransaction();
			tx.commit();
		}
		else {
			System.out.println("Employee Not found..!");
		}
		
	}

	@Override
	public Employee getEmployee(int id) {
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		
		Employee employee1=(Employee)session.get(Employee.class, id);
		
		if(employee1 != null) {
			return employee1;
		}
		else {
			System.out.println("Employee Not found..!");
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() {
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		
		Query query=session.createQuery("from Employee e");
		
		List<Employee> list=query.list();
		
		return list;
	}

}
