/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.business.custom.Impl;

import lk.ijse.comp.business.custom.BranchBO;
import lk.ijse.comp.dao.DAOFactory;
import lk.ijse.comp.dao.custom.BranchDAO;
import lk.ijse.comp.db.HibernateUtil;
import lk.ijse.comp.dto.BranchDTO;
import lk.ijse.comp.entity.Branch;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SDMROX
 */
public class BranchBOImpl implements BranchBO {
    
    private BranchDAO branchDAO;
    private SessionFactory sessionFactory;
    public BranchBOImpl() {
        
        this.branchDAO=(BranchDAO) DAOFactory.getInstance().getDAO(DAOFactory.DaoTypes.branch);
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    

    @Override
    public boolean saveBranch(BranchDTO dto) throws Exception {
        Branch brnh=new Branch(dto.getBid(), dto.getBname(), dto.getBaddress());
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            branchDAO.setSession(session);
            branchDAO.Save(brnh);
            session.getTransaction().commit();
        }
       return true;
        
    }

    @Override
    public boolean updateBranch(BranchDTO dto) throws Exception {
        try(Session session=sessionFactory.openSession()) {
            session.beginTransaction();
            Branch brnh = new Branch(dto.getBid(), dto.getBname(), dto.getBaddress());
            branchDAO.Update(brnh);
            session.getTransaction().commit();
        }
        return true;
    }

    @Override
    public boolean deleteBranch(String id) throws Exception {
        try(Session session=sessionFactory.openSession()) {
            branchDAO.setSession(session);
            session.beginTransaction();

            branchDAO.Delete(id);

            session.getTransaction().commit();
        }
        return true;
    }

    @Override
    public ArrayList<BranchDTO> allBranch() throws Exception {
        try(Session session=sessionFactory.openSession()) {
            session.beginTransaction();
            branchDAO.setSession(session);
            ArrayList<BranchDTO> arr = new ArrayList<>();
            List<Branch> allbranch = branchDAO.getAll();

            for (Branch branch : allbranch) {

                BranchDTO brnh = new BranchDTO(branch.getBid(), branch.getBname(), branch.getBaddress());
                arr.add(brnh);

            }
            session.getTransaction().commit();
            return arr;
        }
    }

    @Override
    public BranchDTO findById(String bid) throws Exception {
        try(Session session=sessionFactory.openSession()) {
            branchDAO.setSession(session);
            session.beginTransaction();

            Branch find = branchDAO.findById(bid);
            BranchDTO brnhdto = new BranchDTO(find.getBid(), find.getBname(), find.getBaddress());
            session.getTransaction().commit();
            return brnhdto;
        }
    }
  
}
