package com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class Test {
	
	public static void main(String[] args) {
		
		ApplicationContext container = new ClassPathXmlApplicationContext("beans.xml");
		
		JdbcTemplate template = container.getBean("template", JdbcTemplate.class);
		
		Employee employee = template.queryForObject("select * from employees where id = ?", 
				(rs, rowNum) -> new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3))
				, 2);
		
		System.out.println(employee);
		
	}

	private static void selectAll(JdbcTemplate template) {
		List<Employee> list = template.query("select * from employees", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3));
			}
			
		});
		
		System.out.println(list);
	}

	private static void selectOne(JdbcTemplate template) {
		Employee employee = template.queryForObject("select * from employees where id = 1", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3));
			}
			
		});
		
		System.out.println(employee);
	}

	private static void dml(JdbcTemplate template) {
		//		template.update("Insert into employees values(?,?,?)" , 1 , "Fayaz", 2000);
				
				template.update("delete from employees where id = ?", 1);
				System.out.println("Updated....");
	}

}
