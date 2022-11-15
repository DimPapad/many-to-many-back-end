/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.manytomany.services;

import com.example.manytomany.models.University;
import com.example.manytomany.repositories.UniversityRepo;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void addXFakeUniversities(int numberOfFakeUniversities) {
        Faker faker = new Faker();
        for (int i = 0; i < numberOfFakeUniversities; i++) {
            University university = new University();
            university.setUName(faker.university().name());
            university.setUDiplomaExpertise(faker.job().field());
            university.setULocation(faker.address().cityName());
            universityRepo.save(university);
        }

    }

}
