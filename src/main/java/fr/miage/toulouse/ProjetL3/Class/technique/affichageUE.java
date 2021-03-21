package fr.miage.toulouse.ProjetL3.Class.technique;

import java.util.ArrayList;

import fr.miage.toulouse.ProjetL3.Class.metier.UE;
import fr.miage.toulouse.ProjetL3.Class.technique.csv.chargementCSV;
import fr.miage.toulouse.ProjetL3.Class.technique.fonction.utilsFunctionUe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

/**
 * Classe affichageUE, cette classe hérite de la classe UE et permet d'avoir un
 * affichage plus personnalisé de la classe UE
 *
 * @see UE
 */
public class affichageUE extends UE {

	// Attribut nécessaire à JavaFX
	private ArrayList<UE> list_prerequis;
	private CheckBox checkValide;

	/**
	 * Ce constructeur permet d'<i>instancier</i> un objet affichageUE
	 * 
	 * @param a Objet UE
	 */
	public affichageUE(UE a) {
		super(a.getCodeIdentification(), a.getNomUE(), a.getCreditECT());
		this.list_prerequis = utilsFunctionUe.getPrerequisForThisUe(a);
		this.checkValide = new CheckBox();
	}

	/**
	 * Méthode permettant de récupérer l'ensemble de la liste des prérequis pour cet
	 * UE
	 * 
	 * @return Une Liste d'UE
	 */
	public ArrayList<UE> getList_prerequis() {
		return this.list_prerequis;
	}

	/**
	 * Méthode permettant de retourner une checkBox
	 * 
	 * @return Objet CheckBox
	 */
	public CheckBox getCheckValide() {
		return checkValide;
	}

}
