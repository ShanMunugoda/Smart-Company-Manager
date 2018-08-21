/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.dao;

import lk.ijse.comp.dao.custom.Impl.AllocateStatusDAOImpl;
import lk.ijse.comp.dao.custom.Impl.BranchDAOImpl;
import lk.ijse.comp.dao.custom.Impl.EmployeeDAOImpl;
import lk.ijse.comp.dao.custom.Impl.ProjectDAOImpl;

/**
 *
 * @author SDMROX
 */
public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
        
    }
    
    public static DAOFactory getInstance(){
        if(daoFactory==null){
             daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    
        public enum DaoTypes{
            allocatestatus,branch,employee,project;
        }
        
        public SuperDAO getDAO(DaoTypes daoTypes){
            switch(daoTypes){
            case allocatestatus:
                return new AllocateStatusDAOImpl();
            case branch:
                return new BranchDAOImpl();
            case employee:
                return new EmployeeDAOImpl();
            case project:
                return new ProjectDAOImpl();
            default:
                return null;
            }
        }
    
}
