package fr.miage.toulouse.ProjetL3.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import fr.miage.toulouse.ProjetL3.Class.metier.UE;
import fr.miage.toulouse.ProjetL3.Class.technique.affichageEtudiant;
import fr.miage.toulouse.ProjetL3.Class.technique.csv.ajoutCSV;
import fr.miage.toulouse.ProjetL3.Class.technique.fonction.appFonction;
import fr.miage.toulouse.ProjetL3.Class.technique.fonction.utilsFunctionEtudiant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;

/**
 * 
 * Contrôleur ListeEtudiant_BureauExamController de la <i> vue
 * ListeEtudiant_BureauExam</i>
 *
 */
public class ListeEtudiant_BureauExamController implements Initializable {
	@FXML
	private TableView<affichageEtudiant> tableView_EtudiantInscrits;
	@FXML
	private TableColumn<affichageEtudiant, String> column_numEtudiantInscrits;
	@FXML
	private TableColumn<affichageEtudiant, String> column_nomEtudiantInscrits;
	@FXML
	private TableColumn<affichageEtudiant, String> column_prenomEtudiantInscrits;
	@FXML
	private TableColumn<affichageEtudiant, String> column_parcoursEtudiantInscrits;
	@FXML
	private TableView<affichageEtudiant> tableView_EtudiantInscritsSelection;
	@FXML
	private TableColumn<affichageEtudiant, String> column_numEtudiantSelection;
	@FXML
	private TableColumn<affichageEtudiant, String> column_nomEtudiantSelection;
	@FXML
	private TableColumn<affichageEtudiant, String> column_prenomEtudiantSelection;
	@FXML
	private TableColumn<affichageEtudiant, String> column_parcoursEtudiantSelection;
	@FXML
	private Button btn_annuler;
	@FXML
	private Label label_UE;

	// Observable contenant la liste des différents étudiants inscrits aux UE
	private ObservableList<affichageEtudiant> listEtudiantInscrit = FXCollections.observableArrayList();
	// Observable contenant la liste des différents étudiants qui auront l'UE
	private ObservableList<affichageEtudiant> listEtudiantSelection = FXCollections.observableArrayList();

	// On récupère ici l'ue sélectionné précédemment
	public static UE ueClic;

	/**
	 * Cette méthode permet de remettre à l'origine la vue tel qu'on l'avait à son
	 * chargement
	 * 
	 * @param event
	 */
	@FXML
	public void clear(MouseEvent event) {
		initializeTableViewWithoutUpdate();
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
		appFonction.retour("ListeUEbureauExamen");
	}

	/**
	 * Cette méthode permet de sauvegarder l'ensemble des modifications qui ont été
	 * effectués
	 * 
	 * @param event
	 */
	@FXML
	public void save(MouseEvent event) {
		// ensuite on fait appel à une méthode qui tout réécrire
		utilsFunctionEtudiant.validationUeEtudiant(listEtudiantSelection, ueClic);

		retour();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		label_UE.setText(label_UE.getText() + " " + ueClic.getCodeIdentification());

		// On rempli nos Observable
		initializeTableViewWithoutUpdate();
		// On ajoute des listeners
		initializeListenerForTableView();
	}

	/**
	 * Cette méthode void permet d'initialiser nos listeners sur les tableView
	 */
	private void initializeListenerForTableView() {
		tableView_EtudiantInscrits.setRowFactory(tv -> {
			TableRow<affichageEtudiant> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {
					affichageEtudiant rowData = row.getItem();
					listEtudiantInscrit.remove(rowData);
					listEtudiantSelection.add(rowData);
					tableView_EtudiantInscrits.setItems(listEtudiantInscrit);
					tableView_EtudiantInscritsSelection.setItems(listEtudiantSelection);
				}
			});
			return row;
		});

		tableView_EtudiantInscritsSelection.setRowFactory(tv -> {
			TableRow<affichageEtudiant> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {
					affichageEtudiant rowData = row.getItem();
					listEtudiantSelection.remove(rowData);
					listEtudiantInscrit.add(rowData);
					tableView_EtudiantInscrits.setItems(listEtudiantInscrit);
					tableView_EtudiantInscritsSelection.setItems(listEtudiantSelection);
				}
			});
			return row;
		});

	}

	/**
	 * Cette méthode void permet à notre tableView d'être rempli au chargement, elle
	 * est par ailleurs aussi appeler lors du clic sur Annuler afin de revenir à un
	 * état de base
	 */
	private void initializeTableViewWithoutUpdate() {
		// Pour commencer on clear notre liste d'étudiants sélectionné
		listEtudiantSelection.clear();
		// Ainsi que notre liste d'étudiants avec l'UE en cours
		listEtudiantInscrit.clear();
		// On ajoute chaque étudiant du fichier CSV à notre Observable
		for (affichageEtudiant e : utilsFunctionEtudiant.etudiantInscrit(ueClic)) {
			listEtudiantInscrit.add(e);
		}

		column_numEtudiantInscrits.setCellValueFactory(new PropertyValueFactory<>("num"));
		column_nomEtudiantInscrits.setCellValueFactory(new PropertyValueFactory<>("nom"));
		column_prenomEtudiantInscrits.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		column_parcoursEtudiantInscrits.setCellValueFactory(new PropertyValueFactory<>("nomParcours"));
		tableView_EtudiantInscrits.setItems(listEtudiantInscrit);

		column_numEtudiantSelection.setCellValueFactory(new PropertyValueFactory<>("num"));
		column_nomEtudiantSelection.setCellValueFactory(new PropertyValueFactory<>("nom"));
		column_prenomEtudiantSelection.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		column_parcoursEtudiantSelection.setCellValueFactory(new PropertyValueFactory<>("nomParcours"));
		tableView_EtudiantInscritsSelection.setItems(listEtudiantSelection);
	}
}
