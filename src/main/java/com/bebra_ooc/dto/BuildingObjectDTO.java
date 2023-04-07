package com.bebra_ooc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class BuildingObjectDTO {

    private Long id;
    private String county;
    private String area;
    private String address;
    private String buildingObjectType;
    private String buildingObjectState;
    private String buildingObjectSquare;
    private String owner;
    private String actualUser;

}
