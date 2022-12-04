package com.example.eventsjaxrs.repo;

import com.example.eventsjaxrs.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepo extends JpaRepository<Event, String> {
}
