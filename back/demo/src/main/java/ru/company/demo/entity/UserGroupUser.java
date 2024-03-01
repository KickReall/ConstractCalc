package ru.company.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users_usersGroup")
public class UserGroupUser extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name="user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name="users_group_id")
    private UserGroup usersGroupId;
}
