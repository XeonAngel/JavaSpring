package com.example.JavaSpringProject.controllers;

import com.example.JavaSpringProject.models.Department;
import com.example.JavaSpringProject.services.DepartmentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.web.servlet.ModelAndView;

import static org.mockito.Mockito.*;

public class DepartmentsControllerTest {
    @Mock
    ModelAndView departmentMV;

    @Mock
    DepartmentService departmentService;

    DepartmentsController departmentsController;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        departmentsController = new DepartmentsController();
    }

    @Test
    public void details() {
        Long id = 1L;
        Department departmentTest = new Department();

        when(departmentService.findById(id)).thenReturn(departmentTest);
        departmentsController.setDepartmentService(departmentService);

        String viewName = departmentsController.details(id.toString()).getViewName();
        when(departmentMV.getViewName()).thenReturn(viewName);

        ArgumentCaptor<Department> argumentCaptor = ArgumentCaptor.forClass(Department.class);
        verify(departmentMV, times(0))
                .addObject(eq("department"), argumentCaptor.capture());

        Assert.assertEquals("Departments/details", departmentMV.getViewName());
        verify(departmentService, times(1)).findById(id);
    }
}