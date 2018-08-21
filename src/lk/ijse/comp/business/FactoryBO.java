/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.business;

import lk.ijse.comp.business.custom.Impl.AllocateStatusBOImpl;
import lk.ijse.comp.business.custom.Impl.BranchBOImpl;
import lk.ijse.comp.business.custom.Impl.EmployeeBOImpl;
import lk.ijse.comp.business.custom.Impl.ProjectBOImpl;

/**
 *
 * @author SDMROX
 */
public class FactoryBO {
    
    private static FactoryBO factoryBO;

    private FactoryBO() {
    }
    
    public static FactoryBO getInstance(){
        if(factoryBO==null){
            factoryBO = new FactoryBO();
        }
        return factoryBO;
    }
    
    public enum BoTypes{
        allocatestatus,branch,employee,project;
    }
    
    
    public SuperBO getBO(BoTypes boTypes){
        switch(boTypes){
            case allocatestatus:
                return new AllocateStatusBOImpl();
            case branch:
                return new BranchBOImpl();
            case employee:
                return new EmployeeBOImpl();
            case project:
                return new ProjectBOImpl();
            default:
                return null;
        }
    }
}
