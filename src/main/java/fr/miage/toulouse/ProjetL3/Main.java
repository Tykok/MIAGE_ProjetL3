package fr.miage.toulouse.ProjetL3;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

/**
 * Classe Main, c'est ici que l'on lance l'application
 * 
 *
 */
public class Main extends Application{
    /**
     * Ouvre la première page (Connexion)
     */
    @Override
    public void start(Stage primaryStage){
        Parent root;
        try{
            root=FXMLLoader.load(getClass().getResource("/fr.miage.toulouse.ProjetL3/Connexion.fxml"));
            Scene scene=new Scene(root);
            
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.getIcons().add(new Image("/fr.miage.toulouse.ProjetL3.Images/_logo.png"));
            primaryStage.setTitle("Suivi des étudiants");
            primaryStage.show();
        } catch (IOException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args){
        launch();
    }
    
}
