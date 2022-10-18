/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.manytomany.repositories;

import com.example.manytomany.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mhtso
 */
@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {

}
