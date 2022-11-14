package br.com.authentication.config.Auth;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "security.token")
public class TokenProperties {
    private long maxAgeSeconds;
    private String secret;
    private String issuer;
    private String publicKey;
    private String privateKey;
}
