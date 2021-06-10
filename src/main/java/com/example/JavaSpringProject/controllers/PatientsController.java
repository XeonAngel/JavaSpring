package com.example.JavaSpringProject.controllers;

import com.example.JavaSpringProject.models.Enums.BloodType;
import com.example.JavaSpringProject.models.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PatientsController extends BaseController<Patient> {
    @GetMapping("/patients")
    @Override
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("Patients/index");
        List<Patient> patients = patientService.findAll();
        modelAndView.addObject("patients", patients);
        return modelAndView;
    }

    @GetMapping("/patients/create")
    @Override
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("Patients/create_edit");
        modelAndView.addObject("patient", new Patient());
        modelAndView.addObject("bloodTypes", BloodType.values());
        return modelAndView;
    }

    @GetMapping("/patients/edit/{id}")
    @Override
    public ModelAndView edit(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("Patients/create_edit");
        modelAndView.addObject("patient", patientService.findById(Long.valueOf(id)));
        modelAndView.addObject("bloodTypes", BloodType.values());
        return modelAndView;
    }

    @PostMapping("/patients/create_edit")
    @Override
    public String saveOrUpdate(Patient entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "Patients/create_edit";
        }
        Patient savedPatient = patientService.save(entity);
        return "redirect:/Patients";
    }

    @GetMapping("/patients/details/{id}")
    @Override
    public ModelAndView details(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("Patients/details");
        modelAndView.addObject("patient", patientService.findById(Long.valueOf(id)));
        return modelAndView;
    }

    @RequestMapping("/patients/delete/{id}")
    @Override
    public String delete(@PathVariable String id) {
        patientService.deleteById(Long.valueOf(id));
        return "redirect:/patients";
    }
}
