# Design

A high level design of the basic resources of the system.
This covers some of the schema, endpoints, and business logic.

## Tenant

A tenant is a way to isolate groupings of resources.
Tenants are global.

    id PK, name (unique)

CRUDL - Requires `isSystemAdmin`.

## User

A single end user of the system.
Users are scoped to a tenant.

    id PK, tenantId, username (unique in tenant), isSystemAdmin, isTenantAdmin

CRUDL - Requires `isSystemAdmin` or `isTenantAdmin`.

- Only expose `isSystemAdmin` to system admins.
- System admins can use create and update to add/remove other system admins.
- Tenant admins can use create and update to add/remove other tenant admins.
- Tenant admins only see users from their tenant.
- System admins can use `TenantIdQueryParam` to filter.

## UserGroup

Used to form groups of users for easier management.
User groups are scoped to a tenant.

    id PK, tenantId, name (unique in tenant)

CRUDL - Requires `isSystemAdmin` or `isTenantAdmin`.

- Tenant admins only see user groups from their tenant.
- System admins can use `TenantIdQueryParam` to filter.

## Permission

Permissions are global.

    id PK, name (unique)

RL - Requires `isSystemAdmin` or `isTenantAdmin`.

- CUD Managed through migrations.

## Role

Used to form groups of permissions to make user to permission management easier.
Roles are scoped to a tenant.

    id PK, tenantId, name (unique in tenant)

CRUDL - Requires `isSystemAdmin` or `isTenantAdmin`.

- Tenant admins only see roles from their tenant.
- System admins can use `TenantIdQueryParam` to filter.

## Entitlement

Used to form groups of permissions to make tenant to permission management easier.
Permissions become available to tenants only if the tenant has an entitlement which allows them access to those permissions.
Entitlements are global.

    id PK, name (unique)

CRUDL - Requires `isSystemAdmin`.

## Mappings

Tenants to Users

    tenantId, userId (PK both)

Users to Roles

	userId, roleId (PK both)

Roles to Permissions

	roleId, permissionId (PK both)

Tenants to Entitlements

    tenantId, entitlementId (PK both)

Entitlements to Permissions

    entitlementId, permissionId (PK both)
