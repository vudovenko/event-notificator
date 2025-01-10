package dev.vudovenko.eventnotificator.notificationAssignments.domain;

import dev.vudovenko.eventnotificator.notifications.domain.Notification;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class NotificationAssignment {

    private Long id;
    private Notification notification;
    private Long userId;
    private Boolean isRead;
}
