package com.bebra_ooc.repository;

import com.bebra_ooc.model.BuildingObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingObjectRepository extends JpaRepository<BuildingObject, Long> {
    BuildingObject findById(long id);

    void deleteById(long id);

    BuildingObject save(BuildingObject buildingObject);
}
