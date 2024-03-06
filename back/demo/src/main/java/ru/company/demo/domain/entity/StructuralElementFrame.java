package ru.company.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StructuralElementFrame {

    /**
     * Уникальный идентификатор каркаса
     */
    @Id
    @GeneratedValue(generator = "structural_element_frame_id_seq")
    private int id;

    /**
     * Ссылка на результат {@code Result}
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="results_id")
    private Result result;

    /**
     * Список проемов {@code Opening}
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "frame_openings",
            joinColumns = {@JoinColumn(name = "structural_element_frame_id")},
            inverseJoinColumns = {@JoinColumn(name = "openings_id")})
    private List<Opening> openings;

    /**
     * Количество этажей
     */
    @Column(name="amount_floor")
    private int amountFloor;

    /**
     * Номер этажа
     */
    @Column(name="floor_number")
    private int floorNumber;

    /**
     * Высота этажа
     */
    @Column(name="floor_height")
    private int floorHeight;

    /**
     * Периметр внешних стен
     */
    @Column(name="perimeter_of_external_walls")
    private float perimeterOfExternalWalls;

    /**
     * Площадь основания
     */
    @Column(name="base_area")
    private float baseArea;

    /**
     * Толщина внешних стен
     */
    @Column(name="external_wall_thickness")
    private float externalWallThickness;

    /**
     * Длина внутренних стен
     */
    @Column(name="internal_wall_length")
    private float internalWallLength;

    /**
     * Толщина внутренних стен
     */
    @Column(name="internal_wall_thickness")
    private float internalWallThickness;

    /**
     * ОСБ обшивка внешних стен
     */
    @Column(name="OSB_external_wall")
    private String OSBExternalWall;

    /**
     * Парогидроизоляция обшивка внешних стен
     */
    @Column(name="steam_waterproofing_external_wall")
    private String steamWaterproofingExternalWall;

    /**
     * Ветрозащита обшивка внешних стен
     */
    @Column(name="windscreen_external_wall")
    private String windscreenExternalWall;

    /**
     * Утеплитель обшивка внешних стен
     */
    @Column(name="insulation_external_wall")
    private String insulationExternalWall;

    /**
     * Толщина перекрытия
     */
    @Column(name="overlap_thickness")
    private String overlapThickness;

    /**
     * Толщина ОСБ
     */
    @Column(name="OSB_thickness")
    private String OSBThickness;

    /**
     * Толщина парогидроизоляции
     */
    @Column(name="steam_waterproofing_thickness")
    private String steamWaterproofingThickness;

    /**
     * Толщина ветрозащиты
     */
    @Column(name="windscreen_thickness")
    private String windscreenThickness;

    /**
     * Толщина утеплителя
     */
    @Column(name="insulation_thickness")
    private String insulationThickness;

    /**
     * ОСБ внутренних стен
     */
    @Column(name="OSB_internal_wall")
    private String OSBInternalWall;

}
