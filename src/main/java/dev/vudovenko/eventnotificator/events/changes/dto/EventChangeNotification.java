package dev.vudovenko.eventnotificator.events.changes.dto;

public record EventChangeNotification(

        Long eventId,
        FieldChangeString name,
        FieldChangeInteger maxPlaces,
        FieldChangeDateTime date,
        FieldChangeInteger cost,
        FieldChangeInteger duration,
        FieldChangeLong locationId,
        FieldChangeStatus status
) {
}
