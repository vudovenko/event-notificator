package dev.vudovenko.eventnotificator.events.changes.dto;

public record FieldChangeInteger(

        Integer oldField,
        Integer newField
) {
}
