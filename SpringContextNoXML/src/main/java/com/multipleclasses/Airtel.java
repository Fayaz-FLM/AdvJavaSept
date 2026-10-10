package com.multipleclasses;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Primary
@Scope("prototype")
public class Airtel implements Sim{
	
	@PostConstruct
	public void init() {
		System.out.println("Data Seeding from Airtel...");
	}
	
	public Airtel() {
		System.out.println("Airtel Object Created..");
	}
	
	@Override
	public void call() {
		System.out.println("Airtel Calling...");
	}

}
