package com.thecodinganalyst.tenanttemplate.configuration;
import java.util.Arrays; import org.springframework.beans.factory.annotation.Value; import org.springframework.context.annotation.*; import org.springframework.web.cors.*; import org.springframework.web.filter.CorsFilter;
@Configuration public class WebCorsConfiguration {
 @Bean CorsConfigurationSource corsConfigurationSource(@Value("${TENANT_TEMPLATE_ALLOWED_FRONTEND_ORIGINS:http://localhost:5173}") String origins){
  var c=new CorsConfiguration();c.setAllowedOrigins(Arrays.stream(origins.split(",")).map(String::trim).filter(s->!s.isBlank()).toList());c.setAllowedMethods(java.util.List.of("GET","POST","PUT","PATCH","DELETE","OPTIONS"));c.setAllowedHeaders(java.util.List.of("*"));c.setAllowCredentials(true);
  var source=new UrlBasedCorsConfigurationSource();source.registerCorsConfiguration("/**",c);return source;
 }
}