package br.com.authentication.domain.application;

import br.com.authentication.api.dto.AuthDto;
import br.com.authentication.config.AuthenticationDomainEventPublisher;
import br.com.authentication.domain.model.*;
import br.com.authentication.domain.service.TokenService;
import br.com.authentication.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthApplication {
    private UserService userService;
    private TokenService tokenService;
    private CryptographyService cryptographyService;
    private final AuthenticationDomainEventPublisher domainEventPublisher;

    public Login login(AuthDto login){
        User user = this.userService.findAccountByUsernameOrEmail(login.getUsername(), login.getEmail());

        user.userIsActive();
        user.passwordIsValid(cryptographyService, login.getPassword());

        var role = user.getRole().getName();
        var userToken = UserToken.builder()
                .id(user.getId())
                .userName(user.getUsername())
                .name(user.getName())
                .email(user.getEmail())
                .companyDocument(user.getCompanyDocument())
                .build();

        var token = this.tokenService.generateToken(userToken, role);

        var authenticatedUser = Login.builder()
                .user(userToken)
                .type("Bearer")
                .accessToken(token)
                .role(role)
                .build();

        var event = AuthenticatedUserSuccessEvent.of(authenticatedUser);
        domainEventPublisher.send(event);

        return authenticatedUser;
    }
}