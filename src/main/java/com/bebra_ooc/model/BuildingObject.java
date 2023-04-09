package com.bebra_ooc.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlRootElement(name = "buildingObject")
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
    //@XmlElement
    private Long id;

    @Column(name = "county")
    //@XmlElement
    private String county;

    @Column(name = "area")
    //@XmlElement
    private String area;

    @Column(name = "address")
    //@XmlElement
    private String address;

    @Column(name = "buildingObjectType")
//    @XmlElement
    private String buildingObjectType;

    @Column(name = "buildingObjectState")
//    @XmlElement
    private String buildingObjectState;

    @Column(name = "buildingObjectSquare")
//    @XmlElement
    private String buildingObjectSquare;

    @Column(name = "owner")
    //@XmlElement
    private String owner;

    @Column(name = "actualUser")
//    @XmlElement
    private String actualUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wg_id")
    private WorkingGroup workingGroup;



    // ToDo добавить фото/видео

}
