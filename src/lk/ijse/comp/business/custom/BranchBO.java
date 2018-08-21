/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.business.custom;

import lk.ijse.comp.business.SuperBO;
import lk.ijse.comp.dto.BranchDTO;

import java.util.ArrayList;

/**
 *
 * @author SDMROX
 */
public interface BranchBO extends SuperBO {
    public boolean saveBranch(BranchDTO dto)throws Exception;
    
    public boolean updateBranch(BranchDTO dto)throws Exception;
    
    public boolean deleteBranch(String bid)throws Exception;
    
    public ArrayList<BranchDTO> allBranch()throws Exception;
    
    public BranchDTO findById(String id)throws Exception;
}
