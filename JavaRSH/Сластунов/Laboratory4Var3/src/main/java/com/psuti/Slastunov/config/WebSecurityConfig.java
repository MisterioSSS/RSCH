package com.psuti.Slastunov.config;

import com.psuti.Slastunov.service.ConfirmFilter;
import com.psuti.Slastunov.service.UserVerificationFilter;
import com.psuti.Slastunov.service.security.SuccessLogoutHandlerImpl;
import com.psuti.Slastunov.service.token.JwtAuthenticationEntryPoint;
import com.psuti.Slastunov.service.token.JwtRequestFilter;
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
    private final UserVerificationFilter userVerificationFilter;
    private final ConfirmFilter confirmFilter;
    @Autowired
    public WebSecurityConfig(UserDetailsService userDetailsService,
                             JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
                             JwtRequestFilter jwtRequestFilter,
                             UserVerificationFilter userVerificationFilter, ConfirmFilter confirmFilter) {
        this.userDetailsService = userDetailsService;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtRequestFilter = jwtRequestFilter;
        this.userVerificationFilter = userVerificationFilter;
        this.confirmFilter = confirmFilter;
    }
    @Bean
    SecurityFilterChain web(HttpSecurity http, SuccessLogoutHandlerImpl successLogoutHandler) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests(
                        (authorize) -> authorize
                                .antMatchers("/auth/login", "/auth/reg/", "/auth/reg/mail").permitAll()

                                .antMatchers(HttpMethod.POST,"/users").hasRole("ADMIN")
                                .antMatchers(HttpMethod.POST,"/users").hasRole("MODERATOR")
                                .antMatchers(HttpMethod.PUT,"/users/*").hasRole("ADMIN")
                                .antMatchers(HttpMethod.PUT,"/users/*").hasRole("MODERATOR")

                                .antMatchers(HttpMethod.POST,"/cars").hasRole("ADMIN")
                                .antMatchers(HttpMethod.POST,"/cars").hasRole("MODERATOR")
                                .antMatchers(HttpMethod.PUT,"/cars*").hasRole("ADMIN")
                                .antMatchers(HttpMethod.PUT,"/cars*").hasRole("MODERATOR")

                                .antMatchers(HttpMethod.DELETE,"/users/*").hasRole("ADMIN")
                                .antMatchers(HttpMethod.DELETE,"/users/*").hasRole("MODERATOR")
                                .antMatchers(HttpMethod.DELETE,"/cars/*").hasRole("ADMIN")
                                .antMatchers(HttpMethod.DELETE,"/cars/*").hasRole("MODERATOR")

                                .antMatchers(HttpMethod.GET,"/users").permitAll()
                                .antMatchers(HttpMethod.GET,"/users/*").permitAll()

                                .antMatchers(HttpMethod.GET,"/cars").permitAll()
                                .antMatchers(HttpMethod.GET,"/cars/*").permitAll()
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
                .addFilterAfter(userVerificationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(confirmFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    @Bean
    AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
