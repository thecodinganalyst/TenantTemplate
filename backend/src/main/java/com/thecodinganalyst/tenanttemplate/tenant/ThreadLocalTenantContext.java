package com.thecodinganalyst.tenanttemplate.tenant;
import java.util.UUID; import org.springframework.stereotype.Component;
@Component public class ThreadLocalTenantContext implements TenantContext {
 private static final ThreadLocal<UUID> CURRENT=new ThreadLocal<>();
 public UUID requireTenantId(){var id=CURRENT.get();if(id==null)throw new IllegalStateException("Tenant context has not been established");return id;}
 public void setTenantId(UUID id){CURRENT.set(id);} public void clear(){CURRENT.remove();}
}