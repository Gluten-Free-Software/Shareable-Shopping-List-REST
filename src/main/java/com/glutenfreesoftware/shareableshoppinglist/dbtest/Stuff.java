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
@Table(name = "stuff")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stuff.findAll", query = "SELECT s FROM Stuff s")
    , @NamedQuery(name = "Stuff.findByStuffID", query = "SELECT s FROM Stuff s WHERE s.stuffID = :stuffID")
    , @NamedQuery(name = "Stuff.findByStuffName", query = "SELECT s FROM Stuff s WHERE s.stuffName = :stuffName")
    , @NamedQuery(name = "Stuff.findByStuffVersion", query = "SELECT s FROM Stuff s WHERE s.stuffVersion = :stuffVersion")})
public class Stuff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StuffID")
    private Integer stuffID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "StuffName")
    private String stuffName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "StuffVersion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stuffVersion;

    public Stuff() {
    }

    public Stuff(Integer stuffID) {
        this.stuffID = stuffID;
    }

    public Stuff(Integer stuffID, String stuffName, Date stuffVersion) {
        this.stuffID = stuffID;
        this.stuffName = stuffName;
        this.stuffVersion = stuffVersion;
    }

    public Integer getStuffID() {
        return stuffID;
    }

    public void setStuffID(Integer stuffID) {
        this.stuffID = stuffID;
    }

    public String getStuffName() {
        return stuffName;
    }

    public void setStuffName(String stuffName) {
        this.stuffName = stuffName;
    }

    public Date getStuffVersion() {
        return stuffVersion;
    }

    public void setStuffVersion(Date stuffVersion) {
        this.stuffVersion = stuffVersion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stuffID != null ? stuffID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stuff)) {
            return false;
        }
        Stuff other = (Stuff) object;
        if ((this.stuffID == null && other.stuffID != null) || (this.stuffID != null && !this.stuffID.equals(other.stuffID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.glutenfreesoftware.shareableshoppinglist.dbtest.Stuff[ stuffID=" + stuffID + " ]";
    }
    
}
