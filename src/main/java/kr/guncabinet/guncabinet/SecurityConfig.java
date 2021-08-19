package kr.guncabinet.guncabinet;

import kr.guncabinet.guncabinet.service.SpringDataUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity // właczenie zabezpieczńe w appce Springa
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll() // metoda antMatchers określa adres. potem jest metoda dostępowa
                .antMatchers("/weapon/**", "/archive/**", "/ammunition/**").hasAnyRole("USER", "ADMIN") // authenticted() określa, że adresy wymagają uwierzytelnienia
                .antMatchers("/admin/**").hasRole("ADMIN") // określamy role dla której będzie dostepna
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/weapon/all") // automatycznie przekierowanie do strony logowania, zamiast strony błędu
                .and().logout().logoutSuccessUrl("/logout") // przekierowanie dla metody logout
                .permitAll()
                .and().exceptionHandling().accessDeniedPage("/403");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }




}
