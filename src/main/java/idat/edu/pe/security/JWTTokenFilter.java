package idat.edu.pe.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JWTTokenFilter extends OncePerRequestFilter{
	@Autowired
	private JWTTokenUtil util;

	@Autowired
	private JWTUserDetailService jWTUserDetailService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String tokenHeader = request.getHeader("Authorization");
		
		String username = null;
		String jwtToken = null;
		
		if(tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
			
			jwtToken = tokenHeader.substring(7);
			
			try {
				username = util.getUsernameFromToken(jwtToken);
				
			} catch (Exception e) {
				System.out.println("Ocurrio un error");
			}
			
		}else {
			
			logger.warn("JWT no esta iniciando con Bearer");
		}
		
		
		if( username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			
			UserDetails userDetail = this.jWTUserDetailService.loadUserByUsername(username);
			
			if( util.validateToken(jwtToken, userDetail)) {
				
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(jwtToken, null,userDetail.getAuthorities());
				
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
			
		}
		
		filterChain.doFilter(request, response);
	}
}
