package com.learning.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.model.FlightDetails;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.stereotype.Component;

@Component
public class FlightProcessor implements Processor {

    private final ObjectMapper objectMapper;

    public FlightProcessor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

        @Override
        public void process(Exchange exchange) throws Exception {

            String message = exchange.getIn().getBody(String.class);
            System.out.println("Raw body: " + message);

            String innerJson;
            try {
                innerJson = objectMapper.readValue(message, String.class);
            } catch (Exception e) {
                innerJson = message;
            }

            System.out.println("Unescaped JSON string: " + innerJson);

            FlightDetails flight = objectMapper.readValue(innerJson, FlightDetails.class);

            exchange.getIn().setHeader("kafka.KEY", flight.getFlightNumber());
            exchange.getIn().setBody(objectMapper.writeValueAsString(flight));
        }
}
