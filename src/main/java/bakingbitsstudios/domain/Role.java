package bakingbitsstudios.domain;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Role extends Resource {

    @NotBlank
    private final String tenantId;

    // IDE support for @SuperBuilder is lacking so we'll do the more verbose solution.
    @Builder
    public Role(final String id, final String name, final String self, final String tenantId) {
        super(id, name, self);
        this.tenantId = tenantId;
    }
}
