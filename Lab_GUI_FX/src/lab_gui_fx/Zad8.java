/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_gui_fx;

/**
 *
 * @author Bartosz
 */

import java.awt.Checkbox;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Zad8 extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        HBox layout = new HBox(20);
        VBox pan1box = new VBox(10);
        VBox pan2box = new VBox(10);
        VBox pan3box= new VBox(10);
        
        VBox mini1 = new VBox(5);
        VBox mini2 = new VBox(5);
        VBox mini3 = new VBox(5);
        
        TextField text1 = new TextField();
        TextField text2 = new TextField();
        TextField text3 = new TextField();
        
        Button btn1 = new Button("Przycisk 1");
        Button btn2 = new Button("Przycisk 2");
        Button btn3 = new Button("Przycisk 3");
        
        CheckBox check1 = new CheckBox();
        CheckBox check2 = new CheckBox();
        CheckBox check3 = new CheckBox();
        
        check1.setOnAction((event) -> {
            if(check1.isSelected()==false){
                mini1.setVisible(true);
            }
            else{
                mini1.setVisible(false);
            }
            
});
              check2.setOnAction((event) -> {
            if(check2.isSelected()==false){
                mini2.setVisible(true);
            }
            else{
                mini2.setVisible(false);
            }
            
});
                    check3.setOnAction((event) -> {
            if(check3.isSelected()==false){
                mini3.setVisible(true);
            }
            else{
                mini3.setVisible(false);
            }
            
});
        
        String minicss = "-fx-border-color: black; " +
                   "-fx-border-insets: 5; " +
                   "-fx-border-width: 3; ";
        
        mini1.getChildren().addAll(text1,btn1);
        mini1.setStyle(minicss);
        mini2.getChildren().addAll(text2,btn2);
        mini2.setStyle(minicss);
        mini3.getChildren().addAll(text3,btn3);
        mini3.setStyle(minicss);
        
        pan1box.getChildren().addAll(mini1,check1);
        pan2box.getChildren().addAll(mini2,check2);
        pan3box.getChildren().addAll(mini3,check3);
        
        layout.getChildren().addAll(pan1box,pan2box,pan3box);
        
        Scene scene = new Scene(layout, 500,400 );
        
        
        
        stage.setTitle("Hello World!");
        stage.setScene(scene);
        stage.show();
    }
    
}
