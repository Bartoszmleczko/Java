/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_gui_fx;


import com.sun.javafx.scene.control.skin.ComboBoxPopupControl;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.SwingUtilities;
/**
 *
 * @author Bartosz
 */
public class Zad6 extends Application{

    @Override
    public void start(Stage stage) throws Exception {
       VBox layout = new VBox(20); 
       Slider sliderRed = new Slider();
       Slider sliderBlue = new Slider();
        Slider sliderGreen = new Slider();
        Label labelred = new Label("Czerwony: 0");
        Label labelgreen = new Label("Zielony: 0");
        Label labelblue = new Label("Niebieski: 0");
        
        
         sliderRed.setMin(0);
         sliderRed.setMax(255);
         sliderRed.setValue(0);
         
         sliderGreen.setMin(0);
         sliderGreen.setMax(255);
         sliderGreen.setValue(0);
         
         sliderBlue.setMin(0);
         sliderBlue.setMax(255);
         sliderBlue.setValue(0);

         layout.getChildren().addAll(sliderRed,labelred,sliderGreen,labelgreen,sliderBlue,labelblue);
         Scene scene = new Scene(layout,500,400);
       sliderRed.valueChangingProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> source, Boolean oldValue, Boolean newValue) {
                
                labelred.textProperty().setValue("Czerwony: "+String.valueOf((int)sliderRed.getValue()));
                int r=(int) sliderRed.getValue();
                int g = (int)sliderGreen.getValue();
                int b = (int) sliderBlue.getValue();
                
                String style = "-fx-background-color: rgba("+String.valueOf(r)+", "+String.valueOf(g)+", "+String.valueOf(b)+", 0.5);";
                layout.setStyle(style);
                
  } });
       
       
              sliderGreen.valueChangingProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> source, Boolean oldValue, Boolean newValue) {
                
                labelgreen.textProperty().setValue("Zielony: "+String.valueOf((int)sliderGreen.getValue()));
                int r=(int) sliderRed.getValue();
                int g = (int)sliderGreen.getValue();
                int b = (int) sliderBlue.getValue();
                
                String style = "-fx-background-color: rgba("+String.valueOf(r)+", "+String.valueOf(g)+", "+String.valueOf(b)+", 0.5);";
                layout.setStyle(style);
  } });
              
              
            sliderBlue.valueChangingProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> source, Boolean oldValue, Boolean newValue) {   
                labelblue.textProperty().setValue("Niebieski: "+String.valueOf((int)sliderBlue.getValue()));
                
            int r=(int) sliderRed.getValue();
                int g = (int)sliderGreen.getValue();
                int b = (int) sliderBlue.getValue();
                
                String style = "-fx-background-color: rgba("+String.valueOf(r)+", "+String.valueOf(g)+", "+String.valueOf(b)+", 0.5);";
                layout.setStyle(style);
  } });
 
         
        
    stage.setTitle("Hello World!");
    stage.setScene(scene);
    stage.show();
    }
    
}
