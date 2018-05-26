package org.helpme.configuration;


import org.helpme.filter.JwtAuthenticationFilter;
import org.helpme.util.request.Endpoints;
import org.helpme.util.security.JwtAuthenticationEntryPoint;
import org.helpme.util.security.UserAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
    private UserAuthenticationProvider authProvider;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthEndPoint;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();

        http.authorizeRequests()
                .antMatchers(Endpoints.LOGIN.getMethod(), Endpoints.LOGIN.getUrl()).permitAll()
                .antMatchers(Endpoints.SIGNUP.getMethod(), Endpoints.SIGNUP.getUrl()).permitAll()
                .antMatchers(HttpMethod.OPTIONS, "**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthEndPoint);
	}
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);

    }
}
