package ru.company.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class AbstractUser {

    @Column(name="last_Name")
    private String lastName;
    @Column(name="first_Name")
    private String firstName;
    @Column(name="second_Name")
    private String secondName;
    @Column(name="phone")
    private Integer phone;
    @Column(name="e_mail")
    @Email
    private String mail;
}
