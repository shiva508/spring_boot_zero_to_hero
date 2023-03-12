package com.pool.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class BankAppSpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;

	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().passwordEncoder(passwordEncoder()).dataSource(dataSource);
	}
	

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth .jdbcAuthentication() .dataSource(dataSource); auth
	 * .jdbcAuthentication() .dataSource(dataSource)
	 * .usersByUsernameQuery("select username,password, enabled from users where username=?"
	 * )
	 * .authoritiesByUsernameQuery("select username, role from user_roles where username=?"
	 * );
	 * 
	 * 
	 * 
	 * auth.inMemoryAuthentication().withUser("shiva").password("{noop}shiva").roles
	 * ("Employee");
	 * auth.inMemoryAuthentication().withUser("shivad").password("{noop}shivad").
	 * roles("Admin");
	 * 
	 * 
	 * 
	 * }
	 */

	  @Bean public PasswordEncoder passwordEncoder() { return new
	  BCryptPasswordEncoder(); }
	 
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/components/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/customlogin")
				.loginProcessingUrl("/authenicatuser")
				.permitAll().and().logout().permitAll().and().exceptionHandling().accessDeniedPage("/403");
	}

}
