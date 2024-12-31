package dev.vudovenko.eventnotificator.common.mappers;

public interface EntityMapper<Domain, Entity> extends ToDomainMapper<Domain, Entity> {

    Entity toEntity(Domain domain);
}
