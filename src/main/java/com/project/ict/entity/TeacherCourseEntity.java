package com.project.ict.entity;

import com.project.ict.pojo.CourseData;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TEACHERCOURSE", schema = "SABBIR")

/*
 * call pkg_std_perf.insertTeacherCourse stored procedure
 */

@NamedStoredProcedureQuery(
        name="insertTeacherCourse",
        procedureName="pkg_std_perf.insertTeacherCourse",
        parameters={
                @StoredProcedureParameter(name="inUsername", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inSession", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inDept", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inSemester", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inCourseCode", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="pResult", type=String.class, mode=ParameterMode.OUT)
        }
)


/*
 * call pkg_std_perf.teacherCourseList stored procedure
 */

@NamedStoredProcedureQuery(
        name="teacherCourseList",
        procedureName="pkg_std_perf.teacherCourseList",
        parameters={
                @StoredProcedureParameter(name="inUsername", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="outCourseCursor", type= CourseData.class, mode=ParameterMode.REF_CURSOR)
        }
)

/*
 * call pkg_std_perf.teacherCourseSearchByDept stored procedure
 */

@NamedStoredProcedureQuery(
        name="teacherCourseSearchByDept",
        procedureName="pkg_std_perf.teacherCourseSearchByDept",
        parameters={
                @StoredProcedureParameter(name="inUsername", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inDept", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="outCourseCursor", type= CourseData.class, mode=ParameterMode.REF_CURSOR)
        }
)

/*
 * call pkg_std_perf.teacherCourseSearchByCode stored procedure
 */

@NamedStoredProcedureQuery(
        name="teacherCourseSearchByCode",
        procedureName="pkg_std_perf.teacherCourseSearchByCode",
        parameters={
                @StoredProcedureParameter(name="inUsername", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inCourseCode", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="outCourseCursor", type= CourseData.class, mode=ParameterMode.REF_CURSOR)
        }
)

public class TeacherCourseEntity {
    private Long serialno;
    private String username;
    private String dept;
    private String asession;
    private String semester;
    private String coursecode;

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
    @Column(name = "DEPT")
    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
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
    @Column(name = "SEMESTER")
    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Basic
    @Column(name = "COURSECODE")
    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherCourseEntity that = (TeacherCourseEntity) o;
        return Objects.equals(serialno, that.serialno) &&
                Objects.equals(username, that.username) &&
                Objects.equals(dept, that.dept) &&
                Objects.equals(asession, that.asession) &&
                Objects.equals(semester, that.semester) &&
                Objects.equals(coursecode, that.coursecode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialno, username, dept, asession, semester, coursecode);
    }
}
