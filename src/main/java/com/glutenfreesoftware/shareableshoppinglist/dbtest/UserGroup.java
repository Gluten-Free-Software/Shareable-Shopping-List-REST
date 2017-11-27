package com.glutenfreesoftware.shareableshoppinglist.dbtest;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author ThomasSTodal
 */
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@XmlRootElement
public class UserGroup implements Serializable
{
    public static final String ADMIN = "admin";
    public static final String USER = "user";
    
    @Id String name;
    @Id String userid;
}
