package com.security.securitynewversion.config.security;

import com.security.securitynewversion.config.permission.ApplicationUserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static com.security.securitynewversion.config.permission.ApplicationUserRole.*;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig {
    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
         http.authorizeHttpRequests(authz -> authz
                 .requestMatchers("/api/v1/customers/list/**").permitAll()
                 .anyRequest().authenticated())
                 .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails  user1= User.builder()
                .username("user1")
                .password(passwordEncoder.encode("1234"))
                .roles(CUSTOMER.name())
                .build();

        UserDetails  user2= User.builder()
                .username("user2")
                .password(passwordEncoder.encode("1234"))
                .roles(MANAGER.name())
                .build();

        UserDetails  user3= User.builder()
                .username("user3")
                .password(passwordEncoder.encode("1234"))
                .roles(ADMIN.name())
                .build();
        return new InMemoryUserDetailsManager(user1,user2,user3);
    }







}
