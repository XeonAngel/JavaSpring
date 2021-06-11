package com.example.JavaSpringProject.services;

import com.example.JavaSpringProject.models.Department;
import com.example.JavaSpringProject.repositories.DepartmentRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("h2")
@Rollback(false)
public class DepartmentServiceTest {
    DepartmentService departmentService;

    @Mock
    DepartmentRepository departmentRepository;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        departmentService =  new DepartmentService(departmentRepository);
    }

    @Test
    public void findDepartments(){
        List<Department> departmentsRet = new ArrayList<>();
        Department department =  new Department();
        department.setId(3L);
        department.setName("Test");
        departmentsRet.add(department);

        when(departmentRepository.findAll()).thenReturn(departmentsRet);
        List<Department> departments = departmentService.findAll();
        assertEquals(1,departments.size());
        verify(departmentRepository,times(1)).findAll();
    }
}