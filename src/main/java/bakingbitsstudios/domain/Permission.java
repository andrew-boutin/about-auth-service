package bakingbitsstudios.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class Permission extends Resource {

    // IDE support for @SuperBuilder is lacking so we'll do the more verbose solution.
    @Builder
    public Permission(final String id, final String name, final String version, final Long timeCreated,
                      final Long timeUpdated, final String self) {
        super(id, name, version, timeCreated, timeUpdated, self);
    }
}
