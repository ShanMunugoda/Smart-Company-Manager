/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.business.custom;

import lk.ijse.comp.business.SuperBO;
import lk.ijse.comp.dto.BranchDTO;
import lk.ijse.comp.dto.EmployeeDTO;

import java.util.ArrayList;

/**
 *
 * @author SDMROX
 */
public interface EmployeeBO extends SuperBO {
   public boolean saveEmployee(EmployeeDTO dto)throws Exception;
    
    public boolean updateEmployee(EmployeeDTO dto)throws Exception;
    
    public boolean deleteEmployee(String id)throws Exception;
    
    public ArrayList<EmployeeDTO> allEmployee()throws Exception;
    
    public ArrayList<BranchDTO> allBids()throws Exception;
    
    public EmployeeDTO findById(String eid)throws Exception;
}
