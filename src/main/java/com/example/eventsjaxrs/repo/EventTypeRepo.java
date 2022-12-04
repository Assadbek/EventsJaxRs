package com.example.eventsjaxrs.repo;

import com.example.eventsjaxrs.model.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTypeRepo extends JpaRepository<EventType, String> {
}
