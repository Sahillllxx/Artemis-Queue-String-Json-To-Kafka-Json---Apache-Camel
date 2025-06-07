package com.learning.config;

import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.endpoint.StaticEndpointBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EndpointUriBuilder {

    private final AppProperties properties;

//    public String artemisQueueUri() {
//        return StaticEndpointBuilders
//                .jms(properties.getArtemis().getQueueName())
//                .transacted(true)
//                .getUri();
//    }

    public String kafkaSuccessUri() {
        return "kafka:" + properties.getKafka().getTopic().getSuccess()
                + "?brokers=" + kafkaBrokers();
    }


    public String kafkaDltUri() {
        return "kafka:" + properties.getKafka().getTopic().getDlt()
                + "?brokers=" + kafkaBrokers();
    }


    private String kafkaBrokers() {
        return "localhost:29092";
    }
}
