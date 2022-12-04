package com.example.eventsjaxrs.service.impl;

import com.example.eventsjaxrs.model.Attendee;
import com.example.eventsjaxrs.repo.AttendeeRepo;
import com.example.eventsjaxrs.service.AttendeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AttendeeServiceImpl implements AttendeeService {

    private final AttendeeRepo attendeeRepo;

    @Override
    public Attendee loadAttendeeById(String attendeeId) {
        return attendeeRepo.findById(attendeeId).orElseThrow();
    }

    @Override
    public List<Attendee> loadAllAttendees() {
        return attendeeRepo.findAll();
    }

    @Override
    public void createAttendee(Attendee attendee) {
        attendeeRepo.save(attendee);
    }

    @Override
    public void updateAttendee(String attendeeId, Attendee attendee) {
        var attendeeById = loadAttendeeById(attendeeId);

        attendeeById.setName(attendee.getName());
        attendeeById.setEmail(attendee.getEmail());
        attendeeById.setPhoneNumber(attendee.getPhoneNumber());

        attendeeRepo.save(attendeeById);
    }

    @Override
    public void removeAttendee(String attendeeId) {
        attendeeRepo.deleteById(attendeeId);
    }

}
