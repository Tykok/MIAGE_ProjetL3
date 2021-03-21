package fr.miage.toulouse.ProjetL3.controleur;

import fr.miage.toulouse.ProjetL3.App;
import fr.miage.toulouse.ProjetL3.Class.metier.Connexion;
import fr.miage.toulouse.ProjetL3.Class.technique.csv.chargementCSV;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

/**
 * Contrôleur FXML ConnexionController de la <i>Vue Connexion</i>. <br/>
 * Ce contrôleur permet de vérifier et de contrôler l'accès à l'application
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
			if (verifConnexion(txtBUserId.getText(), txtBMotDePasse.getText(), cmb_droit.getValue())) {
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
	 * Cette méthode permet de vérifier que l'identifiant et le mot de passe fourni
	 * sont bel et bien correcte
	 * 
	 * @param identifiant Identifiant entré par l'utiliser
	 * @param mdp         Mot de passe entré par l'utiliser
	 * @return Une valeur booléenne
	 */
	public static boolean verifConnexion(String identifiant, String mdp, String droit) {
		ArrayList<Connexion> connexionPossible = chargementCSV.collectionConnexion();
		for (Connexion a : connexionPossible) {
			if (identifiant.equals(a.getIdentifiant()) && mdp.equals(a.getMdp()) && droit.equals(a.getDroit())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Méthode qui permet de changer de vue en fontion du rôle que la personne aura
	 * choisi
	 * 
	 * @param value Correspond à la valeur qu'aura choisi l'utilisateur, et donc la
	 *              vue sur laquel il sera redirigé
	 */
	private void switchVue(String value) {
		try {
			switch (value) {
			case "Directeur d'étude":
				App.setRoot("ListeEtudiant_DirecteurEtude");
				break;
			case "Secréteriat pédagogique":
				App.setRoot("ListeEtudiant_Secretariat");
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

}
