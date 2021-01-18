package fr.miage.toulouse.ProjetL3;

import java.io.IOException;

import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
    	// Fait appel à setRoot pour mettre à jour la fenêtre avec le .fxml nommé primary
        App.setRoot("primary");
    }
}