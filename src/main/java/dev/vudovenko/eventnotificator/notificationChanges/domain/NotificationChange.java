package dev.vudovenko.eventnotificator.notificationChanges.domain;

import dev.vudovenko.eventnotificator.notificationChanges.fieldNames.FieldName;
import dev.vudovenko.eventnotificator.notifications.domain.Notification;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class NotificationChange {

    private Long id;
    private Notification notification;
    private FieldName fieldName;
    private String oldValue;
    private String newValue;
}
