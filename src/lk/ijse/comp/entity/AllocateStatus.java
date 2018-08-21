/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.entity;

import javax.persistence.*;

/**
 *
 * @author SDMROX
 */

@Entity
@Table(name ="allocatedstatus")
public class AllocateStatus {
    @EmbeddedId
    private AllocateStatus_PK alloctedStatus_pk;
    private String status;
    private String dateleft;

    @ManyToOne
    @JoinColumn(name = "eid",referencedColumnName = "eid",updatable = false,insertable = false)
    private
    Employee employee;

    @ManyToOne
    @JoinColumn(name = "pid",referencedColumnName = "pid",insertable = false,updatable = false)
    private
    Project project;


    public AllocateStatus() {
    }

    public AllocateStatus(AllocateStatus_PK alloctedStatus_pk, String status, String dateleft) {
        this.alloctedStatus_pk = alloctedStatus_pk;
        this.status = status;
        this.dateleft = dateleft;
    }

    public AllocateStatus(String eid,String pid, String status, String dateleft) {
        this.alloctedStatus_pk = new AllocateStatus_PK(eid, pid);
        this.status = status;
        this.dateleft = dateleft;
    }
    /**
     * @return the alloctedStatus_pk
     */
    public AllocateStatus_PK getAlloctedStatus_pk() {
        return alloctedStatus_pk;
    }

    /**
     * @param alloctedStatus_pk the alloctedStatus_pk to set
     */
    public void setAlloctedStatus_pk(AllocateStatus_PK alloctedStatus_pk) {
        this.alloctedStatus_pk = alloctedStatus_pk;
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
        return "AllocateStatus{" + "alloctedStatus_pk=" + alloctedStatus_pk + ", status=" + status + ", dateleft=" + dateleft + '}';
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
