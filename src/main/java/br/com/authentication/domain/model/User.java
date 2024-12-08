package br.com.authentication.domain.model;

import br.com.authentication.domain.model.exception.BusinessException;
import br.com.authentication.domain.model.exception.UnauthorizedException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity(name = "user")
public class User {
    public static final String USER_STATUS_INATIVED = "0";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sq_user")
    @SequenceGenerator(name = "sq_user", sequenceName = "sq_user", allocationSize = 1)
    private Long id;

    private String username;

    private String password;

    private String name;

    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    private String status;
    private String companyDocument;

    public void userIsActive() {
        if (!this.getStatus().equals(USER_STATUS_INATIVED)) {
            throw new BusinessException("O usuário que deseja se logar não está ativo.");
        }
    }

    public void passwordIsValid(CryptographyService cryptographyServiceImpl, String password) {
        var decryptedPassword = cryptographyServiceImpl.decrypt(this.getPassword());

        if (!decryptedPassword.equals(password)) {
            throw new UnauthorizedException("A senha informada está inválida");
        }
    }

}
