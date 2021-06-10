package com.example.JavaSpringProject.controllers;

import com.example.JavaSpringProject.models.Consultation;
import org.dom4j.rule.Mode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
public class ConsultationsController extends BaseController<Consultation> {
    @GetMapping("/consultations")
    @Override
    public ModelAndView index() {
        return new ModelAndView("redirect:/consultations/1?sortField=id&sortOrder=asc");
    }

    @GetMapping("/consultations/create")
    @Override
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("Consultations/create_edit");
        modelAndView.addObject("consultation", new Consultation());
        modelAndView.addObject("patients", patientService.findAll());
        modelAndView.addObject("employees", employeeService.findAllMedicalStaff());
        modelAndView.addObject("drugs", drugService.findAll());
        return modelAndView;
    }

    @GetMapping("/consultations/edit/{id}")
    @Override
    public ModelAndView edit(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("Consultations/create_edit");
        modelAndView.addObject("consultation", consultationService.findById(Long.valueOf(id)));
        modelAndView.addObject("patients", patientService.findAll());
        modelAndView.addObject("employees", employeeService.findAll());
        modelAndView.addObject("drugs", drugService.findAll());
        return modelAndView;
    }

    @PostMapping("/consultations/create_edit")
    @Override
    public ModelAndView saveOrUpdate(Consultation entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("Consultations/create_edit");
            modelAndView.addObject("patients", patientService.findAll());
            modelAndView.addObject("employees", employeeService.findAll());
            modelAndView.addObject("drugs", drugService.findAll());
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

    @GetMapping("/consultations/{pageNo}")
    public String getAllConsultations(@PathVariable(value = "pageNo") int pageNo,
                                      @RequestParam("sortField") String sortField,
                                      @RequestParam("sortOrder") String sortOrder,
                                      Model model) {
        int pageSize = 10;

        Page<Consultation> page = consultationService.findPaginated(pageNo, pageSize, sortField, sortOrder);
        List<Consultation> consultations = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortOrder", sortOrder);
        model.addAttribute("reverseSortOrder", sortOrder.equals(Sort.Direction.ASC.name().toLowerCase())
                ? Sort.Direction.DESC.name().toLowerCase()
                : Sort.Direction.ASC.name().toLowerCase());

        model.addAttribute("consultations", consultations);

        return "Consultations/index";
    }
}
