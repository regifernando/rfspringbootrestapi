package com.juaracoding.rfspringbootrestapi.configuration;

import com.juaracoding.rfspringbootrestapi.model.CobaCoba;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfiguration {

    @Bean
    public CobaCoba cobaCoba(){
        return new CobaCoba();
    }

    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }
}
