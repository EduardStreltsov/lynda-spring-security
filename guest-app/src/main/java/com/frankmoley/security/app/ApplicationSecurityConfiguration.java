package com.frankmoley.security.app;

import com.frankmoley.security.app.auth.LandonUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private LandonUserDetailsService landonUserDetailsService;
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(landonUserDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder(11));
		return provider;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/", "/index", "/css/*", "/js/*", "/h2-console", "/h2-console/*").permitAll()
				.anyRequest().authenticated()
				.and()
				.httpBasic();
		
		http.headers().frameOptions().disable();
	}
	
	//	@Bean
	//	@Override
	//	public UserDetailsService userDetailsService() {
	//		List<UserDetails> users = new ArrayList<>();
	//		users.add(User.withDefaultPasswordEncoder().username("fpmoles").password("password").roles("USER", "ADMIN").build());
	//		users.add(User.withDefaultPasswordEncoder().username("jdoe").password("foobar").roles("USER").build());
	//		return new InMemoryUserDetailsManager(users);
	//	}
}
