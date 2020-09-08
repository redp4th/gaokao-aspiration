package gaokao.wrapper;

import gaokao.entity.*;
import gaokao.utils.StudentInfo;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.HashMap;

@Stateless
@Transactional
public class StudentFacade {

    @PersistenceContext
    private EntityManager em;

    @Resource
    private SessionContext context;

    public Student register(String ID, String pwd, int score, String name) {
        Student student = new Student();
        student.setID(ID);
        student.setName(name);
        student.setPw(pwd);
        student.setScore(score);

        em.persist(student);
        return student;
    }

    public boolean login(String ID, String pwd) {
        Student stu = em.find(Student.class, ID);
        if(stu == null)
            return false;
        return stu.getPw().equals(pwd);
    }

    public StudentInfo getInfo(String ID) {
        List<Student> stu = em.createQuery("SELECT s FROM Student s WHERE s.ID = :ID").setParameter("ID", ID).getResultList();
        List<Aspiration> asp = em.createQuery("SELECT a FROM Aspiration a WHERE a.studentID = :ID").setParameter("ID", ID).getResultList();

        StudentInfo ret = new StudentInfo();
        ret.setID(stu.get(0).getID());
        ret.setName(stu.get(0).getName());
        ret.setScore(stu.get(0).getScore());
        ret.setPwd(stu.get(0).getPw());

        HashMap<String, String[]> m = new HashMap<>();
        for (Aspiration a : asp) {
            m.put(a.getCollegeID(), a.getMajorList());
        }
        ret.setAspirations(m);
        return ret;

    }

    public void removeAspiration(String ID, String collegeID) {
        try {
            Aspiration result = (Aspiration) em.createQuery("SELECT a FROM Aspiration a WHERE a.studentID = :ID AND a.collegeID = :cID").setParameter(ID, collegeID).getSingleResult();
            em.remove(result);
        } catch (Exception e) {
            context.setRollbackOnly();
        }
    }

    public void editAspiration(String ID, String collegeID, String[] newAspiration) {
        try {
            Aspiration result = (Aspiration) em.createQuery("SELECT a FROM Aspiration a WHERE a.studentID = :ID AND a.collegeID = :cID").setParameter(ID, collegeID).getSingleResult();
            result.setMajorList(newAspiration);
            em.flush();
        } catch (Exception e) {
            context.setRollbackOnly();
        }
    }

}