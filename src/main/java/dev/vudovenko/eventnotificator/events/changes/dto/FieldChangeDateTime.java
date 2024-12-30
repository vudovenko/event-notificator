package dev.vudovenko.eventnotificator.events.changes.dto;

import java.time.LocalDateTime;

public record FieldChangeDateTime(

        LocalDateTime oldField,
        LocalDateTime newField
) {
}
