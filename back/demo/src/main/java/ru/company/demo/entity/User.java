package ru.company.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
public class User extends AbstractEntity{
    private String lastName;
    private String firstName;
    private String secondName;
    private Integer phone;
    private String mail;
    private String password;
    private String login;

    @OneToMany
    @Column(name="state_id")
    private UserState state;

}
