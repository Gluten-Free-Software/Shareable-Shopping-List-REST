package com.glutenfreesoftware.shareableshoppinglist.dbtest;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author ThomasSTodal
 */
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@XmlRootElement @XmlAccessorType(XmlAccessType.FIELD)
public class SecureUser implements Serializable
{
    @Id
    String userid;
    
    @XmlTransient
    String password;
}