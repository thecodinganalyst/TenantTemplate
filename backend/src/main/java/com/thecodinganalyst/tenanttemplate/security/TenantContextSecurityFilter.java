package com.thecodinganalyst.tenanttemplate.security;
import java.io.IOException; import com.thecodinganalyst.tenanttemplate.tenant.TenantContext; import jakarta.servlet.*; import jakarta.servlet.http.*; import org.springframework.security.core.context.SecurityContextHolder; import org.springframework.stereotype.Component; import org.springframework.web.filter.OncePerRequestFilter;
@Component public class TenantContextSecurityFilter extends OncePerRequestFilter {
 private final TenantContext context; public TenantContextSecurityFilter(TenantContext c){context=c;}
 protected void doFilterInternal(HttpServletRequest req,HttpServletResponse res,FilterChain chain)throws ServletException,IOException{
  try{var a=SecurityContextHolder.getContext().getAuthentication();if(a!=null&&a.isAuthenticated()&&a.getPrincipal() instanceof TenantTemplatePrincipal p&&p.role()==ApplicationRole.TENANT_ADMIN){if(p.tenantId()==null){res.sendError(403,"Tenant administrator has no tenant");return;}context.setTenantId(p.tenantId());}chain.doFilter(req,res);}finally{context.clear();}
 }
}