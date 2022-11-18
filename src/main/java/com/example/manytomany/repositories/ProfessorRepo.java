/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.manytomany.repositories;

import com.example.manytomany.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mhtso
 */
public interface ProfessorRepo extends JpaRepository<Professor, Integer> {

}
