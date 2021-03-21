package fr.miage.toulouse.ProjetL3.controleur;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import fr.miage.toulouse.ProjetL3.Main;
import fr.miage.toulouse.ProjetL3.Class.technique.fonction.appFonction;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

/**
 * Contrôleur ChoiCsvController de le <i>vue ChoixCsv</i> <br/>
 * 
 * Ce contrôleur permet de réagir aux événements de la vue et de gèrer le choix
 * du dossier par l'utilisateur
 *
 */
public class ChoiCsvController implements Initializable {

	@FXML
	private Button btn_valider;
	@FXML
	private TextField txtB_chemin;
	@FXML
	private Text infoCSV;
	@FXML
	private Button choixDossier;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		infoCSV.setVisible(true);
		infoCSV.setText("Aucun fichier sélectionné");
		btn_valider.setDisable(true);
	}

	/**
	 * Cette méthode void permet à l'utilisateur de choisir le dossier contenant
	 * l'ensemble des CSV
	 */
	public void dossierChoice() {
		FileChooser fil_chooser = new FileChooser();
		File file = fil_chooser.showOpenDialog(null);

		if (file == null) {
			infoCSV.setVisible(true);
			infoCSV.setText("Aucun fichier sélectionné");
			btn_valider.setDisable(true);
		} else {
			btn_valider.setDisable(false);
			txtB_chemin.setText(file.getParent().toString());
			Main.PATH_DATA = file.getParent().toString();
		}
	}

	/**
	 * Cette méthode permet de passer vers l'interface de connexion
	 */
	public void connexion() {
		appFonction.retour("Connexion");
	}
}
