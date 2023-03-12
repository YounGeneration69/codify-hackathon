package com.abdiev.secure.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Optional;


@RequiredArgsConstructor
@Component
public class UsernameAuthenticationFilter extends OncePerRequestFilter{
    private final AuthenticationManager manager;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Optional<String> username = Optional.ofNullable(request.getHeader("username"));
        Optional<String> password = Optional.ofNullable(request.getHeader("password"));
        if (username.isPresent() && password.isPresent()) {
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username.get(),password.get());
                SecurityContext emptyContext = SecurityContextHolder.createEmptyContext();
                emptyContext.setAuthentication(manager.authenticate(token));
                SecurityContextHolder.setContext(emptyContext);
                filterChain.doFilter(request,response);
        }else {
            filterChain.doFilter(request,response);
        }
    }
}


