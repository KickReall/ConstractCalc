package ru.company.demo.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
public class Customer{

    /**
     * Уникальный идентификатор заказчика
     */
    @Id
    @GeneratedValue(generator = "customers_id_seq")
    private int id;

    /**
     * Фамилия заказчика
     */
    @Column(name="last_name")
    private String lastName;

    /**
     * Имя заказчика
     */
    @Column(name="first_name")
    private String firstName;

    /**
     * Отчество заказчика
     */
    @Column(name="second_name")
    private String secondName;

    /**
     * Номер телефона заказчика
     */
    @Column(name="phone")
    private String phone;

    /**
     * Электронная почта заказчика
     */
    @Column(name="e-mail")
    @Email
    private String mail;

    /**
     * Адрес заказчика
     */
    @Column(name="address")
    @NotBlank
    private String address;

    /**
     * Связанный с заказчиком сотрудник {@code User}
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
