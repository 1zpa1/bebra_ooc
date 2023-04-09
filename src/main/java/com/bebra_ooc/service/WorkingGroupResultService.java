package com.bebra_ooc.service;

import com.bebra_ooc.model.WorkingGroupResult;
import com.bebra_ooc.repository.WorkingGroupResultRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WorkingGroupResultService {

    @Autowired
    private final WorkingGroupResultRepository workingGroupResultRepository;



    public WorkingGroupResult addWorkingGroupResult(WorkingGroupResult workingGroupResult) {
        return workingGroupResultRepository.save(workingGroupResult);
    }

    public List<WorkingGroupResult> getAllWorkingGroupResult() {
        return workingGroupResultRepository.findAll();
    }

    public Optional<Optional<WorkingGroupResult>> getWorkingGroupResultById(long id) {
        return Optional.ofNullable(workingGroupResultRepository.findById(id));
    }

    public void deleteWorkingGroupResultById(long id) {
        workingGroupResultRepository.deleteById(id);
    }

    public WorkingGroupResult updateWorkingGroupResult(Optional<WorkingGroupResult> workingGroupResult) {
        return workingGroupResultRepository.save(workingGroupResult);
    }

}
