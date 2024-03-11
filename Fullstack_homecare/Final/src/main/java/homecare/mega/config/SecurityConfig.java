package homecare.mega.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import homecare.mega.utils.MyConstant;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
    {
        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
        .cors(cors-> cors.configurationSource(corsConfigurationSource()))
        .authorizeHttpRequests(authorize ->authorize.requestMatchers(MyConstant.WHITELIST)
            .permitAll()
            .anyRequest().authenticated())
        .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class)
        .logout(logout->logout.logoutUrl("api/v1/auth/logout")
            .addLogoutHandler(logoutHandler)
            .logoutSuccessHandler((request,response,authentication) ->SecurityContextHolder.clearContext()))
        .build();
    }

    public CorsConfigurationSource corsConfigurationSource()
    {
            CorsConfiguration corsConfiguration = new CorsConfiguration();
            corsConfiguration.setAllowedOrigins(MyConstant.ORIGINS);
            corsConfiguration.setAllowedHeaders(MyConstant.HEADERS);
            corsConfiguration.setAllowedMethods(MyConstant.METHODS);
            corsConfiguration.setAllowCredentials(true);
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", corsConfiguration);
            return source;
    }
}

