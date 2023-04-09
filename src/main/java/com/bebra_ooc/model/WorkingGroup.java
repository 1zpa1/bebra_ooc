package com.bebra_ooc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "WorkingGroup")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkingGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wg_id")
    private Long id;

    @Column(name = "date")
    private String date;

    @Column(name = "objectType")
    private String objectType;


    @OneToMany(mappedBy = "workingGroup", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BuildingObject> buildingObjectCopyList;

    @Column(name = "confURL")
    private String confURL;


//    public WorkingGroup(String date, String objectType, List<BuildingObject> buildingObjectList, String confURL) {
//    }
}
