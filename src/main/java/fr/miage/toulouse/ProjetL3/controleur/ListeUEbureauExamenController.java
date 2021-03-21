package fr.miage.toulouse.ProjetL3.controleur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import fr.miage.toulouse.ProjetL3.App;
import fr.miage.toulouse.ProjetL3.Class.metier.Etudiant;
import fr.miage.toulouse.ProjetL3.Class.metier.UE;
import fr.miage.toulouse.ProjetL3.Class.technique.csv.chargementCSV;
import fr.miage.toulouse.ProjetL3.Class.technique.fonction.appFonction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;

/**
 * Contrôleur ListeUEbureauExamenController de la <i>vue ListeUEbureauExamen</i>
 *
 */
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

		initializeForTableView();
	}

	private void initializeForTableView() {
		// Ecouteurs permettant de détecter les doubles clics sur la tableView
		tableView_listeUE.setRowFactory(tv -> {
			TableRow<UE> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {
					UE rowData = row.getItem();

					// Maintenant on l'envoi vers l'interface en question
					try {
						// On spécifie sur quelle UE on travail
						ListeEtudiant_BureauExamController.ueClic = rowData;
						// On passe alors à la vue suivante
						App.setRoot("ListeEtudiant_BureauExam");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			return row;
		});
	}

}
