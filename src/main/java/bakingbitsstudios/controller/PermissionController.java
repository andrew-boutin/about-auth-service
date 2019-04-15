package bakingbitsstudios.controller;

import bakingbitsstudios.domain.Permission;
import bakingbitsstudios.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

// TODO: Requires `isSystemAdmin` or `isTenantAdmin`.
@RestController
@RequestMapping(value = "/permissions", produces = "application/json")
public class PermissionController {

    private PermissionService permissionService;

    @Autowired
    public PermissionController(PermissionService permissionsService) {
        this.permissionService = permissionsService;
    }

    @GetMapping
    public ResponseEntity<Collection<Permission>> getPermissions(HttpServletRequest httpServletRequest) {
        Collection<Permission> permissions = permissionService.listPermissions();

        String self = httpServletRequest.getRequestURI();

        permissions.forEach(p -> p.setSelf(self + "/" + p.getId()));

        return ResponseEntity.ok().body(permissions);
    }

    @GetMapping("{permissionId}")
    public ResponseEntity<Permission> getPermission(HttpServletRequest httpServletRequest,
                                                    @NotBlank @PathVariable("permissionId") String permissionId) {
        Permission p = permissionService.getPermission(permissionId);

        String self = httpServletRequest.getRequestURI();

        p.setSelf(self);

        return ResponseEntity.ok().header(HttpHeaders.LOCATION, self).body(p);
    }
}
