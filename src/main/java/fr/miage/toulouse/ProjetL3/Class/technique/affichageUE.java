package fr.miage.toulouse.ProjetL3.Class.technique;

import java.util.ArrayList;

import fr.miage.toulouse.ProjetL3.Class.metier.UE;
import fr.miage.toulouse.ProjetL3.Class.technique.csv.chargementCSV;
import fr.miage.toulouse.ProjetL3.Class.technique.fonction.utilsFunction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

public class affichageUE extends UE {

	// Attribut nécessaire à JavaFX
	private ArrayList<UE> list_prerequis;
	private CheckBox checkValide;

	public affichageUE(UE a) {
		super(a.getCodeIdentification(), a.getNomUE(), a.getCreditECT());
		this.list_prerequis = utilsFunction.getPrerequisForThisUe(a);
		this.checkValide = new CheckBox();
	}

	public ArrayList<UE> getList_prerequis() {
		return this.list_prerequis;
	}

	public CheckBox getCheckValide() {
		return checkValide;
	}

}
