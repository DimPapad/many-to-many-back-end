/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.manytomany.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "course")
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findByCId", query = "SELECT c FROM Course c WHERE c.cId = :cId"),
    @NamedQuery(name = "Course.findByCName", query = "SELECT c FROM Course c WHERE c.cName = :cName"),
    @NamedQuery(name = "Course.findByCStartDate", query = "SELECT c FROM Course c WHERE c.cStartDate = :cStartDate"),
    @NamedQuery(name = "Course.findByCEndDate", query = "SELECT c FROM Course c WHERE c.cEndDate = :cEndDate"),
    @NamedQuery(name = "Course.findByCWeeklyHours", query = "SELECT c FROM Course c WHERE c.cWeeklyHours = :cWeeklyHours"),
    @NamedQuery(name = "Course.findByCClassroom", query = "SELECT c FROM Course c WHERE c.cClassroom = :cClassroom"),
    @NamedQuery(name = "Course.findByCLocation", query = "SELECT c FROM Course c WHERE c.cLocation = :cLocation")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_id")
    private Integer cId;
    @Column(name = "c_name")
    private String cName;
    @Column(name = "c_start_date")
    @Temporal(TemporalType.DATE)
    private Date cStartDate;
    @Column(name = "c_end_date")
    @Temporal(TemporalType.DATE)
    private Date cEndDate;
    @Column(name = "c_weekly_hours")
    private Integer cWeeklyHours;
    @Column(name = "c_classroom")
    private String cClassroom;
    @Column(name = "c_location")
    private String cLocation;
    @JoinColumn(name = "c_u_id", referencedColumnName = "u_id")
    @ManyToOne
    private University cUId;

    public Course() {
    }

    public Course(Integer cId) {
        this.cId = cId;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public Date getCStartDate() {
        return cStartDate;
    }

    public void setCStartDate(Date cStartDate) {
        this.cStartDate = cStartDate;
    }

    public Date getCEndDate() {
        return cEndDate;
    }

    public void setCEndDate(Date cEndDate) {
        this.cEndDate = cEndDate;
    }

    public Integer getCWeeklyHours() {
        return cWeeklyHours;
    }

    public void setCWeeklyHours(Integer cWeeklyHours) {
        this.cWeeklyHours = cWeeklyHours;
    }

    public String getCClassroom() {
        return cClassroom;
    }

    public void setCClassroom(String cClassroom) {
        this.cClassroom = cClassroom;
    }

    public String getCLocation() {
        return cLocation;
    }

    public void setCLocation(String cLocation) {
        this.cLocation = cLocation;
    }

    public University getCUId() {
        return cUId;
    }

    public void setCUId(University cUId) {
        this.cUId = cUId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cId != null ? cId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.manytomany.models.Course[ cId=" + cId + " ]";
    }

}
