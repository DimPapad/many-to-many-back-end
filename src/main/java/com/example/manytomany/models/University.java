/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.manytomany.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author mhtso
 */
@Entity
@Table(name = "university")
@NamedQueries({
    @NamedQuery(name = "University.findAll", query = "SELECT u FROM University u"),
    @NamedQuery(name = "University.findByUId", query = "SELECT u FROM University u WHERE u.uId = :uId"),
    @NamedQuery(name = "University.findByUName", query = "SELECT u FROM University u WHERE u.uName = :uName"),
    @NamedQuery(name = "University.findByUDiplomaExpertise", query = "SELECT u FROM University u WHERE u.uDiplomaExpertise = :uDiplomaExpertise"),
    @NamedQuery(name = "University.findByULocation", query = "SELECT u FROM University u WHERE u.uLocation = :uLocation")})
public class University implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "u_id")
    private Integer uId;
    @Column(name = "u_name")
    private String uName;
    @Column(name = "u_diploma_expertise")
    private String uDiplomaExpertise;
    @Column(name = "u_location")
    private String uLocation;
    @ManyToMany(mappedBy = "universitySet")
    @JsonIgnore
    private Set<Professor> professorSet;
    @ManyToMany(mappedBy = "universitySet")
    @JsonIgnore
    private Set<Student> studentSet;
    @OneToMany(mappedBy = "cUId")
    @JsonIgnore
    private Set<Course> courseSet;

    public University() {
    }

    public University(Integer uId) {
        this.uId = uId;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public String getUName() {
        return uName;
    }

    public void setUName(String uName) {
        this.uName = uName;
    }

    public String getUDiplomaExpertise() {
        return uDiplomaExpertise;
    }

    public void setUDiplomaExpertise(String uDiplomaExpertise) {
        this.uDiplomaExpertise = uDiplomaExpertise;
    }

    public String getULocation() {
        return uLocation;
    }

    public void setULocation(String uLocation) {
        this.uLocation = uLocation;
    }

    public Set<Professor> getProfessorSet() {
        return professorSet;
    }

    public void setProfessorSet(Set<Professor> professorSet) {
        this.professorSet = professorSet;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public Set<Course> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courseSet = courseSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uId != null ? uId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof University)) {
            return false;
        }
        University other = (University) object;
        if ((this.uId == null && other.uId != null) || (this.uId != null && !this.uId.equals(other.uId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.manytomany.models.University[ uId=" + uId + " ]";
    }

}
