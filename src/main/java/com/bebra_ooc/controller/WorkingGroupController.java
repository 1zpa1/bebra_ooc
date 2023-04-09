package com.bebra_ooc.controller;

import com.bebra_ooc.dto.WorkingGroupDTO;
import com.bebra_ooc.model.WorkingGroup;
import com.bebra_ooc.service.WorkingGroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/workingGroup")
public class WorkingGroupController {

    @Autowired
    private WorkingGroupService workingGroupService;

    @PostMapping
    public WorkingGroup addWorkingGroup(@RequestBody WorkingGroup workingGroup) {
        WorkingGroup savedWorkingGroup = workingGroupService.addWorkingGroup(workingGroup); // сохраняем сущность в базу данных и получаем обновленную версию
        return savedWorkingGroup;
    }


    @GetMapping
    public List<WorkingGroupDTO> getAllWorkingGroups() {
        List<WorkingGroup> workingGroups = workingGroupService.getAllWorkingGroup();
        return workingGroups.stream()
                .map(workingGroup -> {
                    WorkingGroupDTO workingGroupDTO = new WorkingGroupDTO();
                    BeanUtils.copyProperties(workingGroup, workingGroupDTO);
                    return workingGroupDTO;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public WorkingGroupDTO getWorkingGroupById(@PathVariable Long id) {
        Optional<WorkingGroup> workingGroup = workingGroupService.getWorkingGroupById(id).orElse(null);
        if (workingGroup != null) {
            WorkingGroupDTO workingGroupDTO = new WorkingGroupDTO();
            BeanUtils.copyProperties(workingGroup, workingGroupDTO);
            return workingGroupDTO;
        } else {
            return null;
        }
    }

    @PutMapping("/{id}")
    public WorkingGroupDTO updateWorkingGroup(@PathVariable Long id, @RequestBody WorkingGroupDTO workingGroupDTO) {
        Optional<WorkingGroup> existingWorkingGroup = workingGroupService.getWorkingGroupById(id).orElse(null);
        if (existingWorkingGroup != null) {
            BeanUtils.copyProperties(workingGroupDTO, existingWorkingGroup);
            WorkingGroup updatedWorkingGroup = workingGroupService.updateWorkingGroup(existingWorkingGroup);
            WorkingGroupDTO updatedWorkingGroupDTO = new WorkingGroupDTO();
            BeanUtils.copyProperties(updatedWorkingGroup, updatedWorkingGroupDTO);
            return updatedWorkingGroupDTO;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteWorkingGroupById(@PathVariable Long id) {
        workingGroupService.deleteWorkingGroupById(id);
    }

}
