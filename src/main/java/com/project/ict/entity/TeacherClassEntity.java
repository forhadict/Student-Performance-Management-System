package com.project.ict.entity;

import com.project.ict.pojo.ClassData;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TEACHERCLASS", schema = "SABBIR")

/*
 * call pkg_std_perf.insertTeacherClass stored procedure
 */

@NamedStoredProcedureQuery(
        name="insertTeacherClass",
        procedureName="pkg_std_perf.insertTeacherClass",
        parameters={
                @StoredProcedureParameter(name="inUsername", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inSession", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inCourseCode", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inClassDate", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="pResult", type=String.class, mode=ParameterMode.OUT)
        }
)


/*
 * call pkg_std_perf.teacherClassList stored procedure
 */

@NamedStoredProcedureQuery(
        name="teacherClassList",
        procedureName="pkg_std_perf.teacherClassList",
        parameters={
                @StoredProcedureParameter(name="inUsername", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inSession", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inCourseCode", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="outClassCursor", type= ClassData.class, mode=ParameterMode.REF_CURSOR)
        }
)

public class TeacherClassEntity {
    private Long serialno;
    private String username;
    private String asession;
    private String coursecode;
    private String classdate;

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
    @Column(name = "CLASSDATE")
    public String getClassdate() {
        return classdate;
    }

    public void setClassdate(String classdate) {
        this.classdate = classdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherClassEntity that = (TeacherClassEntity) o;
        return Objects.equals(serialno, that.serialno) &&
                Objects.equals(username, that.username) &&
                Objects.equals(asession, that.asession) &&
                Objects.equals(coursecode, that.coursecode) &&
                Objects.equals(classdate, that.classdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialno, username, asession, coursecode, classdate);
    }
}
