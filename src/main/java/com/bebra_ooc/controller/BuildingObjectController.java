package com.bebra_ooc.controller;

import com.bebra_ooc.dto.BuildingObjectDTO;
import com.bebra_ooc.model.BuildingObject;
import com.bebra_ooc.service.BuildingObjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buildingObject")
public class BuildingObjectController {

    @Autowired
    private BuildingObjectService buildingObjectService;


    @PostMapping
    public BuildingObjectDTO addBuildingObject(@RequestBody BuildingObjectDTO buildingObjectDTO) {
        BuildingObject buildingObject = new BuildingObject();
        BeanUtils.copyProperties(buildingObjectDTO, buildingObject);
        BuildingObject savedBuildingObject = buildingObjectService.addBuildingObject(buildingObject);
        BuildingObjectDTO savedBuildingObjectDTO = new BuildingObjectDTO();
        BeanUtils.copyProperties(savedBuildingObject, savedBuildingObjectDTO);
        return savedBuildingObjectDTO;
    }

    @GetMapping
    public List<BuildingObjectDTO> getAllBuildingObjects() {
        List<BuildingObject> buildingObjects = buildingObjectService.getAllBuildingObjects();
        return buildingObjects.stream()
                .map(buildingObject -> {
                    BuildingObjectDTO buildingObjectDTO = new BuildingObjectDTO();
                    BeanUtils.copyProperties(buildingObject, buildingObjectDTO);
                    return buildingObjectDTO;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BuildingObjectDTO getBuildingObjectById(@PathVariable Long id) {
        BuildingObject buildingObject = buildingObjectService.getBuildingObjectById(id).orElse(null);
        if (buildingObject != null) {
            BuildingObjectDTO buildingObjectDTO = new BuildingObjectDTO();
            BeanUtils.copyProperties(buildingObject, buildingObjectDTO);
            return buildingObjectDTO;
        } else {
            return null;
        }
    }

    @PutMapping("/{id}")
    public BuildingObjectDTO updateBuildingObject(@PathVariable Long id, @RequestBody BuildingObjectDTO buildingObjectDTO) {
        BuildingObject existingBuildingObject = buildingObjectService.getBuildingObjectById(id).orElse(null);
        if (existingBuildingObject != null) {
            BeanUtils.copyProperties(buildingObjectDTO, existingBuildingObject);
            BuildingObject updatedBuildingObject = buildingObjectService.updateBuildingObject(existingBuildingObject);
            BuildingObjectDTO updatedBuildingObjectDTO = new BuildingObjectDTO();
            BeanUtils.copyProperties(updatedBuildingObject, updatedBuildingObjectDTO);
            return updatedBuildingObjectDTO;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteBuildingObjectById(@PathVariable Long id) {
        buildingObjectService.deleteBuildingObjectById(id);
    }

}
