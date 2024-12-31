package dev.vudovenko.eventnotificator.notifications.entities;

import dev.vudovenko.eventnotificator.events.statuses.EventStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "notifications", schema = "public", catalog = "postgres")
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "event_id", nullable = false)
    private Long eventId;

    @Column(name = "modified_by")
    private Long modifiedBy;

    @Column(name = "event_owner_id")
    private Long eventOwnerId;

    @Column(name = "notification_created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime notificationCreatedAt;

    @Column(name = "is_read")
    private Boolean isRead;

    @Column(name = "old_name")
    private String oldName;

    @Column(name = "new_name")
    private String newName;

    @Column(name = "old_max_places")
    private Integer oldMaxPlaces;

    @Column(name = "new_max_places")
    private Integer newMaxPlaces;

    @Column(name = "old_date", columnDefinition = "TIMESTAMP")
    private LocalDateTime oldDate;

    @Column(name = "new_date", columnDefinition = "TIMESTAMP")
    private LocalDateTime newDate;

    @Column(name = "old_cost")
    private Integer oldCost;

    @Column(name = "new_cost")
    private Integer newCost;

    @Column(name = "old_duration")
    private Integer oldDuration;

    @Column(name = "new_duration")
    private Integer newDuration;

    @Column(name = "old_location_id")
    private Long oldLocationId;

    @Column(name = "new_location_id")
    private Long newLocationId;

    @Enumerated(EnumType.STRING)
    @Column(name = "old_status")
    private EventStatus oldStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "new_status")
    private EventStatus newStatus;
}
