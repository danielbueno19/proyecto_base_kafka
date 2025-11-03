package com.kafka_productor.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic generarTopic (){
        return TopicBuilder.name("topic-test-1")
                .partitions(2)
                .replicas(1)
                .configs(configProps())
                .build();
    }

    public Map<String, String> configProps (){
        Map<String, String> configurations = new HashMap<>();
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "86400000");
        configurations.put(TopicConfig.SEGMENT_MS_CONFIG, "1073741824");
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000012");

        return configurations;
    }
}
