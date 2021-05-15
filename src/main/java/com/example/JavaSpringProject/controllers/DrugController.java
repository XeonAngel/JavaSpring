package com.example.JavaSpringProject.controllers;

import com.example.JavaSpringProject.models.Drug;
import com.example.JavaSpringProject.models.Enums.Drug_Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DrugController extends BaseController<Drug> {
    @GetMapping("/drugs")
    @Override
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("Drugs/index");
        List<Drug> drugs = drugService.findAll();
        modelAndView.addObject("drugs", drugs);
        return modelAndView;
    }

    @GetMapping("/drugs/create")
    @Override
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("Drugs/create_edit");
        modelAndView.addObject("drug", new Drug());
        modelAndView.addObject("categories", Drug_Category.values());
        modelAndView.addObject("distributors",distributorService.findAll());
        return modelAndView;
    }

    @GetMapping("/drugs/edit/{id}")
    @Override
    public ModelAndView edit(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("Drugs/create_edit");
        modelAndView.addObject("drug", drugService.findById(Long.valueOf(id)));
        modelAndView.addObject("categories", Drug_Category.values());
        modelAndView.addObject("distributors",distributorService.findAll());
        return modelAndView;
    }

    @PostMapping("/drugs/create_edit")
    @Override
    public String saveOrUpdate(Drug entity) {
        Drug savedDrug =  drugService.save(entity);
        return "redirect:/drugs";
    }

    @GetMapping("/drugs/details/{id}")
    @Override
    public ModelAndView details(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("Drugs/details");
        modelAndView.addObject("drug", drugService.findById(Long.valueOf(id)));
        return modelAndView;
    }

    @RequestMapping("/drugs/delete/{id}")
    @Override
    public String delete(@PathVariable String id) {
        drugService.deleteById(Long.valueOf(id));
        return "redirect:/drugs";
    }
}
