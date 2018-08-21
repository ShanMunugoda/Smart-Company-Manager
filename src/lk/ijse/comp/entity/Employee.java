/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SDMROX
 */
@Entity
public class Employee {
    @Id
    private String eid;
    private String ename;
    private String eaddress;
    @ManyToOne
    @JoinColumn(name = "bid",referencedColumnName = "bid")
    private
    Branch branch;

    @OneToMany(mappedBy = "employee")
    private
    List<AllocateStatus>allocateStatuses=new ArrayList<>();

    public Employee() {
    }

    public Employee(String eid, String ename, String eaddress, Branch branch) {
        this.eid = eid;
        this.ename = ename;
        this.eaddress = eaddress;
        this.branch = branch;
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
     * @return the ename
     */
    public String getEname() {
        return ename;
    }

    /**
     * @param ename the ename to set
     */
    public void setEname(String ename) {
        this.ename = ename;
    }

    /**
     * @return the eaddress
     */
    public String getEaddress() {
        return eaddress;
    }

    /**
     * @param eaddress the eaddress to set
     */
    public void setEaddress(String eaddress) {
        this.eaddress = eaddress;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", eaddress='" + eaddress + '\'' +
                ", branch=" + branch +
                '}';
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
