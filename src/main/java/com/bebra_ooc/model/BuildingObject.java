package com.bebra_ooc.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "buildingObject")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "buildingObject")
public class BuildingObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @XmlElement
    private Long id;

    @Column(name = "county")
    @XmlElement
    private String county;

    @Column(name = "area")
    @XmlElement
    private String area;

    @Column(name = "address")
    @XmlElement
    private String address;

    @Column(name = "buildingObjectType")
    @XmlElement
    private String buildingObjectType;

    @Column(name = "buildingObjectState")
    @XmlElement
    private String buildingObjectState;

    @Column(name = "buildingObjectSquare")
    @XmlElement
    private String buildingObjectSquare;

    @Column(name = "owner")
    @XmlElement
    private String owner;

    @Column(name = "actualUser")
    @XmlElement
    private String actualUser;

    // ToDo добавить фото/видео

}
