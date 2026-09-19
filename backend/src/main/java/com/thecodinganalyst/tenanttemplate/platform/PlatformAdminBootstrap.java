package com.thecodinganalyst.tenanttemplate.platform;
import com.thecodinganalyst.tenanttemplate.security.*; import org.springframework.beans.factory.annotation.Value; import org.springframework.boot.CommandLineRunner; import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.stereotype.Component;
@Component public class PlatformAdminBootstrap implements CommandLineRunner {
 private final ApplicationUserRepository users; private final PasswordEncoder encoder; private final String username,password;
 public PlatformAdminBootstrap(ApplicationUserRepository u,PasswordEncoder e,@Value("${TENANT_TEMPLATE_PLATFORM_ADMIN_USERNAME:platformadmin}") String n,@Value("${TENANT_TEMPLATE_PLATFORM_ADMIN_PASSWORD:}") String p){users=u;encoder=e;username=n;password=p;}
 public void run(String...args){if(password==null||password.isBlank())return;if(users.findByUsername(username).isEmpty())users.save(new ApplicationUser(username,encoder.encode(password),ApplicationRole.PLATFORM_ADMIN,null));}
}