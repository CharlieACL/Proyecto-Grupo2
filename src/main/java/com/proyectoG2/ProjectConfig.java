
package com.proyectoG2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ProjectConfig implements WebMvcConfigurer{
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/registro/nuevo").setViewName("/registro/nuevo");
    }
    
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((request) -> request
                .requestMatchers("/", "/index", "/errores/**",
                        "/Servicios/**", "/Sedes/**", "/PlanE/**","/EnfoqueH/**","/Tienda/**",
                        "/Matricula/**","/Matricula/guardar/**",  "/Actividades/**","/Contactenos/**","/carrito/**",
                     "/Carrito/**","/Profesores/**",
                        "/registro/**", "/js/**", "/webjars/**","/CSS/**","/img/**")
                .permitAll()
                .requestMatchers(
                        "/libreta/**","/carrito/nuevo", "/carrito/guardar","/carrito/agregar",
                        "/carrito/modificar/**", "/carrito/eliminar/**",
                        "/libreta/nuevo", "/libreta/guardar/**",
                        "/libreta/estudiante/**", "/libreta/eliminar/**",
                        "/usuario/nuevo", "/usuario/guardar",
                        "/usuario/modificar/**", "/usuario/eliminar/**",
                        "/reportes/**"
                ).hasAnyRole("USER","ADMIN","PROFESOR")
                .requestMatchers("/libreta/**","/libreta/listado/**","/libreta/nuevo", "/libreta/guardar/**",
                        "/libreta/estudiante/**", "/libreta/eliminar/**")
                .hasRole("USER")
                )
                .formLogin((form) -> form
                .loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll());
        return http.build();
    }
    
}


