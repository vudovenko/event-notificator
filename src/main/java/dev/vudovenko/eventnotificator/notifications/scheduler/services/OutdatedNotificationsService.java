package dev.vudovenko.eventnotificator.notifications.scheduler.services;

import java.util.List;

public interface OutdatedNotificationsService {

    List<Long> getOutdatedNotificationIds();

    void deleteOutdatedNotificationAssignments(List<Long> idsOfDeletedOutdatedNotifications);
}
