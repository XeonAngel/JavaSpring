package com.example.JavaSpringProject.controllers;

import com.example.JavaSpringProject.models.Department;
import com.example.JavaSpringProject.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DepartmentsController implements BaseController<Department> {

    private DepartmentService departmentService;

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    @Override
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("Departments/index");
        List<Department> departments = departmentService.findAll();
        modelAndView.addObject("departments", departments);
        return modelAndView;
    }

    @GetMapping("/departments/create")
    @Override
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("Departments/create_edit");
        modelAndView.addObject("department", new Department());
        return modelAndView;
    }

    @PostMapping("/departments/create_edit")
    @Override
    public String saveOrUpdate(Department entity) {
        Department savedDepartment = departmentService.save(entity);
        //return "redirect:/departments/details/" + savedDepartment.getId();
        return "redirect:/departments";
    }

    @GetMapping("/departments/edit/{id}")
    @Override
    public ModelAndView edit(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("Departments/create_edit");
        modelAndView.addObject("department", departmentService.findById(Long.valueOf(id)));
        return modelAndView;
    }

    @GetMapping("/departments/details/{id}")
    @Override
    public ModelAndView details(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("Departments/details");
        modelAndView.addObject("department", departmentService.findById(Long.valueOf(id)));
        return modelAndView;
    }

    @RequestMapping("/departments/delete/{id}")
    @Override
    public String delete(@PathVariable String id) {
        departmentService.deleteById(Long.valueOf(id));
        return "redirect:/departments";
    }
}
