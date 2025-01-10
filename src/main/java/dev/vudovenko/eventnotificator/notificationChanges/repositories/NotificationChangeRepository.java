package dev.vudovenko.eventnotificator.notificationChanges.repositories;

import dev.vudovenko.eventnotificator.notificationChanges.entity.NotificationChangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationChangeRepository extends JpaRepository<NotificationChangeEntity, Long> {

    @Modifying
    @Query(
            """
            DELETE NotificationChangeEntity nc
            WHERE nc.notificationId IN :idsOutdatedNotifications
            """
    )
    void deleteAllByNotificationIdIn(List<Long> idsOutdatedNotifications);
}
