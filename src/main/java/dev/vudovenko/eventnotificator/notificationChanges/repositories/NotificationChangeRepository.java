package dev.vudovenko.eventnotificator.notificationChanges.repositories;

import dev.vudovenko.eventnotificator.notificationChanges.entity.NotificationChangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationChangeRepository extends JpaRepository<NotificationChangeEntity, Long> {
}
