package bakingbitsstudios.exception;

public class ExistingEntity extends EntityException {

    public ExistingEntity(final EntityType entityType) {
        super(entityType);
    }
}
