package com.project.ict.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "TEACHERDETAILS", schema = "SABBIR")


/*
 * call pkg_std_perf.insertTeacherDetails stored procedure
 */

@NamedStoredProcedureQuery(
        name="insertTeacherDetails",
        procedureName="pkg_std_perf.insertTeacherDetails",
        parameters={
                @StoredProcedureParameter(name="inDoj", type= String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inName", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inDob", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inBloodGroup", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inImage", type=byte[].class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inEmail", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inPhone", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inFaculty", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inDept", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inDesignation", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inUsername", type= String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inPassword", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="pResult", type=String.class, mode=ParameterMode.OUT)
        }
)

/*
 * call pkg_std_perf.teacherLogin stored procedure
 */

@NamedStoredProcedureQuery(
        name="teacherLogin",
        procedureName="pkg_std_perf.teacherLogin",
        parameters={
                @StoredProcedureParameter(name="inUsername", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="inPassword", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="outUsername", type=String.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outName", type=String.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outDesignation", type=String.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outImage", type=byte[].class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="pResult", type=String.class, mode=ParameterMode.OUT)
        }
)

/*
  call pkg_std_perf.teacherData stored procedure
  */

@NamedStoredProcedureQuery(
        name="teacherData",
        procedureName="pkg_std_perf.teacherData",
        parameters={
                @StoredProcedureParameter(name="inUsername", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="outName", type=String.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outDob", type=String.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outBloodGroup", type=String.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outImage", type=byte[].class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outEmail", type=String.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outPhone", type=String.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outFaculty", type=String.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outDept", type=String.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outDesignation", type=String.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outDoj", type=String.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outAbout", type=String.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outHomeAddress", type=String.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="outCurrentAddress", type=String.class, mode=ParameterMode.OUT),
                @StoredProcedureParameter(name="pResult", type=String.class, mode=ParameterMode.OUT)
        }
)

public class TeacherDetailsEntity {
    private Long serialno;
    private String doj;
    private String name;
    private String dob;
    private String bloodgroup;
    private byte[] image;
    private String email;
    private String phone;
    private String faculty;
    private String dept;
    private String designation;
    private String username;
    private String password;

    @Basic
    @Column(name = "SERIALNO")
    public Long getSerialno() {
        return serialno;
    }

    public void setSerialno(Long serialno) {
        this.serialno = serialno;
    }

    @Basic
    @Column(name = "DOJ")
    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "DOB")
    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Basic
    @Column(name = "BLOODGROUP")
    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    @Basic
    @Column(name = "IMAGE")
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "FACULTY")
    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
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
    @Column(name = "DESIGNATION")
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Id
    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherDetailsEntity that = (TeacherDetailsEntity) o;
        return Objects.equals(serialno, that.serialno) &&
                Objects.equals(doj, that.doj) &&
                Objects.equals(name, that.name) &&
                Objects.equals(dob, that.dob) &&
                Objects.equals(bloodgroup, that.bloodgroup) &&
                Arrays.equals(image, that.image) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(faculty, that.faculty) &&
                Objects.equals(dept, that.dept) &&
                Objects.equals(designation, that.designation) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(serialno, doj, name, dob, bloodgroup, email, phone, faculty, dept, designation, username, password);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}
