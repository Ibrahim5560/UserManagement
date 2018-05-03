package mena.resource;

import mena.model.Entity;
import mena.service.EntityService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

/**
 * Created by Ibrahim.mmh on 5/2/2018.
 */
@Path("/EntityResource")
public class EntityResource {
    EntityService entityService = new EntityService();
    @GET
    @Path("/entities")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Entity> getEntities()
    {
        return entityService.getAllEntities();
    }
    //-------------------------------------------------------------------------
    @GET
    @Path("/entities/{entityid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Entity getEntity(@PathParam("entityid") int entityid)
    {
        return entityService.getEntity(entityid);
    }
    //--------------------------------------------------------------------------
    @PUT
    @Path("/entities")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Entity createEntity(Entity entity) throws IOException {
        return  entityService.addEntity(entity);
    }
    @POST
    @Path("/entities/{entityid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Entity updateEntity(@PathParam("entityid") int entityid,Entity entity) throws IOException {
        entity.setId(entityid);
        return  entityService.updateEntity(entity);
    }
    @DELETE
    @Path("/entities/{entityid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Entity deleteEntity(@PathParam("entityid") int entityid)
    {
        return entityService.deleteEntity(entityid);
    }
}
