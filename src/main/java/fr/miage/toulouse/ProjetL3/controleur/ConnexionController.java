package fr.miage.toulouse.ProjetL3.controleur;

import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import fr.miage.toulouse.ProjetL3.App;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

public class ConnexionController implements Initializable {

	private TextField txtBMotDePasse;
	private Text infoConnexion;
	private ComboBox<String> cmb_droit;
	private TextField txtBIdentifiant;

	public void verifConnexion() {
		if (txtBIdentifiant.getText() == null && txtBMotDePasse.getText() == null) {
			if (txtBIdentifiant.getText().equals("Test") && txtBMotDePasse.getText().equals("Test")) {
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

	/**
	 * Initialise le contrôleur de la classe.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

	public TextField getTxtBIdentifiant() {
		return txtBIdentifiant;
	}

	public void setTxtBIdentifiant(TextField txtBIdentifiant) {
		this.txtBIdentifiant = txtBIdentifiant;
	}

	public ComboBox<String> getCmb_droit() {
		return cmb_droit;
	}

	public void setCmb_droit(ComboBox<String> cmb_droit) {
		this.cmb_droit = cmb_droit;
	}

}
