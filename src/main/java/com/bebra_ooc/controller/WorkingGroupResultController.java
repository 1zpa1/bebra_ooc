package com.bebra_ooc.controller;

import com.bebra_ooc.dto.WorkingGroupDTO;
import com.bebra_ooc.dto.WorkingGroupResultDTO;
import com.bebra_ooc.model.WorkingGroup;
import com.bebra_ooc.model.WorkingGroupResult;
import com.bebra_ooc.service.WorkingGroupResultService;
import com.bebra_ooc.service.WorkingGroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/workingGroupResult")
public class WorkingGroupResultController {

    @Autowired
    private WorkingGroupResultService workingGroupResultService;

    @PostMapping
    public WorkingGroupResult addWorkingGroupResult(@RequestBody WorkingGroupResult workingGroupResult) {
        WorkingGroupResult savedWorkingGroupResult = workingGroupResultService.addWorkingGroupResult(workingGroupResult); // сохраняем сущность в базу данных и получаем обновленную версию
        return savedWorkingGroupResult;
    }



    @GetMapping
    public List<WorkingGroupResultDTO> getAllWorkingGroupsResult(){
        List<WorkingGroupResult> workingGroupsResult = workingGroupResultService.getAllWorkingGroupResult();
        return workingGroupsResult.stream()
                .map(workingGroupResult -> {
                    WorkingGroupResultDTO workingGroupResultDTO = new WorkingGroupResultDTO();
                    BeanUtils.copyProperties(workingGroupResult, workingGroupResultDTO);
                    return workingGroupResultDTO;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public WorkingGroupResultDTO getWorkingGroupResultById(@PathVariable Long id) {
        Optional<WorkingGroupResult> workingGroupResult = workingGroupResultService.getWorkingGroupResultById(id).orElse(null);
        if (workingGroupResult != null) {
            WorkingGroupResultDTO workingGroupResultDTO = new WorkingGroupResultDTO();
            BeanUtils.copyProperties(workingGroupResult, workingGroupResultDTO);
            return workingGroupResultDTO;
        } else {
            return null;
        }
    }

    @PutMapping("/{id}")
    public WorkingGroupResultDTO updateWorkingGroupResult(@PathVariable Long id, @RequestBody WorkingGroupResultDTO workingGroupResultDTO) {
        Optional<WorkingGroupResult> existingWorkingGroupResult = workingGroupResultService.getWorkingGroupResultById(id).orElse(null);
        if (existingWorkingGroupResult != null) {
            BeanUtils.copyProperties(workingGroupResultDTO, existingWorkingGroupResult);
            WorkingGroupResult updatedWorkingGroupResult = workingGroupResultService.updateWorkingGroupResult(existingWorkingGroupResult);
            WorkingGroupResultDTO updatedWorkingGroupResultDTO = new WorkingGroupResultDTO();
            BeanUtils.copyProperties(updatedWorkingGroupResult, updatedWorkingGroupResultDTO);
            return updatedWorkingGroupResultDTO;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteWorkingGroupResultById(@PathVariable Long id) {
        workingGroupResultService.deleteWorkingGroupResultById(id);
    }

}
