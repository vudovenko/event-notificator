package dev.vudovenko.eventnotificator.notificationAssignments.service.impl;

import dev.vudovenko.eventnotificator.notificationAssignments.entity.NotificationAssignmentEntity;
import dev.vudovenko.eventnotificator.notificationAssignments.repository.NotificationAssignmentRepository;
import dev.vudovenko.eventnotificator.notificationAssignments.service.NotificationAssignmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class NotificationAssignmentServiceImpl implements NotificationAssignmentService {

    private final NotificationAssignmentRepository notificationAssignmentRepository;

    @Override
    public void assignNotification(Long notificationId, Long userId) {
        NotificationAssignmentEntity notificationAssignment = new NotificationAssignmentEntity(
                null,
                notificationId,
                userId,
                false
        );

        notificationAssignmentRepository.save(notificationAssignment);
    }

    @Override
    public void deleteAllByNotificationIds(List<Long> IdsOutdatedNotifications) {
        notificationAssignmentRepository.deleteAllByNotificationIdIn(IdsOutdatedNotifications);
    }
}
