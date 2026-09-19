variable "project_id" { type = string }
variable "region" { type = string default = "asia-southeast1" }
variable "cloud_run_service_name" { type = string }
variable "container_image" { type = string }
variable "database_url_secret_name" { type = string default = "tenant-template-db-url" }
variable "database_user_secret_name" { type = string default = "tenant-template-db-user" }
variable "database_password_secret_name" { type = string default = "tenant-template-db-password" }
variable "platform_admin_password_secret_name" { type = string default = "tenant-template-platform-admin-password" }
