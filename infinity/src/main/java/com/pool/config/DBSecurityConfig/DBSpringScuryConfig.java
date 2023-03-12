package com.pool.config.DBSecurityConfig;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pool.serviceImpl.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class DBSpringScuryConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()
			/*.anyRequest().authenticated()*/ //used to authenticate only on user 
			.antMatchers("/").hasRole("EMPLOYEE")
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/ceo/**").hasRole("CEO")
			.antMatchers("/r&d/").hasAnyRole("RND","MANAGER")
			.and()
			.formLogin()
			.loginPage("/loginpage")
			.loginProcessingUrl("/login")
			.permitAll()
			.and()
			.logout()
			.permitAll()
			.and()
			.exceptionHandling()
			.accessDeniedPage("/403");
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new PasswordEncoder() {
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return true;
			}

			@Override
			public String encode(CharSequence rawPassword) {
				return rawPassword.toString();
			}
		};
	}
}
