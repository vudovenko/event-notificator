package dev.vudovenko.eventnotificator.notifications.scheduler.services.impl;

import dev.vudovenko.eventnotificator.notificationAssignments.repository.NotificationAssignmentRepository;
import dev.vudovenko.eventnotificator.notifications.repositories.NotificationRepository;
import dev.vudovenko.eventnotificator.notifications.scheduler.services.OutdatedNotificationsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OutdatedNotificationsServiceImpl implements OutdatedNotificationsService {

    private final Integer notificationTtlInDays;

    private final NotificationRepository notificationRepository;
    private final NotificationAssignmentRepository notificationAssignmentRepository;

    public OutdatedNotificationsServiceImpl(
            @Value("${scheduler.notification.ttl.days}") Integer notificationTtlInDays,
            NotificationRepository notificationRepository,
            NotificationAssignmentRepository notificationAssignmentRepository
    ) {
        this.notificationTtlInDays = notificationTtlInDays;
        this.notificationRepository = notificationRepository;
        this.notificationAssignmentRepository = notificationAssignmentRepository;
    }

    @Override
    public List<Long> getOutdatedNotificationIds() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime retentionPeriodForNotifications = now.minusDays(notificationTtlInDays);
        return notificationRepository.getIdsOutdatedNotifications(retentionPeriodForNotifications);
    }

    @Override
    public void deleteOutdatedNotificationAssignments(List<Long> IdsOutdatedNotifications) {
        notificationAssignmentRepository.deleteByNotificationIdIn(IdsOutdatedNotifications);
    }
}
