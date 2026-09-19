package com.thecodinganalyst.tenanttemplate.tenant;
import java.time.OffsetDateTime; import java.util.UUID; import jakarta.persistence.*;
@Entity @Table(name="tenant")
public class Tenant {
 @Id @GeneratedValue(strategy=GenerationType.UUID) private UUID id;
 @Column(nullable=false,unique=true,length=64) private String code;
 @Column(nullable=false,length=200) private String name;
 @Column(name="created_at",nullable=false) private OffsetDateTime createdAt=OffsetDateTime.now();
 protected Tenant(){} public Tenant(String code,String name){this.code=code;this.name=name;}
 public UUID getId(){return id;} public String getCode(){return code;} public String getName(){return name;}
}