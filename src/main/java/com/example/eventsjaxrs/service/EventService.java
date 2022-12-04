package com.example.eventsjaxrs.service;

import com.example.eventsjaxrs.model.Event;
import com.example.eventsjaxrs.model.EventType;

import java.util.List;

public interface EventService {

    Event loadEventById(String eventId);

    List<Event> loadAllEvents();

    void createEvent(Event event);

    void updateEvent(String eventId, Event event);

    void removeEvent(String eventId);

    EventType loadEventTypeById(String eventTypeId);

    List<EventType> loadAllEventTypes();

    void createEventType(EventType eventType);

    void updateEventType(String eventTypeId, EventType eventType);

    void removeEventType(String eventTypeId);

}
