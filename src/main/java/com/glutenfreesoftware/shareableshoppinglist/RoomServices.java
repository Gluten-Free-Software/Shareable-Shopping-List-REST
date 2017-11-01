package com.glutenfreesoftware.shareableshoppinglist;

import com.glutenfreesoftware.shareableshoppinglist.domain.Lists;
import com.glutenfreesoftware.shareableshoppinglist.domain.Rooms;
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
@Path("rooms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomServices {
    @PersistenceContext
    EntityManager em;
    
    @GET
    @Path("getRooms")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rooms> getRooms(){
        List<Rooms> result = null; 
        result = em.createQuery("SELECT r FROM Rooms r", Rooms.class)
                .getResultList();
        return result != null ? result : Collections.EMPTY_LIST;
    } 
    
    @POST
    @Path("addRoom")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addRoom(@QueryParam("RoomName")  String RoomName,
                            @QueryParam("RoomOWner") String RoomOWner){
        
        return null;
    }

    
}
