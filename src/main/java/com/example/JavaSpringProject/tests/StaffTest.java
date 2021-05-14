package com.example.JavaSpringProject.tests;

import com.example.JavaSpringProject.models.Staff;
import com.example.JavaSpringProject.repositories.StaffRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("mysql")
@Slf4j
public class StaffTest {
    @Autowired
    private StaffRepository staffRepository;

    @Test
    public void findByName() {
        List<Staff> staffList = staffRepository.findByLastNameLike("%ose%");
        assertFalse(staffList.isEmpty());
        log.info("findByLastNameLike ...");
        staffList.forEach(staff -> log.info(staff.getLastName()));
    }

    @Test
    public void findByIds() {
        List<Staff> staffList = staffRepository.findByIdIn(Arrays.asList(1L, 2L));
        assertFalse(staffList.isEmpty());
        log.info("findByIds ...");
        staffList.forEach(staff -> log.info(staff.getLastName()));
    }

    @Test
    public void findBySpecialization() {
        List<Staff> staffList = staffRepository.findBySpecializationId(1L);
        assertFalse(staffList.isEmpty());
        log.info("findBySpecialization ...");
        staffList.forEach(staff -> log.info(staff.getLastName()));
    }

    @Test
    public void findStaffPage() {
        Pageable firstPage = PageRequest.of(0, 2);
        Page<Staff> allProducts = staffRepository.findAll(firstPage);
        Assert.assertEquals(2, allProducts.getNumberOfElements());
    }
}
