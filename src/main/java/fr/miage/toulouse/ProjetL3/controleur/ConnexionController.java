package fr.miage.toulouse.ProjetL3.controleur;

import java.io.IOException;
import javafx.fxml.FXML;
import fr.miage.toulouse.ProjetL3.*;
public class ConnexionController {

	
    @FXML
    private void switchToAcceuil() throws IOException {
    	// Fait appel à setRoot pour mettre à jour la fenêtre avec le .fxml nommé seondary
        App.setRoot("Acceuil");
    }
    
    @FXML
    private void switchToError() throws IOException {
    	// Fait appel à setRoot pour mettre à jour la fenêtre avec le .fxml nommé seondary
        App.setRoot("primary");
    }
    
}