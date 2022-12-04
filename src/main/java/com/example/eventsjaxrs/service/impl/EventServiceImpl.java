package com.example.eventsjaxrs.service.impl;

import com.example.eventsjaxrs.model.Event;
import com.example.eventsjaxrs.model.EventType;
import com.example.eventsjaxrs.repo.EventRepo;
import com.example.eventsjaxrs.repo.EventTypeRepo;
import com.example.eventsjaxrs.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepo eventRepo;
    private final EventTypeRepo eventTypeRepo;

    @Override
    public Event loadEventById(String eventId) {
        return eventRepo.findById(eventId).orElseThrow();
    }

    @Override
    public List<Event> loadAllEvents() {
        return eventRepo.findAll();
    }

    @Override
    public void createEvent(Event event) {
        eventRepo.save(event);
    }

    @Override
    public void updateEvent(String eventId, Event event) {
        var eventById = loadEventById(eventId);

        eventById.setTitle(event.getTitle());
        eventById.setDescription(event.getDescription());
        eventById.setLocation(event.getLocation());
        eventById.setStartDate(event.getStartDate());
        eventById.setEndDate(event.getEndDate());
        eventById.setEventType(event.getEventType());
        eventById.setAttendees(event.getAttendees());

        eventRepo.save(eventById);
    }

    @Override
    public void removeEvent(String eventId) {
        eventRepo.deleteById(eventId);
    }

    @Override
    public EventType loadEventTypeById(String eventTypeId) {
        return eventTypeRepo.findById(eventTypeId).orElseThrow();
    }

    @Override
    public List<EventType> loadAllEventTypes() {
        return eventTypeRepo.findAll();
    }

    @Override
    public void createEventType(EventType eventType) {
        eventTypeRepo.save(eventType);
    }

    @Override
    public void updateEventType(String eventTypeId, EventType eventType) {
        var eventTypeById = loadEventTypeById(eventTypeId);

        eventTypeById.setName(eventType.getName());
        eventTypeById.setDescription(eventType.getDescription());

        eventTypeRepo.save(eventTypeById);
    }

    @Override
    public void removeEventType(String eventTypeId) {
        eventTypeRepo.deleteById(eventTypeId);
    }

}
