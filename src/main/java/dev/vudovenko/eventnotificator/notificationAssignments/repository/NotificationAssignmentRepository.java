package dev.vudovenko.eventnotificator.notificationAssignments.repository;

import dev.vudovenko.eventnotificator.notificationAssignments.entity.NotificationAssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationAssignmentRepository extends JpaRepository<NotificationAssignmentEntity, Long> {
}
