package com.example.eventsjaxrs.controller;

import com.example.eventsjaxrs.model.Event;
import com.example.eventsjaxrs.service.EventService;
import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Singleton
@Path("/events")
@AllArgsConstructor
public class EventController {

    private final EventService eventService;

    @GET
    @Produces(APPLICATION_JSON)
    public List<Event> getEvents() {
        return eventService.loadAllEvents();
    }

    @Path("/{eventId}")
    @GET
    @Produces(APPLICATION_JSON)
    public Event getEvent(@PathParam("eventId") String eventId) {
        return eventService.loadEventById(eventId);
    }

    @Path("/create-event")
    @POST
    @Consumes(APPLICATION_JSON)
    public void createEvent(Event event) {
        eventService.createEvent(event);
    }

    @Path("/update-event/{eventId}")
    @PUT
    @Consumes(APPLICATION_JSON)
    public void updateEvent(@PathParam("eventId") String eventId, Event event) {
        eventService.updateEvent(eventId, event);
    }

    @Path("/remove-event/{eventId}")
    @DELETE
    public void removeEvent(@PathParam("eventId") String eventId) {
        eventService.removeEvent(eventId);
    }

}
