package dev.vudovenko.eventnotificator.notifications.services.impl;

import dev.vudovenko.eventnotificator.common.mappers.EntityMapper;
import dev.vudovenko.eventnotificator.notificationAssignments.repository.NotificationAssignmentRepository;
import dev.vudovenko.eventnotificator.notifications.domain.Notification;
import dev.vudovenko.eventnotificator.notifications.entities.NotificationEntity;
import dev.vudovenko.eventnotificator.notifications.repositories.NotificationRepository;
import dev.vudovenko.eventnotificator.notifications.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationAssignmentRepository notificationAssignmentRepository;

    private final EntityMapper<Notification, NotificationEntity> notificationEntityMapper;

    @Override
    public Notification createNotification(Notification notification) {
        NotificationEntity notificationEntity = notificationRepository.save(
                notificationEntityMapper.toEntity(notification)
        );

        return notificationEntityMapper.toDomain(notificationEntity);
    }

    @Transactional
    @Override
    public List<Notification> getUnreadNotifications(Long userId) {
        List<NotificationEntity> unreadNotifications
                = notificationRepository.getUnreadNotificationsByUserId(userId);

        /*notificationAssignmentRepository.markNotificationsAsRead(
                userId,
                unreadNotifications.stream()
                        .map(NotificationEntity::getId)
                        .toList()
        );*/

        return unreadNotifications.stream()
                .map(notificationEntityMapper::toDomain)
                .toList();
    }
}
