package fr.miage.toulouse.ProjetL3.controleur;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fr.miage.toulouse.ProjetL3.Class.metier.Etudiant;
import fr.miage.toulouse.ProjetL3.Class.metier.Mention;
import fr.miage.toulouse.ProjetL3.Class.metier.Parcours;
import fr.miage.toulouse.ProjetL3.Class.technique.ajoutCSV;
import fr.miage.toulouse.ProjetL3.Class.technique.appFonction;
import fr.miage.toulouse.ProjetL3.Class.technique.chargementCSV;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class ListeEtudiant_SecretariatController implements Initializable {
	@FXML
	private Button btn_deco;
	@FXML
	private Button btn_retour;
	@FXML
	private TableView<Etudiant> tableView_listeEtudiant;
	@FXML
	private TableColumn<Etudiant, String> column_numEtudiant;
	@FXML
	private TableColumn<Etudiant, String> column_nom;
	@FXML
	private TableColumn<Etudiant, String> column_prenom;
	@FXML
	private TableColumn<Etudiant, String> column_parcours;
	@FXML
	private TableColumn<Etudiant, String> column_mention;
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

	// TODO Permet l'auto-complétion de la zone de texte
	// private AutoCompletionBinding<String> autoComplete;

	// Observable contenant la liste des différents étudiants
	private ObservableList<Etudiant> listEtudiant = FXCollections.observableArrayList();

	// ArrayList des différents Parcours, elle est nécessaire aux fonctionnement de
	// certaines méthodes
	private ArrayList<Parcours> parcoursArray = chargementCSV.collectionParcours();

	// Notre objet Parcours qui sera renseigné lors de l'insertion
	private Parcours parcoursInsert;

	// Mention qui sera insérer
	private Mention mentionInsert;

	/*
	 * Cette méthode permet tout simplement de vérifier que l'ensemble des valeurs
	 * ont bien été donné
	 */
	private void verifValide() {
		if (txtb_NumEtudiant.getText() != null && txtb_NomEtudiant.getText() != null
				&& txtb_PrenomEtudiant.getText() != null && txtb_ParcoursEtudiant.getText() != null
				&& txtb_MentionEtudiant.getText() != null) {
			if (txtb_NumEtudiant.getText().length() > 0 && txtb_NomEtudiant.getText().length() > 0
					&& txtb_PrenomEtudiant.getText().length() > 0 && txtb_ParcoursEtudiant.getText().length() > 0
					&& txtb_MentionEtudiant.getText().length() > 0) {
				btn_ajouter.setDisable(false);
			}
		}
	}

	/**
	 * Fonction permettant de renvoyer un booléen, afin de savoir si oui ou non le
	 * parcours est bel et bien existant
	 * 
	 * @param nomParcours
	 * @return
	 */
	private boolean validiteParcours(String nomParcours) {
		for (Parcours p : parcoursArray) {
			if (p.getNomParcours().equals(nomParcours)) {
				parcoursInsert = p;
				return true;
			}
		}
		return false;
	}

	/**
	 * Fonction permettant de renvoyer VRAI ou FAUX en fonction de l'existence ou
	 * non de la mention dans le parcours qui aura été préalablement choisi
	 * 
	 * @param nomMention
	 * @return
	 */
	private boolean validiteMention(String nomMention) {
		for (Mention m : parcoursInsert.getCollectionMention()) {
			if (m.getNomMention().equals(nomMention)) {
				mentionInsert = m;
				return true;
			}
		}
		return false;
	}

	/**
	 * Méthode permettant d'ajouter un étudiant
	 */
	public void ajoutEtudiant() {
		Etudiant e = new Etudiant(txtb_NumEtudiant.getText(), txtb_NomEtudiant.getText(),
				txtb_PrenomEtudiant.getText(), mentionInsert);
		// On ajoute l'étudiant à notre observable
		listEtudiant.add(e);
		
		// On ajoute note étudiant au fichier CSV
		ajoutCSV.ajoutEtudiant(e);
		
		// On clear nos champds d'insertion
		txtb_MentionEtudiant.setText(null);
		txtb_NomEtudiant.setText(null);
		txtb_NumEtudiant.setText(null);
		txtb_ParcoursEtudiant.setText(null);
		txtb_PrenomEtudiant.setText(null);
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
		tableView_listeEtudiant.setItems(listEtudiant); // Ajout des données dans la tableView définit dans notre
		// ObservableF

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
			// On vérifie tout d'abord si le parcours entré est correcte
			if (validiteParcours(newValue)) {
				txtb_MentionEtudiant.setDisable(false);
				verifValide();
			} else {
				txtb_MentionEtudiant.setDisable(true);
			}
		});
		txtb_MentionEtudiant.textProperty().addListener((observable, oldValue, newValue) -> {
			// On vérifie tout d'abord que la mention existe
			if (validiteMention(newValue)) {
				verifValide();
			} else {
				// Si la valeur est modifier on repasse le bouton à false
				btn_ajouter.setDisable(true);
			}
		});

		// TODO TextFields.bindAutoCompletion(txtb_PrenomEtudiant, "Test");
	}
}
