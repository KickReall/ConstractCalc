package ru.company.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.demo.domain.entity.UserState;

public interface UserStateRepository extends JpaRepository<UserState, Integer> {
}
