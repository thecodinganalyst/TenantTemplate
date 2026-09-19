package com.thecodinganalyst.tenanttemplate.tenant;
import static org.junit.jupiter.api.Assertions.*; import java.util.UUID; import org.junit.jupiter.api.Test;
class ThreadLocalTenantContextTest {
 @Test void storesAndClearsTenant(){var c=new ThreadLocalTenantContext();var id=UUID.randomUUID();c.setTenantId(id);assertEquals(id,c.requireTenantId());c.clear();assertThrows(IllegalStateException.class,c::requireTenantId);}
}