package com.bebra_ooc.dto;

import com.bebra_ooc.model.BuildingObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class WorkingGroupDTO {

    private Long id;

    private String date;

    private String objectType;

    private List<BuildingObject> buildingObjectList;

    private String confURL;

}
