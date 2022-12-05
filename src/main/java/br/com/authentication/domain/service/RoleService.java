package br.com.authentication.domain.service;

import br.com.authentication.domain.model.Role;
import br.com.authentication.exception.NotFoundException;
import br.com.authentication.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {
    private RoleRepository repository;

    public Role findRoleById(Long id){
        return this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Role not found"));
    }
}
