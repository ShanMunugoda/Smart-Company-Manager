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
public class BranchTM {
    
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
    private String bid;
    private String bname;
    private String baddress;

    public BranchTM() {
    }

    public BranchTM(String bid, String bname, String baddress) {
        this.bid = bid;
        this.bname = bname;
        this.baddress = baddress;
    }

    @Override
    public String toString() {
        return "BranchTM{" + "bid=" + bid + ", bname=" + bname + ", baddress=" + baddress + '}';
    }
     
}
