package com.thecodinganalyst.tenanttemplate.tenant;
import java.util.UUID; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/tenant") public class TenantController {
 private final TenantContext context; private final TenantRepository tenants; public TenantController(TenantContext c,TenantRepository t){context=c;tenants=t;}
 @GetMapping("/me") public TenantResponse me(){var t=tenants.findById(context.requireTenantId()).orElseThrow();return new TenantResponse(t.getId(),t.getCode(),t.getName());}
 public record TenantResponse(UUID id,String code,String name){}
}