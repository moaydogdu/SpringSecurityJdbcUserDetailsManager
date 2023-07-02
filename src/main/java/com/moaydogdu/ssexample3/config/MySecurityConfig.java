package com.moaydogdu.ssexample3.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class MySecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity httpSecurity
    ) throws Exception{
        httpSecurity.httpBasic();

        httpSecurity
                .csrf().disable()

                .authorizeHttpRequests()
                .requestMatchers("/user")
                .permitAll()

                .anyRequest()
                .authenticated();

        return httpSecurity.build();
    }

}
