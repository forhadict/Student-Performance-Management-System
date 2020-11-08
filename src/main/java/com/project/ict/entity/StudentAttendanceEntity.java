package com.project.ict.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "STUDENTATTENDANCE", schema = "SABBIR")


/*
 * call pkg_std_perf.insertStudentAttendance stored procedure
 */

@NamedStoredProcedureQuery(
        name="insertStudentAttendance",
        procedureName="pkg_std_perf.insertStudentAttendance",
        parameters={
                @StoredProcedureParameter(name="inClassNo", type=Integer.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inUsername", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inSession", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inCourseCode", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="pResult", type=String.class, mode=ParameterMode.OUT)
        }
)

/*
 * call pkg_std_perf.updateStudentAttendance stored procedure
 */

@NamedStoredProcedureQuery(
        name="updateStudentAttendance",
        procedureName="pkg_std_perf.updateStudentAttendance",
        parameters={
                @StoredProcedureParameter(name="inClassNo", type=Integer.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inUsername", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inSession", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inCourseCode", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="pResult", type=String.class, mode=ParameterMode.OUT)
        }
)

/*
 * call pkg_std_perf.studentAttendanceMarks stored procedure
 */

@NamedStoredProcedureQuery(
        name="studentAttendanceMarks",
        procedureName="pkg_std_perf.studentAttendanceMarks",
        parameters={
                @StoredProcedureParameter(name="inUsername", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inSession", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inCourseCode", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="outMarks", type=Integer.class, mode=ParameterMode.OUT)
        }
)

public class StudentAttendanceEntity {
    private Long serialno;
    private Long classno;
    private String username;
    private String asession;
    private String coursecode;
    private Long attendance;

    @Id
    @Column(name = "SERIALNO")
    public Long getSerialno() {
        return serialno;
    }

    public void setSerialno(Long serialno) {
        this.serialno = serialno;
    }

    @Basic
    @Column(name = "CLASSNO")
    public Long getClassno() {
        return classno;
    }

    public void setClassno(Long classno) {
        this.classno = classno;
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
    @Column(name = "ASESSION")
    public String getAsession() {
        return asession;
    }

    public void setAsession(String asession) {
        this.asession = asession;
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
    public Long getAttendance() {
        return attendance;
    }

    public void setAttendance(Long attendance) {
        this.attendance = attendance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentAttendanceEntity that = (StudentAttendanceEntity) o;
        return Objects.equals(serialno, that.serialno) &&
                Objects.equals(classno, that.classno) &&
                Objects.equals(username, that.username) &&
                Objects.equals(asession, that.asession) &&
                Objects.equals(coursecode, that.coursecode) &&
                Objects.equals(attendance, that.attendance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialno, classno, username, asession, coursecode, attendance);
    }
}
