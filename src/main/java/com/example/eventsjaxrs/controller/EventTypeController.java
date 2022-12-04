package com.example.eventsjaxrs.controller;


import com.example.eventsjaxrs.model.Event;
import com.example.eventsjaxrs.model.EventType;
import com.example.eventsjaxrs.service.EventService;
import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Singleton
@Path("/eventTypes")
@AllArgsConstructor
public class EventTypeController {

    private final EventService eventService;

    @GET
    @Produces(APPLICATION_JSON)
    public List<EventType> getEvents() {
        return eventService.loadAllEventTypes();
    }

    @Path("/{eventTypeId}")
    @GET
    @Produces(APPLICATION_JSON)
    public EventType getEvent(@PathParam("eventTypeId") String eventTypeId) {
        return eventService.loadEventTypeById(eventTypeId);
    }

    @Path("/create-event-type")
    @POST
    @Consumes(APPLICATION_JSON)
    public void createEvent(EventType eventType) {
        eventService.createEventType(eventType);
    }

    @Path("/update-event-type/{eventTypeId}")
    @PUT
    @Consumes(APPLICATION_JSON)
    public void updateEvent(@PathParam("eventTypeId") String eventTypeId, EventType eventType) {
        eventService.updateEventType(eventTypeId, eventType);
    }

    @Path("/remove-event-type/{eventTypeId}")
    @DELETE
    public void removeEvent(@PathParam("eventTypeId") String eventTypeId) {
        eventService.removeEventType(eventTypeId);
    }

}
