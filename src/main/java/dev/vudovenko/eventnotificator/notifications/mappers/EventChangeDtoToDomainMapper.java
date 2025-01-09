package dev.vudovenko.eventnotificator.notifications.mappers;

import dev.vudovenko.eventnotificator.common.mappers.ToDomainMapper;
import dev.vudovenko.eventnotificator.events.changes.dto.*;
import dev.vudovenko.eventnotificator.notifications.domain.Notification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EventChangeDtoToDomainMapper implements ToDomainMapper<Notification, EventChangeDto> {

    @Override
    public Notification toDomain(EventChangeDto eventChangeDto) {
        return new Notification(
                null,
                eventChangeDto.eventId(),
                eventChangeDto.modifiedBy(),
                eventChangeDto.ownerId(),
                LocalDateTime.now(),
                new FieldChange<>(
                        eventChangeDto.name().oldField(),
                        eventChangeDto.name().newField()
                ),
                new FieldChange<>(
                        eventChangeDto.maxPlaces().oldField(),
                        eventChangeDto.maxPlaces().newField()
                ),
                new FieldChange<>(
                        eventChangeDto.date().oldField(),
                        eventChangeDto.date().newField()
                ),
                new FieldChange<>(
                        eventChangeDto.cost().oldField(),
                        eventChangeDto.cost().newField()
                ),
                new FieldChange<>(
                        eventChangeDto.duration().oldField(),
                        eventChangeDto.duration().newField()
                ),
                new FieldChange<>(
                        eventChangeDto.locationId().oldField(),
                        eventChangeDto.locationId().newField()
                ),
                new FieldChange<>(
                        eventChangeDto.status().oldField(),
                        eventChangeDto.status().newField()
                )
        );
    }
}
