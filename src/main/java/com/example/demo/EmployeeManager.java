package com.example.demo;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeManager {

    private static final Employees list = new Employees();

    // Method to return the list
    public Employees getAllEmployees() {

        return list;
    }

    // Method to return an Employee with a specific id (string)
    public Employee getEmployeeById(String id) {

        for (Employee currentEmployee : list.getEmployeeList()) {

            if (currentEmployee.getEmployee_id().equals(id)) {
                return currentEmployee;
            }
        }

        return null;
    }

    // Method to delete an Employee with a specific id (string)
    public void deleteEmployee(String id) {

        list.getEmployeeList().removeIf(currentEmployee -> currentEmployee.getEmployee_id().equals(id));

    }

    public void addEmployee(Employee employee) {
        list.getEmployeeList()
                .add(employee);

    }
}
