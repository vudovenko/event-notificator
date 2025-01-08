package dev.vudovenko.eventnotificator.notifications.kafka;

import dev.vudovenko.eventnotificator.common.mappers.ToDomainMapper;
import dev.vudovenko.eventnotificator.events.changes.dto.EventChangeDto;
import dev.vudovenko.eventnotificator.notificationAssignments.service.NotificationAssignmentService;
import dev.vudovenko.eventnotificator.notifications.domain.Notification;
import dev.vudovenko.eventnotificator.notifications.services.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class NotificationKafkaListener {

    private final NotificationService notificationService;
    private final NotificationAssignmentService notificationAssignmentService;

    private final ToDomainMapper<Notification, EventChangeDto> EventChangeDtoToEntityMapper;

    @KafkaListener(topics = "events-changes-topic", containerFactory = "containerFactory")
    public void listenEvents(
            ConsumerRecord<Long, EventChangeDto> record
    ) {
        log.info("event change received: {}", record.value());

        Notification notification = notificationService.createNotification(
                EventChangeDtoToEntityMapper.toDomain(record.value())
        );

        record.value().participants().forEach(
                participantId -> {
                    notificationAssignmentService.assignNotification(
                            notification.getId(),
                            participantId
                    );
                }
        );
    }
}
