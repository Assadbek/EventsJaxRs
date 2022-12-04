package com.example.eventsjaxrs.service.impl;

import com.example.eventsjaxrs.model.Employee;
import com.example.eventsjaxrs.model.EmployeeType;
import com.example.eventsjaxrs.repo.EmployeeRepo;
import com.example.eventsjaxrs.repo.EmployeeTypeRepo;
import com.example.eventsjaxrs.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final EmployeeTypeRepo employeeTypeRepo;

    @Override
    public Employee loadEmployeeById(String employeeId) {
        return employeeRepo.findById(employeeId).orElseThrow();
    }

    @Override
    public List<Employee> loadAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public void updateEmployee(String employeeId, Employee employee) {
        var employeeById = loadEmployeeById(employeeId);

        employeeById.setName(employee.getName());
        employeeById.setEmployeeType(employee.getEmployeeType());
        employeeById.setPhoneNumber(employee.getPhoneNumber());
        employeeById.setStartDate(employee.getStartDate());
        employeeById.setEndDate(employee.getEndDate());

        employeeRepo.save(employeeById);
    }

    @Override
    public void removeEmployee(String employeeId) {
        employeeRepo.deleteById(employeeId);
    }

    @Override
    public EmployeeType loadEmployeeTypeById(String employeeTypeId) {
        return employeeTypeRepo.findById(employeeTypeId).orElseThrow();
    }

    @Override
    public List<EmployeeType> loadAllEmployeeTypes() {
        return employeeTypeRepo.findAll();
    }

    @Override
    public void createEmployeeType(EmployeeType employeeType) {
        employeeTypeRepo.save(employeeType);
    }

    @Override
    public void updateEmployeeType(String employeeTypeId, EmployeeType employeeType) {
        var employeeTypeById = loadEmployeeTypeById(employeeTypeId);

        employeeTypeById.setName(employeeType.getName());
        employeeTypeById.setDescription(employeeType.getDescription());
        employeeTypeById.setFee(employeeType.getFee());

        employeeTypeRepo.save(employeeTypeById);
    }

    @Override
    public void removeEmployeeType(String employeeTypeId) {
        employeeTypeRepo.deleteById(employeeTypeId);
    }

}
