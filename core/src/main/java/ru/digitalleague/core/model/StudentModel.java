package ru.digitalleague.core.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;

@ApiModel("Модель студента")
@Data
@Entity
@Table(name="students")
public class StudentModel {

    @Id
    @ApiModelProperty("Идентификатор студента")
    @Column(name = "id")
    private Long id;

    @ApiModelProperty("Фамилия студент")
    @Column(name = "last_name")
    private String lastName;

    @ApiModelProperty("Имя студента")
    @Column(name = "first_name")
    private String firstName;

    @ApiModelProperty("Отчество студента")
    @Column(name = "middle_name")
    private String middleName;

    @ApiModelProperty("ID специализации студента")
    @Column(name="speciality_id")
    private Long specialityId;

    @ApiModelProperty("Курс студента")
    @Column(name="course")
    private int course;
}
