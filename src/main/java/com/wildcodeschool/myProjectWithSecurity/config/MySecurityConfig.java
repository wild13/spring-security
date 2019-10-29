package com.wildcodeschool.myProjectWithSecurity.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure( AuthenticationManagerBuilder auth )
            throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser( "Steve" )
                .password( encoder.encode( "motdepasse" ) )
                .roles( "CHAMPION" )

                .and()

                .withUser( "Nick" )
                .password( encoder.encode( "flerken" ) )
                .roles( "DIRECTOR" );

    }

    @Override
    protected void configure( HttpSecurity http ) throws Exception {
        http
                .authorizeRequests()
                .antMatchers( "/" ).permitAll()
                .antMatchers( "/avengers/assemble" ).access( "hasRole( 'CHAMPION' )" )
                .antMatchers( "/secret-bases" ).access( "hasRole( 'DIRECTOR' )" )
                .anyRequest().authenticated()

                .and()

                .formLogin()
                .defaultSuccessUrl( "/" )
                .failureUrl( "/login?error=true" )

                .and()

                .httpBasic();
    }
}
