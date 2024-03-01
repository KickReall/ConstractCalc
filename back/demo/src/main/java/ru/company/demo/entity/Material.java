package ru.company.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "materials")
public class Material extends AbstractEntity{

    @Column(name="name")
    private String name;
    @Column(name="material_type")
    private String materialType;
    @Column(name="structural_element_type")
    private String structuralElementType;

}
