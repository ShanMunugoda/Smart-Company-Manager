/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.business.custom;

import lk.ijse.comp.business.SuperBO;
import lk.ijse.comp.dto.AllocateStatusDTO;
import lk.ijse.comp.dto.BranchDTO;
import lk.ijse.comp.dto.ProjectDTO;

import java.util.ArrayList;

/**
 *
 * @author SDMROX
 */
public interface AllocateStatusBO extends SuperBO {
    
    public boolean saveAllocstestatus(AllocateStatusDTO allocateStatus)throws Exception;
    
    public boolean updateAllocatestatus(AllocateStatusDTO allocateStatus)throws Exception;
    
    public boolean deleteAllocatestatus(String eid, String pid)throws Exception;

    public ArrayList<AllocateStatusDTO> allAllocatestatus()throws Exception;

    public ArrayList<BranchDTO> allBids()throws Exception;

    public ArrayList<ProjectDTO> allPids_and_Bids()throws Exception;

    public ArrayList<AllocateStatusDTO> allPids()throws Exception;

    public ArrayList<AllocateStatusDTO> allEids()throws Exception;

    public AllocateStatusDTO findById(String eid, String pid)throws Exception;

    
}
