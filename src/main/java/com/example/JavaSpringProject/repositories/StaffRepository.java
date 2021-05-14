package com.example.JavaSpringProject.repositories;

import com.example.JavaSpringProject.models.Staff;
import java.util.List;

public interface StaffRepository extends BaseRepository<Staff> {
    List<Staff> findByLastNameLike(String lastName);
    List<Staff> findBySpecializationId(Long specializationId);
}
