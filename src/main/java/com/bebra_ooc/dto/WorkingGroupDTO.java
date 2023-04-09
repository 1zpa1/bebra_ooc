package com.bebra_ooc.dto;

import com.bebra_ooc.model.BuildingObject;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

public class WorkingGroupDTO {

    private Long id;

    private String date;

    private String objectType;

    private List<BuildingObject> buildingObjectList;

    private String confURL;

}
