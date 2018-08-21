/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author SDMROX
 */
@Embeddable
public class AllocateStatus_PK implements Serializable {

    @Column(name = "eid")
    private String eid;
    @Column(name = "pid")
    private String pid;

    public AllocateStatus_PK() {
    }

    public AllocateStatus_PK(String eid, String pid) {
        this.eid = eid;
        this.pid = pid;
    }

    /**
     * @return the eid
     */
    public String getEid() {
        return eid;
    }

    /**
     * @param eid the eid to set
     */
    public void setEid(String eid) {
        this.eid = eid;
    }

    /**
     * @return the pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "AllocateStatus_PK{" + "eid=" + eid + ", pid=" + pid + '}';
    }
    
}
