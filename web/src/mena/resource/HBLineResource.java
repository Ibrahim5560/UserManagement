package mena.resource;

import mena.model.HBLine;
import mena.service.HBLineService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Ibrahim.mmh on 5/3/2018.
 */
@Path("/HBLineResource")
public class HBLineResource {
    HBLineService paperService = new HBLineService();
    @GET
    @Path("/lines")
    @Produces(MediaType.APPLICATION_JSON)
    public List<HBLine> getPapers()
    {
        return paperService.getAllPapers();
    }
    //-------------------------------------------------------------------------
    @GET
    @Path("/lines/{paperid}")
    @Produces(MediaType.APPLICATION_JSON)
    public HBLine getPaper(@PathParam("paperid") int paperid)
    {
        return paperService.getPaper(paperid);
    }
    //--------------------------------------------------------------------------
    @PUT
    @Path("/lines")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public HBLine createPaper(HBLine paper)  {
        int result = paperService.addPaper(paper);
        if(result == 1){
            return paper;
        }
        return null;
    }

    @POST
    @Path("/lines")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public HBLine updatePaper(HBLine paper) {
        int result = paperService.updatePaper(paper);
        if(result == 1){
            return paper;
        }
        return null;
    }

    @DELETE
    @Path("/lines/{paperid}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deletePaper(@PathParam("paperid") int paperid)
    {
        int result = paperService.deletePaper(paperid);
        if(result == 1){
            return "success";
        }
        return "failure";
    }
}
