package bakingbitsstudios.controller;

import bakingbitsstudios.domain.Permission;
import bakingbitsstudios.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@RestController
@RequestMapping(value = "/permissions", produces = "application/json")
public class PermissionsController {

    private PermissionsService permissionsService;

    @Autowired
    public PermissionsController(PermissionsService permissionsService) {
        this.permissionsService = permissionsService;
    }

    @GetMapping
    public ResponseEntity<Collection<Permission>> getPermissions(HttpServletRequest httpServletRequest) {
        Collection<Permission> permissions = permissionsService.listPermissions();

        String self = httpServletRequest.getRequestURI();

        permissions.forEach(p -> p.setSelf(self + "/" + p.getId()));

        return ResponseEntity.ok().body(permissions);
    }

    @GetMapping("{permissionId}")
    public ResponseEntity<Permission> getPermission(HttpServletRequest httpServletRequest,
                                                    @NotNull @PathVariable("permissionId") String permissionId) {
        Permission p = permissionsService.getPermission(permissionId);

        String self = httpServletRequest.getRequestURI();

        p.setSelf(self);

        return ResponseEntity.ok().header(HttpHeaders.LOCATION, self).body(p);
    }
}
