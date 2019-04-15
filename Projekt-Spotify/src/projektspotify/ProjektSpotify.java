/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektspotify;

import DBClasses.*;
import java.lang.reflect.InvocationTargetException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Bartosz
 */
public class ProjektSpotify extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        MainWindow window = new MainWindow();
        window.start(stage);
            
//        MainFX main = new MainFX();
//        main.start(stage);
    }

    public static void main(String[] args) {
        launch(args);

    }

}
