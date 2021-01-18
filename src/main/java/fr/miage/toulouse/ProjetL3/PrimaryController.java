package fr.miage.toulouse.ProjetL3;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
    	// Fait appel à setRoot pour mettre à jour la fenêtre avec le .fxml nommé seondary
        App.setRoot("secondary");
    }
}
