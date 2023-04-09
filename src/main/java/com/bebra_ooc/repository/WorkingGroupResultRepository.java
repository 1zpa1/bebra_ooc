package com.bebra_ooc.repository;

import com.bebra_ooc.model.WorkingGroup;
import com.bebra_ooc.model.WorkingGroupResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkingGroupResultRepository extends JpaRepository<WorkingGroupResult, Long> {

    WorkingGroupResult findWorkingGroupResultById(long id);

    void deleteWorkingGroupResultById(long id);

    WorkingGroupResult save(Optional<WorkingGroupResult> workingGroupResult);

}
