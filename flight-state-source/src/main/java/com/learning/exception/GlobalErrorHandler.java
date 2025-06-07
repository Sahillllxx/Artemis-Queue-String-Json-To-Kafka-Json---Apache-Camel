package com.learning.exception;

import com.learning.config.EndpointUriBuilder;
import lombok.RequiredArgsConstructor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteConfigurationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GlobalErrorHandler extends RouteConfigurationBuilder {

    private final EndpointUriBuilder endpointUriBuilder;

    @Override
    public void configuration() throws Exception {

        errorHandler(deadLetterChannel(endpointUriBuilder.kafkaDltUri())
                .maximumRedeliveries(3)
                .redeliveryDelay(2000)
                .retryAttemptedLogLevel(LoggingLevel.WARN)
                .logHandled(true)
                .log("Retries exhausted!.. Sending to DLT")
                .logStackTrace(true)
        );
    }
}
