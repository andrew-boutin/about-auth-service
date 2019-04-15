package bakingbitsstudios.domain;

import lombok.Builder;
import lombok.Data;

// TODO: timeCreated & timeUpdated here and spec. all other classes too.
@Data
public class Entitlement extends Resource {

    // IDE support for @SuperBuilder is lacking so we'll do the more verbose solution.
    @Builder
    public Entitlement(final String id, final String name, final String self) {
        super(id, name, self);
    }
}
