package fr.miage.toulouse.ProjetL3.Class.technique;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import fr.miage.toulouse.ProjetL3.App;
import fr.miage.toulouse.ProjetL3.Main;
import fr.miage.toulouse.ProjetL3.Class.metier.Etudiant;
import fr.miage.toulouse.ProjetL3.Class.metier.UE;
import fr.miage.toulouse.ProjetL3.Class.metier.UEValide;

public class ajoutCSV {

	/**
	 * Cette méthode permet d'ajouter les valeurs voulues à un fichier CSV
	 * 
	 * @param nomFichier
	 * @param valeur
	 */
	private static void ajoutValeurCSV(String nomFichier, ArrayList<String> valeur) {

		// On récupére le fichier contenu dans nos ressources
		URL resource = App.class.getResource(Main.PATH_DATA + nomFichier + ".csv");

		try {
			FileWriter myWriter = new FileWriter(resource.getPath(), true);
			for (String a : valeur) {
				myWriter.write(a);
			}
			myWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Méthode appelé en passant en paramètre l'objet Etudiant, elle permet de ne
	 * pas avoir à refaire la manipulation de "rangement" des différentes valeurs à
	 * implémenter dans le fichier CSV dans un tableau
	 * 
	 * @see Etudiant
	 * 
	 * @param e
	 */
	public static void ajoutEtudiant(Etudiant e) {
		ArrayList<String> etudiant = new ArrayList<String>();
		etudiant.add("\n");
		etudiant.add(e.getNum() + ",");
		etudiant.add(e.getNom() + ",");
		etudiant.add(e.getPrenom() + ",");
		etudiant.add(e.getNomMention());
		ajoutValeurCSV("etudiants", etudiant);
	}

	/**
	 * Méthode permettant de rajotuer une ligne à notre fichier CSV validationue,
	 * permettant donc d'inscrire un étudiant ou d'entrer la validation d'une
	 * matière à un semestre d'un étudiant dans ce fichier CSV
	 * 
	 * @see UEValidation
	 * 
	 * @param u
	 */
	public static void ajoutUeValidation(UEValide u) {
		ArrayList<String> ueInscrit = new ArrayList<String>();
		ueInscrit.add("\n");
		ueInscrit.add(u.getUEValidation().getCodeIdentification() + ",");
		ueInscrit.add(u.getEtudiantValidation().getNum() + ",");
		ueInscrit.add(String.valueOf(u.getAnnneeValidation()) + ",");
		ueInscrit.add(String.valueOf(u.isSemestre()) + ",");
		ueInscrit.add(String.valueOf(u.isValider()) + ",");
		ueInscrit.add(String.valueOf(u.getMoyenne()));
		ajoutValeurCSV("validationue", ueInscrit);
	}

}
