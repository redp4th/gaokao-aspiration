package gaokao.api;



import gaokao.response.Response;

import javax.ws.rs.*;

@Path("/api/uni")
public interface UniService {

    @GET
    @Path("/getUniInfo")
    @Produces("application/json")
    Response getUniInfo(@QueryParam("Uniid") String uniname);
}
