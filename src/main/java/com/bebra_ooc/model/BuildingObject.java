package com.bebra_ooc.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "buildingObject")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BuildingObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "county")
    private String county;

    @Column(name = "area")
    private String area;

    @Column(name = "address")
    private String address;

    @Column(name = "buildingObjectType")
    private String buildingObjectType;

    @Column(name = "buildingObjectState")
    private String buildingObjectState;

    @Column(name = "buildingObjectSquare")
    private String buildingObjectSquare;

    @Column(name = "owner")
    private String owner;

    @Column(name = "actualUser")
    private String actualUser;

    // ToDo добавить фото/видео

}
