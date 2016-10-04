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
 * @author oskar
 */
@Named
@RequestScoped
@Entity
@Table(name = "DAILYSPECIAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dailyspecial.findAll", query = "SELECT d FROM Dailyspecial d"),
    @NamedQuery(name = "Dailyspecial.findByDailyid", query = "SELECT d FROM Dailyspecial d WHERE d.dailyid = :dailyid"),
    @NamedQuery(name = "Dailyspecial.findByMonday", query = "SELECT d FROM Dailyspecial d WHERE d.monday = :monday"),
    @NamedQuery(name = "Dailyspecial.findByTuesday", query = "SELECT d FROM Dailyspecial d WHERE d.tuesday = :tuesday"),
    @NamedQuery(name = "Dailyspecial.findByWednesday", query = "SELECT d FROM Dailyspecial d WHERE d.wednesday = :wednesday"),
    @NamedQuery(name = "Dailyspecial.findByThursday", query = "SELECT d FROM Dailyspecial d WHERE d.thursday = :thursday"),
    @NamedQuery(name = "Dailyspecial.findByFriday", query = "SELECT d FROM Dailyspecial d WHERE d.friday = :friday")})
public class Dailyspecial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DAILYID")
    private Integer dailyid;
    @Size(max = 250)
    @Column(name = "MONDAY")
    private String monday;
    @Size(max = 250)
    @Column(name = "TUESDAY")
    private String tuesday;
    @Size(max = 250)
    @Column(name = "WEDNESDAY")
    private String wednesday;
    @Size(max = 250)
    @Column(name = "THURSDAY")
    private String thursday;
    @Size(max = 250)
    @Column(name = "FRIDAY")
    private String friday;

    public Dailyspecial() {
    }

    public Dailyspecial(Integer dailyid) {
        this.dailyid = dailyid;
    }

    public Dailyspecial(int i, String monday, String tuesday, String wednesday, String thursday, String friday) {
        this.dailyid = i;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
    }

    public Integer getDailyid() {
        return dailyid;
    }

    public void setDailyid(Integer dailyid) {
        this.dailyid = dailyid;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        Charset windows1252 = Charset.forName("ISO-8859-1");
        Charset utf8charset = Charset.forName("UTF-8");

        byte[] bytes = monday.getBytes(windows1252);
        String z = new String(bytes, utf8charset);
        this.monday=z;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        Charset windows1252 = Charset.forName("ISO-8859-1");
        Charset utf8charset = Charset.forName("UTF-8");

        byte[] bytes = tuesday.getBytes(windows1252);
        String z = new String(bytes, utf8charset);
        this.tuesday=z;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        Charset windows1252 = Charset.forName("ISO-8859-1");
        Charset utf8charset = Charset.forName("UTF-8");

        byte[] bytes = wednesday.getBytes(windows1252);
        String z = new String(bytes, utf8charset);
        this.wednesday=z;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
                Charset windows1252 = Charset.forName("ISO-8859-1");
        Charset utf8charset = Charset.forName("UTF-8");

        byte[] bytes = thursday.getBytes(windows1252);
        String z = new String(bytes, utf8charset);
        this.thursday=z;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        Charset windows1252 = Charset.forName("ISO-8859-1");
        Charset utf8charset = Charset.forName("UTF-8");

        byte[] bytes = friday.getBytes(windows1252);
        String z = new String(bytes, utf8charset);
        this.friday=z;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dailyid != null ? dailyid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dailyspecial)) {
            return false;
        }
        Dailyspecial other = (Dailyspecial) object;
        if ((this.dailyid == null && other.dailyid != null) || (this.dailyid != null && !this.dailyid.equals(other.dailyid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Måndag: " + monday + "\nTisdag: " + tuesday
                + "\nWednesday: " + wednesday + "\nThursday: " + thursday
                + "\nFriday: " + friday;
    }
    
}
