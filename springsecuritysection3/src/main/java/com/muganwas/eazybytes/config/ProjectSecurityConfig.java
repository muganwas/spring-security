package com.muganwas.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> configurer
                .requestMatchers("/myAccounts", "/myBalance", "/myLoans", "/myCards")
                .authenticated()
                .requestMatchers("/contact", "/notices").permitAll());
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("Japheth")
                .password("dev1234.")
                .authorities("admin")
                .build();
        UserDetails user_1 = User.withDefaultPasswordEncoder()
                .username("Cleo")
                .password("dev1234.")
                .authorities("user")
                .build();
        return new InMemoryUserDetailsManager(admin, user_1);
    }
}
