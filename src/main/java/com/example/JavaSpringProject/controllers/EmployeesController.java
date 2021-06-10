package com.example.JavaSpringProject.controllers;

import com.example.JavaSpringProject.models.Employee;
import com.example.JavaSpringProject.models.Enums.Rank;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EmployeesController extends BaseController<Employee> {
    @GetMapping("/employees")
    @Override
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("Employees/index");
        List<Employee> employees = employeeService.findAll();
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("/employees/create")
    @Override
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("Employees/create_edit");
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("ranks", Rank.values());
        modelAndView.addObject("occupations", occupationService.findAll());
        modelAndView.addObject("specializations", specializationService.findAll());
        modelAndView.addObject("departments", departmentService.findAll());
        return modelAndView;
    }

    @GetMapping("/employees/edit/{id}")
    @Override
    public ModelAndView edit(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("Employees/create_edit");
        modelAndView.addObject("employee", employeeService.findById(Long.valueOf(id)));
        modelAndView.addObject("ranks", Rank.values());
        modelAndView.addObject("occupations", occupationService.findAll());
        modelAndView.addObject("specializations", specializationService.findAll());
        modelAndView.addObject("departments", departmentService.findAll());
        return modelAndView;
    }

    @PostMapping("/employees/create_edit")
    @Override
    public String saveOrUpdate(Employee entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "Employees/create_edit";
        }
        if (entity.getManagedDepartment().getId() == -1) {
            entity.setManagedDepartment(null);
        }
        Employee savedEmployee = employeeService.save(entity);
        return "redirect:/Employees";
    }

    @GetMapping("/employees/details/{id}")
    @Override
    public ModelAndView details(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("Employees/details");
        modelAndView.addObject("employee", employeeService.findById(Long.valueOf(id)));
        return modelAndView;
    }

    @RequestMapping("/employees/delete/{id}")
    @Override
    public String delete(@PathVariable String id) {
        employeeService.deleteById(Long.valueOf(id));
        return "redirect:/employees";
    }
}
