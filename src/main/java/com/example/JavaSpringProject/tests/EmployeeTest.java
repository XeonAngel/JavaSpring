package com.example.JavaSpringProject.tests;

import com.example.JavaSpringProject.models.Employee;
import com.example.JavaSpringProject.repositories.EmployeeRepository;
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
public class EmployeeTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void findByName() {
        List<Employee> employeeList = employeeRepository.findByLastNameLike("%ose%");
        assertFalse(employeeList.isEmpty());
        log.info("findByLastNameLike ...");
        employeeList.forEach(staff -> log.info(staff.getLastName()));
    }

    @Test
    public void findByIds() {
        List<Employee> employeeList = employeeRepository.findByIdIn(Arrays.asList(1L, 2L));
        assertFalse(employeeList.isEmpty());
        log.info("findByIds ...");
        employeeList.forEach(staff -> log.info(staff.getLastName()));
    }

    @Test
    public void findBySpecialization() {
        List<Employee> employeeList = employeeRepository.findBySpecializationId(1L);
        assertFalse(employeeList.isEmpty());
        log.info("findBySpecialization ...");
        employeeList.forEach(staff -> log.info(staff.getLastName()));
    }

    @Test
    public void findStaffPage() {
        Pageable firstPage = PageRequest.of(0, 2);
        Page<Employee> allProducts = employeeRepository.findAll(firstPage);
        Assert.assertEquals(2, allProducts.getNumberOfElements());
    }
}
