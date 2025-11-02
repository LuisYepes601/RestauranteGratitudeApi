/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Usuario
 */
@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(
                                "http://127.0.0.1:5500",
                                "https://inicio-sesion-three.vercel.app/",
                                "https://reservas-virid-theta.vercel.app/",
                                "https://inicio-sesion-three.vercel.app/olvidasteTuContrase%C3%B1a.html",
                                "http://127.0.0.1:5500/olvidasteTuContrase%C3%B1a.html,https://restaurante-gratitude-frontend-e11cxfw4i-luisyepes601s-projects.vercel.app/"
                                , "https://restaurante-gratitude-frontend-e11cxfw4i-luisyepes601s-projects.vercel.app/Login/index.html"
                        )
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
