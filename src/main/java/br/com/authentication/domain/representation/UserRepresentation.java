package br.com.authentication.domain.representation;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public interface UserRepresentation {
    @Data
    class CreateOrUpdateUser{
        @NotEmpty(message = "Username field cannot be empty!")
        @NotNull(message = "Username field cannot be null!")
        private String username;

        @NotEmpty(message = "Password field cannot be empty!")
        @NotNull(message = "Password field cannot be null!")
        private String password;

        @NotEmpty(message = "Confirm password field cannot be empty!")
        @NotNull(message = "Confirm password field cannot be null!")
        @Column(name = "confirm_password")
        private String confirmPassword;

        private String email;

        @Column(name = "created_at")
        private LocalDateTime createdAt;

        @Column(name = "updated_at")
        private LocalDateTime updatedAt;
    }
}
