package dev.vudovenko.eventnotificator.events.changes.dto;

import dev.vudovenko.eventnotificator.events.statuses.EventStatus;

public record FieldChangeStatus(

        EventStatus oldField,
        EventStatus newField
) {
}
