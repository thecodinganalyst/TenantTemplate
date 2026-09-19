# Bootstrap a new application

1. Create a repository from TenantTemplate.
2. Replace `TenantTemplate`, `tenant-template`, `tenant_template`, Java package `com.thecodinganalyst.tenanttemplate`, and `TENANT_TEMPLATE_` with the new application's names.
3. Configure PostgreSQL and set the platform-admin password through a secret store.
4. Set GCP/Firebase repository variables and secrets before enabling deployment workflows.
5. Add product domain entities behind tenant-scoped services/repositories.
6. Add tenant-isolation tests for every tenant-owned aggregate.
7. Never commit production passwords, database credentials, service-account keys, or generated Terraform state.

The template intentionally contains no StaffAlias Person, Employment, employee-id, lifecycle, jurisdiction, or HR-specific schema.
