package fi.c5msiren;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * This class acts as a configuration of web security
 *
 * @author Miika
 * @version 2017.5.09
 * @since 1.8
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Reference to UserDetailsService class
     */
    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * Method for configuring the security
     * 
     * @param http Http security object
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http
                .authorizeRequests()
                    .antMatchers("/resources/**", "/registration", "/index.jsp", "/products").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/index.jsp")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();
    }

    /**
     * Method for configuring the security globally
     * 
     * @param auth Builder for authentication manager
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}