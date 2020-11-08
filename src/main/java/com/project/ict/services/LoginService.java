package com.project.ict.services;

import com.project.ict.pojo.StudentIntro;
import com.project.ict.pojo.TeacherIntro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

@Service
public class LoginService {
    @Autowired
    private EntityManager entityManager = null;

    /*
     * call studentLogin method to login as student
     */


    @SuppressWarnings("unchecked")
    public StudentIntro studentLogin(String username, String password) {
        StoredProcedureQuery storedProcedureQuery = this.entityManager.createNamedStoredProcedureQuery("studentLogin");
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.setParameter("inPassword", password);
        storedProcedureQuery.execute();

        String uname = (String) storedProcedureQuery.getOutputParameterValue("outUsername");
        String name = (String) storedProcedureQuery.getOutputParameterValue("outName");
        String batch = (String) storedProcedureQuery.getOutputParameterValue("outBatch");
        byte[] image = (byte[]) storedProcedureQuery.getOutputParameterValue("outImage");
        String result = (String) storedProcedureQuery.getOutputParameterValue("pResult");
        StudentIntro studentIntro = new StudentIntro();
        studentIntro.setUsername(uname);
        studentIntro.setName(name);
        studentIntro.setBatch(batch);
        studentIntro.setImage(image);
        studentIntro.setResult(result);

        return studentIntro;
    }


    /*
     * call teacherLogin method to login as teacher
     */


    @SuppressWarnings("unchecked")
    public TeacherIntro teacherLogin(String username, String password) {
        StoredProcedureQuery storedProcedureQuery = this.entityManager.createNamedStoredProcedureQuery("teacherLogin");
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.setParameter("inPassword", password);
        storedProcedureQuery.execute();

        String uname = (String) storedProcedureQuery.getOutputParameterValue("outUsername");
        String name = (String) storedProcedureQuery.getOutputParameterValue("outName");
        String designation = (String) storedProcedureQuery.getOutputParameterValue("outDesignation");
        byte[] image = (byte[]) storedProcedureQuery.getOutputParameterValue("outImage");
        String result = (String) storedProcedureQuery.getOutputParameterValue("pResult");

        TeacherIntro teacherIntro = new TeacherIntro();
        teacherIntro.setUsername(uname);
        teacherIntro.setName(name);
        teacherIntro.setDesignation(designation);
        teacherIntro.setImage(image);
        teacherIntro.setResult(result);

        return teacherIntro;
    }
}
