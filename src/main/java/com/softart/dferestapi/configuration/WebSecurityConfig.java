package com.softart.dferestapi.configuration;

import com.softart.dferestapi.components.auth.AuthTokenFilter;
import com.softart.dferestapi.constants.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
@Getter
public class WebSecurityConfig {
    private final UserDetailsService userDetailsService;
    private final AuthenticationEntryPoint authenticationEntryPoint;
    private final AuthTokenFilter authTokenFilter;

    @Autowired
    public WebSecurityConfig(
            UserDetailsService userDetailsService,
            AuthenticationEntryPoint authenticationEntryPoint,
            AuthTokenFilter authTokenFilter
    ) {
        this.userDetailsService = userDetailsService;
        this.authenticationEntryPoint = authenticationEntryPoint;
        this.authTokenFilter = authTokenFilter;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(getUserDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    @Primary
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(getAuthenticationEntryPoint())
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/api-docs/**").permitAll()
                .requestMatchers("/docs/**").permitAll()
                .requestMatchers("/swagger-ui/**").permitAll()
                .requestMatchers(HealthCheckControllerConstants.BASE_PATH + "/**").permitAll()
                .requestMatchers(AuthControllerConstants.BASE_PATH + "/**").permitAll()
                .requestMatchers(NfeControllerConstants.BASE_PATH + "/**").hasAnyRole("NFE", "ADMIN")
                .requestMatchers(NfceControllerConstants.BASE_PATH + "/**").hasAnyRole("NFCE", "ADMIN")
                .requestMatchers(CteControllerConstants.BASE_PATH + "/**").hasAnyRole("CTE", "ADMIN")
                .requestMatchers(MdfeControllerConstants.BASE_PATH + "/**").hasAnyRole("CTE", "ADMIN")
                .anyRequest()
                .authenticated();

        http.authenticationProvider(authenticationProvider());

        http.addFilterBefore(getAuthTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
