package fr.miage.toulouse.ProjetL3.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import fr.miage.toulouse.ProjetL3.Class.metier.UE;
import fr.miage.toulouse.ProjetL3.Class.technique.appFonction;
import fr.miage.toulouse.ProjetL3.Class.technique.chargementCSV;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableColumn;

public class ListeUEbureauExamenController implements Initializable {
	@FXML
	private TableView<UE> tableView_listeUE;
	@FXML
	private TableColumn<UE, String> tableColumn_codeUE;
	@FXML
	private TableColumn<UE, String> tableColumn_nomUE;
	@FXML
	private TableColumn<UE, Integer> tableColumn_creditUE;

	// Liste des UE
	private ObservableList<UE> listUE = FXCollections.observableArrayList();

	/**
	 * 
	 * Evenement lors de la déconnexion
	 * 
	 * @param event
	 */
	@FXML
	public void deco(MouseEvent event) {
		appFonction.deco();
	}

	/**
	 * Evenement lors du clic sur le bouton retour
	 * 
	 * @param event
	 */
	@FXML
	public void retour(MouseEvent event) {
		appFonction.retour("Connexion");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		for (UE ue : chargementCSV.collectionUE()) {
			listUE.add(ue);
		}

		tableColumn_codeUE.setCellValueFactory(new PropertyValueFactory<>("codeIdentification"));
		tableColumn_nomUE.setCellValueFactory(new PropertyValueFactory<>("nomUE"));
		tableColumn_creditUE.setCellValueFactory(new PropertyValueFactory<>("creditECT"));

		tableView_listeUE.setItems(listUE);

	}

}
