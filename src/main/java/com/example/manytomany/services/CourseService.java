/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.manytomany.services;

import com.example.manytomany.models.Course;
import com.example.manytomany.repositories.CourseRepo;
import com.github.javafaker.Faker;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mhtso
 */
@Service
public class CourseService implements ICourseService {

    @Autowired
    CourseRepo courseRepo;

    @Override
    public void addXFakeCourses(int x) {
        for (int i = 0; i < x; i++) {
            Faker faker = new Faker();
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
}
