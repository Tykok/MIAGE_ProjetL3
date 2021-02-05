/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.ProjetL3.controleur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import fr.miage.toulouse.ProjetL3.App;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author IndiraMonnier
 */
public class ListeUEController implements Initializable {

	public void switchToListeEtudiant() throws IOException {
		App.setRoot("ListeEtudiants");
	}

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

}
