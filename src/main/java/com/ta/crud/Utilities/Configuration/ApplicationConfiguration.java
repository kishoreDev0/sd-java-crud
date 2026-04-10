package com.ta.crud.Utilities.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ta.crud.Utilities.Generic.GenericResponseBuilder;

@Configuration
public class ApplicationConfiguration {

     @Bean
    public GenericResponseBuilder genericResponseBuilder() {
        return new GenericResponseBuilder();
    }

}
