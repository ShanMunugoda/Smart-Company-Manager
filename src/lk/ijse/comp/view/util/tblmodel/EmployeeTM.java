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
public class EmployeeTM {

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
    private String eid;
    private String ename;
    private String eaddress;
    private String bid;

    public EmployeeTM() {
    }

    public EmployeeTM(String eid, String ename, String eaddress, String bid) {
        this.eid = eid;
        this.ename = ename;
        this.eaddress = eaddress;
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "EmployeeTM{" + "eid=" + eid + ", ename=" + ename + ", eaddress=" + eaddress + ", bid=" + bid + '}';
    }
    
}
