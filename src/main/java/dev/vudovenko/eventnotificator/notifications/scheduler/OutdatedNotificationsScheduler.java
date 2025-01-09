package dev.vudovenko.eventnotificator.notifications.scheduler;

import dev.vudovenko.eventnotificator.notifications.scheduler.services.OutdatedNotificationsService;
import dev.vudovenko.eventnotificator.notifications.services.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class OutdatedNotificationsScheduler {

    private final OutdatedNotificationsService outdatedNotificationsService;
    private final NotificationService notificationService;

    @Transactional
    @Scheduled(fixedRateString = "${scheduler.notification.period.ISO}")
    public void deleteOutdatedNotifications() {
        log.info("Deleting outdated notifications");

        List<Long> IdsOutdatedNotifications = outdatedNotificationsService.getOutdatedNotificationIds();
        outdatedNotificationsService.deleteOutdatedNotificationAssignments(IdsOutdatedNotifications);
        notificationService.deleteAll(IdsOutdatedNotifications);
    }
}
