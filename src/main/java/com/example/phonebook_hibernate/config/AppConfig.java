package com.example.phonebook_hibernate.config;


import org.slf4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.ResourceBundle;


@Configuration
public class AppConfig {
    @Bean
    public Logger logger(){
        Logger logger = LoggerFactory.getLogger("Ahmad");// Logger.getLogger("Ahmad");

        return logger;
    }

//    @Bean
//    public LoggerFactory loggerFactory(){
//        LoggerFactory factory=new LoggerFactory();
//        return factory;
//    }




    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("message");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setDefaultLocale(new Locale("fa"));
        messageSource.setUseCodeAsDefaultMessage(false);
        messageSource.setFallbackToSystemLocale(false);
        return messageSource;
    }

    @Bean
    public ResourceBundle resourceBundle() {
        return ResourceBundle.getBundle("message", Locale.forLanguageTag("fa"));
    }
}
