/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SDMROX
 */
@Entity
public class Branch {
    @Id
    private String bid;
    private String bname;
    private String baddress;
    @OneToMany(mappedBy = "branch")
    private
    List<Employee> employees=new ArrayList<>();

    @OneToMany(mappedBy = "branch")
    private
    List<Project> projects=new ArrayList<>();

    public Branch() {
    }

    public Branch(String bid, String bname, String baddress) {
        this.bid = bid;
        this.bname = bname;
        this.baddress = baddress;
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

    /**
     * @return the bname
     */
    public String getBname() {
        return bname;
    }

    /**
     * @param bname the bname to set
     */
    public void setBname(String bname) {
        this.bname = bname;
    }

    /**
     * @return the baddress
     */
    public String getBaddress() {
        return baddress;
    }

    /**
     * @param baddress the baddress to set
     */
    public void setBaddress(String baddress) {
        this.baddress = baddress;
    }

    
    public Branch(String bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "Branch{" + "bid=" + bid + ", bname=" + bname + ", baddress=" + baddress + '}';
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
