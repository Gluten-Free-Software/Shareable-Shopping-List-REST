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
@Table(name = "ListItems")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListItems.findAll", query = "SELECT l FROM ListItems l")
    , @NamedQuery(name = "ListItems.findByListItemID", query = "SELECT l FROM ListItems l WHERE l.listItemID = :listItemID")
    , @NamedQuery(name = "ListItems.findByListItemList", query = "SELECT l FROM ListItems l WHERE l.listItemList = :listItemList")
    , @NamedQuery(name = "ListItems.findByListItemName", query = "SELECT l FROM ListItems l WHERE l.listItemName = :listItemName")
    , @NamedQuery(name = "ListItems.findByListItemOwner", query = "SELECT l FROM ListItems l WHERE l.listItemOwner = :listItemOwner")})
public class ListItems implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ListItemID")
    private Integer listItemID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ListItemList")
    private String listItemList;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ListItemName")
    private String listItemName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ListItemOwner")
    private String listItemOwner;

    public ListItems()
    {
    }

    public ListItems(Integer listItemID)
    {
        this.listItemID = listItemID;
    }

    public ListItems(Integer listItemID, String listItemList, String listItemName, String listItemOwner)
    {
        this.listItemID = listItemID;
        this.listItemList = listItemList;
        this.listItemName = listItemName;
        this.listItemOwner = listItemOwner;
    }

    public Integer getListItemID()
    {
        return listItemID;
    }

    public void setListItemID(Integer listItemID)
    {
        this.listItemID = listItemID;
    }

    public String getListItemList()
    {
        return listItemList;
    }

    public void setListItemList(String listItemList)
    {
        this.listItemList = listItemList;
    }

    public String getListItemName()
    {
        return listItemName;
    }

    public void setListItemName(String listItemName)
    {
        this.listItemName = listItemName;
    }

    public String getListItemOwner()
    {
        return listItemOwner;
    }

    public void setListItemOwner(String listItemOwner)
    {
        this.listItemOwner = listItemOwner;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (listItemID != null ? listItemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListItems)) {
            return false;
        }
        ListItems other = (ListItems) object;
        if ((this.listItemID == null && other.listItemID != null) || (this.listItemID != null && !this.listItemID.equals(other.listItemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.glutenfreesoftware.shareableshoppinglist.dbtest.ListItems[ listItemID=" + listItemID + " ]";
    }
    
}
