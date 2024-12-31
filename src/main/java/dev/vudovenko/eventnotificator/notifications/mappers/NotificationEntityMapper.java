package dev.vudovenko.eventnotificator.notifications.mappers;

import dev.vudovenko.eventnotificator.common.mappers.EntityMapper;
import dev.vudovenko.eventnotificator.events.changes.dto.*;
import dev.vudovenko.eventnotificator.notifications.domain.Notification;
import dev.vudovenko.eventnotificator.notifications.entities.NotificationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationEntityMapper implements EntityMapper<Notification, NotificationEntity> {

    @Override
    public NotificationEntity toEntity(Notification notification) {
        return new NotificationEntity(
                notification.getId(),
                notification.getEventId(),
                notification.getModifiedBy(),
                notification.getEventOwnerId(),
                notification.getNotificationCreatedAt(),
                notification.getIsRead(),
                notification.getName().oldField(),
                notification.getName().newField(),
                notification.getMaxPlaces().oldField(),
                notification.getMaxPlaces().newField(),
                notification.getDate().oldField(),
                notification.getDate().newField(),
                notification.getCost().oldField(),
                notification.getCost().newField(),
                notification.getDuration().oldField(),
                notification.getDuration().newField(),
                notification.getLocationId().oldField(),
                notification.getLocationId().newField(),
                notification.getStatus().oldField(),
                notification.getStatus().newField()
        );
    }

    @Override
    public Notification toDomain(NotificationEntity notificationEntity) {
        return new Notification(
                notificationEntity.getId(),
                notificationEntity.getEventId(),
                notificationEntity.getModifiedBy(),
                notificationEntity.getEventOwnerId(),
                notificationEntity.getNotificationCreatedAt(),
                notificationEntity.getIsRead(),
                new FieldChangeString(
                        notificationEntity.getOldName(),
                        notificationEntity.getNewName()
                ),
                new FieldChangeInteger(
                        notificationEntity.getOldMaxPlaces(),
                        notificationEntity.getNewMaxPlaces()
                ),
                new FieldChangeDateTime(
                        notificationEntity.getOldDate(),
                        notificationEntity.getNewDate()
                ),
                new FieldChangeInteger(
                        notificationEntity.getOldCost(),
                        notificationEntity.getNewCost()
                ),
                new FieldChangeInteger(
                        notificationEntity.getOldDuration(),
                        notificationEntity.getNewDuration()
                ),
                new FieldChangeLong(
                        notificationEntity.getOldLocationId(),
                        notificationEntity.getNewLocationId()
                ),
                new FieldChangeStatus(
                        notificationEntity.getOldStatus(),
                        notificationEntity.getNewStatus()
                )
        );
    }
}
