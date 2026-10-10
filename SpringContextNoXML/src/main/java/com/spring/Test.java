package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.multipleclasses.Airtel;
import com.multipleclasses.SimTest;

public class Test {
	
	public static void main(String[] args) {
		
		ApplicationContext container = new AnnotationConfigApplicationContext(Configs.class);
		
		User user = container.getBean("user", User.class);
		
		System.out.println(user);
		
		System.out.println("====================");
		
		SimTest simTest = container.getBean("test", SimTest.class);
		
		simTest.test();
		
		
		System.out.println("======================");
		Airtel airtel = container.getBean("airtel", Airtel.class);
		Airtel airtel2 = container.getBean("airtel", Airtel.class);
		
		System.out.println(airtel.hashCode());
		System.out.println(airtel2.hashCode());
	}

}
