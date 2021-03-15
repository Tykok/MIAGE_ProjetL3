package fr.miage.toulouse.ProjetL3.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import fr.miage.toulouse.ProjetL3.Class.metier.Etudiant;
import fr.miage.toulouse.ProjetL3.Class.technique.fonction.appFonction;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TabPane;

import javafx.scene.control.Tab;

import javafx.scene.input.MouseEvent;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class ListeUEController implements Initializable {
	@FXML
	private Button btn_deco;
	@FXML
	private Button btn_retour;
	@FXML
	private TabPane tabOnglet;
	@FXML
	private Tab ongletUEValide;
	@FXML
	private TableView tableView_listeUEValide;
	@FXML
	private TableColumn tableColumn_codeUEValide;
	@FXML
	private TableColumn tableColumn_nomUEValide;
	@FXML
	private TableColumn tableColumn_creditUEValide;
	@FXML
	private Tab ongletUECours;
	@FXML
	private TableView tableView_listeUECours;
	@FXML
	private TableColumn tableColumn_codeUECours;
	@FXML
	private TableColumn tableColumn_nomUECours;
	@FXML
	private TableColumn tableColumn_creditUECours;
	@FXML
	private Tab ongletUEPrerequis;
	@FXML
	private TableView tableView_listeUEPrerequis;
	@FXML
	private TableColumn tableColumn_codeUEPrerequis;
	@FXML
	private TableColumn tableColumn_nomUEPrerequis;
	@FXML
	private TableColumn tableColumn_creditUEPrerequis;

	// Etudiant sur lequel on va travailler
	public static Etudiant etudiantClic;

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
		appFonction.retour("ListeEtudiant_DirecteurEtude");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
