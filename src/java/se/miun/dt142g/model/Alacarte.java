/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.miun.dt142g.model;

import java.io.Serializable;
import java.nio.charset.Charset;
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
 * @author William
 */
@Named
@RequestScoped
@Entity
@Table(name = "ALACARTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alacarte.findAll", query = "SELECT a FROM Alacarte a"),
    @NamedQuery(name = "Alacarte.findByAlacarteid", query = "SELECT a FROM Alacarte a WHERE a.alacarteid = :alacarteid"),
    @NamedQuery(name = "Alacarte.findByAlacartename", query = "SELECT a FROM Alacarte a WHERE a.alacartename = :alacartename"),
    @NamedQuery(name = "Alacarte.findByAlacarteprice", query = "SELECT a FROM Alacarte a WHERE a.alacarteprice = :alacarteprice"),
    @NamedQuery(name = "Alacarte.findByAlacartetype", query = "SELECT a FROM Alacarte a WHERE a.alacartetype = :alacartetype")})
public class Alacarte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ALACARTEID")
    private Integer alacarteid;
    @Size(max = 250)
    @Column(name = "ALACARTENAME")
    private String alacartename;
    @Size(max = 15)
    @Column(name = "ALACARTEPRICE")
    private String alacarteprice;
    @Size(max = 25)
    @Column(name = "ALACARTETYPE")
    private String alacartetype;

    public Alacarte() {
    }

    public Alacarte(Integer alacarteid) {
        this.alacarteid = alacarteid;
    }

    public Alacarte(String alacartename, String alacarteprice, String alacartetype) {
        this.alacartename = alacartename;
        this.alacarteprice = alacarteprice;
        this.alacartetype = alacartetype;
    }



    public Integer getAlacarteid() {
        return alacarteid;
    }

    public void setAlacarteid(Integer alacarteid) {
        this.alacarteid = alacarteid;
    }

    public String getAlacartename() {
        return alacartename;
    }

    public void setAlacartename(String alacartename) {
         Charset windows1252 = Charset.forName("ISO-8859-1");
        Charset utf8charset = Charset.forName("UTF-8");

        byte[] bytes = alacartename.getBytes(windows1252);
        String z = new String(bytes, utf8charset);
        this.alacartename = z;
    }

    public String getAlacarteprice() {
        return alacarteprice;
    }

    public void setAlacarteprice(String alacarteprice) {
        this.alacarteprice = alacarteprice;
    }

    public String getAlacartetype() {
        return alacartetype;
    }

    public void setAlacartetype(String alacartetype) {
        Charset windows1252 = Charset.forName("ISO-8859-1");
        Charset utf8charset = Charset.forName("UTF-8");

        byte[] bytes = alacartetype.getBytes(windows1252);
        String z = new String(bytes, utf8charset);
        this.alacartetype = z;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alacarteid != null ? alacarteid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alacarte)) {
            return false;
        }
        Alacarte other = (Alacarte) object;
        if ((this.alacarteid == null && other.alacarteid != null) || (this.alacarteid != null && !this.alacarteid.equals(other.alacarteid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return alacartename + ", " + alacarteprice;
    }
    
}
