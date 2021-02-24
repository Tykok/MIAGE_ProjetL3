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
import fr.miage.toulouse.ProjetL3.Class.technique.chargementCSV;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author IndiraMonnier
 */
public class ListeEtudiantsInscritsController implements Initializable {

	// Différents éléments de la vue FXML
	@FXML
	private TableView<Etudiant> tableView_EtudiantInscrits;
	@FXML
	private TableColumn<Etudiant, String> column_numEtudiant;
	@FXML
	private TableColumn<Etudiant, String> column_nomEtudiant;
	@FXML
	private TableColumn<Etudiant, Integer> column_prenomEtudiant;

	// Observable permettant de remplir notre tableView
	private ObservableList<Etudiant> listeEtudiant = FXCollections.observableArrayList(/*
			new Etudiant("111", "Folvert", "Folvert"), new Etudiant("222", "Mercier", "Aline"),
			new Etudiant("333", "Monnier", "Indira"), new Etudiant("444", "Treport", "Elie")*/);

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
		column_numEtudiant.setCellValueFactory(new PropertyValueFactory<>("num"));
		column_nomEtudiant.setCellValueFactory(new PropertyValueFactory<>("nom"));
		column_prenomEtudiant.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		tableView_EtudiantInscrits.setItems(listeEtudiant); // Ajout des données dans la tableView définit dans notre
		// ObservableF
	}

}
