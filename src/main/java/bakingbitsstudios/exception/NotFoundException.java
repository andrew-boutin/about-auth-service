package bakingbitsstudios.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends EntityException {

    private final String id;

    public NotFoundException(final String id, final EntityType entityType) {
        super(entityType);
        this.id = id;
    }
}
