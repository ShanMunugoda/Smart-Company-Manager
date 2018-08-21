/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author SDMROX
 */
@Entity
public class Project {
    @Id
    private String pid;
    private String pname;
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Temporal(TemporalType.DATE)
    private Date enddate;

    @ManyToOne
    @JoinColumn(name = "bid",referencedColumnName = "bid")
    private
    Branch branch;

    @OneToMany(mappedBy = "project")
    private
    List<AllocateStatus> allocateStatuses=new ArrayList<>();

    public Project() {
    }

    public Project(String pid, String pname, Date startdate, Date enddate, Branch branch) {
        this.pid = pid;
        this.pname = pname;
        this.startdate = startdate;
        this.enddate = enddate;
        this.branch = branch;
    }

    public Project(String pid){
        this.pid = pid;
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


    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public List<AllocateStatus> getAllocateStatuses() {
        return allocateStatuses;
    }

    public void setAllocateStatuses(List<AllocateStatus> allocateStatuses) {
        this.allocateStatuses = allocateStatuses;
    }
}
