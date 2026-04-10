package com.ta.crud.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ta.crud.Generic.GenericResponseBuilder;

@Configuration
public class ApplicationConfiguration {

     @Bean
    public GenericResponseBuilder genericResponseBuilder() {
        return new GenericResponseBuilder();
    }

}
