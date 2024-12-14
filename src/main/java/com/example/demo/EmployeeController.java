
package com.example.demo;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


// Creating the REST controller
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeManager employeeDao;


    @GetMapping("/getEmployees")
    public Employees getEmployees()
    {
        return employeeDao.getAllEmployees();
    }


    @GetMapping("/getEmployee/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String employeeId) {

        Employee employee  = employeeDao.getEmployeeById(employeeId);

        if(employee != null ) {
            return ResponseEntity.ok(employee);
        } else {
            throw new EmployeeNotFoundException("Employee not found with ID: " + employeeId);
        }

    }

    @DeleteMapping("/deleteEmployee/{employeeId}")
    public ResponseEntity<Object> deleteEmployeeById(@PathVariable String employeeId) {

        Employee employee = employeeDao.getEmployeeById(employeeId);

        if(employee != null ) {
            employeeDao.deleteEmployee(employeeId);
            return ResponseEntity.ok().body("Successfully deleted employee with ID : " + employeeId);
        } else {
            throw new EmployeeNotFoundException("Employee not found with ID: " + employeeId);
        }

    }


    @PostMapping(value = "/createEmployee", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee)
    {
        employeeDao.addEmployee(employee);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getEmployee_id())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
