package dev.vudovenko.eventnotificator.notifications.services.impl;

import dev.vudovenko.eventnotificator.notifications.domain.Notification;
import dev.vudovenko.eventnotificator.notifications.repositories.NotificationRepository;
import dev.vudovenko.eventnotificator.notifications.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public List<Notification> getUnreadNotifications(String login) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
