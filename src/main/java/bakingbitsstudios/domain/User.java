package bakingbitsstudios.domain;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class User extends Resource {

    @NotBlank
    private final String tenantId;

    private final Boolean isSystemAdmin;

    private final Boolean isTenantAdmin;

    // IDE support for @SuperBuilder is lacking so we'll do the more verbose solution.
    @Builder
    public User(final String id, final String name, final String self, final String tenantId,
                final Boolean isSystemAdmin, final Boolean isTenantAdmin) {
        super(id, name, self);
        this.tenantId = tenantId;
        this.isSystemAdmin = isSystemAdmin;
        this.isTenantAdmin = isTenantAdmin;
    }
}
