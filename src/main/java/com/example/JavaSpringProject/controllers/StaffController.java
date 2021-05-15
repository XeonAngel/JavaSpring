package com.example.JavaSpringProject.controllers;

import com.example.JavaSpringProject.models.Distributor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StaffController extends BaseController<Distributor> {
    @GetMapping("/distributors")
    @Override
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("Distributors/index");
        List<Distributor> distributors = distributorService.findAll();
        modelAndView.addObject("distributors", distributors);
        return modelAndView;
    }

    @GetMapping("/distributors/create")
    @Override
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("Distributors/create_edit");
        modelAndView.addObject("distributor", new Distributor());
        return modelAndView;
    }

    @GetMapping("/distributors/edit/{id}")
    @Override
    public ModelAndView edit(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("Distributors/create_edit");
        modelAndView.addObject("distributor", distributorService.findById(Long.valueOf(id)));
        return modelAndView;
    }

    @PostMapping("/distributors/create_edit")
    @Override
    public String saveOrUpdate(Distributor entity) {
        Distributor savedDistributor = distributorService.save(entity);
        return "redirect:/distributors";
    }

    @GetMapping("/distributors/details/{id}")
    @Override
    public ModelAndView details(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("Distributors/details");
        modelAndView.addObject("distributor", distributorService.findById(Long.valueOf(id)));
        return modelAndView;
    }

    @RequestMapping("/distributors/delete/{id}")
    @Override
    public String delete(@PathVariable String id) {
        distributorService.deleteById(Long.valueOf(id));
        return "redirect:/distributors";
    }
}
