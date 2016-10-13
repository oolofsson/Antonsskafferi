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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mojjie
 */
@Named
@RequestScoped
@Entity
@Table(name = "IMAGETEXT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Imagetext.findAll", query = "SELECT i FROM Imagetext i"),
    @NamedQuery(name = "Imagetext.findByImagetext", query = "SELECT i FROM Imagetext i WHERE i.imagetext = :imagetext")})
public class Imagetext implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "IMAGETEXT")
    private String imagetext;

    public Imagetext() {
    }

    public Imagetext(String imagetext) {
        this.imagetext = imagetext;
    }

    public String getImagetext() {
        return imagetext;
    }

    public void setImagetext(String imagetext) {
        Charset windows1252 = Charset.forName("ISO-8859-1");
        Charset utf8charset = Charset.forName("UTF-8");

        byte[] bytes = imagetext.getBytes(windows1252);
        String z = new String(bytes, utf8charset);
        this.imagetext=z;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imagetext != null ? imagetext.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imagetext)) {
            return false;
        }
        Imagetext other = (Imagetext) object;
        if ((this.imagetext == null && other.imagetext != null) || (this.imagetext != null && !this.imagetext.equals(other.imagetext))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.miun.dt142g.model.Imagetext[ imagetext=" + imagetext + " ]";
    }
    
}
