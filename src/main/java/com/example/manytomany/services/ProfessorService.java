/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.manytomany.services;

import com.example.manytomany.models.Professor;
import com.example.manytomany.repositories.ProfessorRepo;
import com.github.javafaker.Faker;
import java.math.BigInteger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mhtso
 */
@Service
public class ProfessorService implements IProfessorService {

    private final ProfessorRepo professorRepo;

    public ProfessorService(ProfessorRepo professorRepo) {
        this.professorRepo = professorRepo;
    }

    @Override
    @Transactional
    public void addXFakeUniversities(int numberOfFakeProfessors) {
        Faker faker = new Faker();
        for (int i = 0; i < numberOfFakeProfessors; i++) {
            Professor professor = new Professor();
            professor.setPrSsn(faker.number().numberBetween(100000000, 999999999));
            professor.setPrFname(faker.name().firstName());
            professor.setPrLname(faker.name().lastName());
            professor.setPrProfession(faker.job().field());
            professor.setPrMainExpertise(faker.job().keySkills());
            professor.setPrOfficeLocation("building " + faker.name().lastName());
            professor.setPrMobileNumber(Long.parseLong("69" + faker.number().digits(10)));
            professor.setPrOtherPhoneNumber(Long.parseLong("28" + faker.number().digits(10)));
            professorRepo.save(professor);
        }
    }

}
