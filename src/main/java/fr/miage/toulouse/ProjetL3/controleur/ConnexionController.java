package fr.miage.toulouse.ProjetL3.controleur;

import fr.miage.toulouse.ProjetL3.App;
import fr.miage.toulouse.ProjetL3.Main;
import fr.miage.toulouse.ProjetL3.Class.metier.Connexion;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
		collectionPersonne();
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
				App.setRoot("ListeEtudiants");
				break;
			case "Secréteriat pédagogique":
				App.setRoot("ListeEtudiants");
				break;
			case "Bureau des examens":

				App.setRoot("ListeUEbureauExamen");
				break;
			default:
				infoConnexion.setVisible(true);
				infoConnexion.setText("Erreur lors du chargement de la vue");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Connexion> collectionPersonne() {
		ArrayList<Connexion> returnCol = new ArrayList<Connexion>();
		final Gson gson = new GsonBuilder().create();

		InputStream JSON = App.class.getResourceAsStream(Main.PATH_DATA + "projetl3_table_connexion.json");
		BufferedReader in = new BufferedReader(new InputStreamReader(JSON));
		String thisLine = null;
		try {
			while ((thisLine = in.readLine()) != null) {
				Connexion c = gson.fromJson(thisLine, Connexion.class);
				returnCol.add(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return returnCol;
	}

}
