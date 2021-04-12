package com.jct.pma.security;

import javax.activation.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	javax.sql.DataSource dataSource;
	
	@Autowired
	BCryptPasswordEncoder bCryptEncoder;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.usersByUsernameQuery("select username, password, enabled "+
				"from user_accounts where username = ?" )
			.authoritiesByUsernameQuery("select username, role "+
				"from user_accounts where username = ?")
			.dataSource(dataSource)
			.passwordEncoder(bCryptEncoder);
		
		
	}
			

	
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/projects/new").hasRole("ADMIN") // first priority
			.antMatchers("/employees/new").hasRole("ADMIN")// second priority
			.antMatchers("/projects/save").hasRole("ADMIN")//..
			.antMatchers("/employees/save").hasRole("ADMIN")//fourth priority
			.antMatchers("/projects/delete").hasRole("ADMIN")
			.antMatchers("/employees/update").hasRole("ADMIN")
			.antMatchers("/projects/update").hasRole("ADMIN")
			.antMatchers("/employees/delete").hasRole("ADMIN")

			
			.antMatchers("/","/**").permitAll()// every one should have access everywhere -- least priority
			.and()
//			.formLogin().loginPage("/login-page") when we create a login controller/page
			.formLogin();
		
		
			http.csrf().disable();
			http.headers().frameOptions().disable();
		
			/* (How to set a role in the database
			 * update user_accounts
				set role = 'ROLE_ADMIN'
			 	where username='valton'
			 *
			 * we append 'ROLE_' beacuse of the method hasRole("ADMIN");
			 * 
			 * if we want in the db to type 'set role = 'ADMIN'
			 * we should use the hasAuthority("ADMIN") method
			 * */
				
	}
	
}
