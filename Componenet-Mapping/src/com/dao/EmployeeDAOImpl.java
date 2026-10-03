package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Employee;
import com.utility.HibernateUtility;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void saveEmployee(Employee employee) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Transaction tx = null;
		try (Session session = factory.openSession();) {
			tx = session.beginTransaction();
			session.persist(employee);
			tx.commit();
		} catch (Exception e) {
			if (tx != null || tx.isActive()) {
				tx.rollback();
			}
			
		}
	}


}
