package dev.vudovenko.eventnotificator.notifications.scheduler.services.impl;

import dev.vudovenko.eventnotificator.notifications.repositories.NotificationRepository;
import dev.vudovenko.eventnotificator.notifications.scheduler.services.OutdatedNotificationsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OutdatedNotificationsServiceImpl implements OutdatedNotificationsService {

    private final Integer notificationTtlInDays;

    private final NotificationRepository notificationRepository;

    public OutdatedNotificationsServiceImpl(
            @Value("${scheduler.notification.ttl.days}") Integer notificationTtlInDays,
            NotificationRepository notificationRepository
    ) {
        this.notificationTtlInDays = notificationTtlInDays;
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void deleteOutdatedNotifications() {
        LocalDateTime retentionPeriodForNotifications = getRetentionPeriodForNotifications();

        notificationRepository.deleteAll(
                notificationRepository.getOutdatedNotifications(retentionPeriodForNotifications)
        );
    }

    private LocalDateTime getRetentionPeriodForNotifications() {
        LocalDateTime now = LocalDateTime.now();
        return now.minusDays(notificationTtlInDays);
    }
}
