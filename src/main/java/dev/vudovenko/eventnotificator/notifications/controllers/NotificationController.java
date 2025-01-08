package dev.vudovenko.eventnotificator.notifications.controllers;

import dev.vudovenko.eventnotificator.common.mappers.ToDtoMapper;
import dev.vudovenko.eventnotificator.events.changes.dto.EventChangeNotification;
import dev.vudovenko.eventnotificator.notifications.domain.Notification;
import dev.vudovenko.eventnotificator.notifications.services.NotificationService;
import dev.vudovenko.eventnotificator.users.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;
    private final ToDtoMapper<Notification, EventChangeNotification> notificationToEventChangeNotificationMapper;

    @GetMapping
    public ResponseEntity<List<EventChangeNotification>> getUnreadNotifications(
            @AuthenticationPrincipal User user
    ) {
        log.info("Get request for unread notifications");

        List<Notification> notifications = notificationService.getUnreadNotifications(
                user.getId()
        );

        List<EventChangeNotification> eventChangeNotifications = notifications.stream()
                .map(notificationToEventChangeNotificationMapper::toDto)
                .toList();

        return ResponseEntity.ok(eventChangeNotifications);
    }
}
