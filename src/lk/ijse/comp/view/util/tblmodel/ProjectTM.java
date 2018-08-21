/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.view.util.tblmodel;

import java.util.Date;

/**
 *
 * @author SDMROX
 */
public class ProjectTM {

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
     * @return the pname
     */
    public String getPname() {
        return pname;
    }

    /**
     * @param pname the pname to set
     */
    public void setPname(String pname) {
        this.pname = pname;
    }

    /**
     * @return the startdate
     */
    public Date getStartdate() {
        return startdate;
    }

    /**
     * @param startdate the startdate to set
     */
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    /**
     * @return the enddate
     */
    public Date getEnddate() {
        return enddate;
    }

    /**
     * @param enddate the enddate to set
     */
    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    /**
     * @return the bid
     */
    public String getBid() {
        return bid;
    }

    /**
     * @param bid the bid to set
     */
    public void setBid(String bid) {
        this.bid = bid;
    }
    private String pid;
    private String pname;
    private Date startdate;
    private Date enddate;
    private String bid;

    public ProjectTM() {
    }

    public ProjectTM(String pid, String pname, Date startdate, Date enddate, String bid) {
        this.pid = pid;
        this.pname = pname;
        this.startdate = startdate;
        this.enddate = enddate;
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "ProjectTM{" + "pid=" + pid + ", pname=" + pname + ", startdate=" + startdate + ", enddate=" + enddate + ", bid=" + bid + '}';
    }
    
    
}
