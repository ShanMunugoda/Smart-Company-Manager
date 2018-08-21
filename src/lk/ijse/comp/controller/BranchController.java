/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import lk.ijse.comp.business.custom.BranchBO;
import lk.ijse.comp.dto.BranchDTO;
import lk.ijse.comp.main.StartUp;
import lk.ijse.comp.view.util.tblmodel.BranchTM;

/**
 * FXML Controller class
 *
 * @author SDMROX
 */
public class BranchController implements Initializable {

    @FXML
    private JFXTextField txtBid;
    @FXML
    private JFXTextField txtBname;
    @FXML
    private JFXTextField txtBaddress;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private TableView<BranchTM> tblBranch;
    
    private BranchBO branchBOImpl;
    @FXML
    private AnchorPane root;
    
    public BranchController(){
        this.branchBOImpl=(BranchBO) FactoryBO.getInstance().getBO(FactoryBO.BoTypes.branch);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblBranch.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("bid"));
        tblBranch.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("bname"));
        tblBranch.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("baddress"));
        
       loadAllBranch();
    }    

    @FXML
    private void btnSaveOnAction(ActionEvent event) {
         SaveBranch();
    }

    @FXML
    private void btnDeleteOnAction(ActionEvent event) {
        String BranchID = tblBranch.getSelectionModel().getSelectedItem().getBid();
        try {
            boolean rst = branchBOImpl.deleteBranch(BranchID);
            if (rst) {
                new Alert(Alert.AlertType.CONFIRMATION, "Successfully Deleted", ButtonType.OK);
                loadAllBranch();
            } else {
                new Alert(Alert.AlertType.ERROR, "Error....!", ButtonType.OK);
            }
        } catch (Exception ex) {
            Logger.getLogger(BranchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void SaveBranch(){
        
    String bid=txtBid.getText();
    String bname=txtBname.getText();
    String baddress=txtBaddress.getText();
    
        BranchDTO branchDTO=new BranchDTO(bid, bname, baddress);
       
        try {
        boolean reslut = branchBOImpl.saveBranch(branchDTO);
           
            
            if(reslut){
               new Alert(Alert.AlertType.CONFIRMATION, "Sucessfully Saved", ButtonType.OK).show();
               txtBid.setText("");
               txtBname.setText("");
               txtBaddress.setText("");
               loadAllBranch();
            }else{
            new Alert(Alert.AlertType.ERROR, "Error...!", ButtonType.OK).show();
            }
        
        } catch (Exception ex) {
            Logger.getLogger(BranchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void loadAllBranch(){
        try {
            ArrayList<BranchDTO> allbranch=branchBOImpl.allBranch();
            ObservableList<BranchTM> list=tblBranch.getItems();
            list.removeAll(list);
            
            for (BranchDTO branch : allbranch) {
                BranchTM branchTM = new BranchTM(branch.getBid(), branch.getBname(), branch.getBaddress());
                list.add(branchTM);
            }
        } catch (Exception ex) {
            Logger.getLogger(BranchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void navigateToHome(MouseEvent event) {
         StartUp.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }
}
