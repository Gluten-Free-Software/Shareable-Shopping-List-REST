package com.glutenfreesoftware.shareableshoppinglist;

import com.glutenfreesoftware.shareableshoppinglist.domain.Lists;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Kristian
 */
@Stateless
@Path("lists")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ListServices {
    @PersistenceContext
    EntityManager em;
    
    @GET
    @Path("getLists")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Lists> getLists(){
        List<Lists> result = null; 
        result = em.createQuery("SELECT l FROM Lists l", Lists.class)
                .getResultList();
        return result != null ? result : Collections.EMPTY_LIST;
    } 
    
    @POST
    @Path("addList")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addList(@QueryParam("ListRoom")  String ListRoom,
                            @QueryParam("ListName")  String ListName,
                            @QueryParam("ListOwner") String ListOwner){
        
        return null;
    }
    
}
