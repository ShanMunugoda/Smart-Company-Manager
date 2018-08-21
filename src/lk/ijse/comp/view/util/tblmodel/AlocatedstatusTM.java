/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.view.util.tblmodel;

/**
 *
 * @author SDMROX
 */
public class AlocatedstatusTM {
    String eid;
    String pid;
    String status;

    @Override
    public String toString() {
        return "AlocatedstatusTM{" + "eid=" + eid + ", pid=" + pid + ", status=" + status + ", dateleft=" + dateleft + '}';
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDateleft(String dateleft) {
        this.dateleft = dateleft;
    }

    public String getEid() {
        return eid;
    }

    public String getPid() {
        return pid;
    }

    public String getStatus() {
        return status;
    }

    public String getDateleft() {
        return dateleft;
    }

    public AlocatedstatusTM(String eid, String pid, String status, String dateleft) {
        this.eid = eid;
        this.pid = pid;
        this.status = status;
        this.dateleft = dateleft;
    }

    public AlocatedstatusTM() {
    }
    String dateleft;
    
}
