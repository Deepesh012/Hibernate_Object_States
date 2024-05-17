package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.ProjectWithMaven.Certificate;
import com.jsp.ProjectWithMaven.Student;

public class StateDemo {

	public static void main(String[] args) {
	
		//Practical of Hibernate Object States
		//Transient
		//Persistent
		//Detached
		//Removed
		
		System.out.println("Example :");
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		
		//creating Student Object
		Student s = new Student();	
		s.setId(101);
		s.setName("Dinasour");
		s.setCity("Russia");
		s.setCerti(new Certificate("Advance Java Course","3 months"));
		//s : Transient Stage
		
		//create session to move our object in Persistent Stage
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(s);
		//s : Persistent Stage
		s.setCity("Aligarh");
		tx.commit();
		
		
		session.close();
		//s : Detached Stage
		
		
		//session.delete(s);
		//s : Removed Stage
		
		
		//close the factory
		factory.close();
		
	}	
}
