package br.com.authentication.repository;

import br.com.authentication.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface RoleRepository extends JpaRepository<Role, Long>,
        QuerydslPredicateExecutor<Role> {

}
