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
public class BranchDTO {
    private String bid;
    private String bname;
    private String baddress;

    public BranchDTO() {
    }

    public BranchDTO(String bid){
        this.bid = bid;
    }

    public BranchDTO(String bid, String bname, String baddress) {
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


    @Override
    public String toString() {
        return "BranchDTO{" + "bid=" + bid + ", bname=" + bname + ", baddress=" + baddress + '}';
    }
    
    
}
