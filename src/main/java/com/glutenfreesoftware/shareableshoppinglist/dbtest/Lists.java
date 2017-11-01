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
@Table(name = "Lists")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lists.findAll", query = "SELECT l FROM Lists l")
    , @NamedQuery(name = "Lists.findByListID", query = "SELECT l FROM Lists l WHERE l.listID = :listID")
    , @NamedQuery(name = "Lists.findByListRoom", query = "SELECT l FROM Lists l WHERE l.listRoom = :listRoom")
    , @NamedQuery(name = "Lists.findByListName", query = "SELECT l FROM Lists l WHERE l.listName = :listName")
    , @NamedQuery(name = "Lists.findByListOwner", query = "SELECT l FROM Lists l WHERE l.listOwner = :listOwner")})
public class Lists implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ListID")
    private Integer listID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ListRoom")
    private String listRoom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ListName")
    private String listName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ListOwner")
    private String listOwner;

    public Lists()
    {
    }

    public Lists(Integer listID)
    {
        this.listID = listID;
    }

    public Lists(Integer listID, String listRoom, String listName, String listOwner)
    {
        this.listID = listID;
        this.listRoom = listRoom;
        this.listName = listName;
        this.listOwner = listOwner;
    }

    public Integer getListID()
    {
        return listID;
    }

    public void setListID(Integer listID)
    {
        this.listID = listID;
    }

    public String getListRoom()
    {
        return listRoom;
    }

    public void setListRoom(String listRoom)
    {
        this.listRoom = listRoom;
    }

    public String getListName()
    {
        return listName;
    }

    public void setListName(String listName)
    {
        this.listName = listName;
    }

    public String getListOwner()
    {
        return listOwner;
    }

    public void setListOwner(String listOwner)
    {
        this.listOwner = listOwner;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (listID != null ? listID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lists)) {
            return false;
        }
        Lists other = (Lists) object;
        if ((this.listID == null && other.listID != null) || (this.listID != null && !this.listID.equals(other.listID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.glutenfreesoftware.shareableshoppinglist.dbtest.Lists[ listID=" + listID + " ]";
    }
    
}
