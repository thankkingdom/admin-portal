package com.example.adminportal.config

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

class SecurityConfig: WebSecurityConfigurerAdapter() {

    override fun configure(web: WebSecurity) {
        //super.configure(web)
        web.ignoring().antMatchers("/webjars/**", "/css/**")
    }

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
                .antMatchers("/loginForm").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .failureUrl("/loginForm?error")
                .defaultSuccessUrl("/customers", true)
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/loginForm")
    }
}