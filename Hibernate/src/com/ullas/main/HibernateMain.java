package com.ullas.main;

import java.util.Date;

import org.hibernate.Session;

import com.ullas.hibernate.util.HibernateUtil;
import com.ullas.model.Employee;

public class HibernateMain {

	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Ullas P Naik");
		emp.setRole("CEO");
		emp.setInsertTime(new Date());
		//Get Session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//start transaction
		session.beginTransaction();
		//Save the Model object
		session.save(emp);
		//Commit transaction
		session.getTransaction().commit();
		System.out.println("Employee ID="+emp.getId());
		//terminate session factory, otherwise program won't end
		HibernateUtil.getSessionFactory().close();
	}

}