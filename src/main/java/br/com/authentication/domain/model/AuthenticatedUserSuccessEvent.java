package br.com.authentication.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class AuthenticatedUserSuccessEvent {
    private String email;
    private String username;
    private String role;

    public static AuthenticatedUserSuccessEvent of (Login user) {
        return AuthenticatedUserSuccessEvent.builder()
                .email(user.getUser().getEmail())
                .username(user.getUser().getUserName())
                .role(user.getRole())
                .build();
    }
}
