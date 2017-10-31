package com.glutenfreesoftware.shareableshoppinglist;

import com.glutenfreesoftware.shareableshoppinglist.domain.Lists;
import com.glutenfreesoftware.shareableshoppinglist.domain.Users;
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
@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserServices {
    @PersistenceContext
    EntityManager em;
    
    @GET
    @Path("getUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> getLists(){
        List<Users> result = null; 
        result = em.createQuery("SELECT u FROM Users u", Users.class)
                .getResultList();
        return result != null ? result : Collections.EMPTY_LIST;
    } 
    
    @POST
    @Path("addUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(@QueryParam("Username") String Username,
                            @QueryParam("Email")    String Email,
                            @QueryParam("Password") String Password){
        
        return null;
    }
}
