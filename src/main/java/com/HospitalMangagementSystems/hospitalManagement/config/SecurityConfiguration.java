package com.HospitalMangagementSystems.hospitalManagement.config;

import com.HospitalMangagementSystems.hospitalManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private UserService userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security.authorizeRequests()
                .requestMatchers(request -> {
                    return "/patient/admit".equals(request.getServletPath()) && HttpMethod.POST.matches(request.getMethod());
                }).hasAuthority("receptionist")
                .requestMatchers(request -> {
                    return "patient/all".equals(request.getServletPath()) && HttpMethod.GET.matches(request.getMethod());
                }).hasAnyAuthority("Docter","receptionist")
                .requestMatchers(request -> {
                    return "patient/discharge".equals(request.getServletPath()) && HttpMethod.DELETE.matches(request.getMethod());
                }).hasAuthority("receptionist")
                .requestMatchers("/registration").permitAll()
                .and().httpBasic(new Customizer<HttpBasicConfigurer<HttpSecurity>>() {
                    @Override
                    public void customize(HttpBasicConfigurer<HttpSecurity> httpSecurityHttpBasicConfigurer) {

                    }
                });
        return security.build();
    }


}
