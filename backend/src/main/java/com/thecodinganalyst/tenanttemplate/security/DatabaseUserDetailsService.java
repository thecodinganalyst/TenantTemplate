package com.thecodinganalyst.tenanttemplate.security;
import org.springframework.security.core.userdetails.*; import org.springframework.stereotype.Service;
@Service public class DatabaseUserDetailsService implements UserDetailsService {
 private final ApplicationUserRepository repository; public DatabaseUserDetailsService(ApplicationUserRepository r){repository=r;}
 public UserDetails loadUserByUsername(String username){
  var u=repository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User not found"));
  return new TenantTemplatePrincipal(u.getId(),u.getUsername(),u.getPasswordHash(),u.getRole(),u.getTenant()==null?null:u.getTenant().getId(),u.isEnabled());
 }
}