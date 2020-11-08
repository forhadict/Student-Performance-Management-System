package com.project.ict.entity;

import com.project.ict.pojo.StudentInfo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "STUDENTCT1", schema = "SABBIR")

/*
 * call pkg_std_perf.insertStudentMarks stored procedure
 */

@NamedStoredProcedureQuery(
        name="insertStudentMarks",
        procedureName="pkg_std_perf.insertStudentMarks",
        parameters={
                @StoredProcedureParameter(name="inSaveType", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inUsername", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inSession", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inCourseCode", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="pResult", type=String.class, mode=ParameterMode.OUT)
        }
)

/*
 * call pkg_std_perf.updateStudentMarks stored procedure
 */

@NamedStoredProcedureQuery(
        name="updateStudentMarks",
        procedureName="pkg_std_perf.updateStudentMarks",
        parameters={
                @StoredProcedureParameter(name="inSaveType", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inUsername", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inSession", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inCourseCode", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inMarks", type=Integer.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="pResult", type=String.class, mode=ParameterMode.OUT)
        }
)

/*
 * call pkg_std_perf.studentCT1Marks stored procedure
 */

@NamedStoredProcedureQuery(
        name="studentCT1Marks",
        procedureName="pkg_std_perf.studentCT1Marks",
        parameters={
                @StoredProcedureParameter(name="inUsername", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inSession", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inCourseCode", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="outMarks", type=Integer.class, mode=ParameterMode.OUT)
        }
)

/*
 * call pkg_std_perf.studentExamMarksList stored procedure
 */

@NamedStoredProcedureQuery(
        name="studentExamMarksList",
        procedureName="pkg_std_perf.studentExamMarksList",
        parameters={
                @StoredProcedureParameter(name="inExamType", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inSession", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inCourseCode", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="outStudentCursor", type= StudentInfo.class, mode=ParameterMode.REF_CURSOR)
        }
)

public class StudentCT1Entity {
    private Long serialno;
    private String username;
    private String coursecode;
    private String asession;
    private Double marks;

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
    @Column(name = "ASESSION")
    public String getAsession() {
        return asession;
    }

    public void setAsession(String asession) {
        this.asession = asession;
    }

    @Basic
    @Column(name = "MARKS")
    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentCT1Entity that = (StudentCT1Entity) o;
        return Objects.equals(serialno, that.serialno) &&
                Objects.equals(username, that.username) &&
                Objects.equals(coursecode, that.coursecode) &&
                Objects.equals(asession, that.asession) &&
                Objects.equals(marks, that.marks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialno, username, coursecode, asession, marks);
    }
}
