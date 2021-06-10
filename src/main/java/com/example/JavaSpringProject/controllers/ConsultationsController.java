package com.example.JavaSpringProject.controllers;

import com.example.JavaSpringProject.models.Consultation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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

    @GetMapping("/consultations/create")
    @Override
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("Consultations/create_edit");
        modelAndView.addObject("consultation", new Consultation());
        modelAndView.addObject("patients",patientService.findAll());
        modelAndView.addObject("employees",employeeService.findAllMedicalStaff());
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
    public ModelAndView saveOrUpdate(Consultation entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("Consultations/create_edit");
            modelAndView.addObject("patients",patientService.findAll());
            modelAndView.addObject("employees",employeeService.findAll());
            modelAndView.addObject("drugs",drugService.findAll());
            return modelAndView;
        }
        entity.setCreated(new java.util.Date());
        Consultation savedConsultation = consultationService.save(entity);
        return new ModelAndView("redirect:/consultations");
    }

    @GetMapping("/consultations/details/{id}")
    @Override
    public ModelAndView details(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("Consultations/details");
        modelAndView.addObject("consultation", consultationService.findById(Long.valueOf(id)));
        return modelAndView;
    }

    @RequestMapping("/consultations/delete/{id}")
    @Override
    public String delete(@PathVariable String id) {
        consultationService.deleteById(Long.valueOf(id));
        return "redirect:/consultations";
    }
}
