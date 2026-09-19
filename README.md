# TenantTemplate

A reusable, domain-neutral multi-tenant application starter extracted from the platform foundation of StaffAlias.

## Included

- Java 21 + Spring Boot backend
- PostgreSQL + Flyway
- Session-based authentication with BCrypt passwords
- `PLATFORM_ADMIN` and tenant-scoped `TENANT_ADMIN`
- Tenant context derived from authenticated identity
- Platform APIs to create tenants and tenant administrators
- React + TypeScript + Ant Design frontend shell
- Docker/PostgreSQL local development
- GitHub Actions CI and Dependabot
- Terraform-ready GCP Cloud Run / Firebase deployment structure
- Documentation for extending the template safely

StaffAlias-specific HR concepts such as Person, Employment, employee identifiers, lifecycle events, jurisdictions, and dynamic HR fields are intentionally excluded.

## Repository layout

```
backend/                 Spring Boot API
frontend/                React application
docs/                    Architecture and bootstrap documentation
infrastructure/terraform Reusable GCP infrastructure
.github/workflows/       CI/deployment automation
```

## Local development

Copy `.env.example` to `.env`, then:

```bash
make db-up
make backend
make frontend
```

Set `TENANT_TEMPLATE_PLATFORM_ADMIN_PASSWORD` before starting the backend to bootstrap the first platform administrator.

See [Bootstrap a new application](docs/bootstrap-new-app.md) and [Architecture](docs/architecture.md).

## Template principle

Keep tenant identity, authentication, authorization, infrastructure, and deployment generic. Add business capabilities as separate domain modules and ensure every tenant-owned aggregate is scoped and tested for tenant isolation.

Source reference: https://github.com/thecodinganalyst/StaffAlias
