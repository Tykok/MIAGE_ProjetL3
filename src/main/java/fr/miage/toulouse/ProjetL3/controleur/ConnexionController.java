package fr.miage.toulouse.ProjetL3.controleur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import fr.miage.toulouse.ProjetL3.*;

public class ConnexionController implements Initializable {

	/**
	 * Cette méthode réagit lors du clic sur le bouton "Valider" de la page de
	 * connexion afin de vérifier si la personne qui ce connecte en as les droits,
	 * et quels sont ces droits
	 * 
	 * @throws IOException
	 */
	@FXML
	private void verifConnexion() throws IOException {
		App.setRoot("ListeEtudants");// Fait appel à setRoot pour mettre à jour la fenêtre avec le .fxml donné
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
