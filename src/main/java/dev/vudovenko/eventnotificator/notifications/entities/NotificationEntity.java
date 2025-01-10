package dev.vudovenko.eventnotificator.notifications.entities;

import dev.vudovenko.eventnotificator.notificationAssignments.entity.NotificationAssignmentEntity;
import dev.vudovenko.eventnotificator.notificationChanges.entity.NotificationChangeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NamedEntityGraph(
        name = "notification-with-assignments-and-changes",
        attributeNodes = {
                @NamedAttributeNode("notificationAssignments"),
                @NamedAttributeNode("fieldChanges")
        }
)
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

    @ToString.Exclude
    @OneToMany(mappedBy = "notification", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<NotificationAssignmentEntity> notificationAssignments = new HashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "notification", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NotificationChangeEntity> fieldChanges = new ArrayList<>();
}
