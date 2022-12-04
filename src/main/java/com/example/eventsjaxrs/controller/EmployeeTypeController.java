package com.example.eventsjaxrs.controller;

import com.example.eventsjaxrs.model.EmployeeType;
import com.example.eventsjaxrs.service.EmployeeService;
import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Singleton
@Path("/employeeTypes")
@AllArgsConstructor
public class EmployeeTypeController {

    private final EmployeeService employeeService;

    @GET
    @Produces(APPLICATION_JSON)
    public List<EmployeeType> getEmployees() {
        return employeeService.loadAllEmployeeTypes();
    }

    @Path("/{employeeTypeId}")
    @GET
    @Produces(APPLICATION_JSON)
    public EmployeeType getEmployee(@PathParam("employeeTypeId") String employeeTypeId) {
        return employeeService.loadEmployeeTypeById(employeeTypeId);
    }

    @Path("/create-employee-type")
    @POST
    @Consumes(APPLICATION_JSON)
    public void createEmployee(EmployeeType employeeType) {
        employeeService.createEmployeeType(employeeType);
    }

    @Path("/update-employee-type/{employeeTypeId}")
    @PUT
    @Consumes(APPLICATION_JSON)
    public void updateEmployee(@PathParam("employeeTypeId") String employeeTypeId, EmployeeType employeeType) {
        employeeService.updateEmployeeType(employeeTypeId, employeeType);
    }

    @Path("/remove-employee-type/{employeeTypeId}")
    @DELETE
    public void removeEmployee(@PathParam("employeeTypeId") String employeeTypeId) {
        employeeService.removeEmployeeType(employeeTypeId);
    }

}
