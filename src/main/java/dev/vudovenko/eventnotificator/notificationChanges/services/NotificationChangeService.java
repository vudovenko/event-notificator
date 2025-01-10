package dev.vudovenko.eventnotificator.notificationChanges.services;

import dev.vudovenko.eventnotificator.notificationChanges.domain.NotificationChange;
import dev.vudovenko.eventnotificator.notificationChanges.entity.NotificationChangeEntity;

import java.util.Collection;
import java.util.List;

public interface NotificationChangeService {

    List<NotificationChangeEntity> saveNotificationChanges(Collection<NotificationChange> notificationChanges);

    void deleteAllByNotificationIds(List<Long> IdsOutdatedNotifications);
}
