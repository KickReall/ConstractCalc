package ru.company.demo.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    /**
     * Уникальный идентификатор сотрудника
     */
    @Id
    @GeneratedValue(generator = "users_id_seq")
    private int id;

    /**
     * Список связанных заказчиков {@code Customer}
     */
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Customer> customers;

    /**
     * Имя сотрудника
     */
    @Column(name="first_Name")
    private String firstName;

    /**
     * Отчество сотрудника
     */
    @Column(name="second_Name")
    private String secondName;

    /**
     * Фамилия сотрудника
     */
    @Column(name="last_Name")
    private String lastName;

    /**
     * Номер телефона сотрудника
     */
    @Column(name="phone")
    private String phone;

    /**
     * Адрес электронной почты сотрудника
     */
    @Column(name="e-mail")
    @Email
    private String mail;

    /**
     * Пароль сотрудника
     */
    @Column(name="password")
    private String password;

    /**
     * Логин сотрудника
     */
    @Column(name="login")
    private String login;

    /**
     * Ссылка на текущее состояние пользователя {@code UserState}
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name="state_id")
    private UserState state;

    /**
     * Список групп {@code UserGroup}, к которым принадлежит пользователь
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_usersGroup",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "usersgroup_id")})
    private List<UserGroup> groups;
}
