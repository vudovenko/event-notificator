package dev.vudovenko.eventnotificator.notifications.controllers;

import dev.vudovenko.eventnotificator.common.mappers.ToDtoMapper;
import dev.vudovenko.eventnotificator.events.changes.dto.EventChangeNotification;
import dev.vudovenko.eventnotificator.notifications.domain.Notification;
import dev.vudovenko.eventnotificator.notifications.dto.NotificationIdsDto;
import dev.vudovenko.eventnotificator.notifications.services.NotificationService;
import dev.vudovenko.eventnotificator.users.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
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
                .sorted(Comparator.comparingLong(EventChangeNotification::eventId))
                .toList();

        return ResponseEntity.ok(eventChangeNotifications);
    }

    @PostMapping
    public ResponseEntity<Void> markNotificationsAsRead(
            @AuthenticationPrincipal User user,
            @RequestBody NotificationIdsDto notificationIdsDto
    ) {
        log.info("Get request for marking notifications as read");

        notificationService.markNotificationsAsRead(
                user.getId(),
                notificationIdsDto.notificationIds()
        );

        return ResponseEntity.ok().build();
    }
}
