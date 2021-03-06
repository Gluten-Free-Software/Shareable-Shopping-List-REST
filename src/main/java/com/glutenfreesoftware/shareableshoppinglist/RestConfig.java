package com.glutenfreesoftware.shareableshoppinglist;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

/**
 *
 * @author Kristian
 */
@ApplicationPath("api")
public class RestConfig extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(MultiPartFeature.class);
        addRestResourceClasses(resources);
        return resources;
    }
    
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.glutenfreesoftware.shareableshoppinglist.AuthService.class);
        resources.add(com.glutenfreesoftware.shareableshoppinglist.ListServices.class);
        resources.add(com.glutenfreesoftware.shareableshoppinglist.RoomServices.class);
        resources.add(com.glutenfreesoftware.shareableshoppinglist.UserServices.class);
    }
}
