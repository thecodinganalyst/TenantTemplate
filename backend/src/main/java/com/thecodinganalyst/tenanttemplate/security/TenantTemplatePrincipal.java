package com.thecodinganalyst.tenanttemplate.security;
import java.util.*; import org.springframework.security.core.*; import org.springframework.security.core.authority.SimpleGrantedAuthority; import org.springframework.security.core.userdetails.UserDetails;
public record TenantTemplatePrincipal(UUID userId,String username,String password,ApplicationRole role,UUID tenantId,boolean enabled) implements UserDetails {
 public Collection<? extends GrantedAuthority> getAuthorities(){return List.of(new SimpleGrantedAuthority("ROLE_"+role.name()));}
 public String getPassword(){return password;} public String getUsername(){return username;}
 public boolean isAccountNonExpired(){return true;} public boolean isAccountNonLocked(){return true;} public boolean isCredentialsNonExpired(){return true;} public boolean isEnabled(){return enabled;}
}