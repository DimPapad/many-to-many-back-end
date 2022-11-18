/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.manytomany.models;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author mhtso
 */
@Entity
@Table(name = "professor")
@NamedQueries({
    @NamedQuery(name = "Professor.findAll", query = "SELECT p FROM Professor p"),
    @NamedQuery(name = "Professor.findByPrSsn", query = "SELECT p FROM Professor p WHERE p.prSsn = :prSsn"),
    @NamedQuery(name = "Professor.findByPrFname", query = "SELECT p FROM Professor p WHERE p.prFname = :prFname"),
    @NamedQuery(name = "Professor.findByPrLname", query = "SELECT p FROM Professor p WHERE p.prLname = :prLname"),
    @NamedQuery(name = "Professor.findByPrProfession", query = "SELECT p FROM Professor p WHERE p.prProfession = :prProfession"),
    @NamedQuery(name = "Professor.findByPrMainExpertise", query = "SELECT p FROM Professor p WHERE p.prMainExpertise = :prMainExpertise"),
    @NamedQuery(name = "Professor.findByPrOfficeLocation", query = "SELECT p FROM Professor p WHERE p.prOfficeLocation = :prOfficeLocation"),
    @NamedQuery(name = "Professor.findByPrMobileNumber", query = "SELECT p FROM Professor p WHERE p.prMobileNumber = :prMobileNumber"),
    @NamedQuery(name = "Professor.findByPrOtherPhoneNumber", query = "SELECT p FROM Professor p WHERE p.prOtherPhoneNumber = :prOtherPhoneNumber")})
public class Professor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pr_ssn")
    private Integer prSsn;
    @Column(name = "pr_fname")
    private String prFname;
    @Column(name = "pr_lname")
    private String prLname;
    @Column(name = "pr_profession")
    private String prProfession;
    @Column(name = "pr_main_expertise")
    private String prMainExpertise;
    @Column(name = "pr_office_location")
    private String prOfficeLocation;
    @Column(name = "pr_mobile_number")
    private Long prMobileNumber;
    @Column(name = "pr_other_phone_number")
    private Long prOtherPhoneNumber;
    @Lob
    @Column(name = "pr_identity_document")
    private byte[] prIdentityDocument;
    @JoinTable(name = "university_professor", joinColumns = {
        @JoinColumn(name = "upr_pr_ssn", referencedColumnName = "pr_ssn")}, inverseJoinColumns = {
        @JoinColumn(name = "upr_u_id", referencedColumnName = "u_id")})
    @ManyToMany
    private Set<University> universitySet;
    @JoinTable(name = "professor_student", joinColumns = {
        @JoinColumn(name = "prst_pr_ssn", referencedColumnName = "pr_ssn")}, inverseJoinColumns = {
        @JoinColumn(name = "prst_st_registration_number", referencedColumnName = "st_registration_number")})
    @ManyToMany
    private Set<Student> studentSet;

    public Professor() {
    }

    public Professor(Integer prSsn) {
        this.prSsn = prSsn;
    }

    public Integer getPrSsn() {
        return prSsn;
    }

    public void setPrSsn(Integer prSsn) {
        this.prSsn = prSsn;
    }

    public String getPrFname() {
        return prFname;
    }

    public void setPrFname(String prFname) {
        this.prFname = prFname;
    }

    public String getPrLname() {
        return prLname;
    }

    public void setPrLname(String prLname) {
        this.prLname = prLname;
    }

    public String getPrProfession() {
        return prProfession;
    }

    public void setPrProfession(String prProfession) {
        this.prProfession = prProfession;
    }

    public String getPrMainExpertise() {
        return prMainExpertise;
    }

    public void setPrMainExpertise(String prMainExpertise) {
        this.prMainExpertise = prMainExpertise;
    }

    public String getPrOfficeLocation() {
        return prOfficeLocation;
    }

    public void setPrOfficeLocation(String prOfficeLocation) {
        this.prOfficeLocation = prOfficeLocation;
    }

    public Long getPrMobileNumber() {
        return prMobileNumber;
    }

    public void setPrMobileNumber(Long prMobileNumber) {
        this.prMobileNumber = prMobileNumber;
    }

    public Long getPrOtherPhoneNumber() {
        return prOtherPhoneNumber;
    }

    public void setPrOtherPhoneNumber(Long prOtherPhoneNumber) {
        this.prOtherPhoneNumber = prOtherPhoneNumber;
    }

    public byte[] getPrIdentityDocument() {
        return prIdentityDocument;
    }

    public void setPrIdentityDocument(byte[] prIdentityDocument) {
        this.prIdentityDocument = prIdentityDocument;
    }

    public Set<University> getUniversitySet() {
        return universitySet;
    }

    public void setUniversitySet(Set<University> universitySet) {
        this.universitySet = universitySet;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prSsn != null ? prSsn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.prSsn == null && other.prSsn != null) || (this.prSsn != null && !this.prSsn.equals(other.prSsn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.manytomany.models.Professor[ prSsn=" + prSsn + " ]";
    }

}
