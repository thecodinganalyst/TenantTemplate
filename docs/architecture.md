# Architecture

TenantTemplate is a domain-neutral multi-tenant monorepo extracted from the reusable platform capabilities proven in StaffAlias.

## Security model
- `PLATFORM_ADMIN` is global and has no tenant.
- `TENANT_ADMIN` belongs to exactly one tenant.
- Tenant context is derived from the authenticated principal, never trusted from a client-supplied tenant id.
- Domain tables added by applications should include a `tenant_id` and repository/service access must scope by the authenticated tenant.

## Extension rule
Add product-specific code in new domain modules. Do not modify the tenant/security foundation merely to encode a domain concept.
