package com.spring;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Employee {
	
	int empId;
	
	String name;
	
	int salary;
	
	Set<String> skills;
	
	Map<String, Integer> education;
	
	public Employee() {
		
	}

	public Employee(int empId, String name, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public Set<String> getSkills() {
		return skills;
	}

	public void setSkills(Set<String> skills) {
		this.skills = skills;
	}
	
	public Map<String, Integer> getEducation() {
		return education;
	}

	public void setEducation(Map<String, Integer> education) {
		this.education = education;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", salary=" + salary + ", skills=" + skills
				+ ", education=" + education + "]";
	}

}
