package com.psuti.Zhalnin.security;

import com.psuti.Zhalnin.service.token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfig {
    private final UserDetailsService userDetailsService;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtRequestFilter jwtRequestFilter;
    @Autowired
    public WebSecurityConfig(UserDetailsService userDetailsService,
                             JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
                             JwtRequestFilter jwtRequestFilter) {
        this.userDetailsService = userDetailsService;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtRequestFilter = jwtRequestFilter;
    }
    @Bean
    SecurityFilterChain web(HttpSecurity http, SuccessLogoutHandlerImpl successLogoutHandler) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests(
                        (authorize) -> authorize
                                .antMatchers("/auth/login", "/auth/reg").permitAll()
                                .antMatchers(HttpMethod.POST,"/users").hasRole("ADMIN")
                                .antMatchers(HttpMethod.POST,"/users").hasRole("MODERATOR")
                                .antMatchers(HttpMethod.PUT,"/users/*").hasRole("ADMIN")
                                .antMatchers(HttpMethod.PUT,"/users/*").hasRole("MODERATOR")
                                .antMatchers(HttpMethod.DELETE,"/users/*").hasRole("ADMIN")
                                .antMatchers(HttpMethod.DELETE,"/users/*").hasRole("MODERATOR")
                                .antMatchers(HttpMethod.GET,"/users").permitAll()
                                .antMatchers(HttpMethod.GET,"/users/*").permitAll()
                                .antMatchers(HttpMethod.GET,"/film").permitAll()
                                .antMatchers(HttpMethod.GET,"/film/*").permitAll()
                                .antMatchers(HttpMethod.GET,"/movie").permitAll()
                                .antMatchers(HttpMethod.GET,"/movie/*").permitAll()
                                .anyRequest().authenticated()
                )
                .logout(logout -> logout
                                .logoutUrl("/auth/logout")
                                .deleteCookies("JSESSION")
                                .invalidateHttpSession(true)
                                .logoutSuccessHandler(successLogoutHandler)
                )
                .userDetailsService(userDetailsService)
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    @Bean
    AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
