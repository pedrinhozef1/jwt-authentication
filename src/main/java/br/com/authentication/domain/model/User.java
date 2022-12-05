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
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sq_user")
    @SequenceGenerator(name = "sq_user", sequenceName = "sq_user", allocationSize = 1)
    private Long id;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    @NotNull(message = "Role field cannot be null!")
    private Role role;

    @NotNull(message = "Created at field cannot be null!")
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
