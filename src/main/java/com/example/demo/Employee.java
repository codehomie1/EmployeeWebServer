package com.example.demo;

// Creating an entity Employee
public class Employee {

    private String employee_id;

    private String first_name;

    private String last_name;

    private String email;
    private String title;


    public Employee() {}

    public Employee(
            String id, String firstName,
            String lastName, String email, String title)
    {

        super();

        this.employee_id = id;

        this.first_name = firstName;

        this.last_name = lastName;

        this.email = email;

        this.title = title;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public Employee setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
        return this;
    }

    public String getFirst_name() {
        return first_name;
    }

    public Employee setFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public String getLast_name() {
        return last_name;
    }

    public Employee setLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Employee setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Employee setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public String toString() {
        return "Employee {" +
                "employee_id='" + employee_id + '\'' +
                "\n, first_name='" + first_name + '\'' +
                "\n, last_name='" + last_name + '\'' +
                "\n, email='" + email + '\'' +
                "\n, title='" + title + '\'' +
                '}';
    }
}