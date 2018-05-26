package org.helpme.filter;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.helpme.model.AuthenticatedUser;
import org.springframework.security.core.context.SecurityContextHolder;

public class JwtAuthenticationFilter implements Filter {
	
	@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	HttpServletRequest servletRequest = (HttpServletRequest) request;
    	
        Optional<String> authContent = Optional.of(servletRequest.getHeader("Authorization"));
        
        if (authContent.isPresent()) {
            AuthenticatedUser user = new AuthenticatedUser(authContent.get());
            SecurityContextHolder.getContext().setAuthentication(user);
        }
        
        chain.doFilter(request, response);
    }

	@Override
	public void destroy() {
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
}
