package com.hug.controller;


import com.codegym.students.model.Student;
import com.codegym.students.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping()
    public ModelAndView getAllStudent(){
        ModelAndView modelAndView = new ModelAndView("/student/list");
        List<Student> students = studentService.findAll();
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreateStudent(){
        ModelAndView modelAndView = new ModelAndView("/student/create");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createStudent(@ModelAttribute Student student){
        ModelAndView modelAndView = new ModelAndView("/student/create");
        studentService.save(student);
        modelAndView.addObject("mess", "Tao moi thanh cong");
        return modelAndView;


    }

}
