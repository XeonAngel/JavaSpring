package com.example.JavaSpringProject.services;

import com.example.JavaSpringProject.models.Staff;
import com.example.JavaSpringProject.repositories.StaffRepository;
import com.example.JavaSpringProject.services.interfaces.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class StaffService implements IStaffService {
    StaffRepository staffRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public List<Staff> findAll() {
        List<Staff> staffs = new LinkedList<>();
        staffRepository.findAll().iterator().forEachRemaining(staffs::add);
        return staffs;
    }

    @Override
    public Staff findById(Long Id) {
        Optional<Staff> optionalStaff = staffRepository.findById(Id);
        if (optionalStaff.isEmpty()) {
            throw new RuntimeException("Staff not found!");
        }
        return optionalStaff.get();
    }

    @Override
    public Staff save(Staff entity) {
        return staffRepository.save(entity);
    }

    @Override
    public void deleteById(Long Id) {
        staffRepository.deleteById(Id);
    }
}
