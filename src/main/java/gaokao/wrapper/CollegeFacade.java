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

        List<Major> major = em.createQuery("SELECT m FROM Major m WHERE m.collegeID = :cID").setParameter("cID", collegeID).getResultList();
        int total = 0;
        List<MajorInfo> majorInfos = new ArrayList<>();
        for (Major m : major) {
            majorInfos.add(new MajorInfo(m.getMajorID(), m.getName(), m.getScore(), m.getNum()));
            total += m.getNum();
        }
        ret.setMajorList(majorInfos);
        ret.setTotal(total);
        return ret;
    }

}
