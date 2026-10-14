package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.StudentDAO;
import com.entity.Student;

public class Application {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		StudentDAO studentDAO = context.getBean(StudentDAO.class, "studentDAO");
		
		Student st = new Student(1,"",0);
		studentDAO.deleteStudent(st);
	}

	private static void update(StudentDAO studentDAO) {
		Student student = studentDAO.getStudent(1);
		student.setMarks(50);
		studentDAO.updateStudent(student);
	}

	private static void get(StudentDAO studentDAO) {
		Student student = studentDAO.getStudent(1);
		System.out.println(student);
	}

	private static void save(StudentDAO studentDAO) {
		Student st = new Student("Fayaz", 40);
		studentDAO.saveStudent(st);
	}

}
