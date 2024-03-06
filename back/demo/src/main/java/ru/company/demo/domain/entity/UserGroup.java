package ru.company.demo.domain.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users_group")
public class UserGroup{

    /**
     * Уникальный идентификатор пользовательской группы
     */
    @Id
    @GeneratedValue(generator = "users_group_id_seq")
    private int id;

    /**
     * Название группы
     */
    @Column(name="title")
    @NotBlank
    private String title;

    /**
     * Список сотрудников {@code User}, относящихся к группе
     */
    @ManyToMany(mappedBy = "groups")
    private List<User> users;

}
