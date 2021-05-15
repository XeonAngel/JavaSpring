package com.example.JavaSpringProject.repositories;

import com.example.JavaSpringProject.models.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends BaseRepository<Staff> {
    List<Staff> findByLastNameLike(String lastName);
    List<Staff> findBySpecializationId(Long specializationId);
}
