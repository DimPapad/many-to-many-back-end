/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.manytomany.services;

import com.example.manytomany.models.Course;
import com.example.manytomany.models.Professor;
import com.example.manytomany.models.Student;
import com.example.manytomany.models.University;
import com.example.manytomany.repositories.UniversityRepo;
import com.github.javafaker.Faker;
import java.util.Set;
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

    @Override
    @Transactional
    public University getUniversityById(int universityId) {
        University university = universityRepo.findByUId(universityId);
        return university;
    }

    @Override
    @Transactional
    public Set<Course> getUniversitysCourseSetById(int universityId) {
        Set<Course> courseSet = universityRepo.findByUId(universityId).getCourseSet();
        return courseSet;
    }

    @Override
    @Transactional
    public Set<Professor> getUniversitysProfessorSetById(int universityId) {
        Set<Professor> professorSet = universityRepo.findByUId(universityId).getProfessorSet();
        return professorSet;
    }

    @Override
    @Transactional
    public Set<Student> getUniversitysStudentSetById(int universityId) {
        Set<Student> studentSet = universityRepo.findByUId(universityId).getStudentSet();
        return studentSet;
    }

    @Override
    @Transactional
    public void deleteUniversityById(int universityId) {
        universityRepo.deleteById(universityId);
        /*
        TO-DO
        Action when a University has a Course
        - Are you sure you want to delete the University? YES/NO
        - If yes, do you want to delete their Courses as well? YES/NO
        */
    }

    @Override
    @Transactional
    public void deleteAllUniversities() {
        universityRepo.deleteAll();
    }

}
