package bakingbitsstudios.persistence;

import bakingbitsstudios.domain.Permission;
import bakingbitsstudios.exception.EntityType;
import bakingbitsstudios.exception.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class PermissionDao {

    private Map<String, Permission> permissions;

    public PermissionDao() {
        permissions = new HashMap<>();
        permissions.put("1", Permission.builder().id("1").name("1").build());
        permissions.put("2", Permission.builder().id("2").name("2").build());
        permissions.put("3", Permission.builder().id("3").name("3").build());
    }

    public Collection<Permission> listPermissions() {
        return permissions.values();
    }

    public Permission getPermission(final String permissionId) {
        Permission p = permissions.get(permissionId);

        if (p == null) {
            throw new NotFoundException(permissionId, EntityType.Permission);
        }

        return p;
    }
}
