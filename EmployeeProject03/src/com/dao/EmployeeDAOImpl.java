package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.Exception.EmployeeDAOException;
import com.entity.Employee;
import com.utility.HibernateUtility;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void saveEmployee(Employee employee) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		try (Session session = factory.openSession();) {

			session.save(employee);
			Transaction tx = session.beginTransaction();
			tx.commit();
			System.out.println("Added SucessFully..!");
		} catch (EmployeeDAOException e) {
			EmployeeDAOException ex = new EmployeeDAOException("Failed to Add..!", e);
		}
	}

	@Override
	public void deleteEmployee(int id) {

		SessionFactory factory = HibernateUtility.getSessionFactory();
		try (Session session = factory.openSession();) {

			Employee employee = getEmployee(id);
			session.delete(employee);
			Transaction tx = session.beginTransaction();
			tx.commit();
		} catch (Exception e) {
			EmployeeDAOException ex = new EmployeeDAOException("Failed to Delete...!", e);
			throw ex;
		}
	}

	@Override
	public void updateEmployee(int id, Employee employee) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		try (Session session = factory.openSession();) {

			Employee emp = (Employee) session.get(Employee.class, id);

			if (emp != null) {
				emp.setName(employee.getName());
				emp.setSalary(employee.getSalary());
				session.update(emp);

				Transaction tx = session.beginTransaction();
				tx.commit();
			}
		} catch (EmployeeDAOException e) {
			EmployeeDAOException ex = new EmployeeDAOException("Failed to Update Employee...!", e);
		}
	}

	@Override
	public void updateEmployee(int id, String name, Double salary) {

		SessionFactory factory = HibernateUtility.getSessionFactory();
		try (Session session = factory.openSession();) {

			Employee emp = (Employee) session.get(Employee.class, id);

			if (emp != null) {
				emp.setName(name);
				emp.setSalary(salary);
				session.update(emp);

				Transaction tx = session.beginTransaction();
				tx.commit();
			}
		} catch (EmployeeDAOException e) {
			EmployeeDAOException ex = new EmployeeDAOException("Failed to Update Employee...!", e);
		}
	}

	@Override
	public Employee getEmployee(int id) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		try (Session session = factory.openSession();) {

			System.out.println("++++++++++++++++++++++++++++");
			Employee emp = (Employee) session.load(Employee.class, id);
			System.out.println("=====================================");
			if (emp != null) {
				return emp;
			} else {
				System.out.println("Employee not found..!");
			}
		} catch (Exception e) {
		
			EmployeeDAOException ex = new EmployeeDAOException("Failed to Get Employee!", e);
			throw ex;
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		try (Session session = factory.openSession();) {

			Query query = session.createQuery("from Employee e");

			List<Employee> list = query.list();

			return list;
		} catch (EmployeeDAOException e) {
			EmployeeDAOException ex = new EmployeeDAOException("Failed to Read..!", e);
		}
		return null;
	}

	
}
