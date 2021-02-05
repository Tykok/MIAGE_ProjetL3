package fr.miage.toulouse.ProjetL3.controleur;

import fr.miage.toulouse.ProjetL3.App;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author ElieTreport
 */
public class ConnexionController implements Initializable {

	@FXML
	private ComboBox<String> cmb_droit;
	@FXML
	private Text infoConnexion;
	@FXML
	private TextField txtBMotDePasse;
	@FXML
	private TextField txtBUserId;

	/**
	 * Initializes the controller class.
	 * 
	 * @param url
	 * @param rb
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

	@FXML
	private void verifConnexion() {
		if (txtBUserId.getText() == null && txtBMotDePasse.getText() == null) {
			if (txtBUserId.getText().equals("Test") && txtBMotDePasse.getText().equals("Test")) {
				try {
					App.setRoot("ListeEtudiants");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				infoConnexion.setVisible(true);
				infoConnexion.setText("Le mot de passe est incorrect");
			}
		} else {
			infoConnexion.setVisible(true);
			infoConnexion.setText("Veuillez renseigner l'ensemble des champs");
		}
	}

}
