package dev.vudovenko.eventnotificator.notifications.services;

import dev.vudovenko.eventnotificator.notifications.domain.Notification;

import java.util.List;

public interface NotificationService {

    List<Notification> getUnreadNotifications(String login);
}
