package br.com.authentication.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USER")
    @SequenceGenerator(name = "SQ_USER", sequenceName = "SQ_USER", allocationSize = 1)
    private String id;

    @NotEmpty(message = "Field username cannot be empty!")
    @NotNull(message = "Field username cannot be null!")
    private String username;

    @NotEmpty(message = "Field password cannot be empty!")
    @NotNull(message = "Field password cannot be null!")
    private String password;

    @NotEmpty(message = "Field confirmPassowrd cannot be empty!")
    @NotNull(message = "Field confirmPassword cannot be null!")
    private String confirmPassword;

    private String email;

    @NotNull(message = "Username cannot be null!")
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
