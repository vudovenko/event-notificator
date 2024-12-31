package dev.vudovenko.eventnotificator.notificationAssignments.domain;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class NotificationAssignment {

    private Long id;
    private Long notificationId;
    private Long userId;
}
