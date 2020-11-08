package com.project.ict.services;

import com.project.ict.pojo.ProfileIntro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

@Service
public class SearchService {
    @Autowired
    private EntityManager entityManager = null;

    /*
     * call getImage method to login as student
     */


    @SuppressWarnings("unchecked")
    public byte[] getImage (String imageFor, String username) {
        StoredProcedureQuery storedProcedureQuery = this.entityManager.createNamedStoredProcedureQuery("getImage");
        storedProcedureQuery.setParameter("inImageFor", imageFor);
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.execute();

        return (byte[]) storedProcedureQuery.getOutputParameterValue("outImage");
    }

    /*
     * call searchPerson method to login as student
     */


    @SuppressWarnings("unchecked")
    public ArrayList<ProfileIntro> searchPerson(String searchFor, String searchType, String searchKey) {
        StoredProcedureQuery storedProcedureQuery = this.entityManager.createNamedStoredProcedureQuery("searchPerson");
        storedProcedureQuery.setParameter("inSearchFor", searchFor);
        storedProcedureQuery.setParameter("inSearchType", searchType);
        storedProcedureQuery.setParameter("inSearchKey", searchKey);
        storedProcedureQuery.execute();

        ArrayList<ProfileIntro> array = new ArrayList<ProfileIntro>();

        List<Object> result = (List<Object>) storedProcedureQuery.getResultList();
        Iterator it = result.iterator();

        while (it.hasNext()) {
            String batch;
            String dept;
            String designation;

            Object[] obj = (Object[]) it.next();
            String username = String.valueOf(obj[0]);
            String name = String.valueOf(obj[1]);
            byte[] byteImg = getImage(searchFor, username);
            String image = Base64.getEncoder().encodeToString(byteImg);

            if (searchFor.equalsIgnoreCase("student")) {
                batch = String.valueOf(obj[2]);
                dept = String.valueOf(obj[3]);
                designation = batch + ", " + dept;
            }
            else {
                designation = String.valueOf(obj[2]);
            }

            ProfileIntro profileIntro = new ProfileIntro();
            profileIntro.setUsername(username);
            profileIntro.setName(name);
            profileIntro.setImage(image);
            profileIntro.setDesignation(designation);

            array.add(profileIntro);
        }

        return array;
    }
}
