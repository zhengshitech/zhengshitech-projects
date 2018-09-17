package com.z.tech.rbac.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author H
 */
@Configuration
public class MyResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String PROTECTED_RESOURCE_ID = "myprivateapi";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(PROTECTED_RESOURCE_ID).stateless(true);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/mypublicapi/**").permitAll()
                .antMatchers("/myprivateapi/**").authenticated();
                // Since we want the protected resources to be accessible in the UI as well we need
                // session creation to be allowed (it's disabled by default in 2.0.6)
       /*
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .requestMatchers()
                .anyRequest()
                .and()
                .anonymous()
                .and()
                .authorizeRequests()
//                .antMatchers("/mypublicapi/**").access("permitAll")
//                    .antMatchers("/product/**").access("#oauth2.hasScope('select') and hasRole('ROLE_USER')")
                //配置order访问控制，必须认证过后才可以访问
                .antMatchers("/myprivateapi/**").authenticated();*/

    }
}
