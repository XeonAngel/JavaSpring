package com.example.JavaSpringProject.controllers;

import com.example.JavaSpringProject.models.Specialization;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
    public ModelAndView saveOrUpdate(Specialization entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("Specializations/create_edit");
            modelAndView.addObject("departments",departmentService.findAll());
            return modelAndView;
        }
        Specialization savedSpecialization = specializationService.save(entity);
        return new ModelAndView("redirect:/specializations");
    }

    @GetMapping("/specializations/details/{id}")
    @Override
    public ModelAndView details(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("Specializations/details");
        modelAndView.addObject("specialization", specializationService.findById(Long.valueOf(id)));
        return modelAndView;
    }

    @RequestMapping("/specializations/delete/{id}")
    @Override
    public String delete(@PathVariable String id) {
        specializationService.deleteById(Long.valueOf(id));
        return "redirect:/specializations";
    }
}
