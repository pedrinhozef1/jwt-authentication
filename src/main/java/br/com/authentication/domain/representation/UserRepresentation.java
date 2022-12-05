package br.com.authentication.domain.representation;

import br.com.authentication.domain.model.User;
import lombok.Builder;
import lombok.Data;
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

        @NotNull(message = "Role field cannot be null!")
        @Column(name = "role_id")
        private Long role;

        @Column(name = "created_at")
        private LocalDateTime createdAt;

        @Column(name = "updated_at")
        private LocalDateTime updatedAt;
    }

    @Data
    @Builder
    class UserToken{
        private Long id;
        private String userName;

        public static UserToken from(User user){
            return UserToken.builder()
                    .id(user.getId())
                    .userName(user.getUsername())
                    .build();
        }
    }
}
