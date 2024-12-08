package br.com.authentication.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthDto {
    private String username;
    private String password;
    private String email;
}
