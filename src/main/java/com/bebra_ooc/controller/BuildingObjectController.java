package com.bebra_ooc.controller;

import com.bebra_ooc.dto.BuildingObjectDTO;
import com.bebra_ooc.model.BuildingObject;
import com.bebra_ooc.service.BuildingObjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buildingObject")
public class BuildingObjectController {

    @Autowired
    private BuildingObjectService buildingObjectService;



    @GetMapping(value = "/xml/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public String getBuildingObjectByIdByXML(@PathVariable Long id) throws JAXBException {
        BuildingObject buildingObject = buildingObjectService.getBuildingObjectById(id).orElse(null);
        if (buildingObject != null) {
            JAXBContext jaxbContext = JAXBContext.newInstance(BuildingObject.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(buildingObject, stringWriter);
            String xmlString = stringWriter.toString();
            return xmlString;
        } else {
            return null;
        }
    }

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
