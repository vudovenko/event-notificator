package dev.vudovenko.eventnotificator.common.mappers;

public interface DtoMapper<Domain, DTO> extends
        ToDomainMapper<Domain, DTO>,
        ToDtoMapper<Domain, DTO> {
}
