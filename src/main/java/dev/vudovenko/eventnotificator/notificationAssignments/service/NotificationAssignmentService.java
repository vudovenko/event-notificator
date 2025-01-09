package dev.vudovenko.eventnotificator.notificationAssignments.service;

import java.util.List;

public interface NotificationAssignmentService {

    void assignNotification(Long aLong, Long participantId);

    void deleteAllByNotificationIds(List<Long> IdsOutdatedNotifications);
}
