package dev.vudovenko.eventnotificator.notificationAssignments.mappers;

import dev.vudovenko.eventnotificator.common.mappers.EntityMapper;
import dev.vudovenko.eventnotificator.notificationAssignments.domain.NotificationAssignment;
import dev.vudovenko.eventnotificator.notificationAssignments.entity.NotificationAssignmentEntity;
import dev.vudovenko.eventnotificator.notifications.domain.Notification;
import dev.vudovenko.eventnotificator.notifications.entities.NotificationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationAssignmentEntityMapper implements EntityMapper<NotificationAssignment, NotificationAssignmentEntity> {

    private final EntityMapper<Notification, NotificationEntity> notificationEntityMapper;

    @Override
    public NotificationAssignmentEntity toEntity(NotificationAssignment notificationAssignment) {
        return new NotificationAssignmentEntity(
                notificationAssignment.getId(),
                notificationAssignment.getNotificationId(),
                notificationAssignment.getUserId()
        );
    }

    @Override
    public NotificationAssignment toDomain(NotificationAssignmentEntity notificationAssignmentEntity) {
        return new NotificationAssignment(
                notificationAssignmentEntity.getId(),
                notificationAssignmentEntity.getNotificationId(),
                notificationAssignmentEntity.getUserId()
        );
    }
}
