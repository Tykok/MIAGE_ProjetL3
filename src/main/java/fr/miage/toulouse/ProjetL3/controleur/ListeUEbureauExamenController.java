package fr.miage.toulouse.ProjetL3.controleur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import fr.miage.toulouse.ProjetL3.App;
import fr.miage.toulouse.ProjetL3.Class.metier.UE;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;

public class ListeUEbureauExamenController implements Initializable {
	@FXML
	private ComboBox<String> cmb_trierPar;
	@FXML
	private TableView<UE> tableView_listeUE;
	@FXML
	private TableColumn<UE, String> tableColumn_codeUE;
	@FXML
	private TableColumn<UE, String> tableColumn_nomUE;
	@FXML
	private TableColumn<UE, Integer> tableColumn_creditUE;

	// Observable permettant de compléter notre liste déroulante
	private ObservableList<String> listTri = FXCollections.observableArrayList("Code", "Nom", "Credit");

	// Observable permettant de remplir notre tableView
	private ObservableList<UE> listeUE = FXCollections.observableArrayList(new UE("234", "Amos", 5),
			new UE("456", "Keep", 5));

	// Event Listener on TableView[#tableView_listeUE].onSort
	@FXML
	public void tableView_listeUE() {

	}

	/**
	 * Cette méthode permet de repartir sur l'écran de connexion
	 * 
	 * @throws IOException
	 */
	public void switchToConnexion() throws IOException {
		App.setRoot("Connexion");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tableView_listeUE.setEditable(true);
		cmb_trierPar.setItems(listTri); // Ajout des données dans la comboBox

		// Définition des attributs qui seront acceuillis dans les colonnes
		// (correspondant aux attributs de la classe UE)
		tableColumn_codeUE.setCellValueFactory(new PropertyValueFactory<>("codeIdentification"));
		tableColumn_nomUE.setCellValueFactory(new PropertyValueFactory<>("nomUE"));
		tableColumn_creditUE.setCellValueFactory(new PropertyValueFactory<>("creditECT"));
		tableView_listeUE.setItems(listeUE); // Ajout des données dans la tableView définit dans notre ObservableF

	}

}
