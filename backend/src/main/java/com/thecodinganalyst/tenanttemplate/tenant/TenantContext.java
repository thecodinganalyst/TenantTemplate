package com.thecodinganalyst.tenanttemplate.tenant;
import java.util.UUID;
public interface TenantContext { UUID requireTenantId(); void setTenantId(UUID tenantId); void clear(); }