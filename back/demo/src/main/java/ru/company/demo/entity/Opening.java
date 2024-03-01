package ru.company.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name = "openings")
public class Opening extends AbstractEntity{

    @Column(name="type")
    @NotBlank
    private String type;
    @Column(name="width")
    @NotBlank
    private float width;
    @Column(name="height")
    @NotBlank
    private float height;

}
