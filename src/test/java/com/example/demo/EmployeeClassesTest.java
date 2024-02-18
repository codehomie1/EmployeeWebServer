package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeClassesTest {

	@Test
	void contextLoads() {
	}

	@Test
	void TestEmployeeClassSettersAndGetters() {
		Employee employee = new Employee();

		employee.setEmployee_id("1");
		employee.setEmail("test@gmail.com");
		employee.setFirst_name("Bob");
		employee.setLast_name("Joe");
		employee.setTitle("software engineer");

		assertEquals(employee.getEmployee_id(), "1");
		assertEquals(employee.getEmail(), "test@gmail.com");
		assertEquals(employee.getFirst_name(), "Bob");
		assertEquals(employee.getLast_name(), "Joe");
		assertEquals(employee.getTitle(), "software engineer");
	}

	
	@Test
	void TestEmployeesClassWhenListIsEmpty() {
		Employees employees = new Employees();

		assertTrue(employees.getEmployeeList().isEmpty());
	}

	@Test
	void TestEmployeesClassWithEmployee() {
		Employees employees = new Employees();
		employees.getEmployeeList().add(new Employee());

		assertEquals(employees.getEmployeeList().size(), 1);
		assertFalse(employees.getEmployeeList().isEmpty());
	}

	@Test
	void TestEmployeeManagerAddEmployee() {
		Employee mo = new Employee();
		EmployeeManager employeeManager = new EmployeeManager();

		employeeManager.addEmployee(mo);

		assertFalse(employeeManager.getAllEmployees().getEmployeeList().isEmpty());
		assertEquals(employeeManager.getAllEmployees().getEmployeeList().get(0), mo);
	}



}
