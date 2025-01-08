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
                new FieldChangeString(
                        eventChangeDto.name().oldField(),
                        eventChangeDto.name().newField()
                ),
                new FieldChangeInteger(
                        eventChangeDto.maxPlaces().oldField(),
                        eventChangeDto.maxPlaces().newField()
                ),
                new FieldChangeDateTime(
                        eventChangeDto.date().oldField(),
                        eventChangeDto.date().newField()
                ),
                new FieldChangeInteger(
                        eventChangeDto.cost().oldField(),
                        eventChangeDto.cost().newField()
                ),
                new FieldChangeInteger(
                        eventChangeDto.duration().oldField(),
                        eventChangeDto.duration().newField()
                ),
                new FieldChangeLong(
                        eventChangeDto.locationId().oldField(),
                        eventChangeDto.locationId().newField()
                ),
                new FieldChangeStatus(
                        eventChangeDto.status().oldField(),
                        eventChangeDto.status().newField()
                )
        );
    }
}
