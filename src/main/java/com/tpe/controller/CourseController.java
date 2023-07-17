package com.tpe.controller;

import com.tpe.domain.Course;
import com.tpe.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/courses")  //http://localhost:8080/MvcPractice/courses
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/form")                  //http://localhost:8080/MvcPractice/courses/form
    public String showFormCourse(@ModelAttribute("course")Course course){
        return "courseForm";
    }
    //http://localhost:8080/MvcPractice/courses/save
    @PostMapping("/saveCourse")
    public String saveCourse (@ModelAttribute Course course){
        courseService.saveCourse(course);
        return "redirect:/courses";
    }

    @GetMapping
    public ModelAndView getAllCourses(){
        ModelAndView mav = new ModelAndView();
        List<Course> courses = courseService.getAllCourse();
        mav.addObject("courses",courses);
        mav.setViewName("courses");
        return mav;
    }


    //update
    //http://localhost:8080/MvcPractice/courses/update?id=1

//    @GetMapping("/update")
//    public String showUpdateForm(@RequestParam("id") Long id, Model model){
//        Course foundCourse = courseService.getById(id);
//        model.addAttribute("course",foundCourse);
//        return "courseForm";
//    }
        @GetMapping("/update")
        public ModelAndView showUpdateForm(@RequestParam("id") Long id){
        Course foundCourse = courseService.getById(id);
        ModelAndView mav = new ModelAndView();
        mav.addObject("course",foundCourse);
        mav.setViewName("courseForm");
       return mav;
    }


    //delete
    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable ("id") Long id ){
        courseService.delete(id);
        return "redirect:/courses";
    }


    /*
    git remote add origin https://github.com/ZiaRMUSLEH/SpringMVC_Project_courseManagementSystem.git
git branch -M main
git push -u origin main
     */





















//    @PostMapping("/saveCourse")           // http://localhost:8080/MvcPractice/courses/saveCourse
//    public String createCourse(@Valid @ModelAttribute Course course, BindingResult bindingResult){
//       if(bindingResult.hasErrors()){
//           return "courseForm";
//       }
//        courseService.saveCourse(course);
//        return "redirect:/courses";
//    }
//
//    @GetMapping
//    public ModelAndView getCourses(){
//        List<Course> courseList = courseService.getAllCourse();
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("courses",courseList);
//        mav.setViewName("courses");
//        return mav;
//    }




}
