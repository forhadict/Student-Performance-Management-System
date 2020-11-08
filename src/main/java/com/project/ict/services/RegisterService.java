package com.project.ict.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

@Service
public class RegisterService {
    @Autowired
    private EntityManager entityManager = null;

    /*
     * call insertStudentDetails method
     */


    @SuppressWarnings("unchecked")
    public String insertStudentDetails(String sid, String name, String dob, String bloodGroup, byte[] image, String email, String phone, String faculty, String dept, String batch, String session, String doj, String username, String password) {
        StoredProcedureQuery storedProcedureQuery = this.entityManager.createNamedStoredProcedureQuery("insertStudentDetails");
        storedProcedureQuery.setParameter("inSid", sid);
        storedProcedureQuery.setParameter("inName", name);
        storedProcedureQuery.setParameter("inDob", dob);
        storedProcedureQuery.setParameter("inBloodGroup", bloodGroup);
        storedProcedureQuery.setParameter("inImage", image);
        storedProcedureQuery.setParameter("inEmail", email);
        storedProcedureQuery.setParameter("inPhone", phone);
        storedProcedureQuery.setParameter("inFaculty", faculty);
        storedProcedureQuery.setParameter("inDept", dept);
        storedProcedureQuery.setParameter("inBatch", batch);
        storedProcedureQuery.setParameter("inSession", session);
        storedProcedureQuery.setParameter("inDoj", doj);
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.setParameter("inPassword", password);
        storedProcedureQuery.execute();

        String result = (String) storedProcedureQuery.getOutputParameterValue("pResult");

        return result;
    }


    /*
     * call insertStudentDetails method
     */


    @SuppressWarnings("unchecked")
    public String insertTeacherDetails(String doj, String name, String dob, String bloodGroup, byte[] image, String email, String phone, String faculty, String dept, String designation, String username, String password) {
        StoredProcedureQuery storedProcedureQuery = this.entityManager.createNamedStoredProcedureQuery("insertTeacherDetails");
        storedProcedureQuery.setParameter("inDoj", doj);
        storedProcedureQuery.setParameter("inName", name);
        storedProcedureQuery.setParameter("inDob", dob);
        storedProcedureQuery.setParameter("inBloodGroup", bloodGroup);
        storedProcedureQuery.setParameter("inImage", image);
        storedProcedureQuery.setParameter("inEmail", email);
        storedProcedureQuery.setParameter("inPhone", phone);
        storedProcedureQuery.setParameter("inFaculty", faculty);
        storedProcedureQuery.setParameter("inDept", dept);
        storedProcedureQuery.setParameter("inDesignation", designation);
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.setParameter("inPassword", password);
        storedProcedureQuery.execute();

        String result = (String) storedProcedureQuery.getOutputParameterValue("pResult");

        return result;
    }
}
