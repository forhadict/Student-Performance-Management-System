package com.project.ict.services;

import com.project.ict.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class AccountService {
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
     * call insertStudentCourse method
     */

    @SuppressWarnings("unchecked")
    public String insertStudentCourse (String username, String session, String semester, String course) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("insertStudentCourse");
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.setParameter("inSession", session);
        storedProcedureQuery.setParameter("inSemester", semester);
        storedProcedureQuery.setParameter("inCourseCode", course);
        storedProcedureQuery.execute();

        String result = (String) storedProcedureQuery.getOutputParameterValue("pResult");
        return result;
    }

    /*
     * call insertTeacherCourse method
     */

    @SuppressWarnings("unchecked")
    public String insertTeacherCourse (String username, String dept, String session, String semester, String course) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("insertTeacherCourse");
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.setParameter("inDept", dept);
        storedProcedureQuery.setParameter("inSession", session);
        storedProcedureQuery.setParameter("inSemester", semester);
        storedProcedureQuery.setParameter("inCourseCode", course);
        storedProcedureQuery.execute();

        String result = (String) storedProcedureQuery.getOutputParameterValue("pResult");
        return result;
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
     * call courseStudentList method
     */

    @SuppressWarnings("unchecked")
    public ArrayList<StudentInfo> courseStudentList (String session, String code) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("courseStudentList");
        storedProcedureQuery.setParameter("inSession", session);
        storedProcedureQuery.setParameter("inCourseCode", code);
        storedProcedureQuery.execute();

        ArrayList<StudentInfo> array = new ArrayList<StudentInfo>();

        List<Object> result = (List<Object>) storedProcedureQuery.getResultList();
        Iterator it = result.iterator();

        while (it.hasNext()) {
            Object[] obj = (Object[]) it.next();
            String username = String.valueOf(obj[0]);
            String sid = String.valueOf(obj[1]);
            String name = String.valueOf(obj[2]);

            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setUsername(username);
            studentInfo.setSid(sid);
            studentInfo.setName(name);

            array.add(studentInfo);
        }

        return array;
    }

    /*
     * call insertTeacherClass method
     */

    @SuppressWarnings("unchecked")
    public String insertTeacherClass (String username, String session, String course, String date) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("insertTeacherClass");
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.setParameter("inSession", session);
        storedProcedureQuery.setParameter("inCourseCode", course);
        storedProcedureQuery.setParameter("inClassDate", date);
        storedProcedureQuery.execute();

        String result = (String) storedProcedureQuery.getOutputParameterValue("pResult");
        return result;
    }

    /*
     * call teacherClassList method
     */

    @SuppressWarnings("unchecked")
    public ArrayList<ClassData> teacherClassList (String username, String session, String code) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("teacherClassList");
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.setParameter("inSession", session);
        storedProcedureQuery.setParameter("inCourseCode", code);
        storedProcedureQuery.execute();

        ArrayList<ClassData> array = new ArrayList<ClassData>();

        List<Object> result = (List<Object>) storedProcedureQuery.getResultList();
        Iterator it = result.iterator();

        while (it.hasNext()) {
            Object[] obj = (Object[]) it.next();
            String seqStr = String.valueOf(obj[0]);
            int sequence = Integer.parseInt(seqStr);
            String sess = String.valueOf(obj[1]);
            String courseCode = String.valueOf(obj[2]);
            String classDate = String.valueOf(obj[3]);

            ClassData classData = new ClassData();
            classData.setSequence(sequence);
            classData.setSession(sess);
            classData.setCourseCode(courseCode);
            classData.setDate(classDate);

            array.add(classData);
        }

        return array;
    }

    /*
     * call insertStudentAttendance method
     */

    @SuppressWarnings("unchecked")
    public String insertStudentAttendance (int totalClass, String username, String session, String course) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("insertStudentAttendance");
        storedProcedureQuery.setParameter("inClassNo", totalClass);
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.setParameter("inSession", session);
        storedProcedureQuery.setParameter("inCourseCode", course);
        storedProcedureQuery.execute();

        String result = (String) storedProcedureQuery.getOutputParameterValue("pResult");
        return result;
    }

    /*
     * call updateStudentAttendance method
     */

    @SuppressWarnings("unchecked")
    public String updateStudentAttendance (int totalClass, String username, String session, String course) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("updateStudentAttendance");
        storedProcedureQuery.setParameter("inClassNo", totalClass);
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.setParameter("inSession", session);
        storedProcedureQuery.setParameter("inCourseCode", course);
        storedProcedureQuery.execute();

        String result = (String) storedProcedureQuery.getOutputParameterValue("pResult");
        return result;
    }

    /*
     * call insertStudentMarks method
     */

    @SuppressWarnings("unchecked")
    public String insertStudentMarks (String saveMarksType, String username, String session, String course) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("insertStudentMarks");
        storedProcedureQuery.setParameter("inSaveType", saveMarksType);
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.setParameter("inSession", session);
        storedProcedureQuery.setParameter("inCourseCode", course);
        storedProcedureQuery.execute();

        String result = (String) storedProcedureQuery.getOutputParameterValue("pResult");
        return result;
    }

    /*
     * call updateStudentMarks method
     */

    @SuppressWarnings("unchecked")
    public String updateStudentMarks (String saveMarksType, String username, String session, String course, int marks) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("updateStudentMarks");
        storedProcedureQuery.setParameter("inSaveType", saveMarksType);
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.setParameter("inSession", session);
        storedProcedureQuery.setParameter("inCourseCode", course);
        storedProcedureQuery.setParameter("inMarks", marks);
        storedProcedureQuery.execute();

        String result = (String) storedProcedureQuery.getOutputParameterValue("pResult");
        return result;
    }

    /*
     * call studentPerformanceData method
     */
    /*
    @SuppressWarnings("unchecked")
    public PerformanceData studentPerformanceData (String username, String session, String courseCode) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("studentPerformanceData");
        storedProcedureQuery.setParameter("inUsername", username);
        storedProcedureQuery.setParameter("inSession", session);
        storedProcedureQuery.setParameter("inCourseCode", courseCode);
        storedProcedureQuery.execute();
        int ct1S = (int) storedProcedureQuery.getOutputParameterValue("outCt1S");
        int ct2S = (int) storedProcedureQuery.getOutputParameterValue("outCt2S");
        int ct3S = (int) storedProcedureQuery.getOutputParameterValue("outCt3S");
        int ct4S = (int) storedProcedureQuery.getOutputParameterValue("outCt4S");
        int semesterS = (int) storedProcedureQuery.getOutputParameterValue("outSemesterS");
        int totalClass = (int) storedProcedureQuery.getOutputParameterValue("outTotalClass");
        int attendance = (int) storedProcedureQuery.getOutputParameterValue("outAttendance");
        int ct1M = (int) storedProcedureQuery.getOutputParameterValue("outCt1M");
        int ct2M = (int) storedProcedureQuery.getOutputParameterValue("outCt2M");
        int ct3M = (int) storedProcedureQuery.getOutputParameterValue("outCt3M");
        int ct4M = (int) storedProcedureQuery.getOutputParameterValue("outCt4M");
        int semesterM = (int) storedProcedureQuery.getOutputParameterValue("outSemesterM");

        PerformanceData performanceData = new PerformanceData();
        performanceData.setCt1s(ct1S);
        performanceData.setCt2s(ct2S);
        performanceData.setCt3s(ct3S);
        performanceData.setCt4s(ct4S);
        performanceData.setSemesterS(semesterS);
        performanceData.setTotalClass(totalClass);
        performanceData.setAttendance(attendance);
        performanceData.setCt1m(ct1M);
        performanceData.setCt2m(ct2M);
        performanceData.setCt3m(ct3M);
        performanceData.setCt4m(ct4M);
        performanceData.setSemesterM(semesterM);

        return performanceData;
    }
    */

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

    /*
     * call studentExamMarksList method
     */

    @SuppressWarnings("unchecked")
    public ArrayList<StudentMarks> studentExamMarksList (String exam, String session, String code) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("studentExamMarksList");
        storedProcedureQuery.setParameter("inExamType", exam);
        storedProcedureQuery.setParameter("inSession", session);
        storedProcedureQuery.setParameter("inCourseCode", code);
        storedProcedureQuery.execute();

        ArrayList<StudentMarks> array = new ArrayList<StudentMarks>();

        List<Object> result = (List<Object>) storedProcedureQuery.getResultList();
        Iterator it = result.iterator();

        while (it.hasNext()) {
            Object[] obj = (Object[]) it.next();
            String username = String.valueOf(obj[0]);
            String sid = String.valueOf(obj[1]);
            String name = String.valueOf(obj[2]);
            String m = String.valueOf(obj[3]); int marks = Integer.parseInt(m);

            StudentMarks studentMarks = new StudentMarks();
            studentMarks.setUsername(username);
            studentMarks.setSid(sid);
            studentMarks.setName(name);
            studentMarks.setMarks(marks);

            array.add(studentMarks);
        }

        return array;
    }
}
