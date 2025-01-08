package dev.vudovenko.eventnotificator.events.changes.mappers;

import dev.vudovenko.eventnotificator.common.mappers.ToDtoMapper;
import dev.vudovenko.eventnotificator.events.changes.dto.EventChangeNotification;
import dev.vudovenko.eventnotificator.notifications.domain.Notification;
import org.springframework.stereotype.Component;

@Component
public class NotificationToEventChangeNotificationMapper implements ToDtoMapper<Notification, EventChangeNotification> {

    @Override
    public EventChangeNotification toDto(Notification notification) {
        return new EventChangeNotification(
                notification.getEventId(),
                notification.getName(),
                notification.getMaxPlaces(),
                notification.getDate(),
                notification.getCost(),
                notification.getDuration(),
                notification.getLocationId(),
                notification.getStatus()
        );
    }
}
