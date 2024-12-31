package dev.vudovenko.eventnotificator.notifications.domain;

import dev.vudovenko.eventnotificator.events.changes.dto.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    private Long id;
    private Long eventId;
    private Long modifiedBy;
    private Long eventOwnerId;
    private LocalDateTime notificationCreatedAt;
    private Boolean isRead;
    FieldChangeString name;
    FieldChangeInteger maxPlaces;
    FieldChangeDateTime date;
    FieldChangeInteger cost;
    FieldChangeInteger duration;
    FieldChangeLong locationId;
    FieldChangeStatus status;

    public Notification(Long id) {
        this.id = id;
    }
}
