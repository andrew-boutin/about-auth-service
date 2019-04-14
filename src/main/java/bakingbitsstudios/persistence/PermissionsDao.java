package bakingbitsstudios.persistence;

import bakingbitsstudios.domain.Permission;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class PermissionsDao {

    private Map<String, Permission> permissions;

    public PermissionsDao() {
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
            throw new RuntimeException(String.format("Permission %s not found.", permissionId));
        }

        return p;
    }
}
