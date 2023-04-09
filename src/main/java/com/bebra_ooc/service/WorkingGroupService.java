package com.bebra_ooc.service;

import com.bebra_ooc.model.WorkingGroup;
import com.bebra_ooc.repository.WorkingGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkingGroupService {

    @Autowired
    private WorkingGroupRepository workingGroupRepository;

    public WorkingGroup addWorkingGroup(WorkingGroup workingGroup) {
        return workingGroupRepository.save(workingGroup);
    }

    public List<WorkingGroup> getAllWorkingGroup() {
        return workingGroupRepository.findAll();
    }

    public Optional<Optional<WorkingGroup>> getWorkingGroupById(long id) {
        return Optional.ofNullable(workingGroupRepository.findById(id));
    }

    public void deleteWorkingGroupById(long id) {
        workingGroupRepository.deleteById(id);
    }

    public WorkingGroup updateWorkingGroup(Optional<WorkingGroup> workingGroup) {
        return workingGroupRepository.save(workingGroup);
    }
}
