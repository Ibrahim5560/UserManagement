package mena.resource;

import mena.model.Paper;
import mena.service.PaperService;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

/**
 * Created by Ibrahim.mmh on 5/2/2018.
 */
@Path("/PaperResource")
public class PaperResource {

    PaperService paperService = new PaperService();
    @GET
    @Path("/papers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Paper> getPapers()
    {
        return paperService.getAllPapers();
    }
    //-------------------------------------------------------------------------
    @GET
    @Path("/papers/{paperid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Paper getPaper(@PathParam("paperid") int paperid)
    {
        return paperService.getPaper(paperid);
    }
   //--------------------------------------------------------------------------
    @PUT
    @Path("/papers")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Paper createPaper(Paper paper) throws IOException {
        int result = paperService.addPaper(paper);
        if(result == 1){
            return paper;
        }
        return null;
    }

    @POST
    @Path("/papers")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Paper updatePaper(Paper paper) throws IOException {
        int result = paperService.updatePaper(paper);
        if(result == 1){
            return paper;
        }
        return null;
    }

    @DELETE
    @Path("/papers/{paperid}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deletePaper(@PathParam("paperid") int paperid)
    {
        int result = paperService.deletePaper(paperid);
        if(result == 1){
            return "success";
        }
        return "failure";
    }
    //-------------------------------------------------------------------------
}