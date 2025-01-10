package dev.vudovenko.eventnotificator.notificationChanges.services.impl;

import dev.vudovenko.eventnotificator.common.mappers.EntityMapper;
import dev.vudovenko.eventnotificator.notificationChanges.domain.NotificationChange;
import dev.vudovenko.eventnotificator.notificationChanges.entity.NotificationChangeEntity;
import dev.vudovenko.eventnotificator.notificationChanges.repositories.NotificationChangeRepository;
import dev.vudovenko.eventnotificator.notificationChanges.services.NotificationChangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationChangeServiceImpl implements NotificationChangeService {

    private final NotificationChangeRepository notificationChangeRepository;

    private final EntityMapper<NotificationChange, NotificationChangeEntity> notificationChangeEntityMapper;

    @Override
    public List<NotificationChangeEntity> saveNotificationChanges(Collection<NotificationChange> notificationChanges) {
        return notificationChangeRepository.saveAll(
                notificationChanges.stream()
                        .map(notificationChangeEntityMapper::toEntity)
                        .toList()
        );
    }

    @Override
    public void deleteAllByNotificationIds(List<Long> IdsOutdatedNotifications) {
        notificationChangeRepository.deleteAllByNotificationIdIn(IdsOutdatedNotifications);
    }
}
