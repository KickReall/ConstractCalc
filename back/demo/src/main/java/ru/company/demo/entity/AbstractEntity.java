package ru.company.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class AbstractEntity {

    @Column(name="id")
    @Id
    private Integer id;
}
