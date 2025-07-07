
package shopit.shop.security.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
// changing this to see if the changes are shown or not

    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
//        UserDetails user = User.withUsername("frank@frank.com")
//                .password(passwordEncoder.encode(passwordEncoder.encode("12345")))
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable());
 
        http.headers(headers -> headers.frameOptions(frame -> frame.disable()));

        http
                .authorizeHttpRequests((requests) -> requests
                .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
                               .requestMatchers(new AntPathRequestMatcher("/")).hasAnyAuthority("USER", "ADMIN")
                               .requestMatchers(new AntPathRequestMatcher("/seller/products")).hasAnyAuthority("ADMIN")
                               .requestMatchers(new AntPathRequestMatcher("/products/**"), new AntPathRequestMatcher("/cart/**")).hasAnyAuthority("USER")
                               .requestMatchers(new AntPathRequestMatcher("/cart/**"), new AntPathRequestMatcher("/products/**")).fullyAuthenticated()
                               .requestMatchers(new AntPathRequestMatcher("/seller/**")).fullyAuthenticated()
                               .requestMatchers(new AntPathRequestMatcher("/**"), new AntPathRequestMatcher("/css/**"),new AntPathRequestMatcher("/js/**")).permitAll()
                               .anyRequest().permitAll()

                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/products")
                        .successHandler((request, response, authentication) -> {
                            String redirectUrl = determineTargetUrl(authentication);
                            response.sendRedirect(redirectUrl);
                        })
                        .permitAll()
                        )
                .logout((logout) -> logout
                        .logoutSuccessUrl("/login?logout").permitAll()
                        .invalidateHttpSession(true).clearAuthentication(true)

                )
                .exceptionHandling((exceptionHandling) ->
                        exceptionHandling
                                .accessDeniedPage("/access-denied")
                );



        return http.build();
    }

 private String determineTargetUrl(Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        for (GrantedAuthority authority : authorities) {
            String role = authority.getAuthority();

            if (role.equals("ADMIN")) {
                return "/seller/products";
            } else if (role.equals("USER")) {
                return "/products"; // Default for regular users
            }
        }
        return "/login?error"; // Redirect to login if no valid role
    }

}


