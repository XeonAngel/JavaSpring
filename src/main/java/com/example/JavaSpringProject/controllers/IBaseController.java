package com.example.JavaSpringProject.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

public interface IBaseController<T>{
    ModelAndView index();
    ModelAndView create();
    ModelAndView edit(@PathVariable String id);
    String saveOrUpdate(@ModelAttribute T entity);
    ModelAndView details(@PathVariable String id);
    String delete(@PathVariable String id);
}