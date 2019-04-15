package bakingbitsstudios.exception;

import lombok.Getter;

@Getter
abstract class EntityException extends RuntimeException {

    private final EntityType entityType;

    EntityException(final EntityType entityType) {
        this.entityType = entityType;
    }
}
