/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.manytomany.controllers;

import com.example.manytomany.models.Course;
import com.example.manytomany.services.ICourseService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mhtso
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    private final ICourseService courseService;

    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/add/{numberOfFakeCourses}")
    public void addXFakeCourses(@PathVariable int numberOfFakeCourses) {
        courseService.addXFakeCourses(numberOfFakeCourses);
    }

    @PutMapping("/university/{courseId}/{universityId}")
    public void assignUniversityToCourse(@PathVariable int courseId, @PathVariable int universityId) {
        courseService.assignUniversityToCourse(courseId, universityId);
    }

    @GetMapping("/get/{courseId}")
    public Course getCourseById(@PathVariable int courseId) {
        Course course = courseService.getCourseById(courseId);
        return course;
    }
    
    @DeleteMapping("/delete/{courseId}")
    public void deleteCourseById(@PathVariable int courseId){
        courseService.deleteCourseById(courseId);
    }
}
