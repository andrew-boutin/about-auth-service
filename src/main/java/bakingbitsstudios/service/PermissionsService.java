package bakingbitsstudios.service;

import bakingbitsstudios.domain.Permission;
import bakingbitsstudios.persistence.PermissionsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PermissionsService {

    private PermissionsDao permissionsDao;

    @Autowired
    public PermissionsService(PermissionsDao permissionsDao) {
        this.permissionsDao = permissionsDao;
    }

    public Collection<Permission> listPermissions() {
        return permissionsDao.listPermissions();
    }

    public Permission getPermission(final String permissionId) {
        return permissionsDao.getPermission(permissionId);
    }
}
