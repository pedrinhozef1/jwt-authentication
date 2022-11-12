package br.com.authentication.domain.service;

import br.com.authentication.domain.model.User;
import br.com.authentication.domain.representation.UserRepresentation;
import br.com.authentication.exception.BusinessException;
import br.com.authentication.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private CryptographyService cryptographyService;

    public void create(UserRepresentation.CreateOrUpdateUser user) {

        this.checkAccountExistsAndUsernameLength(user.getUsername());
        this.checkPasswordAndConfirmPassword(user.getPassword(), user.getConfirmPassword());

        User newUser = User.builder()
                .username(user.getUsername())
                .password(this.cryptographyService.encrypt(user.getPassword()))
                .confirmPassword(this.cryptographyService.encrypt(user.getConfirmPassword()))
                .createdAt(LocalDateTime.now())
                .build();
        this.userRepository.save(newUser);
    }

    public void checkAccountExistsAndUsernameLength(String username){
        Optional<User> findUser = this.userRepository.findByUsername(username);

        if (username.length() < 6) {
            throw new BusinessException("Username field less than six characters!");
        } else if (findUser.isPresent()) {
            throw new BusinessException("An account with the username " + username + " already exists!");
        }
    }

    public void checkPasswordAndConfirmPassword(String password, String confirmPassword){
        if (password.length() < 8) {
            throw new BusinessException("Password field less than eight characters!");
        } else if (confirmPassword.length() < 8) {
            throw new BusinessException("Confirm password field less than eight characters!");
        } else if (!password.equals(confirmPassword)){
            throw new BusinessException("Password field and confirm password field are different");
        }
    }
}
