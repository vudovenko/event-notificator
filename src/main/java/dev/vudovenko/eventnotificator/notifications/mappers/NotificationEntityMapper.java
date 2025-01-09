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
                new FieldChange<>(
                        notificationEntity.getOldName(),
                        notificationEntity.getNewName()
                ),
                new FieldChange<>(
                        notificationEntity.getOldMaxPlaces(),
                        notificationEntity.getNewMaxPlaces()
                ),
                new FieldChange<>(
                        notificationEntity.getOldDate(),
                        notificationEntity.getNewDate()
                ),
                new FieldChange<>(
                        notificationEntity.getOldCost(),
                        notificationEntity.getNewCost()
                ),
                new FieldChange<>(
                        notificationEntity.getOldDuration(),
                        notificationEntity.getNewDuration()
                ),
                new FieldChange<>(
                        notificationEntity.getOldLocationId(),
                        notificationEntity.getNewLocationId()
                ),
                new FieldChange<>(
                        notificationEntity.getOldStatus(),
                        notificationEntity.getNewStatus()
                )
        );
    }
}
