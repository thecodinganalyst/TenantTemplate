resource "google_project_service" "services" { for_each = toset(["run.googleapis.com","artifactregistry.googleapis.com","secretmanager.googleapis.com"]) project=var.project_id service=each.value disable_on_destroy=false }
resource "google_secret_manager_secret" "app" { for_each=toset([var.database_url_secret_name,var.database_user_secret_name,var.database_password_secret_name,var.platform_admin_password_secret_name]) secret_id=each.value replication { auto {} } depends_on=[google_project_service.services] }
resource "google_cloud_run_v2_service" "api" {
 name=var.cloud_run_service_name location=var.region depends_on=[google_project_service.services]
 template { containers { image=var.container_image
  env { name="SPRING_PROFILES_ACTIVE" value="prod" }
  env { name="TENANT_TEMPLATE_DB_URL" value_source { secret_key_ref { secret=var.database_url_secret_name version="latest" } } }
  env { name="TENANT_TEMPLATE_DB_USER" value_source { secret_key_ref { secret=var.database_user_secret_name version="latest" } } }
  env { name="TENANT_TEMPLATE_DB_PASSWORD" value_source { secret_key_ref { secret=var.database_password_secret_name version="latest" } } }
  env { name="TENANT_TEMPLATE_PLATFORM_ADMIN_PASSWORD" value_source { secret_key_ref { secret=var.platform_admin_password_secret_name version="latest" } } }
 } }
}
