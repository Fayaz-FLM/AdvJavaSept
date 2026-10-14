package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entity.Student;

import jakarta.transaction.Transactional;

@Component
@Transactional
public class StudentDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void saveStudent(Student student) {
		
		Session session = getSession();
		session.persist(student);
		
	}
	
	public Student getStudent(int id) {
		Session session = getSession();
		Student student = session.find(Student.class, id);
		
		return student;
		
	}
	
	public void updateStudent(Student st) {
		
		Session session = getSession();
		
		session.merge(st);
		
		System.out.println("Updated data...");
		
	}
	
	public void deleteStudent(Student st) {
		Session session = getSession();
		
		session.remove(st);
		System.out.println("Deleted");
	}
	
	private Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

}
