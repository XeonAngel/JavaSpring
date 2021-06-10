package com.example.JavaSpringProject.controllers;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

public interface IBaseController<T>{
    ModelAndView index();
    ModelAndView create();
    ModelAndView edit(@PathVariable String id);
    ModelAndView saveOrUpdate(@Valid @ModelAttribute T entity, BindingResult bindingResult);
    ModelAndView details(@PathVariable String id);
    String delete(@PathVariable String id);
}