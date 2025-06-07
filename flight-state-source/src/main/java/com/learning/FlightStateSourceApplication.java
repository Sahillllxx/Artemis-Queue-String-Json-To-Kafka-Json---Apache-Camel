package com.learning;

import com.learning.config.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlightStateSourceApplication  {

    public static void main(String[] args) {
        SpringApplication.run(FlightStateSourceApplication.class, args);
    }

}
