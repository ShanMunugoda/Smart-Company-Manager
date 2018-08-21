/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.business.custom.Impl;

import lk.ijse.comp.business.custom.EmployeeBO;
import lk.ijse.comp.dao.DAOFactory;
import lk.ijse.comp.dao.custom.BranchDAO;
import lk.ijse.comp.dao.custom.EmployeeDAO;
import lk.ijse.comp.db.HibernateUtil;
import lk.ijse.comp.dto.BranchDTO;
import lk.ijse.comp.dto.EmployeeDTO;
import lk.ijse.comp.entity.Branch;
import lk.ijse.comp.entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SDMROX
 */
public class EmployeeBOImpl implements EmployeeBO {
    
    private EmployeeDAO employeeDAO;
    private BranchDAO branchDAOImpl;
    private SessionFactory sessionFactory;

    public EmployeeBOImpl() {
        this.employeeDAO=(EmployeeDAO) DAOFactory.getInstance().getDAO(DAOFactory.DaoTypes.employee);
        this.branchDAOImpl=(BranchDAO) DAOFactory.getInstance().getDAO(DAOFactory.DaoTypes.branch);
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    

    @Override
    public boolean saveEmployee(EmployeeDTO dto) throws Exception {
        try(Session session=sessionFactory.openSession()) {
            employeeDAO.setSession(session);
            session.beginTransaction();
            Employee emp = new Employee(dto.getEid(), dto.getEname(), dto.getEaddress(), new Branch(dto.getBid()));
            employeeDAO.Save(emp);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException exp){
            return false;
        }
    }

    @Override
    public boolean updateEmployee(EmployeeDTO dto) throws Exception {
//       Employee emp=new Employee(dto.getEid(), dto.getEname(),dto.getEaddress(),new Branch(dto.getBid()));
//        boolean rst = employeeDAO.Update(emp);
//        return rst;
        return false;
    }

    @Override
    public boolean deleteEmployee(String id) throws Exception {
        try(Session session=sessionFactory.openSession()){
            employeeDAO.setSession(session);
            session.beginTransaction();
            employeeDAO.Delete(id);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException exp){
            return false;
        }

    }

    @Override
    public ArrayList<EmployeeDTO> allEmployee() throws Exception {

        try (Session session = sessionFactory.openSession()) {
            employeeDAO.setSession(session);
            session.beginTransaction();

            ArrayList<EmployeeDTO> arr = new ArrayList<>();
            List<Employee> allemp = employeeDAO.getAll();

            for (Employee employee : allemp) {
                EmployeeDTO employeeDTO = new EmployeeDTO(employee.getEid(), employee.getEname(), employee.getEaddress(), employee.getBranch().getBid());
                arr.add(employeeDTO);

            }
            session.getTransaction().commit();
            return arr;
        }catch (HibernateException exp){
            return null;
        }
    }

    @Override
    public EmployeeDTO findById(String eid) throws Exception {

        try(Session session=sessionFactory.openSession()) {
            employeeDAO.setSession(session);
            session.beginTransaction();

            Employee find = employeeDAO.findById(eid);
            EmployeeDTO employeedto = new EmployeeDTO(find.getEid(), find.getEname(), find.getEaddress(), find.getBranch().getBid());
            session.getTransaction().commit();
            return employeedto;
        }catch (HibernateException exp){
            return null;
        }
    }

    @Override
    public ArrayList<BranchDTO> allBids() throws Exception {
        try (Session session = sessionFactory.openSession()) {
            branchDAOImpl.setSession(session);
            session.beginTransaction();
            List<Branch> branch = branchDAOImpl.getAll();
            ArrayList<BranchDTO> arr = new ArrayList<>();
            for (Branch branch1 : branch) {
                BranchDTO b = new BranchDTO(branch1.getBid());
                arr.add(b);

            }
            session.getTransaction().commit();
            return arr;
        }catch (HibernateException exp){
            return null;
        }
    }
}
