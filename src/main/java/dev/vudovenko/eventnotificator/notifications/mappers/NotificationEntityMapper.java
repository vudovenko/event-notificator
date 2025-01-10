package dev.vudovenko.eventnotificator.notifications.mappers;

import dev.vudovenko.eventnotificator.common.mappers.EntityMapper;
import dev.vudovenko.eventnotificator.events.changes.dto.FieldChange;
import dev.vudovenko.eventnotificator.events.statuses.EventStatus;
import dev.vudovenko.eventnotificator.notificationChanges.domain.NotificationChange;
import dev.vudovenko.eventnotificator.notificationChanges.entity.NotificationChangeEntity;
import dev.vudovenko.eventnotificator.notificationChanges.fieldNames.FieldName;
import dev.vudovenko.eventnotificator.notifications.domain.Notification;
import dev.vudovenko.eventnotificator.notifications.entities.NotificationEntity;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class NotificationEntityMapper implements EntityMapper<Notification, NotificationEntity> {

    private final EntityMapper<NotificationChange, NotificationChangeEntity> notificationChangeEntityMapper;

    @Override
    public NotificationEntity toEntity(Notification notification) {
        NotificationEntity notificationEntity = new NotificationEntity(
                notification.getId(),
                notification.getEventId(),
                notification.getModifiedBy(),
                notification.getEventOwnerId(),
                notification.getNotificationCreatedAt(),
                Set.of(),
                List.of()
        );

        List<NotificationChangeEntity> changes = new ArrayList<>();

        if (notification.getName() != null) {
            changes.add(
                    createChangeEntity(
                            notificationEntity,
                            FieldName.NAME,
                            notification.getName().oldField(),
                            notification.getName().newField()
                    )
            );
        }

        // 2) maxPlaces
        if (notification.getMaxPlaces() != null) {
            changes.add(
                    createChangeEntity(
                            notificationEntity,
                            FieldName.MAX_PLACES,
                            notification.getMaxPlaces().oldField(),
                            notification.getMaxPlaces().newField()
                    )
            );
        }

        // 3) date
        if (notification.getDate() != null) {
            changes.add(
                    createChangeEntity(
                            notificationEntity,
                            FieldName.DATE,
                            notification.getDate().oldField(),
                            notification.getDate().newField()
                    )
            );
        }

        // 4) cost
        if (notification.getCost() != null) {
            changes.add(
                    createChangeEntity(
                            notificationEntity,
                            FieldName.COST,
                            notification.getCost().oldField(),
                            notification.getCost().newField()
                    )
            );
        }

        // 5) duration
        if (notification.getDuration() != null) {
            changes.add(
                    createChangeEntity(
                            notificationEntity,
                            FieldName.DURATION,
                            notification.getDuration().oldField(),
                            notification.getDuration().newField()
                    )
            );
        }

        // 6) locationId
        if (notification.getLocationId() != null) {
            changes.add(
                    createChangeEntity(
                            notificationEntity,
                            FieldName.LOCATION_ID,
                            notification.getLocationId().oldField(),
                            notification.getLocationId().newField()
                    )
            );
        }

        // 7) status
        if (notification.getStatus() != null) {
            changes.add(
                    createChangeEntity(
                            notificationEntity,
                            FieldName.STATUS,
                            notification.getStatus().oldField() != null
                                    ? notification.getStatus().oldField().name()
                                    : null,
                            notification.getStatus().newField() != null
                                    ? notification.getStatus().newField().name()
                                    : null
                    )
            );
        }

        notificationEntity.setFieldChanges(changes);

        return notificationEntity;
    }

    private NotificationChangeEntity createChangeEntity(
            NotificationEntity notificationEntity,
            FieldName fieldName,
            Object oldValue,
            Object newValue
    ) {
        return new NotificationChangeEntity(
                null,
                notificationEntity,
                fieldName,
                oldValue != null ? oldValue.toString() : null,
                newValue != null ? newValue.toString() : null
        );
    }

    @Override
    public Notification toDomain(NotificationEntity notificationEntity) {
        Map<FieldName, NotificationChange> fieldChanges =
                Hibernate.isInitialized(notificationEntity.getFieldChanges())
                        ? notificationEntity.getFieldChanges().stream()
                        .collect(
                                Collectors.toMap(
                                        NotificationChangeEntity::getFieldName,
                                        notificationChangeEntityMapper::toDomain
                                )
                        )
                        : Collections.emptyMap();
        return new Notification(
                notificationEntity.getId(),
                notificationEntity.getEventId(),
                notificationEntity.getModifiedBy(),
                notificationEntity.getEventOwnerId(),
                notificationEntity.getNotificationCreatedAt(),

                // name
                makeFieldChangeString(fieldChanges.get(FieldName.NAME)),

                // maxPlaces
                makeFieldChangeInteger(fieldChanges.get(FieldName.MAX_PLACES)),

                // date
                makeFieldChangeLocalDateTime(fieldChanges.get(FieldName.DATE)),

                // cost
                makeFieldChangeInteger(fieldChanges.get(FieldName.COST)),

                // duration
                makeFieldChangeInteger(fieldChanges.get(FieldName.DURATION)),

                // locationId
                makeFieldChangeLong(fieldChanges.get(FieldName.LOCATION_ID)),

                // status
                makeFieldChangeEventStatus(fieldChanges.get(FieldName.STATUS))
        );
    }

    private FieldChange<String> makeFieldChangeString(NotificationChange change) {
        if (change == null) {
            return null;
        }
        return new FieldChange<>(change.getOldValue(), change.getNewValue());
    }

    private FieldChange<Integer> makeFieldChangeInteger(NotificationChange change) {
        if (change == null) {
            return null;
        }
        return new FieldChange<>(
                change.getOldValue() != null ? Integer.valueOf(change.getOldValue()) : null,
                change.getNewValue() != null ? Integer.valueOf(change.getNewValue()) : null
        );
    }

    private FieldChange<Long> makeFieldChangeLong(NotificationChange change) {
        if (change == null) {
            return null;
        }
        return new FieldChange<>(
                change.getOldValue() != null ? Long.valueOf(change.getOldValue()) : null,
                change.getNewValue() != null ? Long.valueOf(change.getNewValue()) : null
        );
    }

    private FieldChange<LocalDateTime> makeFieldChangeLocalDateTime(NotificationChange change) {
        if (change == null) {
            return null;
        }
        return new FieldChange<>(
                change.getOldValue() != null ? LocalDateTime.parse(change.getOldValue()) : null,
                change.getNewValue() != null ? LocalDateTime.parse(change.getNewValue()) : null
        );
    }

    private FieldChange<EventStatus> makeFieldChangeEventStatus(NotificationChange change) {
        if (change == null) {
            return null;
        }
        return new FieldChange<>(
                change.getOldValue() != null ? EventStatus.valueOf(change.getOldValue()) : null,
                change.getNewValue() != null ? EventStatus.valueOf(change.getNewValue()) : null
        );
    }
}
