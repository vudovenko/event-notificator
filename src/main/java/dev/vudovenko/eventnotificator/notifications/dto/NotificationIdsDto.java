package dev.vudovenko.eventnotificator.notifications.dto;

import java.util.List;

public record NotificationIdsDto(

        List<Long> notificationIds
) {
}
