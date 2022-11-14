package br.com.authentication.domain.representation;

import lombok.Builder;
import lombok.Data;

public interface LoginRepresentation {
    @Data
    @Builder
    class Login{
        private String username;
        private String password;
    }

    @Data
    @Builder
    class LoginResponse{
        private UserRepresentation.UserToken user;
        private String token;
        private String tokenType;
    }
}
