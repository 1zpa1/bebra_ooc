package com.bebra_ooc.repository;

import com.bebra_ooc.model.WorkingGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkingGroupRepository extends JpaRepository<WorkingGroup, Long> {

    WorkingGroup findWorkingGroupById(long id);

    void deleteWorkingGroupById(long id);

    WorkingGroup save(Optional<WorkingGroup> workingGroup);

}
