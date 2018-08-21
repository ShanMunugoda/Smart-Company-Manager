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
//import java.sql.Date;
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
import javafx.scene.input.MouseEvent;

import java.util.Date;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.comp.business.FactoryBO;
import lk.ijse.comp.business.custom.AllocateStatusBO;
import lk.ijse.comp.business.custom.BranchBO;
import lk.ijse.comp.business.custom.ProjectBO;
import lk.ijse.comp.dto.AllocateStatusDTO;
import lk.ijse.comp.dto.BranchDTO;
import lk.ijse.comp.dto.ProjectDTO;
import lk.ijse.comp.main.StartUp;
import lk.ijse.comp.view.util.tblmodel.AlocatedstatusTM;

/**
 * FXML Controller class
 *
 * @author SDMROX
 */
public class AllocatestatusController implements Initializable {

    @FXML
    private JFXComboBox<String> cmbBranch;
    @FXML
    private JFXComboBox<String> cmbProject;
    @FXML
    private JFXComboBox<String> cmbemployee;
    @FXML
    private JFXTextField txtprojId;
    @FXML
    private JFXTextField txtEmpId;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private TableView<AlocatedstatusTM> tblAllocateStatus;
    private BranchBO branchBO;
    private AllocateStatusBO allocatestatusBO;
    private ProjectBO projectBO;
    @FXML
    private AnchorPane root;

