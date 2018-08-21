/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.dto;

/**
 *
 * @author SDMROX
 */
public class AllocateStatusDTO {

    private String eid;
    private String pid;
    private String status;
    private String dateleft;

    public AllocateStatusDTO() {
    }

    public AllocateStatusDTO(String eid, String pid){
        this.eid = eid;
        this.pid = pid;
    }
    public AllocateStatusDTO(String eid, String pid, String status, String dateleft) {
        this.eid = eid;
        this.pid = pid;
        this.status = status;
        this.dateleft = dateleft;
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

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the dateleft
     */
    public String getDateleft() {
        return dateleft;
    }

    /**
     * @param dateleft the dateleft to set
     */
    public void setDateleft(String dateleft) {
        this.dateleft = dateleft;
    }

    @Override
    public String toString() {
        return "AllocatedStatusDTO{" + "eid=" + eid + ", pid=" + pid + ", status=" + status + ", dateleft=" + dateleft + '}';
    }
    
    
    
}
