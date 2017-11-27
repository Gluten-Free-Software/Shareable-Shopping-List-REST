/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glutenfreesoftware.shareableshoppinglist.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kristian
 */
@Entity
@Table(name = "listitems")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listitems.findAll", query = "SELECT l FROM Listitems l")
    , @NamedQuery(name = "Listitems.findByListItemID", query = "SELECT l FROM Listitems l WHERE l.listItemID = :listItemID")
    , @NamedQuery(name = "Listitems.findByListItemList", query = "SELECT l FROM Listitems l WHERE l.listItemList = :listItemList")
    , @NamedQuery(name = "Listitems.findByListItemName", query = "SELECT l FROM Listitems l WHERE l.listItemName = :listItemName")
    , @NamedQuery(name = "Listitems.findByListItemOwner", query = "SELECT l FROM Listitems l WHERE l.listItemOwner = :listItemOwner")
    , @NamedQuery(name = "Listitems.findByListItemVersion", query = "SELECT l FROM Listitems l WHERE l.listItemVersion = :listItemVersion")})
public class ListItems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "ListItemVersion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date listItemVersion;

    public ListItems() {
    }

    public ListItems(Integer listItemID) {
        this.listItemID = listItemID;
    }

    public ListItems(Integer listItemID, String listItemList, String listItemName, String listItemOwner, Date listItemVersion) {
        this.listItemID = listItemID;
        this.listItemList = listItemList;
        this.listItemName = listItemName;
        this.listItemOwner = listItemOwner;
        this.listItemVersion = listItemVersion;
    }

    public Integer getListItemID() {
        return listItemID;
    }

    public void setListItemID(Integer listItemID) {
        this.listItemID = listItemID;
    }

    public String getListItemList() {
        return listItemList;
    }

    public void setListItemList(String listItemList) {
        this.listItemList = listItemList;
    }

    public String getListItemName() {
        return listItemName;
    }

    public void setListItemName(String listItemName) {
        this.listItemName = listItemName;
    }

    public String getListItemOwner() {
        return listItemOwner;
    }

    public void setListItemOwner(String listItemOwner) {
        this.listItemOwner = listItemOwner;
    }

    public Date getListItemVersion() {
        return listItemVersion;
    }

    public void setListItemVersion(Date listItemVersion) {
        this.listItemVersion = listItemVersion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (listItemID != null ? listItemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
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
    public String toString() {
        return "com.glutenfreesoftware.shareableshoppinglist.domain.Listitems[ listItemID=" + listItemID + " ]";
    }
    
}
