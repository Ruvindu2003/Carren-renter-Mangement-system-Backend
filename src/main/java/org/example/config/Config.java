package org.example.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class Config {

    @Bean
    public ModelMapper addModelMapper(){
        return new ModelMapper();
    }



}
