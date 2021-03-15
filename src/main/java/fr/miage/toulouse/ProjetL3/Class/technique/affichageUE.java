package fr.miage.toulouse.ProjetL3.Class.technique;

import java.util.ArrayList;

import fr.miage.toulouse.ProjetL3.Class.metier.UE;
import fr.miage.toulouse.ProjetL3.Class.technique.csv.chargementCSV;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

public class affichageUE extends UE {

	// Attribut nécessaire à JavaFX
	private ComboBox<String> cmb_prerequis;
	private CheckBox checkValide;

	public affichageUE(String codeId, String nomUE, int credit) {
		super(codeId, nomUE, credit);
		this.cmb_prerequis = new ComboBox<String>();
		this.checkValide = new CheckBox();
	}

	public affichageUE(UE a) {
		super(a.getCodeIdentification(), a.getNomUE(), a.getCreditECT());
		this.cmb_prerequis = new ComboBox<String>();
		this.checkValide = new CheckBox();
	}

	/**
	 * @return the cmb_prerequis
	 */
	public ComboBox<String> getCmb_prerequis() {
		ObservableList<String> listUEPrerequis = FXCollections.observableArrayList();
		ArrayList<UE> listUE = chargementCSV.getAllUEPrerequis(this);

		if (listUE.size() > 0) {
			for (UE u : listUE) {
				if (u != null) {
					listUEPrerequis.add(u.getCodeIdentification() + " - " + u.getNomUE());
				}
			}
			cmb_prerequis.setItems(listUEPrerequis);
			return cmb_prerequis;
		} else {
			return null;
		}
	}

	/**
	 * @return the checkValide
	 */
	public CheckBox getCheckValide() {
		return checkValide;
	}

}
