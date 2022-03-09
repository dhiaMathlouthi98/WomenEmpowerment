package tn.esprit.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import tn.esprit.spring.service.UserDetailsServiceImpl;

@Configuration

public class WebsecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean
 public UserDetailsService userDetailsService() {
     return new UserDetailsServiceImpl();
 }
	
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		return super.authenticationManagerBean();
	}
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
				
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);		 
		
		auth
		 .inMemoryAuthentication()
      .withUser("women").password("{noop}password").roles("women")
      .and()
      .withUser("Admin").password("{noop}password").roles("Admin")		
		.and()
     .withUser("tutor").password("{noop}password").roles("tutor")		
		.and()
     .withUser("expert").password("{noop}password").roles("expert");		
	}


	@Bean
	public PasswordEncoder passwordEncoder() {
	    return PasswordEncoderFactories.createDelegatingPasswordEncoder();

		}
	
	/*	
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	    http.cors().disable();
		
		http.headers().frameOptions().disable();
		
		http.csrf().disable();
/*
		http
     .httpBasic()
         .and()
     .authorizeRequests()
         .antMatchers("/user/register").permitAll()
         .antMatchers("/user/confirm-account").permitAll()
         .antMatchers("/user/retrieve-all-User").permitAll()
         .antMatchers("/user/retrieve-User/**").permitAll()

         .and()
     .authorizeRequests()
         .antMatchers("/user/add-User").hasAnyAuthority("Admin")
         .antMatchers("/user/remove-User/**").hasAnyAuthority("Admin")
         .antMatchers("/user/modify-User/**").hasAnyAuthority("Admin","women","expert","tutor")
       // .anyRequest().authenticated()
        .and()
     .formLogin()
         .permitAll();
		
		
	
		
		
		
		*/
		
		
		/*http.
		cors()
     .and()
     .csrf()
     .disable()
     // Register our CustomRequestCache, that saves unauthorized access attempts, so
     // the user is redirected after login.
     //.requestCache().requestCache(new CustomRequestCache())
     // Restrict access to our application.
     .authorizeRequests()
     
     .antMatchers("/user/add-User").hasRole("ADMIN")
     .anyRequest().authenticated()
     .antMatchers("/user/register").permitAll();
     
     		
    // .antMatchers("/user/confirm").permitAll()
		
		//.antMatchers("/user/delete-user").hasAnyRole("Admin");
		//.antMatchers("/user/modify-user").access("@userSecurity.hasUserId(authentication,#userid)")
		//.antMatchers("/user/retrieve-User/{userid}").access("@userSecurity.hasUserId(authentication,#userid)");

		
		//http.cors().disable();
		
		//http.headers().frameOptions().disable();
		
		//super.configure(http);

		*/
		
	}
	
	
	@Override
 public void configure(WebSecurity web) throws Exception {
     web
         .ignoring()
         .antMatchers("/h2-console/**");
 }
}
	
	
	
/*	@Autowired
 public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
	//	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	//	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		 
		
		auth
		 .inMemoryAuthentication()
      .withUser("user").password("{noop}password").roles("USER")
      .and()
      .withUser("admin").password("{noop}password").roles("Admin");
 }*/