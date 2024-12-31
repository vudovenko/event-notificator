package dev.vudovenko.eventnotificator.common.mappers;

public interface ToDomainMapper<Domain, AnotherLayer> {

    Domain toDomain(AnotherLayer anotherLayer);
}
