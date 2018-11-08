/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_gui_fx;

import com.sun.javafx.scene.control.skin.ComboBoxPopupControl;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author Bartosz
 */
public class Zad5 extends Application {
   

    @Override
    public void start(Stage stage)  {
        VBox layout = new VBox();
        
        
        TextField text = new TextField();
        Button addButton = new Button("Dodaj rekord");
        Button rmvBtn = new Button("Usun rekord");
        Button rmvAll = new Button("Usun cala liste");
        Button rmvByContent = new Button("Usun poprzez zawartosc");
        ObservableList<String> list = FXCollections.observableArrayList (text.getText());
        ComboBox combo = new ComboBox(list);
         
        addButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
             
                if(combo.getSelectionModel().getSelectedIndex()==0)
                combo.getItems().add(0,text.getText());
                else{
                   combo.getItems().add(combo.getSelectionModel().getSelectedIndex()+1,text.getText()); 
                }
                text.setText("");
            }
        });
        
                rmvBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                if(combo.getSelectionModel().getSelectedIndex()==-1){
                    combo.getItems().remove(0);
                }else{
                    combo.getItems().remove(combo.getSelectionModel().getSelectedIndex()+1);
                }
            }
        });
                
          rmvAll.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                list.removeAll(list);
                combo.getItems().remove(combo);
            }
        });
                  rmvByContent.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
               
                combo.getItems().remove(text.getText());
            }
        });
          
          
        HBox hbox = new HBox(30);
        hbox.getChildren().addAll(text, addButton,rmvBtn,rmvAll,rmvByContent);
        layout.getChildren().addAll(hbox, combo);
        Scene scene = new Scene(layout,500,400);
    stage.setTitle("Hello World!");
    stage.setScene(scene);
    stage.show();
    
    
    
    }




}
