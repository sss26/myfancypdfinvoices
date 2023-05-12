package com.smthasa.myfancypdfinvoices.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smthasa.myfancypdfinvoices.ApplicationLauncher;

@Configuration
@ComponentScan(basePackageClasses = ApplicationLauncher.class)
public class MyFancyPdfInvoicesApplicationConfiguration {
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
