package com.glutenfreesoftware.shareableshoppinglist;

import com.glutenfreesoftware.shareableshoppinglist.domain.Friends;
import com.glutenfreesoftware.shareableshoppinglist.domain.Lists;
import com.glutenfreesoftware.shareableshoppinglist.domain.Users;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
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
    public List<Users> getUsers(){
        List<Users> result = null; 
        result = em.createQuery("SELECT u FROM Users u", Users.class)
                .getResultList();
        return result != null ? result : Collections.EMPTY_LIST;
    } 
    
    @POST
    @Path("regsterUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(@QueryParam("Username") String Username,
                            @QueryParam("Email")    String Email,
                            @QueryParam("Password") String Password){
        if (Username != null && Email != null && Password != null) {
            Users u = new Users();
            em.persist(u);
            u.setUsername(Username);
            u.setEmail(Email);
            u.setPassword(Password);
        }

        JsonArrayBuilder builder = Json.createArrayBuilder();
        JsonObject obj1 = Json.createObjectBuilder()
                .add("Status", "OK")
                .build();
        builder.add(obj1);

        return Response.ok(builder.build()).build();
    }
    
    @GET
    @Path("getFriends")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Friends> getFriends(@QueryParam("Username") String User1){
        List<Friends> result = null; 
        result = em.createQuery("SELECT f FROM Friends f WHERE (f.user1 = :user1) OR (f.user2 = :user1)", Friends.class)
                .setParameter("user1", User1)
                .getResultList();
        return result != null ? result : Collections.EMPTY_LIST;
    }
    
    @POST
    @Path("friendRequest")
    @Produces(MediaType.APPLICATION_JSON)
    public Response friendRequest(@QueryParam("User1")  String User1,
                                  @QueryParam("User2")  String User2,
                                  @QueryParam("Status") String Status){
        
        return null;
    }
    
    @POST
    @Path("updatefriendRequestStatus")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatefriendRequestStatus(@QueryParam("User1")     String User1,
                                              @QueryParam("User2")     String User2,
                                              @QueryParam("newStatus") String newStatus){
         
        return null;
    }
}
