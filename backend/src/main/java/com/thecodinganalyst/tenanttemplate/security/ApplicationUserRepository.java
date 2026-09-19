package com.thecodinganalyst.tenanttemplate.security;
import java.util.*; import org.springframework.data.jpa.repository.JpaRepository;
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser,UUID>{ Optional<ApplicationUser> findByUsername(String username); }