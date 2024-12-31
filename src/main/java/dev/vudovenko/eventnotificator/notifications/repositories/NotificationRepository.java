package dev.vudovenko.eventnotificator.notifications.repositories;

import dev.vudovenko.eventnotificator.notifications.entities.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {
}
