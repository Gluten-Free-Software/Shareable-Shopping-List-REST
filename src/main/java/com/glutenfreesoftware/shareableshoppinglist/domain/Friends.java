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
@Table(name = "friends")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Friends.findAll", query = "SELECT f FROM Friends f")
    , @NamedQuery(name = "Friends.findByFriendsID", query = "SELECT f FROM Friends f WHERE f.friendsID = :friendsID")
    , @NamedQuery(name = "Friends.findByUser1", query = "SELECT f FROM Friends f WHERE f.user1 = :user1")
    , @NamedQuery(name = "Friends.findByUser2", query = "SELECT f FROM Friends f WHERE f.user2 = :user2")
    , @NamedQuery(name = "Friends.findByStatus", query = "SELECT f FROM Friends f WHERE f.status = :status")
    , @NamedQuery(name = "Friends.findByFriendsVersion", query = "SELECT f FROM Friends f WHERE f.friendsVersion = :friendsVersion")})
public class Friends implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FriendsID")
    private Integer friendsID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "User1")
    private String user1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "User2")
    private String user2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FriendsVersion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date friendsVersion;

    public Friends() {
    }

    public Friends(Integer friendsID) {
        this.friendsID = friendsID;
    }

    public Friends(Integer friendsID, String user1, String user2, String status, Date friendsVersion) {
        this.friendsID = friendsID;
        this.user1 = user1;
        this.user2 = user2;
        this.status = status;
        this.friendsVersion = friendsVersion;
    }

    public Integer getFriendsID() {
        return friendsID;
    }

    public void setFriendsID(Integer friendsID) {
        this.friendsID = friendsID;
    }

    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public String getUser2() {
        return user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFriendsVersion() {
        return friendsVersion;
    }

    public void setFriendsVersion(Date friendsVersion) {
        this.friendsVersion = friendsVersion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (friendsID != null ? friendsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Friends)) {
            return false;
        }
        Friends other = (Friends) object;
        if ((this.friendsID == null && other.friendsID != null) || (this.friendsID != null && !this.friendsID.equals(other.friendsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.glutenfreesoftware.shareableshoppinglist.domain.Friends[ friendsID=" + friendsID + " ]";
    }
    
}
