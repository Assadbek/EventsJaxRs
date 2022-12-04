package com.example.eventsjaxrs.service;

import com.example.eventsjaxrs.model.Employee;
import com.example.eventsjaxrs.model.EmployeeType;

import java.util.List;

public interface EmployeeService {

    Employee loadEmployeeById(String eventId);

    List<Employee> loadAllEmployees();

    void createEmployee(Employee event);

    void updateEmployee(String eventId, Employee event);

    void removeEmployee(String eventId);

    EmployeeType loadEmployeeTypeById(String eventTypeId);

    List<EmployeeType> loadAllEmployeeTypes();

    void createEmployeeType(EmployeeType eventType);

    void updateEmployeeType(String eventTypeId, EmployeeType eventType);

    void removeEmployeeType(String eventTypeId);

}
