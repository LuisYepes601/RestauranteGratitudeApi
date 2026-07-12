/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Config;

import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author luis
 */
@Configuration
public class JacksonConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizer() {

        return builder -> builder.postConfigurer(objectMapper -> {

            objectMapper.coercionConfigFor(String.class)
                    .setCoercion(
                            CoercionInputShape.Integer,
                            CoercionAction.Fail
                    );

            objectMapper.coercionConfigFor(String.class)
                    .setCoercion(
                            CoercionInputShape.Boolean,
                            CoercionAction.Fail
                    );
        });
    }
}
