package ru.company.demo.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class AbstractUser extends AbstractEntity {
    private String lastName;
    private String firstName;
    private String secondName;
    private Integer phone;
    @Email
    private String mail;
}
