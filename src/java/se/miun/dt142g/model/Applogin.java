/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.miun.dt142g.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author William
 */
@Entity
@Table(name = "APPLOGIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Applogin.findAll", query = "SELECT a FROM Applogin a"),
    @NamedQuery(name = "Applogin.findByFirstname", query = "SELECT a FROM Applogin a WHERE a.firstname = :firstname"),
    @NamedQuery(name = "Applogin.findByLastname", query = "SELECT a FROM Applogin a WHERE a.lastname = :lastname"),
    @NamedQuery(name = "Applogin.findByPincode", query = "SELECT a FROM Applogin a WHERE a.pincode = :pincode")})
public class Applogin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 30)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 30)
    @Column(name = "LASTNAME")
    private String lastname;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PINCODE")
    private Integer pincode;

    public Applogin() {
    }

    public Applogin(Integer pincode) {
        this.pincode = pincode;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pincode != null ? pincode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Applogin)) {
            return false;
        }
        Applogin other = (Applogin) object;
        if ((this.pincode == null && other.pincode != null) || (this.pincode != null && !this.pincode.equals(other.pincode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.miun.dt142g.model.Applogin[ pincode=" + pincode + " ]";
    }
    
}
