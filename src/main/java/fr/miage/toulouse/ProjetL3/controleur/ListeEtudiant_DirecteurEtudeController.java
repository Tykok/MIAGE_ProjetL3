package fr.miage.toulouse.ProjetL3.controleur;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

import fr.miage.toulouse.ProjetL3.App;
import fr.miage.toulouse.ProjetL3.Class.metier.Etudiant;
import fr.miage.toulouse.ProjetL3.Class.metier.Mention;
import fr.miage.toulouse.ProjetL3.Class.metier.Parcours;
import fr.miage.toulouse.ProjetL3.Class.technique.affichageEtudiant;
import fr.miage.toulouse.ProjetL3.Class.technique.csv.chargementCSV;
import fr.miage.toulouse.ProjetL3.Class.technique.fonction.appFonction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;

/**
 * Contrôleur ListeEtudiant_DirecteurEtudeController de la <i>vue
 * ListeEtudiant_DirecteurEtude</i>
 *
 */
public class ListeEtudiant_DirecteurEtudeController implements Initializable {

	// Différents objets de l'interface FXML
	@FXML
	private Button btn_deco;
	@FXML
	private Button btn_retour;
	@FXML
	private TableView<affichageEtudiant> tableView_listeEtudiant1;
	@FXML
	private TableColumn<affichageEtudiant, String> column_numEtudiant;
	@FXML
	private TableColumn<affichageEtudiant, String> column_nom;
	@FXML
	private TableColumn<affichageEtudiant, String> column_prenom;
	@FXML
	private TableColumn<affichageEtudiant, String> column_parcours;
	@FXML
	private TableColumn<affichageEtudiant, String> column_mention;

	// Observable contenant la liste des différents étudiants
	private ObservableList<affichageEtudiant> listEtudiant = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// ArrayList qui récupérer grâce à la méthode de chargement du fichier CSV
		ArrayList<Etudiant> etudiantArray = chargementCSV.collectionEtudiant();

		// On ajoute chaque étudiant du fichier CSV à notre Observable
		for (Etudiant e : etudiantArray) {
			listEtudiant.add(new affichageEtudiant(e));
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

		// Ecouteurs permettant de détecter les doubles clics sur la tableView
		tableView_listeEtudiant1.setRowFactory(tv -> {
			TableRow<affichageEtudiant> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {
					Etudiant rowData = row.getItem();

					// Maintenant on l'envoi vers l'interface pour l'ajout des UE
					try {
						// On spécifie sur quelle étudiant on travail
						ListeUEController.etudiantClic = rowData;
						// On passe alors à la vue suivante
						App.setRoot("ListeUE");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			return row;
		});
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
