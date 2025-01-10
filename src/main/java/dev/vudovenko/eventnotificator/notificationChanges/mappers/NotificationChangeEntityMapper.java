package dev.vudovenko.eventnotificator.notificationChanges.mappers;

import dev.vudovenko.eventnotificator.common.mappers.EntityMapper;
import dev.vudovenko.eventnotificator.notificationChanges.domain.NotificationChange;
import dev.vudovenko.eventnotificator.notificationChanges.entity.NotificationChangeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationChangeEntityMapper
        implements EntityMapper<NotificationChange, NotificationChangeEntity> {

    @Override
    public NotificationChange toDomain(NotificationChangeEntity notificationChangeEntity) {
        return new NotificationChange(
                notificationChangeEntity.getId(),
                null,
                notificationChangeEntity.getFieldName(),
                notificationChangeEntity.getOldValue(),
                notificationChangeEntity.getNewValue()
        );
    }

    @Override
    public NotificationChangeEntity toEntity(NotificationChange notificationChange) {
        return new NotificationChangeEntity(
                notificationChange.getId(),
                null,
                notificationChange.getFieldName(),
                notificationChange.getOldValue(),
                notificationChange.getNewValue()
        );
    }
}
