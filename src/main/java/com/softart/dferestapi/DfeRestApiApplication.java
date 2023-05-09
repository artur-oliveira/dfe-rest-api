package com.softart.dferestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class DfeRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DfeRestApiApplication.class, args);
    }


}
