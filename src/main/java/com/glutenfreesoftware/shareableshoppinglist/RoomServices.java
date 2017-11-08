package com.glutenfreesoftware.shareableshoppinglist;

import com.glutenfreesoftware.shareableshoppinglist.domain.Lists;
import com.glutenfreesoftware.shareableshoppinglist.domain.Rooms;
import com.glutenfreesoftware.shareableshoppinglist.domain.Sharedrooms;
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
    public Response addRoom(@QueryParam("roomName")  String roomName,
                            @QueryParam("roomOwner") String roomOwner){
        if(roomName != null && roomOwner != null){
            List<Rooms> rooms = null;
            rooms = em.createQuery("SELECT r FROM Rooms r WHERE r.roomName = :roomName AND r.roomOwner = :roomOwner", Rooms.class)
                .setParameter("roomName", roomName)    
                .setParameter("roomOwner", roomOwner)
                .getResultList();
            if(rooms.size() != 0){
                return Response.ok("Room already exists").build();
            }
            if(rooms.size() == 0){
                Rooms newRoom = new Rooms();
                em.persist(newRoom);
                newRoom.setRoomName(roomName);
                newRoom.setRoomOwner(roomOwner);
                return Response.ok(roomName).build();
            }
        }
        return Response.noContent().build();
    }
    
    @POST
    @Path("removeRoom")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeRoom(@QueryParam("roomName")  String roomName,
                               @QueryParam("roomOwner") String roomOwner){
        if(roomName != null && roomOwner != null) {
            List<Rooms> rooms = null;
            rooms = em.createQuery("SELECT r FROM Rooms r WHERE r.roomName = :roomName AND r.roomOwner = :roomOwner", Rooms.class)
                    .setParameter("roomName", roomName)
                    .setParameter("roomOwner", roomOwner)
                    .getResultList();
            if (rooms.size() != 0) {
                if (rooms.size() == 1) {
                    em.createQuery("DELETE FROM Rooms r WHERE r.roomName = :roomName AND r.roomOwner = :roomOwner", Rooms.class)
                            .setParameter("roomName", roomName)
                            .setParameter("roomOwner", roomOwner)
                            .executeUpdate();
                    return Response.ok("Room removed: " + roomName).build();
                }
                return Response.noContent().build();
            }
            if (rooms.size() == 0) {
                return Response.ok("No room found by that name: " + roomName).build();
            }
        }
        return Response.noContent().build();
    }
    
    @POST
    @Path("shareRoom")
    @Produces(MediaType.APPLICATION_JSON)
    public Response shareRoom(@QueryParam("sharedRoomName")  String sharedRoomName,
                              @QueryParam("sharedRoomOwner") String sharedRoomOwner, 
                              @QueryParam("sharedWith")      String sharedWith){
        if(sharedRoomName != null && sharedRoomOwner != null && sharedWith != null){
            List<Sharedrooms> sharedRoom = null;
            sharedRoom = em.createQuery("Select s FROM Sharedrooms s WHERE s.sharedRoomName = :sharedRoomName AND s.sharedRoomOwner = :sharedRoomOwner AND s.sharedWith = :sharedWith", Sharedrooms.class)
                    .setParameter("sharedRoomName", sharedRoomName)
                    .setParameter("sharedRoomOwner", sharedRoomOwner)
                    .setParameter("sharedWith", sharedWith)
                    .getResultList();
            if(sharedRoom.size() != 0){
                return Response.ok("Room have already been shared with this user").build();
            }
            if(sharedRoom.size() == 0){
                Sharedrooms newShared = new Sharedrooms();
                em.persist(newShared);
                newShared.setSharedRoomName(sharedRoomName);
                newShared.setSharedRoomOwner(sharedRoomOwner);
                newShared.setSharedWith(sharedWith);
                return Response.ok("Room shared with " + sharedWith).build();
            }
        }
        return Response.noContent().build();
    }
    
    @GET
    @Path("sharedRooms")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sharedrooms> sharedRooms(@QueryParam("sharedWith") String sharedWith){
        List<Sharedrooms> result = null; 
        
        if(sharedWith != null){
            result = em.createQuery("SELECT s FROM Sharedrooms s WHERE s.sharedWith = :sharedWith", Sharedrooms.class)
                .setParameter("sharedWith", sharedWith)
                .getResultList();
        }
        return result != null ? result : Collections.EMPTY_LIST;
    }
}
