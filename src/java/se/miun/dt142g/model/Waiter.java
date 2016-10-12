/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.miun.dt142g.model;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author oskar
 */
@Named
@RequestScoped
@Entity
@Table(name = "WAITER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Waiter.findAll", query = "SELECT w FROM Waiter w"),
    @NamedQuery(name = "Waiter.findByWaiterid", query = "SELECT w FROM Waiter w WHERE w.waiterid = :waiterid"),
    @NamedQuery(name = "Waiter.findByWaitername", query = "SELECT w FROM Waiter w WHERE w.waitername = :waitername"),
    @NamedQuery(name = "Waiter.findByPincode", query = "SELECT w FROM Waiter w WHERE w.pincode = :pincode")})
public class Waiter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "WAITERID")
    private Integer waiterid;
    @Size(max = 40)
    @Column(name = "WAITERNAME")
    private String waitername;
    @Size(max = 4)
    @Column(name = "PINCODE")
    private String pincode;

    public Waiter() {
    }

    public Waiter(Integer waiterid) {
        this.waiterid = waiterid;
    }

    public Waiter(String waitername, String pincode) {
        this.waitername = waitername;
        this.pincode = pincode;
    }

    public Integer getWaiterid() {
        return waiterid;
    }

    public void setWaiterid(Integer waiterid) {
        this.waiterid = waiterid;
    }

    public String getWaitername() {
        return waitername;
    }

    public void setWaitername(String waitername) {
        this.waitername = waitername;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (waiterid != null ? waiterid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Waiter)) {
            return false;
        }
        Waiter other = (Waiter) object;
        if ((this.waiterid == null && other.waiterid != null) || (this.waiterid != null && !this.waiterid.equals(other.waiterid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return waitername;
    }
    
}
