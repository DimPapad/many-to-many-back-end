/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.manytomany.controllers;

import com.example.manytomany.services.IProfessorService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mhtso
 */
@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private final IProfessorService professorService;

    public ProfessorController(IProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping("/add/{numberOfFakeProfessors}")
    public void addXFakeProfessors(@PathVariable int numberOfFakeProfessors) {
        professorService.addXFakeUniversities(numberOfFakeProfessors);
    }
}
