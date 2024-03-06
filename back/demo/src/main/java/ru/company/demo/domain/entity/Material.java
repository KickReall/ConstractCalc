package ru.company.demo.domain.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "materials")
public class Material{

    /**
     * Уникальный идентификатор материала
     */
    @Id
    @GeneratedValue(generator = "materials_id_seq")
    private int id;

    /**
     * Название материала
     */
    @Column(name="name")
    private String name;

    /**
     * Тип материала
     */
    @Column(name="material_type")
    private String materialType;

    /**
     * Тип конструктивного элемента
     */
    @Column(name="structural_element_type")
    private String structuralElementType;

}
