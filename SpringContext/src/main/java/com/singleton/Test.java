package com.singleton;

public class Test {
	
	public static void main(String[] args) {
		
		Employee emp = Employee.getEmployee();
		
		System.out.println(emp.hashCode());
		
		Employee emp2 = Employee.getEmployee();
		
		System.out.println(emp2.hashCode());
		
	}

}
