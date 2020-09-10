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

    // 返回学校信息
    public CollegeInfo getCollegeInfo(String collegeID) {
        CollegeInfo ret = new CollegeInfo();
        College college = em.find(College.class, collegeID);
        ret.setID(college.getID());
        ret.setAddr(college.getAddress());
        ret.setScore(college.getScore());
        ret.setName(college.getName());

        List<MajorInfo> majorinfos = new ArrayList<MajorInfo>();
        List<Major> majors = college.getMajors();

        int total = 0;
        for (Major m : majors) {
            total += m.getNum();
            majorinfos.add(m.extract());
        }
        ret.setTotal(total);
        ret.setMajorList(majorinfos);
        return ret;
    }

    // 查找学生录取信息
    public void grantAdmission(String studentID, String collegeID, String majorID) {
        Admission adm = new Admission();
        adm.setStudentID(studentID);
        adm.setCollegeID(collegeID);
        adm.setMajorID(majorID);
        em.persist(adm);
    }

    // 查找填报填报某学校的所有学生
    public List<Student> getEnrollStudent(String collegeID) {
        List<Student> l = em.createQuery("SELECT s FROM Student s WHERE EXISTS (SELECT a FROM Aspiration a WHERE a.collegeID = :cID AND a.studentID = s.studentID) ORDER BY s.studentScore DESC ").setParameter("cID", collegeID).getResultList();
        return l;
    }

    // 查找某学生填报的所有学校
    public List<College> getEnrollCollege(String studentID) {
        return em.createQuery("SELECT c FROM College c WHERE c.ID IN (SELECT a FROM Aspiration a WHERE a.studentID = :sID)").setParameter("sID", studentID).getResultList();
    }

    public boolean queryMajorCapacity(String majorID) {
        return em.find(Major.class, majorID).getRemain() > 0;
    }
}
