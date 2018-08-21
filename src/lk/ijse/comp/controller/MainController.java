/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author SDMROX
 */
public class MainController implements Initializable {

    @FXML
    private ImageView imgEmployee;
    @FXML
    private ImageView imgBranch;
    @FXML
    private ImageView imgStatus;
    @FXML
    private ImageView imgProject;
    @FXML
    private Label lblMenu;
    @FXML
    private Label lblDescription;
    @FXML
    private AnchorPane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void playMouseExitAnimation(MouseEvent event) {
         if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();
            ScaleTransition scaleT =new ScaleTransition(Duration.millis(150), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play(); 
            
            icon.setEffect(null);
            lblMenu.setText("Welcome");
            lblDescription.setText("Please select one of above main operations to proceed");
        }
    }

    @FXML
    private void playMouseEnterAnimation(MouseEvent event) {
        
            if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();
            
            switch(icon.getId()){
                case "imgEmployee":
                    lblMenu.setText("Emploies");
                    lblDescription.setText("Click to add,delete or view emploies");
                    break;
                case "imgBranch":
                    lblMenu.setText("Branches");
                    lblDescription.setText("Click to add, delete or view Branches");
                    break;
                case "imgProject":
                    lblMenu.setText("Projects");
                    lblDescription.setText("Click to add or view On going Projects");
                    break;
                case "imgStatus":
                    lblMenu.setText("Status");
                    lblDescription.setText("Click to allocate and view status of your employes");
                    break;
                
                
            }
            
            ScaleTransition scaleT =new ScaleTransition(Duration.millis(400), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play(); 
            
            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);            
        }
        
    }

    @FXML
    private void navigate(MouseEvent event)throws IOException{
           if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();
            
            Parent root = null;     
            
            switch(icon.getId()){
                case "imgEmployee":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/comp/view/Employee.fxml"));
                    break;
                case "imgBranch":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/comp/view/Branch.fxml"));
                    break;
                case "imgProject":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/comp/view/Project.fxml"));
                    break;
                case "imgStatus":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/comp/view/Allocatestatus.fxml"));
                    break;
                
                
            }
            
            if (root != null){
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();
                
                TranslateTransition tt = new TranslateTransition(Duration.millis(400), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();
                
            }
        }
    }
    
}
