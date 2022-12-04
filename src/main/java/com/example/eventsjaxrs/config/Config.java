package com.example.eventsjaxrs.config;


import com.example.eventsjaxrs.model.*;
import com.example.eventsjaxrs.service.AttendeeService;
import com.example.eventsjaxrs.service.EmployeeService;
import com.example.eventsjaxrs.service.EventService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;
import java.util.List;

@Configuration
public class Config {

    @Bean
    CommandLineRunner commandLineRunner(EventService eventService, AttendeeService attendeeService, EmployeeService employeeService) {
        return args -> {

            Calendar calendar = Calendar.getInstance();

            var attendee = Attendee.builder()
                    .name("John")
                    .phoneNumber("87771231212")
                    .email("jjonson@gmail.com")
                    .build();

            var attendee2 = Attendee.builder()
                    .name("Sam")
                    .phoneNumber("87474564545")
                    .email("ssamson@gmail.com")
                    .build();

            EventType eventType = EventType.builder()
                    .name("Birthday party")
                    .description("Birthday party, Birthday party")
                    .build();

            var employeeType = EmployeeType.builder()
                    .name("Manager")
                    .description("Manager of party")
                    .fee("250000")
                    .build();

            calendar.add(Calendar.DATE, 2);
            var employeeStartDate = calendar.getTime();

            calendar.add(Calendar.DATE, 1);
            var employeeEndDate = calendar.getTime();

            var employee = Employee.builder()
                    .name("Tom")
                    .phoneNumber("139749128374")
                    .startDate(employeeStartDate)
                    .endDate(employeeEndDate)
                    .employeeType(employeeType)
                    .build();

            calendar.add(Calendar.DATE, 2);
            var startDate = calendar.getTime();

            calendar.add(Calendar.DATE, 1);
            var endDate = calendar.getTime();

            Event event = Event.builder()
                    .title("John's birthday")
                    .description("John's birthday, John's birthday")
                    .location("John's home")
                    .startDate(startDate)
                    .endDate(endDate)
                    .eventType(eventType)
                    .attendees(List.of(attendee, attendee2))
                    .build();

            employeeService.createEmployeeType(employeeType);
            employeeService.createEmployee(employee);

            attendeeService.createAttendee(attendee);
            attendeeService.createAttendee(attendee2);

            eventService.createEventType(eventType);
            eventService.createEvent(event);
        };
    }

}
