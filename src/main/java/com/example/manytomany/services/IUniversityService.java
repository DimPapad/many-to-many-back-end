/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.manytomany.services;

import com.example.manytomany.models.Course;
import com.example.manytomany.models.University;
import java.util.Set;

/**
 *
 * @author mhtso
 */
public interface IUniversityService {

    void addXFakeUniversities(int numberOfFakeUniversities);

    University getUniversityById(int universityId);

    Set<Course> getUniversitysCourseSetById(int universityId);

}
