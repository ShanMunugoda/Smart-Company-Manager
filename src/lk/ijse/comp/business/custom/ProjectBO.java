/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.business.custom;

import lk.ijse.comp.business.SuperBO;
import lk.ijse.comp.dto.BranchDTO;
import lk.ijse.comp.dto.ProjectDTO;

import java.util.ArrayList;

/**
 *
 * @author SDMROX
 */
public interface ProjectBO extends SuperBO {
     public boolean saveProject(ProjectDTO dto)throws Exception;
    
    public boolean updateProject(ProjectDTO dto)throws Exception;
    
    public boolean deleteProject(String id)throws Exception;
    
    public ArrayList<ProjectDTO> allProject()throws Exception;
        
     public ArrayList<BranchDTO> allBids()throws Exception;
     
    public ProjectDTO findById(String pid)throws Exception;
}
