package bakingbitsstudios.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO: CRUDL - Requires `isSystemAdmin` or `isTenantAdmin`.
@RestController
@RequestMapping("/users")
public class UserController {

    /*
    id PK, tenantId, username (unique in tenant), isSystemAdmin, isTenantAdmin

    - Only expose `isSystemAdmin` to system admins.
    - System admins can use create and update to add/remove other system admins.
    - Tenant admins can use create and update to add/remove other tenant admins.
    - Tenant admins only see users from their tenant.
    - System admins can use `TenantIdQueryParam` to filter.
     */
}
