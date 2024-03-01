package ru.company.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User extends AbstractUser{

    @Column(name="password")
    private String password;
    @Column(name="login")
    private String login;

    @ManyToOne
    @JoinColumn (name="state_id")
    private UserState stateId;

}
