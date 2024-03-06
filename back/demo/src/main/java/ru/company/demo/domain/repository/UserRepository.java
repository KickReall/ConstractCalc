package ru.company.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.demo.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
