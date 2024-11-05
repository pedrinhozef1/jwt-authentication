package br.com.authentication.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class SnsProperties {
    @Value(value = "${spring.cloud.aws.sns.authentication-user-domain-event}")
    public String authenticationDomainEvent;
}
