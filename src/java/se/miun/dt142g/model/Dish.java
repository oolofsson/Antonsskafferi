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
@Table(name = "DISH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dish.findAll", query = "SELECT d FROM Dish d"),
    @NamedQuery(name = "Dish.findByDishid", query = "SELECT d FROM Dish d WHERE d.dishid = :dishid"),
    @NamedQuery(name = "Dish.findByDishname", query = "SELECT d FROM Dish d WHERE d.dishname = :dishname"),
    @NamedQuery(name = "Dish.findByDishprice", query = "SELECT d FROM Dish d WHERE d.dishprice = :dishprice"),
    @NamedQuery(name = "Dish.findByDishtype", query = "SELECT d FROM Dish d WHERE d.dishtype = :dishtype")})
public class Dish implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DISHID")
    private Integer dishid;
    @Size(max = 250)
    @Column(name = "DISHNAME")
    private String dishname;
    @Size(max = 15)
    @Column(name = "DISHPRICE")
    private String dishprice;
    @Size(max = 25)
    @Column(name = "DISHTYPE")
    private String dishtype;

    public Dish() {
    }

    public Dish(Integer dishid) {
        this.dishid = dishid;
    }

    public Dish(String dishname, String dishprice, String dishtype) {
        this.dishname = dishname;
        this.dishprice = dishprice;
        this.dishtype = dishtype;
    }

    public Integer getDishid() {
        return dishid;
    }

    public void setDishid(Integer dishid) {
        this.dishid = dishid;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public String getDishprice() {
        return dishprice;
    }

    public void setDishprice(String dishprice) {
        this.dishprice = dishprice;
    }

    public String getDishtype() {
        return dishtype;
    }

    public void setDishtype(String dishtype) {
        this.dishtype = dishtype;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dishid != null ? dishid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dish)) {
            return false;
        }
        Dish other = (Dish) object;
        if ((this.dishid == null && other.dishid != null) || (this.dishid != null && !this.dishid.equals(other.dishid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return dishname + ", " + dishprice;
    }
    
}
