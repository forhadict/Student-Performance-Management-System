package com.project.ict.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "EXAMSTATUS", schema = "SABBIR")

/*
 * call pkg_std_perf.studentExamStatus stored procedure
 */

@NamedStoredProcedureQuery(
        name="studentExamStatus",
        procedureName="pkg_std_perf.studentExamStatus",
        parameters={
                @StoredProcedureParameter(name="inSession", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inCourseCode", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="outCt1S", type=Integer.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outCt2S", type=Integer.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outCt3S", type=Integer.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outCt4S", type=Integer.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outSemesterS", type=Integer.class, mode=ParameterMode.OUT)
        }
)

public class ExamStatusEntity {
    private Long serialno;
    private String asession;
    private String coursecode;
    private Long ct1;
    private Long ct2;
    private Long ct3;
    private Long ct4;
    private Long semesterfinal;

    @Id
    @Column(name = "SERIALNO")
    public Long getSerialno() {
        return serialno;
    }

    public void setSerialno(Long serialno) {
        this.serialno = serialno;
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
    @Column(name = "CT1")
    public Long getCt1() {
        return ct1;
    }

    public void setCt1(Long ct1) {
        this.ct1 = ct1;
    }

    @Basic
    @Column(name = "CT2")
    public Long getCt2() {
        return ct2;
    }

    public void setCt2(Long ct2) {
        this.ct2 = ct2;
    }

    @Basic
    @Column(name = "CT3")
    public Long getCt3() {
        return ct3;
    }

    public void setCt3(Long ct3) {
        this.ct3 = ct3;
    }

    @Basic
    @Column(name = "CT4")
    public Long getCt4() {
        return ct4;
    }

    public void setCt4(Long ct4) {
        this.ct4 = ct4;
    }

    @Basic
    @Column(name = "SEMESTERFINAL")
    public Long getSemesterfinal() {
        return semesterfinal;
    }

    public void setSemesterfinal(Long semesterfinal) {
        this.semesterfinal = semesterfinal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamStatusEntity that = (ExamStatusEntity) o;
        return Objects.equals(serialno, that.serialno) &&
                Objects.equals(asession, that.asession) &&
                Objects.equals(coursecode, that.coursecode) &&
                Objects.equals(ct1, that.ct1) &&
                Objects.equals(ct2, that.ct2) &&
                Objects.equals(ct3, that.ct3) &&
                Objects.equals(ct4, that.ct4) &&
                Objects.equals(semesterfinal, that.semesterfinal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialno, asession, coursecode, ct1, ct2, ct3, ct4, semesterfinal);
    }
}
