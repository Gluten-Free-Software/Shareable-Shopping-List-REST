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
@Table(name = "Rooms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rooms.findAll", query = "SELECT r FROM Rooms r")
    , @NamedQuery(name = "Rooms.findByRoomID", query = "SELECT r FROM Rooms r WHERE r.roomID = :roomID")
    , @NamedQuery(name = "Rooms.findByRoomName", query = "SELECT r FROM Rooms r WHERE r.roomName = :roomName")
    , @NamedQuery(name = "Rooms.findByRoomOwner", query = "SELECT r FROM Rooms r WHERE r.roomOwner = :roomOwner")})
public class Rooms implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RoomID")
    private Integer roomID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "RoomName")
    private String roomName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "RoomOwner")
    private String roomOwner;

    public Rooms()
    {
    }

    public Rooms(Integer roomID)
    {
        this.roomID = roomID;
    }

    public Rooms(Integer roomID, String roomName, String roomOwner)
    {
        this.roomID = roomID;
        this.roomName = roomName;
        this.roomOwner = roomOwner;
    }

    public Integer getRoomID()
    {
        return roomID;
    }

    public void setRoomID(Integer roomID)
    {
        this.roomID = roomID;
    }

    public String getRoomName()
    {
        return roomName;
    }

    public void setRoomName(String roomName)
    {
        this.roomName = roomName;
    }

    public String getRoomOwner()
    {
        return roomOwner;
    }

    public void setRoomOwner(String roomOwner)
    {
        this.roomOwner = roomOwner;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (roomID != null ? roomID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rooms)) {
            return false;
        }
        Rooms other = (Rooms) object;
        if ((this.roomID == null && other.roomID != null) || (this.roomID != null && !this.roomID.equals(other.roomID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.glutenfreesoftware.shareableshoppinglist.dbtest.Rooms[ roomID=" + roomID + " ]";
    }
    
}
