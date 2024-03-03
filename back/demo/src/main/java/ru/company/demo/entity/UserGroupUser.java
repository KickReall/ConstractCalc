package ru.company.demo.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "users_usersGroup")
public class UserGroupUser{
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name="users_group_id")
    private UserGroup usersGroupId;
}
