/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.manytomany.controllers;

import com.example.manytomany.services.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mhtso
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    ICourseService courseService;

    @GetMapping("/add/{x}")
    public void addXFakeCourses(@PathVariable int x) {
        courseService.addXFakeCourses(x);
    }

}
