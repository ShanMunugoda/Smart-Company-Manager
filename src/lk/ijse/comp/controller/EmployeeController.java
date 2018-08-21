/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.comp.business.FactoryBO;
import lk.ijse.comp.business.SuperBO;
import lk.ijse.comp.business.custom.EmployeeBO;
import lk.ijse.comp.dto.BranchDTO;
import lk.ijse.comp.dto.EmployeeDTO;
import lk.ijse.comp.main.StartUp;
import lk.ijse.comp.view.util.tblmodel.EmployeeTM;

/**
 * FXML Controller class
 *
 * @author SDMROX
 */
public class EmployeeController implements Initializable {

    @FXML
    private JFXTextField txteid;
    @FXML
    private JFXTextField txteName;
    @FXML
    private JFXTextField txteAddress;
    @FXML
    private JFXComboBox<String> cmbBid;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private TableView<EmployeeTM> tblEmployee;
    
    private EmployeeBO employeeBOImpl;
    @FXML
    private AnchorPane root;

    public EmployeeController() {
       
    }
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblEmployee.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("eid"));
        tblEmployee.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("ename"));
        tblEmployee.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("eaddress"));
        tblEmployee.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("bid"));
        
        setemployeeBOImpl(FactoryBO.getInstance().getBO(FactoryBO.BoTypes.employee));
        loadBidToCombo();
        loadTable();
        
    }    
    
    private void setemployeeBOImpl(SuperBO emp){
        this.employeeBOImpl=(EmployeeBO)emp;
    }

    @FXML
    private void btnSaveOnAction(ActionEvent event) {
         saveAll();
    }

    @FXML
    private void btnDeleteOnAction(ActionEvent event) {
        String eid = tblEmployee.getSelectionModel().getSelectedItem().getEid();
        try {
            boolean deleteEmployee = employeeBOImpl.deleteEmployee(eid);
            if (deleteEmployee) {
                new Alert(Alert.AlertType.CONFIRMATION, "employee Deleted....!", ButtonType.OK).show();
                loadTable();
            } else {
                new Alert(Alert.AlertType.ERROR, "Error....!", ButtonType.OK).show();
            }
            
        } catch (Exception ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadBidToCombo(){
        try {
            ArrayList<BranchDTO> bids=employeeBOImpl.allBids();
            ArrayList<String> arr=new ArrayList<>();
            
            for (BranchDTO bid : bids) {
                String b=bid.getBid();
                arr.add(b);
                
            }
            ObservableList<String> olist=FXCollections.observableArrayList(arr);
            cmbBid.setItems(olist);
        } catch (Exception ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveAll(){
        String eid=txteid.getText();
        String ename=txteName.getText();
        String eaddress=txteAddress.getText();
        String bid=cmbBid.getValue();
          EmployeeDTO employee=new EmployeeDTO(eid, ename, eaddress, bid);
        try {
            boolean saveEmployee = employeeBOImpl.saveEmployee(employee);
            if (saveEmployee) {
                new Alert(Alert.AlertType.CONFIRMATION, "Employee Saved...", ButtonType.OK).show();
                txteid.setText("");
                txteName.setText("");
                txteAddress.setText("");
                cmbBid.setValue(null);
                loadTable();
            } else {
                new Alert(Alert.AlertType.ERROR, "Error.....!", ButtonType.OK).show();
            }
          
            
            
        } catch (Exception ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void loadTable(){
        try {
            ArrayList<EmployeeDTO> allEmployee = employeeBOImpl.allEmployee();
            ObservableList<EmployeeTM> OlistItem = tblEmployee.getItems();
            OlistItem.removeAll(OlistItem);
            for (EmployeeDTO emp : allEmployee) {
                EmployeeTM employeeTM=new EmployeeTM(emp.getEid(), emp.getEname(), emp.getEaddress(), emp.getBid());
                OlistItem.add(employeeTM);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void navigateToHome(MouseEvent event) {
         StartUp.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }
}
