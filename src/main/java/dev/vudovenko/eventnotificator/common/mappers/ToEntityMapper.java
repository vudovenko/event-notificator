package dev.vudovenko.eventnotificator.common.mappers;

public interface ToEntityMapper<AnotherLayer, Entity> {

    Entity toEntity(AnotherLayer anotherLayer);
}
