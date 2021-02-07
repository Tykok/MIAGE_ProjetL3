/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.ProjetL3.controleur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import fr.miage.toulouse.ProjetL3.App;
import fr.miage.toulouse.ProjetL3.Class.metier.Etudiant;
import fr.miage.toulouse.ProjetL3.Class.metier.Mention;
import fr.miage.toulouse.ProjetL3.Class.metier.Parcours;
import fr.miage.toulouse.ProjetL3.Class.technique.listeEtudiant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author IndiraMonnier
 */
public class ListeEtudiantsController implements Initializable {

	@FXML
	private Button btn_retour;
	@FXML
	private ComboBox<String> cmb_trieListeEtudiant;
	@FXML
	private TableView<listeEtudiant> tableView_listeEtudiant;
	@FXML
	private TableColumn<listeEtudiant, String> column_numEtudiant;
	@FXML
	private TableColumn<listeEtudiant, String> column_nom;
	@FXML
	private TableColumn<listeEtudiant, String> column_prenom;
	@FXML
	private TableColumn<listeEtudiant, String> column_parcours;
	@FXML
	private TableColumn<listeEtudiant, String> column_mention;

	// Observable permettant de remplir notre tableView
	private ObservableList<listeEtudiant> listeEtudiant = FXCollections.observableArrayList(
			new listeEtudiant(new Etudiant("111", "Folvert", "Folvert"), new Mention("MIASHS"),
					new Parcours("MIAGE", 5, 5)),
			new listeEtudiant(new Etudiant("222", "Monnier", "Indira"), new Mention("MIASHS"),
					new Parcours("MIAGE", 5, 5)),
			new listeEtudiant(new Etudiant("333", "Mercier", "Aline"), new Mention("MIASHS"),
					new Parcours("MIAGE", 5, 5)),
			new listeEtudiant(new Etudiant("444", "Treport", "Elie"), new Mention("MIASHS"),
					new Parcours("MIAGE", 5, 5)));
	// Observable permettant de remplir notre combobox
	private ObservableList<String> listeTri = FXCollections.observableArrayList("Numéro d'étudiant", "Nom", "Prénom",
			"Mention", "Parcours");

	/**
	 * Cette méthode permet de repartir sur l'écran de connexion
	 * 
	 * @throws IOException
	 */
	public void switchToConnexion() throws IOException {
		App.setRoot("Connexion");
	}

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// Définition des attributs qui seront acceuillis dans les colonnes
		// (correspondant aux attributs de la classe Etudiant)
		column_numEtudiant.setCellValueFactory(new PropertyValueFactory<>("numEtudiant"));
		column_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		column_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		column_parcours.setCellValueFactory(new PropertyValueFactory<>("mention"));
		column_mention.setCellValueFactory(new PropertyValueFactory<>("parcours"));
		tableView_listeEtudiant.setItems(listeEtudiant);
		
		//On ajoute notre Obsrvable à notre comboBox
		cmb_trieListeEtudiant.setItems(listeTri);
	}

}
