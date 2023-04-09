package com.bebra_ooc.controller;

import com.bebra_ooc.dto.BuildingObjectDTO;
import com.bebra_ooc.model.BuildingObject;
import com.bebra_ooc.service.BuildingObjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.Resource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buildingObject")
public class BuildingObjectController {

    @Autowired
    private BuildingObjectService buildingObjectService;



//    @GetMapping(value = "/buildingObject/xml/{id}", produces = MediaType.APPLICATION_XML_VALUE)
//    @ResponseBody
//    public BuildingObject getBuildingObjectByIdInXML(@PathVariable Long id) throws JAXBException {
//        BuildingObject buildingObject = buildingObjectService.getBuildingObjectById(id).orElse(null);
//        if (buildingObject != null) {
//            return buildingObject;
//        } else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "BuildingObject not found");
//        }
//    }
//@PostMapping
//public ResponseEntity<Resource> addBuildingObject(@RequestBody BuildingObjectDTO buildingObjectDTO) throws Exception {
//    BuildingObject buildingObject = new BuildingObject();
//    BeanUtils.copyProperties(buildingObjectDTO, buildingObject);
//    BuildingObject savedBuildingObject = buildingObjectService.addBuildingObject(buildingObject);
//    BuildingObjectDTO savedBuildingObjectDTO = new BuildingObjectDTO();
//    BeanUtils.copyProperties(savedBuildingObject, savedBuildingObjectDTO);
//
//    // Создание XML файла
//    JAXBContext jaxbContext = JAXBContext.newInstance(BuildingObjectDTO.class);
//    Marshaller marshaller = jaxbContext.createMarshaller();
//    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//    File xmlFile = new File("savedBuildingObject.xml");
//    marshaller.marshal(savedBuildingObjectDTO, xmlFile);
//
//    // Загрузка файла
//    Path path = Paths.get(xmlFile.getAbsolutePath());
//    ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
//
//    // Установка заголовков ответа
//    HttpHeaders headers = new HttpHeaders();
//    headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=savedBuildingObject.xml");
//    headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE);
//    headers.setContentLength(xmlFile.length());
//
//    return ResponseEntity.ok()
//            .headers(headers)
//            .contentLength(xmlFile.length())
//            .contentType(MediaType.APPLICATION_XML)
//            .body((Resource) resource);
//}



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
