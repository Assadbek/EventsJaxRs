package com.example.eventsjaxrs.repo;

import com.example.eventsjaxrs.model.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeTypeRepo extends JpaRepository<EmployeeType, String> {
}
