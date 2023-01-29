package com.emailSender;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.emailSender")
public class AppConfig {
    @Bean
    public MailSender mailSender(){
        JavaMailSenderImpl impl = new JavaMailSenderImpl();

        impl.setHost("smtp.gmail.com");
        impl.setPort(587);

        Properties properties = new Properties();

        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.debug", "true");

        impl.setJavaMailProperties(properties);

        return impl;
    }
}
