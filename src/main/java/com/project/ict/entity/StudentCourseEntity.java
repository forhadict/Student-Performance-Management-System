package com.project.ict.entity;

import com.project.ict.pojo.CourseData;
import com.project.ict.pojo.StudentInfo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "STUDENTCOURSE", schema = "SABBIR")

/*
 * call pkg_std_perf.insertStudentCourse stored procedure
 */

@NamedStoredProcedureQuery(
        name="insertStudentCourse",
        procedureName="pkg_std_perf.insertStudentCourse",
        parameters={
                @StoredProcedureParameter(name="inUsername", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inSession", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inSemester", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inCourseCode", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="pResult", type=String.class, mode=ParameterMode.OUT)
        }
)


/*
 * call pkg_std_perf.studentCourseList stored procedure
 */

@NamedStoredProcedureQuery(
        name="studentCourseList",
        procedureName="pkg_std_perf.studentCourseList",
        parameters={
                @StoredProcedureParameter(name="inUsername", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="outCourseCursor", type= CourseData.class, mode=ParameterMode.REF_CURSOR)
        }
)

/*
 * call pkg_std_perf.studentCourseSearchBySemester stored procedure
 */

@NamedStoredProcedureQuery(
        name="studentCourseSearchBySemester",
        procedureName="pkg_std_perf.studentCourseSearchBySemester",
        parameters={
                @StoredProcedureParameter(name="inUsername", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inSemester", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="outCourseCursor", type= CourseData.class, mode=ParameterMode.REF_CURSOR)
        }
)

/*
 * call pkg_std_perf.studentCourseSearchByCode stored procedure
 */

@NamedStoredProcedureQuery(
        name="studentCourseSearchByCode",
        procedureName="pkg_std_perf.studentCourseSearchByCode",
        parameters={
                @StoredProcedureParameter(name="inUsername", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inCourseCode", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="outCourseCursor", type= CourseData.class, mode=ParameterMode.REF_CURSOR)
        }
)

/*
 * call pkg_std_perf.courseStudentList stored procedure
 */

@NamedStoredProcedureQuery(
        name="courseStudentList",
        procedureName="pkg_std_perf.courseStudentList",
        parameters={
                @StoredProcedureParameter(name="inSession", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inCourseCode", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="outStudentCursor", type= StudentInfo.class, mode=ParameterMode.REF_CURSOR)
        }
)

/*
 * call pkg_std_perf.studentPerformanceData stored procedure
 */

@NamedStoredProcedureQuery(
        name="studentPerformanceData",
        procedureName="pkg_std_perf.studentPerformanceData",
        parameters={
                @StoredProcedureParameter(name="inUsername", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inSession", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inCourseCode", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="outCt1S", type=Integer.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outCt2S", type=Integer.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outCt3S", type=Integer.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outCt4S", type=Integer.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outSemesterS", type=Integer.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outTotalClass", type=Integer.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outAttendance", type=Integer.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outCt1M", type=Integer.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outCt2M", type=Integer.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outCt3M", type=Integer.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outCt4M", type=Integer.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outSemesterM", type=Integer.class, mode=ParameterMode.OUT)
        }
)

public class StudentCourseEntity {
    private Long serialno;
    private String username;
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
        StudentCourseEntity that = (StudentCourseEntity) o;
        return Objects.equals(serialno, that.serialno) &&
                Objects.equals(username, that.username) &&
                Objects.equals(asession, that.asession) &&
                Objects.equals(semester, that.semester) &&
                Objects.equals(coursecode, that.coursecode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialno, username, asession, semester, coursecode);
    }
}
