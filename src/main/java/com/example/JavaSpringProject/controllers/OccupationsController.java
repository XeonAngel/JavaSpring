package com.example.JavaSpringProject.controllers;

import com.example.JavaSpringProject.models.Occupation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OccupationsController extends BaseController<Occupation> {
    @GetMapping("/occupations")
    @Override
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("Occupations/index");
        List<Occupation> occupations = occupationService.findAll();
        modelAndView.addObject("occupations", occupations);
        return modelAndView;
    }

    @GetMapping("/occupations/create")
    @Override
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("Occupations/create_edit");
        modelAndView.addObject("occupation", new Occupation());
        return modelAndView;
    }

    @GetMapping("/occupations/edit/{id}")
    @Override
    public ModelAndView edit(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("Occupations/create_edit");
        modelAndView.addObject("occupation", occupationService.findById(Long.valueOf(id)));
        return modelAndView;
    }

    @PostMapping("/occupations/create_edit")
    @Override
    public String saveOrUpdate(Occupation entity) {
        Occupation savedOccupation =  occupationService.save(entity);
        return "redirect:/occupations";
    }

    @GetMapping("/occupations/details/{id}")
    @Override
    public ModelAndView details(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("Occupations/details");
        modelAndView.addObject("occupation", occupationService.findById(Long.valueOf(id)));
        return modelAndView;
    }

    @RequestMapping("/occupations/delete/{id}")
    @Override
    public String delete(@PathVariable String id) {
        occupationService.deleteById(Long.valueOf(id));
        return "redirect:/occupations";
    }
}
