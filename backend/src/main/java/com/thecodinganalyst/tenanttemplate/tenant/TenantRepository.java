package com.thecodinganalyst.tenanttemplate.tenant;
import java.util.*; import org.springframework.data.jpa.repository.JpaRepository;
public interface TenantRepository extends JpaRepository<Tenant,UUID>{ Optional<Tenant> findByCode(String code); }