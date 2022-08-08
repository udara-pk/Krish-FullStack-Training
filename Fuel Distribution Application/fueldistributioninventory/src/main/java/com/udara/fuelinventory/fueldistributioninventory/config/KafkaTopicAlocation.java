package com.udara.fuelinventory.fueldistributioninventory.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
@Configuration
public class KafkaTopicAlocation {

    public static final String MESSAGE_TOPIC = "allocation_topic";

    @Bean
    public NewTopic allocationTopic(){
        return TopicBuilder.name(MESSAGE_TOPIC)
                .build();
    }
}
