package dev.vudovenko.eventnotificator.notifications.repositories;

import dev.vudovenko.eventnotificator.notifications.entities.NotificationEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {

    @EntityGraph(attributePaths = {"fieldChanges"})
    @Query(
            """
                    SELECT n
                    FROM NotificationAssignmentEntity na
                    LEFT JOIN NotificationEntity n
                    ON na.notification.id = n.id
                    WHERE na.userId = :userId AND na.isRead = false
                    """
    )
    List<NotificationEntity> getUnreadNotificationsByUserId(Long userId);

    @EntityGraph(value = "notification-with-assignments-and-changes")
    @Query(
            """
                    SELECT n
                    FROM NotificationEntity n
                    WHERE n.notificationCreatedAt < :retentionPeriodForNotifications
                    """
    )
    List<NotificationEntity> getOutdatedNotifications(LocalDateTime retentionPeriodForNotifications);
}
