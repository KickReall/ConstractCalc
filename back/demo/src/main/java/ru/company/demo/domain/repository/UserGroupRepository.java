package ru.company.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.demo.domain.entity.UserGroup;

public interface UserGroupRepository extends JpaRepository<UserGroup, Integer> {
}
