package ru.company.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users_state")
public class UserState{

    /**
     * Уникальный идентификатор пользовательского статуса
     */
    @Id
    @GeneratedValue(generator = "users_state_id_seq")
    private int id;

    /**
     * Уникальный идентификатор каркаса
     */
    @Column(name="name")
    private String name;
}
