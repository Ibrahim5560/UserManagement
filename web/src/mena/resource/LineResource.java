package mena.resource;

import mena.model.Line;
import mena.service.LineService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Ibrahim.mmh on 5/2/2018.
 */
@Path("/LineResource")
public class LineResource {

    LineService paperService = new LineService();
    @GET
    @Path("/lines")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Line> getPapers()
    {
        return paperService.getAllPapers();
    }
    //-------------------------------------------------------------------------
    @GET
    @Path("/lines/{paperid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Line getPaper(@PathParam("paperid") int paperid)
    {
        return paperService.getPaper(paperid);
    }
    //--------------------------------------------------------------------------
    @PUT
    @Path("/lines")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Line createPaper(Line paper)  {
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
    public Line updatePaper(Line paper) {
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