package com.example.JavaSpringProject.controllers;

import com.example.JavaSpringProject.models.Specialization;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SpecializationsController extends BaseController<Specialization> {
    @GetMapping("/specializations")
    @Override
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("Specializations/index");
        List<Specialization> specializations = specializationService.findAll();
        modelAndView.addObject("specializations", specializations);
        return modelAndView;
    }

    @GetMapping("/specializations/create")
    @Override
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("Specializations/create_edit");
        modelAndView.addObject("specialization", new Specialization());
        modelAndView.addObject("departments",departmentService.findAll());
        return modelAndView;
    }

    @GetMapping("/specializations/edit/{id}")
    @Override
    public ModelAndView edit(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("Specializations/create_edit");
        modelAndView.addObject("specialization", specializationService.findById(Long.valueOf(id)));
        modelAndView.addObject("departments",departmentService.findAll());
        return modelAndView;
    }

    @PostMapping("/specializations/create_edit")
    @Override
    public String saveOrUpdate(Specialization entity) {
        Specialization savedSpecialization = specializationService.save(entity);
        return "redirect:/specializations";
    }

    @GetMapping("/specializations/details/{id}")
    @Override
    public ModelAndView details(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("Specializations/details");
        modelAndView.addObject("specialization", specializationService.findById(Long.valueOf(id)));
        return modelAndView;
    }
    //TODO: try Catch
    @RequestMapping("/specializations/delete/{id}")
    @Override
    public String delete(@PathVariable String id) {
        specializationService.deleteById(Long.valueOf(id));
        return "redirect:/specializations";
    }
}
