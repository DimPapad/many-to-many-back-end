/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.manytomany.services;

import com.example.manytomany.repositories.UniversityRepo;
import org.springframework.stereotype.Service;

/**
 *
 * @author mhtso
 */
@Service
public class UniversityService implements IUniversityService {

    private final UniversityRepo universityRepo;

    public UniversityService(UniversityRepo universityRepo) {
        this.universityRepo = universityRepo;
    }

    @Override
    public void addXFakeUniversities(int numberOfFakeUniversities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
