package dev.vudovenko.eventnotificator.notificationChanges.entity;

import dev.vudovenko.eventnotificator.notificationChanges.fieldNames.FieldName;
import dev.vudovenko.eventnotificator.notifications.entities.NotificationEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "notification_changes", schema = "public", catalog = "postgres")
public class NotificationChangeEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "notification_id", referencedColumnName = "id", nullable = false)
    private NotificationEntity notification;

    @Enumerated(EnumType.STRING)
    @Column(name = "field_name", nullable = false)
    private FieldName fieldName;

    @Column(name = "old_value")
    private String oldValue;

    @Column(name = "new_value")
    private String newValue;
}
