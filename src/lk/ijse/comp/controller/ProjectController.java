/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.ZoneId;
import java.sql.Date;
import java.time.LocalDate;
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
import lk.ijse.comp.business.custom.BranchBO;
import lk.ijse.comp.business.custom.ProjectBO;
import lk.ijse.comp.dto.BranchDTO;
import lk.ijse.comp.dto.ProjectDTO;
import lk.ijse.comp.main.StartUp;
import lk.ijse.comp.view.util.tblmodel.ProjectTM;

/**
 * FXML Controller class
 *
 * @author SDMROX
 */
public class ProjectController implements Initializable {

    @FXML
    private JFXTextField txtPid;
    @FXML
    private JFXDatePicker dtStartDate;
    @FXML
    private JFXTextField txtPname;
    @FXML
    private JFXDatePicker dtEndDate;
    @FXML
    private JFXComboBox<String> cmbBranch;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private TableView<ProjectTM> tblProject;
    private ProjectBO projectBOImpl;
    private BranchBO branchBOImpl;
    @FXML
    private AnchorPane root;
 
    
    public void ProjectController(){
        this.branchBOImpl=(BranchBO) FactoryBO.getInstance().getBO(FactoryBO.BoTypes.branch);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblProject.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("pid"));
        tblProject.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("pname"));
        tblProject.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("startdate"));
        tblProject.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("enddate"));
        tblProject.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("bid"));
        
        
       setProjectBOImpl(FactoryBO.getInstance().getBO(FactoryBO.BoTypes.project));
        loadCmbBranch();
        getall();
    }    
    private void setProjectBOImpl(SuperBO proj){
         this.projectBOImpl=(ProjectBO) proj;
    }

    @FXML
    private void btnSaveOnAction(ActionEvent event) {
        saveProject();
    }

    @FXML
    private void btnDeleteOnAction(ActionEvent event) {
        String pid = tblProject.getSelectionModel().getSelectedItem().getPid();
        try {
            boolean deleteProject = projectBOImpl.deleteProject(pid);
            if (deleteProject) {
                new Alert(Alert.AlertType.CONFIRMATION, "Sucessfully Deleted", ButtonType.OK).show();
                getall();
                
            } else {
                new Alert(Alert.AlertType.ERROR, "Error....!", ButtonType.OK).show();
            }
        } catch (Exception ex) {
            Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveProject(){
        String pid=txtPid.getText();
        String pname=txtPname.getText();
        LocalDate localdate1=dtEndDate.getValue();
        Date enddate =Date.valueOf(localdate1);
//        Date enddate =Date.from(localdate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
         LocalDate localdate2= dtStartDate.getValue();
          Date startdate =Date.valueOf(localdate2);
        String bid=cmbBranch.getValue();
        ProjectDTO projectDto=new ProjectDTO(pid, pname, startdate, enddate, bid);
        
        try {
            boolean save = projectBOImpl.saveProject(projectDto);
            if (save) {
                new Alert(Alert.AlertType.INFORMATION, "Saved sucessfully...", ButtonType.OK);
                txtPid.setText("");
                txtPname.setText("");
                dtStartDate.setValue(null);
                dtEndDate.setValue(null);
                cmbBranch.setValue("");
                getall();
            } else {
            }
        } catch (Exception ex) {
            Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadCmbBranch(){
        try {
   
        ArrayList<BranchDTO> arr=projectBOImpl.allBids();
        ArrayList<String> arr2=new ArrayList<>();
            for (BranchDTO branchDTO : arr) {
                String bid = branchDTO.getBid();
                arr2.add(bid);
    
        }
        ObservableList<String> arr3=FXCollections.observableArrayList(arr2);
                         cmbBranch.setItems(arr3);
        } catch (Exception ex) {
            Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
     }
    
    public void getall(){
        try {
            ArrayList<ProjectDTO> allProject = projectBOImpl.allProject();
            ObservableList<ProjectTM> list=tblProject.getItems();
            list.removeAll(list);
            for (ProjectDTO pro : allProject) {
                ProjectTM projectTM=new ProjectTM(pro.getPid(), pro.getPname(), pro.getStartdate(), pro.getEnddate(), pro.getBid());
                list.add(projectTM);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void navigateToHome(MouseEvent event) {
         StartUp.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }
}