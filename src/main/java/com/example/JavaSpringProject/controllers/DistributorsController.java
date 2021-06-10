package com.example.JavaSpringProject.controllers;

import com.example.JavaSpringProject.models.Distributor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DistributorsController extends BaseController<Distributor> {
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
    public String saveOrUpdate(Distributor entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "Distributors/create_edit";
        }
        Distributor savedDistributor = distributorService.save(entity);
        return "redirect:/Distributors";
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
