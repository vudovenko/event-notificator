package dev.vudovenko.eventnotificator.notifications.controllers;

import dev.vudovenko.eventnotificator.events.changes.dto.EventChangeNotification;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/notifications")
public class NotificationsController {

    @GetMapping
    public ResponseEntity<EventChangeNotification> getUnreadNotifications() {
        log.info("Get request for unread notifications");

        throw new UnsupportedOperationException("Not implemented yet");
    }
}
