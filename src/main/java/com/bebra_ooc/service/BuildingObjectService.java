package com.bebra_ooc.service;

import com.bebra_ooc.model.BuildingObject;
import com.bebra_ooc.repository.BuildingObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuildingObjectService {
    @Autowired
    private BuildingObjectRepository buildingObjectRepository;

    public BuildingObject addBuildingObject(BuildingObject buildingObject) {
        return buildingObjectRepository.save(buildingObject);
    }

    public List<BuildingObject> getAllBuildingObjects() {
        return buildingObjectRepository.findAll();
    }

    public Optional<BuildingObject> getBuildingObjectById(long id) {
        return Optional.ofNullable(buildingObjectRepository.findById(id));
    }

    public void deleteBuildingObjectById(long id) {
        buildingObjectRepository.deleteById(id);
    }

    public BuildingObject updateBuildingObject(BuildingObject buildingObject) {
        return buildingObjectRepository.save(buildingObject);
    }
}
