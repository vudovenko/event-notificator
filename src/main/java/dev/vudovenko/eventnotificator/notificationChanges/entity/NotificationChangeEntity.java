package dev.vudovenko.eventnotificator.notificationChanges.entity;

import dev.vudovenko.eventnotificator.notificationChanges.fieldNames.FieldName;
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

    @Column(name = "notification_id", nullable = false)
    private Long notificationId;

    @Enumerated(EnumType.STRING)
    @Column(name = "field_name", nullable = false)
    private FieldName fieldName;

    @Column(name = "old_value")
    private String oldValue;

    @Column(name = "new_value")
    private String newValue;
}
