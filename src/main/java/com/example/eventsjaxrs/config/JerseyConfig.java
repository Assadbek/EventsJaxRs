package com.example.eventsjaxrs.config;

import com.example.eventsjaxrs.controller.AttendeeController;
import com.example.eventsjaxrs.controller.EventController;
import com.example.eventsjaxrs.controller.EventTypeController;
import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    @PostConstruct
    public void init(){
        register(EventController.class);
        register(AttendeeController.class);
        register(EventTypeController.class);
    }

}
