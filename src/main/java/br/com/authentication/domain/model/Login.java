package br.com.authentication.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Login {
    private UserToken user;
    private String token;
    private String tokenType;
    private String role;
}
