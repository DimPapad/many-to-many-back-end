/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.manytomany.services;

import com.example.manytomany.models.Course;
import com.example.manytomany.models.University;
import com.example.manytomany.repositories.CourseRepo;
import com.example.manytomany.repositories.UniversityRepo;
import com.github.javafaker.Faker;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mhtso
 */
@Service
public class CourseService implements ICourseService {

    private final CourseRepo courseRepo;
    private final UniversityRepo universityRepo;

    public CourseService(CourseRepo courseRepo, UniversityRepo universityRepo) {
        this.courseRepo = courseRepo;
        this.universityRepo = universityRepo;
    }

    @Override
    @Transactional
    public void addXFakeCourses(int numberOfFakeCourses) {
        Faker faker = new Faker();
        for (int i = 0; i < numberOfFakeCourses; i++) {
            Course course = new Course();
            course.setCClassroom(faker.number().digits(2));
            course.setCLocation("building " + faker.name().lastName());
            course.setCStartDate(faker.date().future(90, TimeUnit.DAYS));
            course.setCEndDate(faker.date().future(180, TimeUnit.DAYS, course.getCStartDate()));
            course.setCWeeklyHours(faker.number().numberBetween(1, 4));
            course.setCName(faker.job().field());
            courseRepo.save(course);
        }
    }

    @Override
    @Transactional
    public void assignUniversityToCourse(int courseId, int universityId) {
        Course course = courseRepo.findByCId(courseId);

        System.out.println(course.getCName());

        University university = universityRepo.findByUId(universityId);
        course.setCUId(university);
        courseRepo.save(course);
    }

    @Override
    @Transactional
    public Course getCourseById(int courseId) {
        Course course = courseRepo.findByCId(courseId);
        return course;
    }

    @Override
    @Transactional
    public void deleteCourseById(int courseId) {
        courseRepo.deleteById(courseId);
    }

    @Override
    public void deleteAllCourses() {
        courseRepo.deleteAll();
    }

}
