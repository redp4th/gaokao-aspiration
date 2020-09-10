package gaokao.api;



import gaokao.response.Response;

import javax.ws.rs.*;
import java.util.List;

@Path("/api/user")
public interface UserSevice {
    //注册
    @GET
    @Path("/register")
    @Produces("application/json")
    Response registerApi(@QueryParam("id") String id,@QueryParam("username") String username, @QueryParam("password") String password, @QueryParam("score") int score);
    //登录
    @POST
    @Path("/login")
    @Produces("application/json")
    Response loginApi(@FormParam("id") String id, @FormParam("password") String password);

    //判断是填报
    @GET
    @Path("/isFilled")
    @Produces("application/json")
    Response isFilledApi(@QueryParam("id") String id);

    //填报志愿
    @GET
    @Path("/aspirations")
    @Produces("application/json")
    Response aspirations(@QueryParam("id") String id, @QueryParam("uniname") List<String> collegelsit , @QueryParam("majorinfo")List<String> majorinfolist);
    //录取
    @GET
    @Path("/admit")
    @Produces("application/json")
    void admitAspirations();
    //查看录取结果
    @GET
    @Path("/view")
    @Produces("application/json")
    String[] view(@QueryParam("id") String id);

    @GET
    @Path("/viewASpiration")
    @Produces("application/json")
    Response viewAspiration(@QueryParam("id") String id);
}
