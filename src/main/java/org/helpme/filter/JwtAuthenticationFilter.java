package org.helpme.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.helpme.model.AuthenticatedUser;
import org.helpme.util.security.SecurityCons;
import org.springframework.security.core.context.SecurityContextHolder;

public class JwtAuthenticationFilter implements Filter {
	
	@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	HttpServletRequest servletRequest = (HttpServletRequest) request;
    	
        String authContent = servletRequest.getHeader(SecurityCons.HEADER);
        
        if (authContent != null) {
        	if (authContent.substring(0, SecurityCons.TOKEN_PRE.length()).equals(SecurityCons.TOKEN_PRE)) {
        		String token = authContent.replace(SecurityCons.TOKEN_PRE, "");
                AuthenticatedUser user = new AuthenticatedUser(token);
                SecurityContextHolder.getContext().setAuthentication(user);
        	}
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
