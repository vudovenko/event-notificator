package dev.vudovenko.eventnotificator.notificationAssignments.mappers;

import dev.vudovenko.eventnotificator.common.mappers.EntityMapper;
import dev.vudovenko.eventnotificator.notificationAssignments.domain.NotificationAssignment;
import dev.vudovenko.eventnotificator.notificationAssignments.entity.NotificationAssignmentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationAssignmentEntityMapper implements EntityMapper<NotificationAssignment, NotificationAssignmentEntity> {

    @Override
    public NotificationAssignmentEntity toEntity(NotificationAssignment notificationAssignment) {
        return new NotificationAssignmentEntity(
                notificationAssignment.getId(),
                notificationAssignment.getNotificationId(),
                notificationAssignment.getUserId(),
                notificationAssignment.getIsRead()
        );
    }

    @Override
    public NotificationAssignment toDomain(NotificationAssignmentEntity notificationAssignmentEntity) {
        return new NotificationAssignment(
                notificationAssignmentEntity.getId(),
                notificationAssignmentEntity.getNotificationId(),
                notificationAssignmentEntity.getUserId(),
                notificationAssignmentEntity.getIsRead()
        );
    }
}
