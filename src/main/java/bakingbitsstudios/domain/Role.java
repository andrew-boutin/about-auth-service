package bakingbitsstudios.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class Role extends Resource {

    // IDE support for @SuperBuilder is lacking so we'll do the more verbose solution.
    @Builder
    public Role(final String id, final String name, final String self) {
        super(id, name, self);
    }
}