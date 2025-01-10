package dev.vudovenko.eventnotificator.notifications.scheduler;

import dev.vudovenko.eventnotificator.notifications.scheduler.services.OutdatedNotificationsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@RequiredArgsConstructor
public class OutdatedNotificationsScheduler {

    private final OutdatedNotificationsService outdatedNotificationsService;

    @Transactional
    @Scheduled(fixedRateString = "${scheduler.notification.period.ISO}")
    public void deleteOutdatedNotifications() {
        log.info("Deleting outdated notifications");

        outdatedNotificationsService.deleteOutdatedNotifications();
    }
}
