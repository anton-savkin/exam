package ru.digitalleague.core.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel("Модель преподавателя")
@Data
@Entity
@Table(name="teachers")
public class TeacherModel {

    @Id
    @ApiModelProperty("Идентификатор преподавателя")
    @Column(name = "id")
    private Long id;

    @ApiModelProperty("Фамилия преподавателя")
    @Column(name = "last_name")
    private String lastName;

    @ApiModelProperty("Имя преподавателя")
    @Column(name = "first_name")
    private String firstName;

    @ApiModelProperty("Отчество преподавателя")
    @Column(name = "middle_name")
    private String middleName;

    @ApiModelProperty("ID кафедры преподавателя")
    @Column(name = "chair_id")
    private Long chairId;
}
