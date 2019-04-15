package bakingbitsstudios.service;

import bakingbitsstudios.domain.Permission;
import bakingbitsstudios.persistence.PermissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PermissionService {

    private PermissionDao permissionDao;

    @Autowired
    public PermissionService(PermissionDao permissionsDao) {
        this.permissionDao = permissionsDao;
    }

    public Collection<Permission> listPermissions() {
        return permissionDao.listPermissions();
    }

    public Permission getPermission(final String permissionId) {
        return permissionDao.getPermission(permissionId);
    }
}
