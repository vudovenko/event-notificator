package dev.vudovenko.eventnotificator.common.mappers;

public interface ToDtoMapper<AnotherLayer, Dto> {

    Dto toDto(AnotherLayer anotherLayer);
}
