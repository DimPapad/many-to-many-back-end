/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.manytomany.controllers;

import com.example.manytomany.models.Course;
import com.example.manytomany.models.Professor;
import com.example.manytomany.models.Student;
import com.example.manytomany.models.University;
import com.example.manytomany.services.IUniversityService;
import java.util.Set;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mhtso
 */
@RestController
@RequestMapping("/university")
public class UniversityController {

    private final IUniversityService universityService;

    public UniversityController(IUniversityService universityService) {
        this.universityService = universityService;
    }

    @PostMapping("/add/{numberOfFakeUniversities}")
    public void addXFakeUniversities(@PathVariable int numberOfFakeUniversities) {
        universityService.addXFakeUniversities(numberOfFakeUniversities);
    }

    @GetMapping("/get/{universityId}")
    public University getUniversityById(@PathVariable int universityId) {
        University university = universityService.getUniversityById(universityId);
        return university;
    }

    @GetMapping("/get/{universityId}/courseset")
    public Set<Course> getUniversitysCourseSetById(@PathVariable int universityId) {
        Set<Course> courseSet = universityService.getUniversitysCourseSetById(universityId);
        return courseSet;
    }

    @GetMapping("/get/{universityId}/professorset")
    public Set<Professor> getUniversitysProfessorSetById(@PathVariable int universityId) {
        Set<Professor> professorSet = universityService.getUniversitysProfessorSetById(universityId);
        return professorSet;
    }

    @GetMapping("/get/{universityId}/studentset")
    public Set<Student> getUniversitysStudentSetById(@PathVariable int universityId) {
        Set<Student> studentSet = universityService.getUniversitysStudentSetById(universityId);
        return studentSet;
    }

    @DeleteMapping("/delete/{universityId}")
    public void deleteUniversityById(@PathVariable int universityId) {
        universityService.deleteUniversityById(universityId);
    }

    @DeleteMapping("/delete/all")
    public void deleteAllUniversities() {
        universityService.deleteAllUniversities();
    }
}
