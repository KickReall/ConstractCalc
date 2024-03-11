package ru.company.demo.repository;

import org.springframework.data.repository.CrudRepository;
import ru.company.demo.entity.UserGroup;

import javax.management.relation.Role;
import java.util.Optional;

public interface UserGroupRepository extends CrudRepository<UserGroup, Integer> {
    Optional<UserGroup> findByName (String title);
}
