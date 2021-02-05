package fr.miage.toulouse.ProjetL3.controleur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import fr.miage.toulouse.ProjetL3.*;

public class ConnexionController implements Initializable {

	// Ici l'ensemble l'ensemble des éléments présents sur notre vue Connexion
	@FXML
	private ComboBox<String> cmb_droit;

	private ObservableList<String> dbTypeList = FXCollections.observableArrayList("Directeur d'étude",
			"Secréteriat pédagogique", "Bureau des examens");

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
		cmb_droit.setItems(dbTypeList); // On ajoute les éléments de notre Observable à la comboBox
	}

}
