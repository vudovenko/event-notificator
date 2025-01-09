package dev.vudovenko.eventnotificator.notificationChanges.domain;

import dev.vudovenko.eventnotificator.notificationChanges.fieldNames.FieldName;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class NotificationChange {

    private Long id;
    private Long notificationId;
    private FieldName fieldName;
    private String oldValue;
    private String newValue;
}
