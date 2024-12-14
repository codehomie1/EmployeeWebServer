package com.example.demo;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeeManager employeeDao;



    @Test
    void TestGetAllEmployeesEndpoint() throws Exception {
        Employee e1 = new Employee("1", "mo", "joe", "mj@gmail.com","designer");
        Employee e2 = new Employee("2", "robert", "jack", "rj@gmail.com","developer");
        Employee e3 = new Employee("3", "liam", "abet", "la@gmail.com","manager");

        Employees employees = new Employees();
        employees.setEmployeeList(List.of(e1, e2, e3));

        when(employeeDao.getAllEmployees()).thenReturn(employees);

        mockMvc
                .perform(get("/api/getEmployees"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.employeeList.size()", Matchers.is(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.employeeList[0].employee_id").value("1"));
    }

    @Test
    void TestCreateEmployeeEndpoint() throws Exception {


        String employeeJSON = "{\"employee_id\":\"1\",\"first_name\":\"mo\"," +
                "\"last_name\":\"joe\",\"email\":\"mj@gmail.com\"," +
                "\"title\":\"designer\"}";



        // test post request
        mockMvc.perform(
                post("/api/createEmployee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(employeeJSON)
                )
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }


    @Test
    void TestGetEmployeeByIdEndpoint() throws Exception {

        Employee e1 = new Employee("1", "mo", "joe", "mj@gmail.com","designer");

        when(employeeDao.getEmployeeById(e1.getEmployee_id())).thenReturn(e1);


        // test get request
        mockMvc.perform(get("/api/getEmployee/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.employee_id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.last_name").value("joe"));

    }

    @Test
    void TestDeleteEmployeeByIdEndpoint() throws Exception {

        Employee e1 = new Employee("1", "mo", "joe", "mj@gmail.com","designer");

        // simulate that we have an employee with this id
        when(employeeDao.getEmployeeById(e1.getEmployee_id())).thenReturn(e1);

        // test delete request
        mockMvc.perform(delete("/api/deleteEmployee/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Verify that the deleteEmployeeById method was called with the correct ID
        Mockito.verify(employeeDao).deleteEmployee("1");
    }


}
