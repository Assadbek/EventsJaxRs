package com.example.eventsjaxrs.controller;


import com.example.eventsjaxrs.model.Employee;
import com.example.eventsjaxrs.service.EmployeeService;
import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Singleton
@Path("/employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GET
    @Produces(APPLICATION_JSON)
    public List<Employee> getEmployees() {
        return employeeService.loadAllEmployees();
    }

    @Path("/{employeeId}")
    @GET
    @Produces(APPLICATION_JSON)
    public Employee getEmployee(@PathParam("employeeId") String employeeId) {
        return employeeService.loadEmployeeById(employeeId);
    }

    @Path("/create-employee")
    @POST
    @Consumes(APPLICATION_JSON)
    public void createEmployee(Employee employee) {
        employeeService.createEmployee(employee);
    }

    @Path("/update-employee/{employeeId}")
    @PUT
    @Consumes(APPLICATION_JSON)
    public void updateEmployee(@PathParam("employeeId") String employeeId, Employee employee) {
        employeeService.updateEmployee(employeeId, employee);
    }

    @Path("/remove-employee/{employeeId}")
    @DELETE
    public void removeEmployee(@PathParam("employeeId") String employeeId) {
        employeeService.removeEmployee(employeeId);
    }

}
