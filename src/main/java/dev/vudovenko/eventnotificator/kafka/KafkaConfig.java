package dev.vudovenko.eventnotificator.kafka;

import dev.vudovenko.eventnotificator.events.changes.dto.EventChangeDto;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConfig {

    @Bean
    public ConsumerFactory<Long, EventChangeDto> consumerFactory(
            KafkaProperties kafkaProperties
    ) {
        Map<String, Object> configProperties = kafkaProperties.buildConsumerProperties();
        DefaultKafkaConsumerFactory<Long, EventChangeDto> factory =
                new DefaultKafkaConsumerFactory<>(configProperties);
        factory.setValueDeserializer(new JsonDeserializer<>(EventChangeDto.class, false));

        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<Long, EventChangeDto> containerFactory(
            ConsumerFactory<Long, EventChangeDto> consumerFactory
    ) {
        ConcurrentKafkaListenerContainerFactory<Long, EventChangeDto> factory
                = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }
}
