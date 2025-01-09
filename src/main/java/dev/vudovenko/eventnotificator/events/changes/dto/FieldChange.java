package dev.vudovenko.eventnotificator.events.changes.dto;

public record FieldChange<T>(

        T oldField,
        T newField
) {
}
