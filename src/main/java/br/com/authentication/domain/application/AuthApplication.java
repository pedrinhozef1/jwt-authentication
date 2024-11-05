package br.com.authentication.domain.application;

import br.com.authentication.api.dto.AuthDto;
import br.com.authentication.config.AuthenticationDomainEventPublisher;
import br.com.authentication.domain.model.AuthenticatedUserSuccessEvent;
import br.com.authentication.domain.model.Login;
import br.com.authentication.domain.model.UserToken;
import br.com.authentication.domain.model.User;
import br.com.authentication.domain.model.exception.BusinessException;
import br.com.authentication.domain.service.CryptographyService;
import br.com.authentication.domain.service.TokenService;
import br.com.authentication.domain.service.UserService;
import br.com.authentication.domain.model.exception.UnauthorizedException;
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
        User user = this.userService.findAccountByUsername(login.getUsername());

        if (!user.getStatus().equals("0")) {
            throw new BusinessException("O usuário que deseja se logar não está ativo.");
        }

        if (!this.cryptographyService.decrypt(user.getPassword()).equals(login.getPassword())) {
            throw new UnauthorizedException("A senha informada está inválida");
        }

        var role = user.getRole().getName();
        var token = this.tokenService.generateToken(new UserToken(user.getId(), user.getUsername(), user.getName(), user.getEmail()), role);

        var authenticatedUser = Login.builder()
                .user(UserToken.builder()
                        .id(user.getId())
                        .userName(user.getUsername())
                        .name(user.getName())
                        .email(user.getEmail())
                        .build())
                .type("Bearer")
                .accessToken(token)
                .role(role)
                .build();

        var event = AuthenticatedUserSuccessEvent.of(authenticatedUser);
        domainEventPublisher.send(event);

        return authenticatedUser;
    }
}