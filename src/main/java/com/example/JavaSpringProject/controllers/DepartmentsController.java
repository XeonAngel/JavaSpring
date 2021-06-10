package com.example.JavaSpringProject.controllers;

import com.example.JavaSpringProject.models.Department;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DepartmentsController extends BaseController<Department> {
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
    public ModelAndView saveOrUpdate(Department entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("Departments/create_edit");
        }
        Department savedDepartment = departmentService.save(entity);
        //return "redirect:/departments/details/" + savedDepartment.getId();
        return new ModelAndView("redirect:/departments");
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