    public AllocatestatusController() {
        this.allocatestatusBO = (AllocateStatusBO) FactoryBO.getInstance().getBO(FactoryBO.BoTypes.allocatestatus);
        this.branchBO = (BranchBO) FactoryBO.getInstance().getBO(FactoryBO.BoTypes.branch);
        this.projectBO = (ProjectBO) FactoryBO.getInstance().getBO(FactoryBO.BoTypes.project);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tblAllocateStatus.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("eid"));
        tblAllocateStatus.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("pid"));
        tblAllocateStatus.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("status"));
        tblAllocateStatus.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("dateleft"));

        loadcmbBranch();
    }

    public void loadcmbBranch() {
        try {
            ArrayList<BranchDTO> allBranch = branchBO.allBranch();
            ArrayList<String> arr = new ArrayList<>();
            for (BranchDTO branchDTO : allBranch) {
                String b = branchDTO.getBid();
                arr.add(b);

            }
            ObservableList olist = FXCollections.observableList(arr);
            cmbBranch.setItems(olist);
        } catch (Exception ex) {
            Logger.getLogger(AllocatestatusController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void cmbBranchOnAction(ActionEvent event) {
        String selectedBid = cmbBranch.getValue();

        try {
            //clear Earliar cmbProject List list when select another
            ObservableList<String> items = cmbProject.getItems();
            items.remove(items);
            //load projects according to selected branch
            ArrayList<ProjectDTO> allPids_and_Bids = allocatestatusBO.allPids_and_Bids();
            ArrayList<String> arr = new ArrayList<>();
            for (ProjectDTO PidsBids : allPids_and_Bids) {
                String prjId = PidsBids.getPid();
                String bnchId = PidsBids.getBid();

                if (bnchId.equals(selectedBid)) {
                    arr.add(prjId);
                    ObservableList<String> olist = FXCollections.observableList(arr);
                    cmbProject.setItems(olist);
                } else {

                }

            }

        } catch (Exception ex) {
            Logger.getLogger(AllocatestatusController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void cmbemployeegetEids(ActionEvent event) {
        String selectedEid = cmbemployee.getValue();
        String selectedProjId = cmbProject.getValue();
        String status;
               System.out.println(selectedEid);
        try {
            ProjectDTO findById = projectBO.findById(selectedProjId);
//            System.out.println(findById);
            Date selectesEdate = findById.getEnddate();

            Date endate = new Date(selectesEdate.getTime());
            long endDate = endate.getTime();
//                System.out.println( time/1000*60*60*24*7);
//            LocalDateTime curDate = LocalDateTime.now();
            long currentDate = new Date().getTime();//Get current Date

            long dleft = (endDate - currentDate) / (1000 * 60 * 60 * 24);//get Date diffrence and convert to days
            String dateLeft = Long.toString(dleft);
            
            if(dleft>0){
                
            status="allocated";
            
                System.out.println(status);
                AllocateStatusDTO allocateStatusDTO = new AllocateStatusDTO(selectedEid, selectedProjId, status, dateLeft);
                boolean result = allocatestatusBO.updateAllocatestatus(allocateStatusDTO);
                if(result){
//                    new Alert(Alert.AlertType.CONFIRMATION,"Employee Allocated",ButtonType.OK).show();
                }
                
            }else{
             status="Free";
             System.out.println(status);
             AllocateStatusDTO allocateStatusDTO = new AllocateStatusDTO(selectedEid, selectedProjId, status, dateLeft);
                boolean result = allocatestatusBO.updateAllocatestatus(allocateStatusDTO);
                if(result){
//                    new Alert(Alert.AlertType.CONFIRMATION,"Employee is free",ButtonType.OK).show();
                }
            }

            loadSelectedEmployee();
        } catch (Exception ex) {
            Logger.getLogger(AllocatestatusController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadSelectedEmployee(){
        try {
            String selectedEid = cmbemployee.getValue();
            String selectedProjId = cmbProject.getValue();
            
            AllocateStatusDTO result = allocatestatusBO.findById(selectedEid, selectedProjId);
            if(result==null){
            return;
            }
            System.out.println("DDDDDDDDDD"+ result.getPid());
            AlocatedstatusTM tblModel=new AlocatedstatusTM(result.getEid(), result.getPid(), result.getStatus(), result.getDateleft());
            
             ObservableList<AlocatedstatusTM> list=tblAllocateStatus.getItems();
            list.removeAll(list);
            list.add(tblModel);
            
        } catch (Exception ex) {
            Logger.getLogger(AllocatestatusController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    @FXML
    private void cmbprojectOnAction(ActionEvent event) {
        String selectPids = cmbProject.getValue();

        try {
            ObservableList<String> items = cmbemployee.getItems();
            items.removeAll(items);
            ArrayList<AllocateStatusDTO> allAllocatestatus = allocatestatusBO.allAllocatestatus();
            ArrayList<String> arr = new ArrayList<>();
            for (AllocateStatusDTO alstatu : allAllocatestatus) {

                String pid = alstatu.getPid();
                String Eid = alstatu.getEid();

                if (pid.equals(selectPids)) {
                    arr.add(Eid);
                    ObservableList<String> olist = FXCollections.observableList(arr);
                    cmbemployee.setItems(olist);
                } else {
                }

            }

        } catch (Exception ex) {
            Logger.getLogger(AllocatestatusController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void cmbEmployeeupdateStatus(MouseEvent event) {
    }

    @FXML
    private void btnAddOnAction(ActionEvent event) {
        
        String projectId=txtprojId.getText();
        String employerId=txtEmpId.getText();
        String status;
        
        try {
            ProjectDTO findById = projectBO.findById(projectId);
//            System.out.println(findById);
            Date selectesEdate = findById.getEnddate();

            Date endate = new Date(selectesEdate.getTime());
            long endDate = endate.getTime();
              //Get current Date 
            long currentDate = new Date().getTime();
            //get Date diffrence and convert to days
            long dleft = (endDate - currentDate) / (1000 * 60 * 60 * 24);
            String dateLeft = Long.toString(dleft);
            
            if(dleft>0){
                
            status="allocated";
            
                System.out.println(status);
                AllocateStatusDTO allocateStatusDTO = new AllocateStatusDTO(employerId, projectId, status, dateLeft);
                boolean result = allocatestatusBO.saveAllocstestatus(allocateStatusDTO);
                if(result){
                    new Alert(Alert.AlertType.CONFIRMATION,"Sucessfully Assign the employee..",ButtonType.OK).show();
                }
                
            }else{
             
                new Alert(Alert.AlertType.INFORMATION, "That project is Ended You Cant Assign Employer", ButtonType.OK).show();
            }

            loadSelectedEmployee();
        } catch (Exception ex) {
            Logger.getLogger(AllocatestatusController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
        
    }

    @FXML
    private void navigateToHome(MouseEvent event) {
       StartUp.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }

}
