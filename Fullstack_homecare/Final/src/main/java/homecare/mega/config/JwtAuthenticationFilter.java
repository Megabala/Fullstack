package homecare.mega.config;



import java.io.IOException;

import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import homecare.mega.repository.TokenRepository;
import homecare.mega.utils.JwtUtil;
import org.springframework.http.HttpHeaders;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;
    private final TokenRepository tokenRepository;
    
    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request, 
            @NonNull HttpServletResponse response, 
            @NonNull FilterChain filterChain)
            throws ServletException, IOException 
    {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);    
        final String token;
        final String userEmail;

        if(authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        token = authHeader.substring(7);
        userEmail = jwtUtil.extractEmail(token);

        if(userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
            
            var isTokenValid = tokenRepository.findByToken(token).map(t->!t.isExpired()||!t.isRevoked())
                .orElse(false);
            if(jwtUtil.isTokenValid(token, userDetails) && isTokenValid) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userEmail, null, userDetails.getAuthorities());

                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }
    
}
