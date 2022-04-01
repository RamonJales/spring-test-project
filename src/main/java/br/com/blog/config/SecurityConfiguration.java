package br.com.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
    private static final String[] AUTH_LIST = {
            "/",
            "/about-us",
            "/article/{id}",
            "/search",
            "/images/**",
            "/css/**",
            "/bootstrap/**"
        };
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers(AUTH_LIST).permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin().permitAll()
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/").permitAll();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
			.withUser("ramon")
			.password(passwordEncoder().encode("123"))
			.authorities("ADMIN");
	}
	
	/* this is the old way
	 * @Override public void configure(WebSecurity web) throws Exception{
	 * web.ignoring().antMatchers("/images/**", "/css/**", "/bootstrap/**"); }
	 */
}
