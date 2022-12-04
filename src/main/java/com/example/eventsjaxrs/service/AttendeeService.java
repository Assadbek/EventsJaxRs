package com.example.eventsjaxrs.service;

import com.example.eventsjaxrs.model.Attendee;
import com.example.eventsjaxrs.model.Event;
import com.example.eventsjaxrs.model.EventType;

import java.util.List;

public interface AttendeeService {

    Attendee loadAttendeeById(String attendeeId);

    List<Attendee> loadAllAttendees();

    void createAttendee(Attendee attendee);

    void updateAttendee(String attendeeId, Attendee attendee);

    void removeAttendee(String attendeeId);

}
