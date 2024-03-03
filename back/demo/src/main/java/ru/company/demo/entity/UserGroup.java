package ru.company.demo.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users_group")
public class UserGroup{
    @Id
    @GeneratedValue
    private int id;

    @Column(name="title")
    @NotBlank
    private String title;

}
