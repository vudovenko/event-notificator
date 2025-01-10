package dev.vudovenko.eventnotificator.notificationAssignments.entity;

import dev.vudovenko.eventnotificator.notifications.entities.NotificationEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "notification_assignments", schema = "public", catalog = "postgres")
public class NotificationAssignmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "notification_id", referencedColumnName = "id", nullable = false)
    private NotificationEntity notification;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "is_read")
    private Boolean isRead;
}
