package dev.vudovenko.eventnotificator.notifications.entities;

import dev.vudovenko.eventnotificator.notificationChanges.entity.NotificationChangeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

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
    @JoinColumn(name = "notification_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NotificationChangeEntity> fieldChanges;
}
