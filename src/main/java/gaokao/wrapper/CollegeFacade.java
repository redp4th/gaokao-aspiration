package gaokao.wrapper;

import gaokao.utils.*;
import gaokao.entity.*;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Transactional
public class CollegeFacade {
    @PersistenceContext
    private EntityManager em;

    @Resource
    private SessionContext context;

    public CollegeInfo getCollegeInfo(String collegeID) {
        CollegeInfo ret = new CollegeInfo();
        College college = em.find(College.class, collegeID);
        ret.setID(college.getID());
        ret.setAddr(college.getAddress());
        ret.setScore(college.getScore());
        ret.setName(college.getName());

        List<Major> majors = college.getMajorList();
        ret.setMajorList(majors);

        int total = 0;
        for (Major m : majors)
            total += m.getNum();
        ret.setTotal(total);
        return ret;
    }

    public void grantAdmission(String studentID, String collegeID, String majorID) {
        Admission adm = new Admission();
        adm.setStudentID(studentID);
        adm.setCollegeID(collegeID);
        adm.setMajorID(majorID);
        em.persist(adm);
    }

    public List<Student> getEnrollStudent(String collegeID) {
        List<Student> l = em.createQuery("SELECT s FROM Student s WHERE EXISTS (SELECT a FROM Aspiration a WHERE a.collegeID = :cID AND a.studentID = s.studentID) ORDER BY s.studentScore DESC ").setParameter("cID", collegeID).getResultList();
        return l;
    }

}
