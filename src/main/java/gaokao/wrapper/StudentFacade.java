package gaokao.wrapper;

import gaokao.entity.*;
import gaokao.utils.StudentInfo;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.transaction.Transactional;
import java.util.*;

@Stateless
@Transactional
public class StudentFacade {

    @PersistenceContext
    private EntityManager em;

    @Resource
    private SessionContext context;

    // call this method to register a student
    public Student register(String ID, String pwd, int score, String name) {
        try {
            Student student = new Student();
            student.setStudentID(ID);
            student.setStudentName(name);
            student.setStudentPwd(pwd);
            student.setStudentScore(score);

            em.persist(student);
            return student;
        } catch (Exception e) {
            context.setRollbackOnly();
            return null;
        }
    }

    public boolean login(String ID, String pwd) {
        Student stu = em.find(Student.class, ID);
        if (stu == null)
            return false;
        return stu.getStudentPwd().equals(pwd);
    }

    public StudentInfo getInfo(String ID) {
        List<Student> stu = em.createNamedQuery("find student by ID").setParameter("ID", ID).getResultList();
        List<Aspiration> asp = em.createNamedQuery("find aspiration by student ID").setParameter("ID", ID).getResultList();

        StudentInfo ret = new StudentInfo();
        ret.setID(stu.get(0).getStudentID());
        ret.setName(stu.get(0).getStudentName());
        ret.setScore(stu.get(0).getStudentScore());
        ret.setPwd(stu.get(0).getStudentPwd());

        HashMap<String, String[]> m = new HashMap<>();
        for (Aspiration a : asp) {
            m.put(a.getCollegeID(), a.getMajorList());
        }
        ret.setAspirations(m);
        return ret;

    }

    public String[] getAdmission(String ID) {
        Admission adm = em.find(Admission.class, ID);
        String collegeName = em.find(College.class, adm.getCollegeID()).getName();
        String majorName = em.find(Major.class, adm.getMajorID()).getName();
        String[] ret = new String[2];
        ret[0] = collegeName;
        ret[1] = majorName;

        return ret;
    }

    public void removeAspiration(String ID, String collegeID) {
        try {
            Aspiration result = (Aspiration) em.createQuery("SELECT a FROM Aspiration a WHERE a.studentID = :ID AND a.collegeID = :cID").setParameter(ID, collegeID).getSingleResult();
            em.remove(result);
            em.flush();
        } catch (Exception e) {
            context.setRollbackOnly();
        }
    }

    public void editAspiration(String ID, String collegeID, String[] newAspiration) {
        try {
            Aspiration result = (Aspiration) em.createQuery("SELECT a FROM Aspiration a WHERE a.studentID = :ID AND a.collegeID = :cID").setParameter(ID, collegeID).getSingleResult();
            if (result != null) {
                result.setCollegeID(collegeID);
                result.setMajorList(newAspiration);
            }
            else {
                result = new Aspiration();
                result.setCollegeID(collegeID);
                result.setMajorList(newAspiration);
                result.setStudentID(ID);
            }
            em.persist(result);
            em.flush();
        } catch (Exception e) {
            context.setRollbackOnly();
        }

    }

    public List<Student> getStudentRank() {
        return em.createQuery("SELECT s FROM Student s ORDER BY s.studentScore").getResultList();
    }

//
//    public List<Aspiration> getStudentRank() {
//        List<Object[]> l = em.createQuery("SELECT a, s FROM Aspiration a, Student s WHERE a.studentID = s.studentID ORDER BY s.studentScore DESC ").getResultList();
//        List<Aspiration> ret = new ArrayList<>();
//        for (Object[] o : l) {
//            ret.add((Aspiration)o[0]);
//        }
//        return ret;
//    }

    public List<Aspiration> getFilledAspiration(String studentID) {
        return em.createNamedQuery("find aspiration by student ID").setParameter("ID", studentID).getResultList();
    }
}