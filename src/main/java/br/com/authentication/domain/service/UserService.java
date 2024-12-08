package br.com.authentication.domain.service;

import br.com.authentication.domain.model.QUser;
import br.com.authentication.domain.model.User;
import br.com.authentication.domain.model.exception.BusinessException;
import br.com.authentication.domain.model.exception.NotFoundException;
import br.com.authentication.repository.UserRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User findAccountByUsernameOrEmail(String username, String email){
        if (nullSafe(username) && nullSafe(email)) {
            throw new BusinessException("Necessário informar o usuário ou email para se autenticar");
        }
        BooleanExpression filter = QUser.user.username.eq(username).or(QUser.user.email.eq(email));

        return this.userRepository.findOne(filter)
                .orElseThrow(() -> new NotFoundException("Usuário " + username + " não encontrado"));
    }

    private boolean nullSafe(String value) {
        return Objects.isNull(value) || value.isEmpty();
    }
}
