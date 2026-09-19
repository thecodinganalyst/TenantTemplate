package com.thecodinganalyst.tenanttemplate.security;
import static org.junit.jupiter.api.Assertions.*; import com.thecodinganalyst.tenanttemplate.tenant.Tenant; import org.junit.jupiter.api.Test;
class ApplicationUserTest {
 @Test void platformAdminCannotHaveTenant(){assertThrows(IllegalArgumentException.class,()->new ApplicationUser("p","hash",ApplicationRole.PLATFORM_ADMIN,new Tenant("T","Tenant")));}
 @Test void tenantAdminRequiresTenant(){assertThrows(IllegalArgumentException.class,()->new ApplicationUser("t","hash",ApplicationRole.TENANT_ADMIN,null));}
}