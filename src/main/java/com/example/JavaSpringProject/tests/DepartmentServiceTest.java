package com.example.JavaSpringProject.tests;

import com.example.JavaSpringProject.models.Department;
import com.example.JavaSpringProject.repositories.DepartmentRepository;
import com.example.JavaSpringProject.services.DepartmentService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

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
