package gaokao.api;


import gaokao.entity.Major;
import gaokao.response.Response;
import gaokao.utils.*;
import gaokao.wrapper.CollegeFacade;
import gaokao.wrapper.StudentFacade;

import javax.ejb.EJB;
import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;

public class UniServiceImpl implements UniService {
    @EJB
    private CollegeFacade collegeFacade;
    @EJB
    private  StudentFacade studentFacade;

    @Override
    public Response getUniInfo(String uniname) {


        //获得学校的所有信息
        CollegeInfo collegeInfo = collegeFacade.getCollegeInfo("11");
        Response response = new Response("曹尼玛", collegeInfo, 0);

        studentFacade.getStudentRank();

        return response;
    }
}
