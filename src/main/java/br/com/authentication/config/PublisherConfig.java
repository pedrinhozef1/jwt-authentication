package br.com.authentication.config;


import io.awspring.cloud.sns.core.SnsTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PublisherConfig {

    @Bean
    public AuthenticationDomainEventPublisher emailSenderPublisher(SnsTemplate snsTemplate,
                                                     SnsProperties snsProperties) {

        return new AuthenticationDomainEventPublisher(snsTemplate, snsProperties);
    }
}
