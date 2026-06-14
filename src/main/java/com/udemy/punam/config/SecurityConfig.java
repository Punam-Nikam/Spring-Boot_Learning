package com.udemy.punam.config;
////spring security chain
import com.udemy.punam.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration     // indicates that this class has @Bean definitions and can be processed by the Spring container to generate bean definitions and service requests at runtime.
@EnableWebSecurity    // enables spring web security and provides the spring MVC integration.
public class SecurityConfig {

    @Autowired
    private CustomUserDetailService customUserDetailService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.
         csrf(csrf -> csrf.ignoringRequestMatchers("/api/users/createUser"))
        .authenticationProvider(authenticationProvider())
                .authorizeHttpRequests((requests)->requests
                        .requestMatchers("/api/users/createUser").permitAll()
                        .requestMatchers("/api/users/**").authenticated()
                                .anyRequest()
                        .permitAll()
    ).formLogin(withDefaults())
                .httpBasic(withDefaults());

    return http.build();
    }
    /////Static credentials
//    @Bean
//    public UserDetailsService userDetailsService()
//    {
//        var user = User.builder()
//                .username("user")   //static data
//                .password(passwordEncoder().encode("password")) //static credential
//                .roles("User")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(customUserDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
}