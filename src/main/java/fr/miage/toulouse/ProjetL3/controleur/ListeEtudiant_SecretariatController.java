package fr.miage.toulouse.ProjetL3.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import fr.miage.toulouse.ProjetL3.Class.technique.appFonction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

public class ListeEtudiant_SecretariatController implements Initializable {
	@FXML
	private Button btn_deco;
	@FXML
	private Button btn_retour;
	@FXML
	private TableView tableView_listeEtudiant;
	@FXML
	private TableColumn column_numEtudiant;
	@FXML
	private TableColumn column_nom;
	@FXML
	private TableColumn column_prenom;
	@FXML
	private TableColumn column_parcours;
	@FXML
	private TableColumn column_mention;
	@FXML
	private ComboBox<String> cmb_parcours;
	@FXML
	private Button btn_ajouter;
	@FXML
	private TextField txtb_NumEtudiant;
	@FXML
	private TextField txtb_NomEtudiant;
	@FXML
	private TextField txtb_PrenomEtudiant;
	@FXML
	private TextField txtb_ParcoursEtudiant;
	@FXML
	private TextField txtb_MentionEtudiant;

	// Observable de la combobox permettant d'effectuer le choix
	private ObservableList<String> listEtudiant = FXCollections.observableArrayList("Test", "Blabla");
	// Permet l'auto-complétion de la zone de texte
	private AutoCompletionBinding<String> autoComplete;

	/*
	 * Cette méthode permet tout simplement de vérifier que l'ensemble des valeurs
	 * ont bien été donné
	 */
	public void verifValide() {
		if (txtb_NumEtudiant.getText().length() > 0 && txtb_NomEtudiant.getText().length() > 0
				&& txtb_PrenomEtudiant.getText().length() > 0 && txtb_ParcoursEtudiant.getText().length() > 0
				&& txtb_MentionEtudiant.getText().length() > 0) {
			btn_ajouter.setDisable(false);
		}

	}

	// Méthode appeler lors du clic sur le bouton de déconnexion
	@FXML
	public void deco(MouseEvent event) {
		appFonction.deco();
	}

	// Méthode appeler lors du clic sur le bouton permettant de faire un retour
	@FXML
	public void retour(MouseEvent event) {
		appFonction.retour("Connexion");
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {

		/*
		 * écouteurs permettant de faire un appel à chaque modification des différentes
		 * textBox pour en vérifier la validité
		 */
		txtb_PrenomEtudiant.textProperty().addListener((observable, oldValue, newValue) -> {
			verifValide();
		});
		txtb_NumEtudiant.textProperty().addListener((observable, oldValue, newValue) -> {
			verifValide();
		});
		txtb_NomEtudiant.textProperty().addListener((observable, oldValue, newValue) -> {
			verifValide();
		});
		txtb_ParcoursEtudiant.textProperty().addListener((observable, oldValue, newValue) -> {
			verifValide();
		});
		txtb_MentionEtudiant.textProperty().addListener((observable, oldValue, newValue) -> {
			verifValide();
		});
		
		TextFields.bindAutoCompletion(txtb_PrenomEtudiant, "Test");
	}
}
