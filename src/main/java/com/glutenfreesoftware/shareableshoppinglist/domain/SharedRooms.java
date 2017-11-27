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
@Table(name = "sharedrooms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sharedrooms.findAll", query = "SELECT s FROM Sharedrooms s")
    , @NamedQuery(name = "Sharedrooms.findBySharedRoomID", query = "SELECT s FROM Sharedrooms s WHERE s.sharedRoomID = :sharedRoomID")
    , @NamedQuery(name = "Sharedrooms.findBySharedRoomName", query = "SELECT s FROM Sharedrooms s WHERE s.sharedRoomName = :sharedRoomName")
    , @NamedQuery(name = "Sharedrooms.findBySharedRoomOwner", query = "SELECT s FROM Sharedrooms s WHERE s.sharedRoomOwner = :sharedRoomOwner")
    , @NamedQuery(name = "Sharedrooms.findBySharedWith", query = "SELECT s FROM Sharedrooms s WHERE s.sharedWith = :sharedWith")
    , @NamedQuery(name = "Sharedrooms.findBySharedRoomVersion", query = "SELECT s FROM Sharedrooms s WHERE s.sharedRoomVersion = :sharedRoomVersion")})
public class SharedRooms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "SharedRoomVersion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sharedRoomVersion;

    public SharedRooms() {
    }

    public SharedRooms(Integer sharedRoomID) {
        this.sharedRoomID = sharedRoomID;
    }

    public SharedRooms(Integer sharedRoomID, String sharedRoomName, String sharedRoomOwner, String sharedWith, Date sharedRoomVersion) {
        this.sharedRoomID = sharedRoomID;
        this.sharedRoomName = sharedRoomName;
        this.sharedRoomOwner = sharedRoomOwner;
        this.sharedWith = sharedWith;
        this.sharedRoomVersion = sharedRoomVersion;
    }

    public Integer getSharedRoomID() {
        return sharedRoomID;
    }

    public void setSharedRoomID(Integer sharedRoomID) {
        this.sharedRoomID = sharedRoomID;
    }

    public String getSharedRoomName() {
        return sharedRoomName;
    }

    public void setSharedRoomName(String sharedRoomName) {
        this.sharedRoomName = sharedRoomName;
    }

    public String getSharedRoomOwner() {
        return sharedRoomOwner;
    }

    public void setSharedRoomOwner(String sharedRoomOwner) {
        this.sharedRoomOwner = sharedRoomOwner;
    }

    public String getSharedWith() {
        return sharedWith;
    }

    public void setSharedWith(String sharedWith) {
        this.sharedWith = sharedWith;
    }

    public Date getSharedRoomVersion() {
        return sharedRoomVersion;
    }

    public void setSharedRoomVersion(Date sharedRoomVersion) {
        this.sharedRoomVersion = sharedRoomVersion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sharedRoomID != null ? sharedRoomID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
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
    public String toString() {
        return "com.glutenfreesoftware.shareableshoppinglist.domain.Sharedrooms[ sharedRoomID=" + sharedRoomID + " ]";
    }
    
}
