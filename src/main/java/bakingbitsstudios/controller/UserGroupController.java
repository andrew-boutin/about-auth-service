package bakingbitsstudios.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO: CRUDL - Requires `isSystemAdmin` or `isTenantAdmin`.
@RestController
@RequestMapping("/userGroups")
public class UserGroupController {

    /*
    id PK, tenantId, name (unique in tenant)

    - Tenant admins only see user groups from their tenant.
    - System admins can use `TenantIdQueryParam` to filter.
     */
}
