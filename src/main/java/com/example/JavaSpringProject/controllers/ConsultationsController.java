package com.example.JavaSpringProject.controllers;

import com.example.JavaSpringProject.models.Consultation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ConsultationsController extends BaseController<Consultation> {
    @GetMapping("/consultations")
    @Override
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("Consultations/index");
        List<Consultation> consultations = consultationService.findAll();
        modelAndView.addObject("consultations", consultations);
        return modelAndView;
    }

    ///TODO: Find All DOCTORS not every Employee
    @GetMapping("/consultations/create")
    @Override
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("Consultations/create_edit");
        modelAndView.addObject("consultation", new Consultation());
        modelAndView.addObject("patients",patientService.findAll());
        modelAndView.addObject("employees",employeeService.findAll());
        modelAndView.addObject("drugs",drugService.findAll());
        return modelAndView;
    }

    @GetMapping("/consultations/edit/{id}")
    @Override
    public ModelAndView edit(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("Consultations/create_edit");
        modelAndView.addObject("consultation", consultationService.findById(Long.valueOf(id)));
        modelAndView.addObject("patients",patientService.findAll());
        modelAndView.addObject("employees",employeeService.findAll());
        modelAndView.addObject("drugs",drugService.findAll());
        return modelAndView;
    }

    @PostMapping("/consultations/create_edit")
    @Override
    public String saveOrUpdate(Consultation entity) {
        entity.setCreated(new java.util.Date());
        Consultation savedConsultation = consultationService.save(entity);
        return "redirect:/consultations";
    }

    @GetMapping("/consultations/details/{id}")
    @Override
    public ModelAndView details(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("Consultations/details");
        modelAndView.addObject("consultation", consultationService.findById(Long.valueOf(id)));
        return modelAndView;
    }

    //TODO: try Catch
    @RequestMapping("/consultations/delete/{id}")
    @Override
    public String delete(@PathVariable String id) {
        consultationService.deleteById(Long.valueOf(id));
        return "redirect:/consultations";
    }
}
