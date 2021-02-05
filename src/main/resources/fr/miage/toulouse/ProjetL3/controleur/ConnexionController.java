/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.ProjetL3.controleur;

import fr.miage.toulouse.ProjetL3.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
    private PasswordField txtBMotDePasse;
    @FXML
    private TextField txtBIdentifiant;
    @FXML
    private Text infoConnexion;

    private ObservableList<String> dbTypeList = FXCollections.observableArrayList("Directeur d'étude",
            "Secréteriat pédagogique", "Bureau des examens");

    /**
     * Cette méthode réagit lors du clic sur le bouton "Valider" de la page de
     * connexion afin de vérifier si la personne qui ce connecte en as les
     * droits, et quels sont ces droits
     *
     * @throws IOException
     */
    @FXML
    private void verifConnexion() throws IOException {
        System.out.println(txtBMotDePasse.getText().toString());
        if (txtBIdentifiant.getText().equals("Test") && txtBMotDePasse.getText().equals("Test")) {
            App.setRoot("ListeEtudiants");// Fait appel à setRoot pour mettre à jour la fenêtre avec le .fxml donné
        } else {
            infoConnexion.setVisible(true);
            infoConnexion.setText("Le mot de passe est incorrect");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmb_droit.setItems(dbTypeList); // On ajoute les éléments de notre Observable à la comboBox
    }

}
