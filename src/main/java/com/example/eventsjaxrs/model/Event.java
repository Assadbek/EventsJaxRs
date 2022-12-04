package com.example.eventsjaxrs.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@XmlRootElement(name = "event")

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    private String location;

    private Date startDate;

    private Date endDate;

    @ManyToOne
    private EventType eventType;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Attendee> attendees;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Employee> employees;

}
