package dev.vudovenko.eventnotificator.notifications.domain;

import dev.vudovenko.eventnotificator.events.changes.dto.*;
import dev.vudovenko.eventnotificator.events.statuses.EventStatus;
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
    FieldChange<String> name;
    FieldChange<Integer> maxPlaces;
    FieldChange<LocalDateTime> date;
    FieldChange<Integer> cost;
    FieldChange<Integer> duration;
    FieldChange<Long> locationId;
    FieldChange<EventStatus> status;
}
