package com.learning.routes;

import com.learning.config.AppProperties;
import com.learning.config.EndpointUriBuilder;
import com.learning.model.FlightDetails;
import com.learning.service.FlightProcessor;
import lombok.RequiredArgsConstructor;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FlightRouteBuilder extends RouteBuilder {

    private final EndpointUriBuilder endpointUriBuilder;

    private final FlightProcessor flightProcessor;

    private final AppProperties properties;

    @Override
    public void configure() {

        from("jms:" + properties.getArtemis().getQueueName())
                .routeId("flight-processing-route")
                .log("Received message from Artemis: ${body}")
                .log("Transforming : ${body}")

                .process(flightProcessor)
                .setExchangePattern(ExchangePattern.InOnly)

                .to(endpointUriBuilder.kafkaSuccessUri())
                .log("Message successfully sent to Kafka !...");

    }
}
