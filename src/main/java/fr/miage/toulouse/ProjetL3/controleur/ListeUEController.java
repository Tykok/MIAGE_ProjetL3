package fr.miage.toulouse.ProjetL3.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import fr.miage.toulouse.ProjetL3.Class.metier.Etudiant;
import fr.miage.toulouse.ProjetL3.Class.metier.UE;
import fr.miage.toulouse.ProjetL3.Class.technique.affichageUE;
import fr.miage.toulouse.ProjetL3.Class.technique.fonction.appFonction;
import fr.miage.toulouse.ProjetL3.Class.technique.fonction.utilsFunctionUe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;

import javafx.scene.control.Tab;

import javafx.scene.input.MouseEvent;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
	private TableView<UE> tableView_listeUEValide;
	@FXML
	private TableColumn<UE, String> tableColumn_codeUEValide;
	@FXML
	private TableColumn<UE, String> tableColumn_nomUEValide;
	@FXML
	private TableColumn<UE, String> tableColumn_creditUEValide;
	@FXML
	private Tab ongletUECours;
	@FXML
	private TableView<UE> tableView_listeUECours;
	@FXML
	private TableColumn<UE, String> tableColumn_codeUECours;
	@FXML
	private TableColumn<UE, String> tableColumn_nomUECours;
	@FXML
	private TableColumn<UE, String> tableColumn_creditUECours;
	@FXML
	private Tab ongletUEPrerequis;
	@FXML
	private TableView<UE> tableView_listeUEPrerequis;
	@FXML
	private TableColumn<UE, String> tableColumn_codeUEPrerequis;
	@FXML
	private TableColumn<UE, String> tableColumn_nomUEPrerequis;
	@FXML
	private TableColumn<UE, String> tableColumn_creditUEPrerequis;
	@FXML
	private ContextMenu contextMenu_uePrerequis;
	@FXML
	private ContextMenu contextMenu_ueValide;
	@FXML
	private ContextMenu contextMenu_ueEnCours;
	@FXML
	private MenuItem menuItem_uePrerequis;
	@FXML
	private MenuItem menuItem_ueValide;
	@FXML
	private MenuItem menuItem_ueEnCours;

	/**
	 * Attribut privé nécessaire pour le controleur
	 */

	// Etudiant sur lequel on va travailler
	public static Etudiant etudiantClic;

	// Observable contenant la liste des UE validés
	private ObservableList<UE> listUEValide = FXCollections.observableArrayList();
	// Observable contenant la liste des UE en cours
	private ObservableList<UE> listUEEnCours = FXCollections.observableArrayList();
	// Observable contenant la liste des UE avec possibilité d'inscription
	private ObservableList<UE> listUeInscription = FXCollections.observableArrayList();

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

