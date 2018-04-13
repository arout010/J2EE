/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.StudentRecord.oracle;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Akshaya
 */
@Entity
@XmlRootElement
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Password;
    private String FName;
    
    private String Lname;

    private long Mob_no;

    /**
     * Get the value of Mob_no
     *
     * @return the value of Mob_no
     */
    public long getMob_no() {
        return Mob_no;
    }

    /**
     * Set the value of Mob_no
     *
     * @param Mob_no new value of Mob_no
     */
    public void setMob_no(long Mob_no) {
        this.Mob_no = Mob_no;
    }

    /**
     * Get the value of Lname
     *
     * @return the value of Lname
     */
    public String getLname() {
        return Lname;
    }

    /**
     * Set the value of Lname
     *
     * @param Lname new value of Lname
     */
    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    /**
     * Get the value of FName
     *
     * @return the value of FName
     */
    public String getFName() {
        return FName;
    }

    /**
     * Set the value of FName
     *
     * @param FName new value of FName
     */
    public void setFName(String FName) {
        this.FName = FName;
    }


    /**
     * Get the value of Password
     *
     * @return the value of Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * Set the value of Password
     *
     * @param Password new value of Password
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Record)) {
            return false;
        }
        Record other = (Record) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.StudentRecord.oracle.Record[ id=" + id + " ]";
    }
    
}
