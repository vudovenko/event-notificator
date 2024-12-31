package dev.vudovenko.eventnotificator.notifications.services.impl;

import dev.vudovenko.eventnotificator.common.mappers.EntityMapper;
import dev.vudovenko.eventnotificator.notifications.domain.Notification;
import dev.vudovenko.eventnotificator.notifications.entities.NotificationEntity;
import dev.vudovenko.eventnotificator.notifications.repositories.NotificationRepository;
import dev.vudovenko.eventnotificator.notifications.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final EntityMapper<Notification, NotificationEntity> notificationEntityMapper;

    @Override
    public Notification createNotification(Notification domain) {
        NotificationEntity notificationEntity = notificationRepository.save(
                notificationEntityMapper.toEntity(domain)
        );

        return notificationEntityMapper.toDomain(notificationEntity);
    }

    @Override
    public List<Notification> getUnreadNotifications(String login) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
