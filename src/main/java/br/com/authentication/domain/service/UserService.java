package br.com.authentication.domain.service;

import br.com.authentication.domain.model.QUser;
import br.com.authentication.domain.model.User;
import br.com.authentication.domain.model.exception.NotFoundException;
import br.com.authentication.repository.UserRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User findAccountByUsername(String username){
        BooleanExpression filter = QUser.user.username.eq(username);

        return this.userRepository.findOne(filter)
                .orElseThrow(() -> new NotFoundException("User " + username + " not found "));
    }
}
