/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glutenfreesoftware.shareableshoppinglist.dbtest;

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
@Table(name = "sharedlists")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sharedlists.findAll", query = "SELECT s FROM Sharedlists s")
    , @NamedQuery(name = "Sharedlists.findBySharedListID", query = "SELECT s FROM Sharedlists s WHERE s.sharedListID = :sharedListID")
    , @NamedQuery(name = "Sharedlists.findBySharedListName", query = "SELECT s FROM Sharedlists s WHERE s.sharedListName = :sharedListName")
    , @NamedQuery(name = "Sharedlists.findBySharedListOwner", query = "SELECT s FROM Sharedlists s WHERE s.sharedListOwner = :sharedListOwner")
    , @NamedQuery(name = "Sharedlists.findBySharedWith", query = "SELECT s FROM Sharedlists s WHERE s.sharedWith = :sharedWith")
    , @NamedQuery(name = "Sharedlists.findBySharedListVersion", query = "SELECT s FROM Sharedlists s WHERE s.sharedListVersion = :sharedListVersion")})
public class SharedLists implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SharedListID")
    private Integer sharedListID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SharedListName")
    private String sharedListName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SharedListOwner")
    private String sharedListOwner;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SharedWith")
    private String sharedWith;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SharedListVersion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sharedListVersion;

    public SharedLists() {
    }

    public SharedLists(Integer sharedListID) {
        this.sharedListID = sharedListID;
    }

    public SharedLists(Integer sharedListID, String sharedListName, String sharedListOwner, String sharedWith, Date sharedListVersion) {
        this.sharedListID = sharedListID;
        this.sharedListName = sharedListName;
        this.sharedListOwner = sharedListOwner;
        this.sharedWith = sharedWith;
        this.sharedListVersion = sharedListVersion;
    }

    public Integer getSharedListID() {
        return sharedListID;
    }

    public void setSharedListID(Integer sharedListID) {
        this.sharedListID = sharedListID;
    }

    public String getSharedListName() {
        return sharedListName;
    }

    public void setSharedListName(String sharedListName) {
        this.sharedListName = sharedListName;
    }

    public String getSharedListOwner() {
        return sharedListOwner;
    }

    public void setSharedListOwner(String sharedListOwner) {
        this.sharedListOwner = sharedListOwner;
    }

    public String getSharedWith() {
        return sharedWith;
    }

    public void setSharedWith(String sharedWith) {
        this.sharedWith = sharedWith;
    }

    public Date getSharedListVersion() {
        return sharedListVersion;
    }

    public void setSharedListVersion(Date sharedListVersion) {
        this.sharedListVersion = sharedListVersion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sharedListID != null ? sharedListID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SharedLists)) {
            return false;
        }
        SharedLists other = (SharedLists) object;
        if ((this.sharedListID == null && other.sharedListID != null) || (this.sharedListID != null && !this.sharedListID.equals(other.sharedListID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.glutenfreesoftware.shareableshoppinglist.dbtest.Sharedlists[ sharedListID=" + sharedListID + " ]";
    }
    
}
