package com.thecodinganalyst.tenanttemplate.security;
import java.util.UUID; import com.thecodinganalyst.tenanttemplate.tenant.Tenant; import jakarta.persistence.*;
@Entity @Table(name="application_user")
public class ApplicationUser {
 @Id @GeneratedValue(strategy=GenerationType.UUID) private UUID id;
 @Column(nullable=false,unique=true,length=200) private String username;
 @Column(name="password_hash",nullable=false,length=100) private String passwordHash;
 @Enumerated(EnumType.STRING) @Column(nullable=false,length=32) private ApplicationRole role;
 @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="tenant_id") private Tenant tenant;
 @Column(nullable=false) private boolean enabled=true;
 protected ApplicationUser(){}
 public ApplicationUser(String u,String p,ApplicationRole r,Tenant t){
  if(r==ApplicationRole.PLATFORM_ADMIN&&t!=null)throw new IllegalArgumentException("Platform admin must not belong to a tenant");
  if(r==ApplicationRole.TENANT_ADMIN&&t==null)throw new IllegalArgumentException("Tenant admin must belong to a tenant");
  username=u;passwordHash=p;role=r;tenant=t;
 }
 public UUID getId(){return id;} public String getUsername(){return username;} public String getPasswordHash(){return passwordHash;}
 public ApplicationRole getRole(){return role;} public Tenant getTenant(){return tenant;} public boolean isEnabled(){return enabled;}
}