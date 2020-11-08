package com.project.ict.services;

import com.project.ict.pojo.CourseData;
import com.project.ict.pojo.ExamStatus;
import com.project.ict.pojo.StudentData;
import com.project.ict.pojo.TeacherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProfileService {
    @Autowired
    private EntityManager entityManager = null;

    /*
     * call studentData method
     */

    @SuppressWarnings("unchecked")
    public StudentData studentData(String username) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("studentData");
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.execute();

        String sid = (String) storedProcedureQuery.getOutputParameterValue("outSid");
        String name = (String) storedProcedureQuery.getOutputParameterValue("outName");
        String dob = (String) storedProcedureQuery.getOutputParameterValue("outDob");
        String bloodGroup = (String) storedProcedureQuery.getOutputParameterValue("outBloodGroup");
        byte[] image = (byte[]) storedProcedureQuery.getOutputParameterValue("outImage");
        String email = (String) storedProcedureQuery.getOutputParameterValue("outEmail");
        String phone = (String) storedProcedureQuery.getOutputParameterValue("outPhone");
        String faculty = (String) storedProcedureQuery.getOutputParameterValue("outFaculty");
        String dept = (String) storedProcedureQuery.getOutputParameterValue("outDept");
        String batch = (String) storedProcedureQuery.getOutputParameterValue("outBatch");
        String session = (String) storedProcedureQuery.getOutputParameterValue("outSession");
        String doj = (String) storedProcedureQuery.getOutputParameterValue("outDoj");
        String about = (String) storedProcedureQuery.getOutputParameterValue("outAbout");
        String homeAddress  = (String) storedProcedureQuery.getOutputParameterValue("outHomeAddress");
        String currentAddress  = (String) storedProcedureQuery.getOutputParameterValue("outCurrentAddress");
        String result = (String) storedProcedureQuery.getOutputParameterValue("pResult");

        StudentData studentData = new StudentData();
        studentData.setSid(sid);
        studentData.setName(name);
        studentData.setDob(dob);
        studentData.setBloodGroup(bloodGroup);
        studentData.setImage(image);
        studentData.setEmail(email);
        studentData.setPhone(phone);
        studentData.setFaculty(faculty);
        studentData.setDept(dept);
        studentData.setBatch(batch);
        studentData.setSession(session);
        studentData.setDoj(doj);
        studentData.setAbout(about);
        studentData.setHomeAddress(homeAddress);
        studentData.setCurrentAddress(currentAddress);
        studentData.setResult(result);

        return studentData;
    }

    /*
     * call teacherData method
     */

    @SuppressWarnings("unchecked")
    public TeacherData teacherData(String username) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("teacherData");
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.execute();

        String name = (String) storedProcedureQuery.getOutputParameterValue("outName");
        String dob = (String) storedProcedureQuery.getOutputParameterValue("outDob");
        String bloodGroup = (String) storedProcedureQuery.getOutputParameterValue("outBloodGroup");
        byte[] image = (byte[]) storedProcedureQuery.getOutputParameterValue("outImage");
        String email = (String) storedProcedureQuery.getOutputParameterValue("outEmail");
        String phone = (String) storedProcedureQuery.getOutputParameterValue("outPhone");
        String faculty = (String) storedProcedureQuery.getOutputParameterValue("outFaculty");
        String dept = (String) storedProcedureQuery.getOutputParameterValue("outDept");
        String designation = (String) storedProcedureQuery.getOutputParameterValue("outDesignation");
        String doj = (String) storedProcedureQuery.getOutputParameterValue("outDoj");
        String about = (String) storedProcedureQuery.getOutputParameterValue("outAbout");
        String homeAddress  = (String) storedProcedureQuery.getOutputParameterValue("outHomeAddress");
        String currentAddress  = (String) storedProcedureQuery.getOutputParameterValue("outCurrentAddress");
        String result = (String) storedProcedureQuery.getOutputParameterValue("pResult");

        TeacherData teacherData = new TeacherData();
        teacherData.setName(name);
        teacherData.setDob(dob);
        teacherData.setBloodGroup(bloodGroup);
        teacherData.setImage(image);
        teacherData.setEmail(email);
        teacherData.setPhone(phone);
        teacherData.setFaculty(faculty);
        teacherData.setDept(dept);
        teacherData.setDesignation(designation);
        teacherData.setDoj(doj);
        teacherData.setAbout(about);
        teacherData.setHomeAddress(homeAddress);
        teacherData.setCurrentAddress(currentAddress);
        teacherData.setResult(result);

        return teacherData;
    }

    /*
     * call studentCourseList method
     */

    @SuppressWarnings("unchecked")
    public ArrayList<CourseData> studentCourseList (String username) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("studentCourseList");
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.execute();

        ArrayList<CourseData> array = new ArrayList<CourseData>();

        List<Object> result = (List<Object>) storedProcedureQuery.getResultList();
        Iterator it = result.iterator();

        while (it.hasNext()) {
            Object[] obj = (Object[]) it.next();
            String session = String.valueOf(obj[0]);
            String semester = String.valueOf(obj[1]);
            String courseCode = String.valueOf(obj[2]);

            CourseData courseData = new CourseData();
            courseData.setSession(session);
            courseData.setSemester(semester);
            courseData.setCourseCode(courseCode);

            array.add(courseData);
        }

        return array;
    }

    /*
     * call teacherCourseList method
     */

    @SuppressWarnings("unchecked")
    public ArrayList<CourseData> teacherCourseList (String username) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("teacherCourseList");
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.execute();

        ArrayList<CourseData> array = new ArrayList<CourseData>();

        List<Object> result = (List<Object>) storedProcedureQuery.getResultList();
        Iterator it = result.iterator();

        while (it.hasNext()) {
            Object[] obj = (Object[]) it.next();
            String session = String.valueOf(obj[0]);
            String semester = String.valueOf(obj[1]);
            String courseCode = String.valueOf(obj[2]);

            CourseData courseData = new CourseData();
            courseData.setSession(session);
            courseData.setSemester(semester);
            courseData.setCourseCode(courseCode);

            array.add(courseData);
        }

        return array;
    }

    /*
     * call studentCourseSearchBySemester method
     */

    @SuppressWarnings("unchecked")
    public ArrayList<CourseData> studentCourseSearchBySemester (String username, String semester) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("studentCourseSearchBySemester");
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.setParameter("inSemester", semester);
        storedProcedureQuery.execute();

        ArrayList<CourseData> array = new ArrayList<CourseData>();

        List<Object> result = (List<Object>) storedProcedureQuery.getResultList();
        Iterator it = result.iterator();

        while (it.hasNext()) {
            Object[] obj = (Object[]) it.next();
            String session = String.valueOf(obj[0]);
            String sem = String.valueOf(obj[1]);
            String courseCode = String.valueOf(obj[2]);

            CourseData courseData = new CourseData();
            courseData.setSession(session);
            courseData.setSemester(sem);
            courseData.setCourseCode(courseCode);

            array.add(courseData);
        }

        return array;
    }

    /*
     * call studentCourseSearchByCode method
     */

    @SuppressWarnings("unchecked")
    public ArrayList<CourseData> studentCourseSearchByCode (String username, String code) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("studentCourseSearchByCode");
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.setParameter("inCourseCode", code);
        storedProcedureQuery.execute();

        ArrayList<CourseData> array = new ArrayList<CourseData>();

        List<Object> result = (List<Object>) storedProcedureQuery.getResultList();
        Iterator it = result.iterator();

        while (it.hasNext()) {
            Object[] obj = (Object[]) it.next();
            String session = String.valueOf(obj[0]);
            String sem = String.valueOf(obj[1]);
            String courseCode = String.valueOf(obj[2]);

            CourseData courseData = new CourseData();
            courseData.setSession(session);
            courseData.setSemester(sem);
            courseData.setCourseCode(courseCode);

            array.add(courseData);
        }

        return array;
    }

    /*
     * call teacherCourseSearchByDept method
     */

    @SuppressWarnings("unchecked")
    public ArrayList<CourseData> teacherCourseSearchByDept (String username, String dept) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("teacherCourseSearchByDept");
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.setParameter("inDept", dept);
        storedProcedureQuery.execute();

        ArrayList<CourseData> array = new ArrayList<CourseData>();

        List<Object> result = (List<Object>) storedProcedureQuery.getResultList();
        Iterator it = result.iterator();

        while (it.hasNext()) {
            Object[] obj = (Object[]) it.next();
            String session = String.valueOf(obj[0]);
            String sem = String.valueOf(obj[1]);
            String courseCode = String.valueOf(obj[2]);

            CourseData courseData = new CourseData();
            courseData.setSession(session);
            courseData.setSemester(sem);
            courseData.setCourseCode(courseCode);

            array.add(courseData);
        }

        return array;
    }

    /*
     * call teacherCourseSearchByCode method
     */

    @SuppressWarnings("unchecked")
    public ArrayList<CourseData> teacherCourseSearchByCode (String username, String code) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("teacherCourseSearchByCode");
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.setParameter("inCourseCode", code);
        storedProcedureQuery.execute();

        ArrayList<CourseData> array = new ArrayList<CourseData>();

        List<Object> result = (List<Object>) storedProcedureQuery.getResultList();
        Iterator it = result.iterator();

        while (it.hasNext()) {
            Object[] obj = (Object[]) it.next();
            String session = String.valueOf(obj[0]);
            String sem = String.valueOf(obj[1]);
            String courseCode = String.valueOf(obj[2]);

            CourseData courseData = new CourseData();
            courseData.setSession(session);
            courseData.setSemester(sem);
            courseData.setCourseCode(courseCode);

            array.add(courseData);
        }

        return array;
    }

    /*
     * call studentExamStatus method
     */

    @SuppressWarnings("unchecked")
    public ExamStatus studentExamStatus (String session, String courseCode) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("studentExamStatus");
        storedProcedureQuery.setParameter("inSession", session);
        storedProcedureQuery.setParameter("inCourseCode", courseCode);
        storedProcedureQuery.execute();
        int ct1S = (int) storedProcedureQuery.getOutputParameterValue("outCt1S");
        int ct2S = (int) storedProcedureQuery.getOutputParameterValue("outCt2S");
        int ct3S = (int) storedProcedureQuery.getOutputParameterValue("outCt3S");
        int ct4S = (int) storedProcedureQuery.getOutputParameterValue("outCt4S");
        int semesterS = (int) storedProcedureQuery.getOutputParameterValue("outSemesterS");

        ExamStatus examStatus = new ExamStatus();
        examStatus.setCt1s(ct1S);
        examStatus.setCt2s(ct2S);
        examStatus.setCt3s(ct3S);
        examStatus.setCt4s(ct4S);
        examStatus.setSemesterS(semesterS);

        return examStatus;
    }


    /*
     * call studentAttendanceMarks method
     */

    @SuppressWarnings("unchecked")
    public int studentAttendanceMarks (String username, String session, String courseCode) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("studentAttendanceMarks");
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.setParameter("inSession", session);
        storedProcedureQuery.setParameter("inCourseCode", courseCode);
        storedProcedureQuery.execute();
        int marks = (int) storedProcedureQuery.getOutputParameterValue("outMarks");

        return marks;
    }

    /*
     * call studentCT1Marks method
     */

    @SuppressWarnings("unchecked")
    public int studentCT1Marks (String username, String session, String courseCode) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("studentCT1Marks");
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.setParameter("inSession", session);
        storedProcedureQuery.setParameter("inCourseCode", courseCode);
        storedProcedureQuery.execute();
        int marks = (int) storedProcedureQuery.getOutputParameterValue("outMarks");

        return marks;
    }

    /*
     * call studentCT2Marks method
     */

    @SuppressWarnings("unchecked")
    public int studentCT2Marks (String username, String session, String courseCode) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("studentCT2Marks");
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.setParameter("inSession", session);
        storedProcedureQuery.setParameter("inCourseCode", courseCode);
        storedProcedureQuery.execute();
        int marks = (int) storedProcedureQuery.getOutputParameterValue("outMarks");

        return marks;
    }

    /*
     * call studentCT3Marks method
     */

    @SuppressWarnings("unchecked")
    public int studentCT3Marks (String username, String session, String courseCode) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("studentCT3Marks");
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.setParameter("inSession", session);
        storedProcedureQuery.setParameter("inCourseCode", courseCode);
        storedProcedureQuery.execute();
        int marks = (int) storedProcedureQuery.getOutputParameterValue("outMarks");

        return marks;
    }

    /*
     * call studentCT4Marks method
     */

    @SuppressWarnings("unchecked")
    public int studentCT4Marks (String username, String session, String courseCode) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("studentCT4Marks");
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.setParameter("inSession", session);
        storedProcedureQuery.setParameter("inCourseCode", courseCode);
        storedProcedureQuery.execute();
        int marks = (int) storedProcedureQuery.getOutputParameterValue("outMarks");

        return marks;
    }

    /*
     * call studentSemesterMarks method
     */

    @SuppressWarnings("unchecked")
    public int studentSemesterMarks (String username, String session, String courseCode) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("studentSemesterMarks");
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.setParameter("inSession", session);
        storedProcedureQuery.setParameter("inCourseCode", courseCode);
        storedProcedureQuery.execute();
        int marks = (int) storedProcedureQuery.getOutputParameterValue("outMarks");

        return marks;
    }

}
