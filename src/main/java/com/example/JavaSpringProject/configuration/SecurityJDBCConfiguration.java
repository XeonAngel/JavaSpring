package com.example.JavaSpringProject.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@Profile("mysql")
public class SecurityJDBCConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(new BCryptPasswordEncoder())
                .usersByUsernameQuery("select username,password,enabled "
                        + "from user "
                        + "where username = ?")
                .authoritiesByUsernameQuery("select username, authority "
                        + "from user_authority as ua "
                        + "inner join authority as a "
                        + "on ua.authority_id = a.id "
                        + "where ua.username = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("DOCTOR","MANAGER")
                .antMatchers("/index").hasAnyRole("DOCTOR","MANAGER")
                .antMatchers("/drugs/**").hasAnyRole("DOCTOR","MANAGER")
                .antMatchers("/patients/**").hasAnyRole("DOCTOR","MANAGER")
                .antMatchers("/consultations/**").hasAnyRole("DOCTOR","MANAGER")

                .antMatchers("/departments/**").hasRole("MANAGER")
                .antMatchers("/specialization/**").hasRole("MANAGER")
                .antMatchers("/occupation/**").hasRole("MANAGER")
                .antMatchers("/distributors/**").hasRole("MANAGER")
                .antMatchers("/employees/**").hasRole("MANAGER")

                .and().formLogin().loginPage("/login").loginProcessingUrl("/login").failureUrl("/login-error").permitAll()
                .and().exceptionHandling().accessDeniedPage("/access-denied");
    }
}