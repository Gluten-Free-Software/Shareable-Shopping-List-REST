package com.glutenfreesoftware.shareableshoppinglist;

import com.glutenfreesoftware.shareableshoppinglist.domain.Friends;
import com.glutenfreesoftware.shareableshoppinglist.dbtest.Lists;
import com.glutenfreesoftware.shareableshoppinglist.dbtest.Users;
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
import java.util.ArrayList;
import jdk.nashorn.internal.parser.JSONParser;


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
    
    @GET
    @Path("getUser")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> getUser(@QueryParam("username") String username, @QueryParam("password") String password){
        List<Users> result = null; 
        result = em.createQuery("SELECT u FROM Users u WHERE u.username = :username AND u.password = :password", Users.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getResultList();
        return result != null ? result : Collections.EMPTY_LIST;
    }
    
    /*
        Ikke bruk denne
    */
    @POST
    @Path("add")
    public Response addUser2(@QueryParam("username") String username, @QueryParam("email") String email, @QueryParam("password") String password) {
        
        System.out.println(username + "*************************************************************************");
        System.out.println(email + "*************************************************************************");
        System.out.println(password + "*************************************************************************");
        if (username != null && email != null && password != null) {
            System.out.println("Hei *************************************************************************");
            List<Users> result = null;
            result = em.createQuery("SELECT u FROM Users u WHERE u.username = :username", Users.class)
                .setParameter("username", username)
                .getResultList();
            if(result.size() == 0){
                System.out.println("0 *************************************************************************");
                Users u = new Users();
                em.persist(u);
                u.setUsername(username);
                u.setEmail(email);
                u.setPassword(password); 
                System.out.println("Lagt til databasen? *************************************************************************");
            }          
        } 
        return null;
    }
    
    @POST
    @Path("registerUser")
    public Response addUser(@QueryParam("username") String username,
                            @QueryParam("email")    String email,
                            @QueryParam("password") String password){
        if (username != null && email != null && password != null) {
            List<Users> result = null;
            result = em.createQuery("SELECT u FROM Users u WHERE u.username = :username", Users.class)
                .setParameter("username", username)
                .getResultList();
            if(result.size() == 0){
                Users u = new Users();
                em.persist(u);
                u.setUsername(username);
                u.setEmail(email);
                u.setPassword(password); 
            }else{
                return Response.noContent().build();
            }
            return Response.ok(username).build();
        }
        return Response.noContent().build();     
    }
    
    /*@GET
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
    public Response friendRequest(@QueryParam("user1")  String user1,
                                  @QueryParam("user2")  String user2,
                                  @QueryParam("status") String status){
        
        if (user1 != null && user2 != null && status != null) {
            List<Friends> result = null;
            result = em.createQuery("SELECT f FROM Friends f WHERE (f.user1 = :user1 AND f.user2 = :user2) OR (f.user1 = :user2 AND f.user2 = :user1)", Friends.class)
                .setParameter("user1", user1)
                .setParameter("user2", user2)
                .getResultList();
            if(result.size() == 0){
                Friends f = new Friends();
                em.persist(f);
                f.setUser1(user1);
                f.setUser2(user2);
                f.setStatus(status); 
            }else{
                return Response.noContent().build();
            }
            return Response.ok(user1).build();
        }
        return Response.noContent().build();     
    }
    
    @POST
    @Path("updatefriendRequestStatus")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatefriendRequestStatus(@QueryParam("user1")     String user1,
                                              @QueryParam("user2")     String user2,
                                              @QueryParam("newStatus") String newStatus){
        
        List<Friends> result = null;
            result = em.createQuery("SELECT f FROM Friends f WHERE (f.user1 = :user1 AND f.user2 = :user2) OR (f.user1 = :user2 AND f.user2 = :user1)", Friends.class)
                .setParameter("user1", user1)
                .setParameter("user2", user2)
                .getResultList();
        if(result.size() == 1){
            Friends friend = (Friends)result.get(0);
            friend.setStatus(newStatus);
            return Response.ok(friend.getStatus()).build();
        }
        return Response.noContent().build();  
        
        /*
        em.createQuery("UPDATE Friends SET f.status = :newStatus WHERE (f.user1 = :user1 AND f.user2 = :user2) OR (f.user1 = :user2 AND f.user2 = :user1)", Friends.class)
                .setParameter("newStatus", newStatus)
                .setParameter("user1", user1)
                .setParameter("user2", user2)
                .executeUpdate();
        */ 
    //}
}
