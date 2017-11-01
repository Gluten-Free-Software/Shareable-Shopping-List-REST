/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glutenfreesoftware.shareableshoppinglist.dbtest;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ThomasSTodal
 */
@Entity
@Table(name = "SharedRooms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SharedRooms.findAll", query = "SELECT s FROM SharedRooms s")
    , @NamedQuery(name = "SharedRooms.findBySharedRoomID", query = "SELECT s FROM SharedRooms s WHERE s.sharedRoomID = :sharedRoomID")
    , @NamedQuery(name = "SharedRooms.findBySharedRoomName", query = "SELECT s FROM SharedRooms s WHERE s.sharedRoomName = :sharedRoomName")
    , @NamedQuery(name = "SharedRooms.findBySharedRoomOwner", query = "SELECT s FROM SharedRooms s WHERE s.sharedRoomOwner = :sharedRoomOwner")
    , @NamedQuery(name = "SharedRooms.findBySharedWith", query = "SELECT s FROM SharedRooms s WHERE s.sharedWith = :sharedWith")})
public class SharedRooms implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SharedRoomID")
    private Integer sharedRoomID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SharedRoomName")
    private String sharedRoomName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SharedRoomOwner")
    private String sharedRoomOwner;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SharedWith")
    private String sharedWith;

    public SharedRooms()
    {
    }

    public SharedRooms(Integer sharedRoomID)
    {
        this.sharedRoomID = sharedRoomID;
    }

    public SharedRooms(Integer sharedRoomID, String sharedRoomName, String sharedRoomOwner, String sharedWith)
    {
        this.sharedRoomID = sharedRoomID;
        this.sharedRoomName = sharedRoomName;
        this.sharedRoomOwner = sharedRoomOwner;
        this.sharedWith = sharedWith;
    }

    public Integer getSharedRoomID()
    {
        return sharedRoomID;
    }

    public void setSharedRoomID(Integer sharedRoomID)
    {
        this.sharedRoomID = sharedRoomID;
    }

    public String getSharedRoomName()
    {
        return sharedRoomName;
    }

    public void setSharedRoomName(String sharedRoomName)
    {
        this.sharedRoomName = sharedRoomName;
    }

    public String getSharedRoomOwner()
    {
        return sharedRoomOwner;
    }

    public void setSharedRoomOwner(String sharedRoomOwner)
    {
        this.sharedRoomOwner = sharedRoomOwner;
    }

    public String getSharedWith()
    {
        return sharedWith;
    }

    public void setSharedWith(String sharedWith)
    {
        this.sharedWith = sharedWith;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (sharedRoomID != null ? sharedRoomID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SharedRooms)) {
            return false;
        }
        SharedRooms other = (SharedRooms) object;
        if ((this.sharedRoomID == null && other.sharedRoomID != null) || (this.sharedRoomID != null && !this.sharedRoomID.equals(other.sharedRoomID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.glutenfreesoftware.shareableshoppinglist.dbtest.SharedRooms[ sharedRoomID=" + sharedRoomID + " ]";
    }
    
}
