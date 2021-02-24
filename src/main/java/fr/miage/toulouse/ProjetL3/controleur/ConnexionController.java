package fr.miage.toulouse.ProjetL3.controleur;

import fr.miage.toulouse.ProjetL3.App;
import fr.miage.toulouse.ProjetL3.Class.metier.Connexion;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 */
public class ConnexionController implements Initializable {

	// Différent composant récupérer de notre classe Connexion.fxml
	@FXML
	private ComboBox<String> cmb_droit;
	@FXML
	private Text infoConnexion;
	@FXML
	private TextField txtBUserId, txtBMotDePasse;

	// Observable permettant de compléter notre liste déroulante
	private ObservableList<String> listRole = FXCollections.observableArrayList("Directeur d'étude",
			"Secréteriat pédagogique", "Bureau des examens");

	/**
	 * Permet d'initialiser le contrôleur de la classe
	 * 
	 * @param url
	 * @param rb
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		cmb_droit.setItems(listRole);
	}

	/**
	 * Méthode qui permet de vérifier l'identité de la personne qui ce connecte mais
	 * aussi de vérifier si les champs ont bien été remplis
	 */
	@FXML
	private void verifConnexion() {
		if (txtBUserId.getText().length() > 0 && txtBMotDePasse.getText().length() > 0
				&& cmb_droit.getValue() != null) {
			if (Connexion.verifConnexion(txtBUserId.getText(), txtBMotDePasse.getText())) {
				switchVue(cmb_droit.getValue());
			} else {
				infoConnexion.setVisible(true);
				infoConnexion.setText("Le mot de passe est incorrect");
			}
		} else {
			infoConnexion.setVisible(true);
			infoConnexion.setText("Veuillez renseigner l'ensemble des champs");
		}
	}

	/**
	 * Méthode qui permet de changer de vue en fontion du rôle que la personne aura
	 * choisi
	 * 
	 * @param value
	 */
	private void switchVue(String value) {
		try {
			switch (value) {
			case "Directeur d'étude":
				App.setRoot("ListeEtudiant_DirecteurEtude");
				break;
			case "Secréteriat pédagogique":
				App.setRoot("ListeEtudiant_Secreteriat");
				break;
			case "Bureau des examens":

				App.setRoot("ListeUEBureauExam");
				break;
			default:
				infoConnexion.setVisible(true);
				infoConnexion.setText("Erreur lors du chargement de la vue");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
