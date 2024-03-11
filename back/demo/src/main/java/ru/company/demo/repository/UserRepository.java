package ru.company.demo.repository;

import org.springframework.data.repository.CrudRepository;
import ru.company.demo.entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByLogin(String username);
}
