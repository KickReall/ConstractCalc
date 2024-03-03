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
@Table(name = "materials")
public class Material{
    @Id
    @GeneratedValue
    private int id;

    @Column(name="name")
    private String name;
    @Column(name="material_type")
    private String materialType;
    @Column(name="structural_element_type")
    private String structuralElementType;

}
