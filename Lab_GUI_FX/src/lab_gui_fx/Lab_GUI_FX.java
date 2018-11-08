/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package lab_gui_fx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
*
* @author Student
*/
public class Lab_GUI_FX extends Application {

@Override
public void start(Stage primaryStage) throws Exception {
Button btn = new Button();
Button rmvbtn = new Button();
Button removeList = new Button();
Button AddToList = new Button();
Button removeContent = new Button();
final TextField poleTextowe = new TextField();
final ListView<String> list = new ListView<String>();
final String[] liczby= {"jeden", "dwa","trzy","cztery"};
final ObservableList<String> items =FXCollections.observableArrayList (liczby);
list.setItems(items);



HBox box = new HBox(30);
box.getChildren().addAll(poleTextowe, btn, rmvbtn, removeList);
HBox box2 = new HBox(30);
box2.getChildren().addAll(rmvbtn, removeList, AddToList, removeContent);
VBox mainBox = new VBox(20);
mainBox.getChildren().addAll(box,box2,list);

btn.setText("Dodaj do listy");
btn.setOnAction(new EventHandler<ActionEvent>() {

@Override
public void handle(ActionEvent event) {
String text = poleTextowe.getText();
items.add(text);
list.setItems(items);
poleTextowe.setText("");

}
});
rmvbtn.setText("Usun z listy");
rmvbtn.setOnAction(new EventHandler<ActionEvent>() {

@Override
public void handle(ActionEvent event) {
items.remove(list.getSelectionModel().getSelectedIndex());
items.removeAll(liczby);
items.addAll(liczby);
items.remove(0);
items.add(poleTextowe.getText());
poleTextowe.setText("");

}
});
removeList.setText("Usun cala liste");
removeList.setOnAction(new EventHandler<ActionEvent>() {

@Override
public void handle(ActionEvent event) {

items.removeAll(items);
items.addAll(liczby);
items.add(poleTextowe.getText());

}
});
AddToList.setText("Dodaj w srodek");
AddToList.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent event) {
items.add(list.getSelectionModel().getSelectedIndex()+1,poleTextowe.getText());
poleTextowe.setText("");

} 
});

removeContent.setText("Usun zawartosc");
removeContent.setOnAction(new EventHandler<ActionEvent>() {

@Override
public void handle(ActionEvent event) {
items.remove(poleTextowe.getText());
poleTextowe.setText("");

}
});


Scene scene = new Scene(mainBox, 500, 450);


primaryStage.setTitle("Hello World!");
primaryStage.setScene(scene);
primaryStage.show();

//Zad5 zad5 = new Zad5();
Stage stage = new Stage();


Zad6 zad6 = new Zad6();

Zad8 zad8 = new Zad8();
zad8.start(stage);

}

/**
* The main() method is ignored in correctly deployed JavaFX application.
* main() serves only as fallback in case the application can not be
* launched through deployment artifacts, e.g., in IDEs with limited FX
* support. NetBeans ignores main().
*
* @param args the command line arguments
*/
public static void main(String[] args) {
launch(args);
}

}
