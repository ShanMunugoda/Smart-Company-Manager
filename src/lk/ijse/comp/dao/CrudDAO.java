/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.dao;

import java.util.List;

/**
 *
 * @author SDMROX
 */
public interface CrudDAO<T,ID>extends SuperDAO {
    
    public void Save(T entity)throws Exception;
    
    public void Update(T entity)throws Exception;
    
    public void Delete(ID id)throws Exception;
    
    public List<T> getAll()throws Exception;
    
    public T findById(ID id)throws Exception;
    
}