// On remplit l'observable des UE validé par l'étudiant
		for (UE a : utilsFunctionUe.ueEtudiant(etudiantClic)) {
			listUEValide.add(a);
		}

		// On remplit l'observable des UE en cours de l'étudiant
		for (UE a : utilsFunctionUe.ueEtudiantEnCours(etudiantClic)) {
			listUEEnCours.add(a);
		}

		// On remplit l'observable des UE avec possibilité d'inscription
		for (UE a : utilsFunctionUe.getAllInscriptionPossible(etudiantClic)) {
			listUeInscription.add(a);
		}

		// On définit les valeurs des colonnes des UE validés
		tableColumn_codeUEValide.setCellValueFactory(new PropertyValueFactory<>("codeIdentification"));
		tableColumn_nomUEValide.setCellValueFactory(new PropertyValueFactory<>("nomUE"));
		tableColumn_creditUEValide.setCellValueFactory(new PropertyValueFactory<>("creditECT"));
		tableView_listeUEValide.setItems(listUEValide);

		// On définit les valeurs des colonnes des UE en cours
		tableColumn_codeUECours.setCellValueFactory(new PropertyValueFactory<>("codeIdentification"));
		tableColumn_nomUECours.setCellValueFactory(new PropertyValueFactory<>("nomUE"));
		tableColumn_creditUECours.setCellValueFactory(new PropertyValueFactory<>("creditECT"));
		tableView_listeUECours.setItems(listUEEnCours);

		// On définit les valeurs des colonnes des UE avec possibilité d'inscription
		tableColumn_codeUEPrerequis.setCellValueFactory(new PropertyValueFactory<>("codeIdentification"));
		tableColumn_nomUEPrerequis.setCellValueFactory(new PropertyValueFactory<>("nomUE"));
		tableColumn_creditUEPrerequis.setCellValueFactory(new PropertyValueFactory<>("creditECT"));
		tableView_listeUEPrerequis.setItems(listUeInscription);

		// On initialise les listeners des contextMenu
		listenerContextMenu();

	}

	private void listenerContextMenu() {

		/*
		 * Listeners permettant de récupérer la ligne sur laquelle le clic droit à été
		 * effectuer et ensuite de pouvoir afficher l'ensemble des UE prérequis pour
		 * l'UE qu'il aura sélectionné
		 */

		// listener pour les UE en cours
		contextMenu_ueEnCours.setOnShowing(e -> {
			// On récupère la ligne sélectioné
			UE ueSelected = tableView_listeUECours.getSelectionModel().getSelectedItem();
			menuItem_ueEnCours.setText("Prérequis de l'UE " + ueSelected.getCodeIdentification());
			menuItem_ueEnCours.setStyle("-fx-font-weight: bold");
			contextMenu_ueEnCours.getItems().remove(2, contextMenu_ueEnCours.getItems().size());

			// On ajoute ensuite les prérequis
			MenuItem a;
			if (ueSelected.getCollectionUE_Prerequis().size() > 0) {
				for (UE b : ueSelected.getCollectionUE_Prerequis()) {
					a = new MenuItem();
					a.setText(b.getCodeIdentification() + " - " + b.getNomUE());
					contextMenu_ueEnCours.getItems().add(a);
				}
			} else {
				a = new MenuItem();
				a.setText("Aucun prérequis nécessaire");
				contextMenu_ueEnCours.getItems().add(a);
			}
		});

		// Listener pour les UE possible
		contextMenu_uePrerequis.setOnShowing(e -> {
			// On récupère la ligne sélectioné
			UE ueSelected = tableView_listeUEPrerequis.getSelectionModel().getSelectedItem();
			menuItem_uePrerequis.setText("Prérequis de l'UE " + ueSelected.getCodeIdentification());
			menuItem_uePrerequis.setStyle("-fx-font-weight: bold");
			contextMenu_uePrerequis.getItems().remove(2, contextMenu_uePrerequis.getItems().size());

			// On ajoute ensuite les prérequis
			MenuItem a;
			if (ueSelected.getCollectionUE_Prerequis().size() > 0) {
				for (UE b : ueSelected.getCollectionUE_Prerequis()) {
					a = new MenuItem();
					a.setText(b.getCodeIdentification() + " - " + b.getNomUE());
					contextMenu_uePrerequis.getItems().add(a);
				}
			} else {
				a = new MenuItem();
				a.setText("Aucun prérequis nécessaire");
				contextMenu_uePrerequis.getItems().add(a);
			}
		});

		// listener pour les ue validé
		contextMenu_ueValide.setOnShowing(e -> {
			// On récupère la ligne sélectioné
			UE ueSelected = tableView_listeUEValide.getSelectionModel().getSelectedItem();
			menuItem_ueValide.setText("Prérequis de l'UE " + ueSelected.getCodeIdentification());
			menuItem_ueValide.setStyle("-fx-font-weight: bold");
			contextMenu_ueValide.getItems().remove(2, contextMenu_ueValide.getItems().size());

			// On ajoute ensuite les prérequis
			MenuItem a;
			if (ueSelected.getCollectionUE_Prerequis().size() > 0) {
				for (UE b : ueSelected.getCollectionUE_Prerequis()) {
					a = new MenuItem();
					a.setText(b.getCodeIdentification() + " - " + b.getNomUE());
					contextMenu_ueValide.getItems().add(a);
				}
			} else {
				a = new MenuItem();
				a.setText("Aucun prérequis nécessaire");
				contextMenu_ueValide.getItems().add(a);
			}
		});

	}

}
