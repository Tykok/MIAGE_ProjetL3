package fr.miage.toulouse.ProjetL3.controleur;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

import fr.miage.toulouse.ProjetL3.Class.metier.Etudiant;
import fr.miage.toulouse.ProjetL3.Class.metier.Mention;
import fr.miage.toulouse.ProjetL3.Class.metier.Parcours;
import fr.miage.toulouse.ProjetL3.Class.technique.appFonction;
import fr.miage.toulouse.ProjetL3.Class.technique.chargementCSV;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;

public class ListeEtudiant_DirecteurEtudeController implements Initializable {

	// Différents objets de l'interface FXML
	@FXML
	private Button btn_deco;
	@FXML
	private Button btn_retour;
	@FXML
	private TableView<Etudiant> tableView_listeEtudiant1;
	@FXML
	private TableColumn<Etudiant, String> column_numEtudiant;
	@FXML
	private TableColumn<Etudiant, String> column_nom;
	@FXML
	private TableColumn<Etudiant, String> column_prenom;
	@FXML
	private TableColumn<Parcours, String> column_parcours;
	@FXML
	private TableColumn<Mention, String> column_mention;


	// Observable contenant la liste des différents étudiants
	private ObservableList<Etudiant> listEtudiant = FXCollections.observableArrayList();


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// ArrayList qui récupérer grâce à la méthode de chargement du fichier CSV
		ArrayList<Etudiant> etudiantArray = chargementCSV.collectionEtudiant();

		// On ajoute chaque étudiant du fichier CSV à notre Observable
		for (Etudiant e : etudiantArray) {
			listEtudiant.add(e);
		}

		// Définition des attributs qui seront acceuillis dans les colonnes
		// (correspondant aux attributs de la classe Etudiant)
		column_numEtudiant.setCellValueFactory(new PropertyValueFactory<>("num"));
		column_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		column_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		column_parcours.setCellValueFactory(new PropertyValueFactory<>("nomParcours"));
		column_mention.setCellValueFactory(new PropertyValueFactory<>("nomMention"));
		tableView_listeEtudiant1.setItems(listEtudiant); // Ajout des données dans la tableView définit dans notre
		// ObservableF
	}

	/**
	 * Appel de la méthode permettant d'effectuer la déconnexion
	 * 
	 * @see appFonction
	 */
	public void deco() {
		appFonction.deco();
	}

	/**
	 * Méthode permettant de faire appel à la fonction Retour de la classe
	 * appFonction
	 * 
	 * @see appFonction
	 */
	public void retour() {
		appFonction.retour("Connexion");
	}

}
