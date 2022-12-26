package com.isanf.users.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.apache.coyote.http11.Http11InputBuffer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration 
@EnableWebSecurity
public class SecurityConfig{

	@Configuration
	public class SecurityConfiguration {
		
		@Bean
		public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
			
			return new InMemoryUserDetailsManager(
				User.withUsername("user1").password("{noop}1234").authorities("USER").build(),
				User.withUsername("user2").password("{noop}1234").authorities("USER").build(),
				User.withUsername("admin").password("{noop}1234").authorities("USER","ADMIN").build()
			);
			
		}

	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    	
	        return http
	        		.csrf((csrf) -> csrf.disable())
	        		.authorizeHttpRequests(auth -> auth
	        				.anyRequest().authenticated())
	        		.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
	        		.sessionManagement(session -> session
	        				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	        				)
	        		.httpBasic(withDefaults())
	        		.build();
	    }

	}
	
	@Bean
	JwtEncoder jwtEncoder() {
		
	}
	
	
	@Bean
	JwtDecoder jwtDecoder() {
		
	}
	
}
