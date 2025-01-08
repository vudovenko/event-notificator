package dev.vudovenko.eventnotificator.notificationAssignments.repository;

import dev.vudovenko.eventnotificator.notificationAssignments.entity.NotificationAssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationAssignmentRepository extends JpaRepository<NotificationAssignmentEntity, Long> {

    @Modifying
    @Query(
            """
                    UPDATE NotificationAssignmentEntity na
                    SET na.isRead = true
                    WHERE na.notificationId IN :notificationIds
                    AND na.userId = :userId
                    """
    )
    void markNotificationsAsRead(Long userId, List<Long> notificationIds);
}
