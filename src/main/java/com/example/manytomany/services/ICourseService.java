/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.manytomany.services;

import com.example.manytomany.models.Course;

/**
 *
 * @author mhtso
 */
public interface ICourseService {

    void addXFakeCourses(int numberOfFakeCourses);

    void assignUniversityToCourse(int courseId, int universityId);

    Course getCourseById(int courseId);

    void deleteCourseById(int courseId);

    void deleteAllCourses();

}
