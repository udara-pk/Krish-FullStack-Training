package com.udara.fuelapp.fueldistributionapp.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaCompleteConfig {
    public static final String MESSAGE_TOPIC = "complete_topic";

    @Bean
    public NewTopic completeTopic(){
        return TopicBuilder.name(MESSAGE_TOPIC)
                .build();
    }
}
