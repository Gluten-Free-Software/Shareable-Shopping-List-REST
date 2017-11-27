package com.glutenfreesoftware.shareableshoppinglist;

//import com.glutenfreesoftware.shareableshoppinglist.domain.*;
import com.glutenfreesoftware.shareableshoppinglist.dbtest.*;
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
    public List<Lists> getLists(@QueryParam("listRoom")  String listRoom,
                                @QueryParam("listOwner") String listOwner){
        List<Lists> result = null; 
        result = em.createQuery("SELECT l FROM Lists l WHERE l.listRoom = :listRoom AND l.listOwner = :listOwner", Lists.class)
                .setParameter("listRoom", listRoom)
                .setParameter("listOwner", listOwner)
                .getResultList();
        return result != null ? result : Collections.EMPTY_LIST;
    } 
    
    @POST
    @Path("addList")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addList(@QueryParam("listRoom")  String listRoom,
                            @QueryParam("listName")  String listName,
                            @QueryParam("listOwner") String listOwner){
        if(listRoom != null && listName != null && listOwner != null){
            List<Lists> list = null;
            list = em.createQuery("SELECT l FROM Lists l WHERE l.listRoom = :listRoom AND l.listName = :listName AND l.listOwner = :listOwner", Lists.class)
                    .setParameter("listRoom", listRoom)
                    .setParameter("listName", listName)
                    .setParameter("listOwner", listOwner)
                    .getResultList();
            if(list.size() != 0){
                return Response.ok("List already exists with this name").build();
            }
            if(list.size() == 0){
                Lists newList = new Lists();
                em.persist(newList);
                newList.setListRoom(listRoom);
                newList.setListName(listName);
                newList.setListOwner(listOwner);
                return Response.ok("List created: " + listName).build();
            }
        }
        return Response.noContent().build();
    }
    
    @POST
    @Path("removeList2")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeList2(@QueryParam("listName")  String listName,
                                @QueryParam("listOwner") String listOwner){
        if(listName != null && listOwner != null){
            List<Lists> list = null;
            list = em.createQuery("SELECT l FROM Lists l WHERE l.listName = :listName AND l.listOwner = :listOwner", Lists.class)
                    .setParameter("listName", listName)
                    .setParameter("listOwner", listOwner)
                    .getResultList();
            if (list.size() != 0) {
                if (list.size() == 1) {
                    em.createQuery("DELETE FROM Lists l WHERE l.listName = :listName AND l.listOwner = :listOwner", Lists.class)
                            .setParameter("listName", listName)
                            .setParameter("listOwner", listOwner)
                            .executeUpdate();
                    return Response.ok("List removed").build();
                }
                return Response.noContent().build();
            }
            if (list.size() == 0) {
                return Response.ok("No list found by that name: " + listName).build();
            }
        }
        return Response.noContent().build();
    }
    
    @POST
    @Path("removeList")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeList(@QueryParam("listRoom")  String listRoom,
                               @QueryParam("listName")  String listName,
                               @QueryParam("listOwner") String listOwner){
        if(listRoom != null && listName != null && listOwner != null){
            List<Lists> list = null;
            list = em.createQuery("SELECT l FROM Lists l WHERE l.listRoom = :listRoom AND l.listName = :listName AND l.listOwner = :listOwner", Lists.class)
                    .setParameter("listRoom", listRoom)
                    .setParameter("listName", listName)
                    .setParameter("listOwner", listOwner)
                    .getResultList();
            if (list.size() != 0) {
                if (list.size() == 1) {
                    em.createQuery("DELETE FROM Lists l WHERE l.listRoom = :listRoom AND l.listName = :listName AND l.listOwner = :listOwner", Lists.class)
                            .setParameter("listRoom", listRoom)
                            .setParameter("listName", listName)
                            .setParameter("listOwner", listOwner)
                            .executeUpdate();
                    return Response.ok("List removed").build();
                }
                return Response.noContent().build();
            }
            if (list.size() == 0) {
                return Response.ok("No list found by that name: " + listName).build();
            }
        }
        return Response.noContent().build();
    }
    
    @POST
    @Path("addListItem")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addListItem(@QueryParam("listItemList")  String listItemList,
                                @QueryParam("listItemName")  String listItemName,
                                @QueryParam("listItemOwner") String listItemOwner){
        if(listItemList != null && listItemName != null && listItemOwner != null){
            List<ListItems> listItem = null; 
            listItem = em.createQuery("SELECT l FROM Listitems l WHERE l.listItemList = :listItemList AND l.listItemName = :listItemName AND l.listItemOwner = :listItemOwner", ListItems.class)
                    .setParameter("listItemList", listItemList)
                    .setParameter("listItemName", listItemName)
                    .setParameter("listItemOwner", listItemOwner)
                    .getResultList();
            if(listItem.size() != 0){
                return Response.ok("List item already exists").build();
            }
            if(listItem.size() == 0){
                ListItems newItem = new ListItems();
                em.persist(newItem);
                newItem.setListItemList(listItemList);
                newItem.setListItemName(listItemName);
                newItem.setListItemOwner(listItemOwner);
                return Response.ok("List item added: " + listItemName).build();
            }
        }
        return Response.noContent().build();
    }
    
    @GET
    @Path("getListItems")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ListItems> getListItems(@QueryParam("listItemList") String listItemList,
                                        @QueryParam("listItemOwner") String listItemOwner) {
        List<ListItems> result = null;
        if (listItemList != null && listItemOwner != null) {
            result = em.createQuery("SELECT l FROM Listitems l WHERE l.listItemList = :listItemList AND l.listItemOwner = :listItemOwner", ListItems.class)
                    .setParameter("listItemList", listItemList)
                    .setParameter("listItemOwner", listItemOwner)
                    .getResultList();
        }
        return result != null ? result : Collections.EMPTY_LIST;
    }
    
    @POST
    @Path("removeListItem")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeListItem(@QueryParam("listItemList")  String listItemList,
                                @QueryParam("listItemName")  String listItemName,
                                @QueryParam("listItemOwner") String listItemOwner){
        if(listItemList != null && listItemName != null && listItemOwner != null){
            List<ListItems> listItem = null; 
            listItem = em.createQuery("SELECT l FROM Listitems l WHERE l.listItemList = :listItemList AND l.listItemName = :listItemName AND l.listItemOwner = :listItemOwner", ListItems.class)
                    .setParameter("listItemList", listItemList)
                    .setParameter("listItemName", listItemName)
                    .setParameter("listItemOwner", listItemOwner)
                    .getResultList();
            if(listItem.size() != 0){
                if(listItem.size() == 1) {
                    em.createQuery("DELETE FROM Listitems l WHERE l.listItemList = :listItemList AND l.listItemName = :listItemName AND l.listItemOwner = :listItemOwner", ListItems.class)
                            .setParameter("listItemList", listItemList)
                            .setParameter("listItemName", listItemName)
                            .setParameter("listItemOwner", listItemOwner)
                            .executeUpdate();
                    return Response.ok("List item removed").build();
                }
                return Response.noContent().build();
            }
            if(listItem.size() == 0){
                return Response.ok("No list item found by that name: " + listItemName).build();
            }
        }
        return Response.noContent().build();
    }
}
