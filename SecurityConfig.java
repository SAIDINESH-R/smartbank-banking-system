{\rtf1\ansi\ansicpg1252\cocoartf2821
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 package com.saidinesh.smartbank.config;\
\
import org.springframework.context.annotation.Bean;\
import org.springframework.context.annotation.Configuration;\
import org.springframework.security.config.Customizer;\
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;\
import org.springframework.security.web.SecurityFilterChain;\
\
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;\
import static org.springframework.security.config.annotation.web.builders.HttpSecurity.*;\
\
@Configuration\
@EnableWebSecurity\
public class SecurityConfig \{\
\
    @Bean\
    public SecurityFilterChain filterChain(org.springframework.security.config.annotation.web.builders.HttpSecurity http) throws Exception \{\
        http\
            .csrf(csrf -> csrf.disable())\
            .authorizeHttpRequests(auth -> auth\
                .requestMatchers("/api/**").authenticated()\
                .anyRequest().permitAll()\
            )\
            .httpBasic(Customizer.withDefaults())\
            .sessionManagement(session -> session.sessionCreationPolicy(STATELESS));\
\
        return http.build();\
    \}\
\}\
}