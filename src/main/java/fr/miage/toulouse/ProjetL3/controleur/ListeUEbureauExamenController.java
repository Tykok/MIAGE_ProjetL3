package fr.miage.toulouse.ProjetL3.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class ListeUEbureauExamenController implements Initializable {
	@FXML
	private TableView tableView_listeUE;
	@FXML
	private TableColumn tableColumn_codeUE;
	@FXML
	private TableColumn tableColumn_nomUE;
	@FXML
	private TableColumn tableColumn_creditUE;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
