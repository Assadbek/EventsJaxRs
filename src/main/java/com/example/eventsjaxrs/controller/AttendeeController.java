package com.example.eventsjaxrs.controller;

import com.example.eventsjaxrs.model.Attendee;
import com.example.eventsjaxrs.service.AttendeeService;
import jakarta.ws.rs.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path("/attendees")
@AllArgsConstructor
public class AttendeeController {

    private final AttendeeService attendeeService;

    @GET
    @Produces(APPLICATION_JSON)
    public List<Attendee> getAttendees() {
        return attendeeService.loadAllAttendees();
    }

    @Path("/{attendeeId}")
    @GET
    @Produces(APPLICATION_JSON)
    public Attendee getAttendee(@PathParam("attendeeId") String attendeeId) {
        return attendeeService.loadAttendeeById(attendeeId);
    }

    @Path("/create-attendee")
    @POST
    @Consumes(APPLICATION_JSON)
    public void createAttendee(Attendee attendee) {
        attendeeService.createAttendee(attendee);
    }

    @Path("/update-attendee/{attendeeId}")
    @PUT
    @Consumes(APPLICATION_JSON)
    public void updateAttendee(@PathParam("attendeeId") String attendeeId, Attendee attendee) {
        attendeeService.updateAttendee(attendeeId, attendee);
    }

    @Path("/remove-attendee/{attendeeId}")
    @DELETE
    public void removeAttendee(@PathParam("attendeeId") String attendeeId) {
        attendeeService.removeAttendee(attendeeId);
    }

}
