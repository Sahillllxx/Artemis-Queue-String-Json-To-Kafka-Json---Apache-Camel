package com.learning.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "app")
public class AppProperties {
    private ArtemisConfig artemis;
    private KafkaConfig kafka;

    @Data
    public static class ArtemisConfig {
        private String queueName;
    }

    @Data
    public static class KafkaConfig {
        private TopicConfig topic;

        @Data
        public static class TopicConfig {
            private String success;
            private String dlt;
        }
    }
}
