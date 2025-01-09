package dev.vudovenko.eventnotificator.notifications.repositories;

import dev.vudovenko.eventnotificator.notifications.entities.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {

    @Query(
            """
                    SELECT n
                    FROM NotificationAssignmentEntity na
                    LEFT JOIN NotificationEntity n
                    ON na.notificationId = n.id
                    WHERE na.userId = :userId AND na.isRead = false
                    """
    )
    List<NotificationEntity> getUnreadNotificationsByUserId(Long userId);

    @Query(
            """
                    SELECT n.id
                    FROM NotificationEntity n
                    WHERE n.notificationCreatedAt < :retentionPeriodForNotifications
                    """
    )
    List<Long> getIdsOutdatedNotifications(LocalDateTime retentionPeriodForNotifications);
}
