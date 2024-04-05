package com.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.project.models.adminDetails;
import com.project.service.serviceInterface.IAdminService;

@Configuration
public class AdminConfig {
	@Autowired
	private IAdminService adminService;

    @Bean
    UserDetailsService userDetailsService() {
		adminDetails admin = adminService.getAdminDetails();
		String username = admin.getUname();
		String password = admin.getUpassword();
        UserDetails userDetails = User.builder().
                username(username)
                .password(passwordEncoder().encode(password)).roles("ADMIN").
                build();
        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
     PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
     AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}
