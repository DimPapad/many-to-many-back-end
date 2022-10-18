/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.manytomany.models;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mhtso
 */
@Entity
@Table(name = "student")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStRegistrationNumber", query = "SELECT s FROM Student s WHERE s.stRegistrationNumber = :stRegistrationNumber"),
    @NamedQuery(name = "Student.findByStSsn", query = "SELECT s FROM Student s WHERE s.stSsn = :stSsn"),
    @NamedQuery(name = "Student.findByStFname", query = "SELECT s FROM Student s WHERE s.stFname = :stFname"),
    @NamedQuery(name = "Student.findByStLname", query = "SELECT s FROM Student s WHERE s.stLname = :stLname"),
    @NamedQuery(name = "Student.findByStDateOfEnrollment", query = "SELECT s FROM Student s WHERE s.stDateOfEnrollment = :stDateOfEnrollment"),
    @NamedQuery(name = "Student.findByStMobileNumber", query = "SELECT s FROM Student s WHERE s.stMobileNumber = :stMobileNumber"),
    @NamedQuery(name = "Student.findByStOtherPhoneNumber", query = "SELECT s FROM Student s WHERE s.stOtherPhoneNumber = :stOtherPhoneNumber")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "st_registration_number")
    private Integer stRegistrationNumber;
    @Basic(optional = false)
    @Column(name = "st_ssn")
    private int stSsn;
    @Column(name = "st_fname")
    private String stFname;
    @Column(name = "st_lname")
    private String stLname;
    @Basic(optional = false)
    @Column(name = "st_date_of_enrollment")
    @Temporal(TemporalType.DATE)
    private Date stDateOfEnrollment;
    @Column(name = "st_mobile_number")
    private BigInteger stMobileNumber;
    @Column(name = "st_other_phone_number")
    private BigInteger stOtherPhoneNumber;
    @Lob
    @Column(name = "st_identity_document")
    private byte[] stIdentityDocument;
    @JoinTable(name = "university_student", joinColumns = {
        @JoinColumn(name = "ust_st_registration_number", referencedColumnName = "st_registration_number")}, inverseJoinColumns = {
        @JoinColumn(name = "ust_u_id", referencedColumnName = "u_id")})
    @ManyToMany
    private Set<University> universitySet;
    @ManyToMany(mappedBy = "studentSet")
    private Set<Professor> professorSet;

    public Student() {
    }

    public Student(Integer stRegistrationNumber) {
        this.stRegistrationNumber = stRegistrationNumber;
    }

    public Student(Integer stRegistrationNumber, int stSsn, Date stDateOfEnrollment) {
        this.stRegistrationNumber = stRegistrationNumber;
        this.stSsn = stSsn;
        this.stDateOfEnrollment = stDateOfEnrollment;
    }

    public Integer getStRegistrationNumber() {
        return stRegistrationNumber;
    }

    public void setStRegistrationNumber(Integer stRegistrationNumber) {
        this.stRegistrationNumber = stRegistrationNumber;
    }

    public int getStSsn() {
        return stSsn;
    }

    public void setStSsn(int stSsn) {
        this.stSsn = stSsn;
    }

    public String getStFname() {
        return stFname;
    }

    public void setStFname(String stFname) {
        this.stFname = stFname;
    }

    public String getStLname() {
        return stLname;
    }

    public void setStLname(String stLname) {
        this.stLname = stLname;
    }

    public Date getStDateOfEnrollment() {
        return stDateOfEnrollment;
    }

    public void setStDateOfEnrollment(Date stDateOfEnrollment) {
        this.stDateOfEnrollment = stDateOfEnrollment;
    }

    public BigInteger getStMobileNumber() {
        return stMobileNumber;
    }

    public void setStMobileNumber(BigInteger stMobileNumber) {
        this.stMobileNumber = stMobileNumber;
    }

    public BigInteger getStOtherPhoneNumber() {
        return stOtherPhoneNumber;
    }

    public void setStOtherPhoneNumber(BigInteger stOtherPhoneNumber) {
        this.stOtherPhoneNumber = stOtherPhoneNumber;
    }

    public byte[] getStIdentityDocument() {
        return stIdentityDocument;
    }

    public void setStIdentityDocument(byte[] stIdentityDocument) {
        this.stIdentityDocument = stIdentityDocument;
    }

    public Set<University> getUniversitySet() {
        return universitySet;
    }

    public void setUniversitySet(Set<University> universitySet) {
        this.universitySet = universitySet;
    }

    public Set<Professor> getProfessorSet() {
        return professorSet;
    }

    public void setProfessorSet(Set<Professor> professorSet) {
        this.professorSet = professorSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stRegistrationNumber != null ? stRegistrationNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.stRegistrationNumber == null && other.stRegistrationNumber != null) || (this.stRegistrationNumber != null && !this.stRegistrationNumber.equals(other.stRegistrationNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.manytomany.models.Student[ stRegistrationNumber=" + stRegistrationNumber + " ]";
    }
    
}
