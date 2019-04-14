package bakingbitsstudios.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotFoundException extends RuntimeException {

    private final String id;
    private final ResourceType resourceType;

    public NotFoundException(final String id, final ResourceType resourceType) {
        this.id = id;
        this.resourceType = resourceType;
    }

    public enum ResourceType {
        Permission
    }
}
