package br.com.authentication.config;

import io.awspring.cloud.sns.core.SnsTemplate;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Getter
@Log4j2
public class AuthenticationDomainEventPublisher extends SnsSenderConfig {
    private String topicArn;

    public AuthenticationDomainEventPublisher(SnsTemplate snsTemplate, SnsProperties snsProperties) {
        super(snsTemplate);
        this.topicArn = snsProperties.getAuthenticationDomainEvent();
    }
}
