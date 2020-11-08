package com.project.ict.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "STUDENTPERFORMANCE", schema = "SABBIR")
public class StudentPerformanceEntity {
    private Long serialno;
    private String username;
    private String coursecode;
    private Double attendance;
    private Double ctmarks;
    private Double semesterfinal;
    private Double average;

    @Id
    @Column(name = "SERIALNO")
    public Long getSerialno() {
        return serialno;
    }

    public void setSerialno(Long serialno) {
        this.serialno = serialno;
    }

    @Basic
    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "COURSECODE")
    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    @Basic
    @Column(name = "ATTENDANCE")
    public Double getAttendance() {
        return attendance;
    }

    public void setAttendance(Double attendance) {
        this.attendance = attendance;
    }

    @Basic
    @Column(name = "CTMARKS")
    public Double getCtmarks() {
        return ctmarks;
    }

    public void setCtmarks(Double ctmarks) {
        this.ctmarks = ctmarks;
    }

    @Basic
    @Column(name = "SEMESTERFINAL")
    public Double getSemesterfinal() {
        return semesterfinal;
    }

    public void setSemesterfinal(Double semesterfinal) {
        this.semesterfinal = semesterfinal;
    }

    @Basic
    @Column(name = "AVERAGE")
    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentPerformanceEntity that = (StudentPerformanceEntity) o;
        return Objects.equals(serialno, that.serialno) &&
                Objects.equals(username, that.username) &&
                Objects.equals(coursecode, that.coursecode) &&
                Objects.equals(attendance, that.attendance) &&
                Objects.equals(ctmarks, that.ctmarks) &&
                Objects.equals(semesterfinal, that.semesterfinal) &&
                Objects.equals(average, that.average);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialno, username, coursecode, attendance, ctmarks, semesterfinal, average);
    }
}
