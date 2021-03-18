package fr.miage.toulouse.ProjetL3.Class.technique.csv;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import com.opencsv.CSVWriter;

import fr.miage.toulouse.ProjetL3.App;
import fr.miage.toulouse.ProjetL3.Main;
import fr.miage.toulouse.ProjetL3.Class.metier.Etudiant;
import fr.miage.toulouse.ProjetL3.Class.metier.UEValide;

public class ajoutCSV {

	/**
	 * Cette méthode permet d'ajouter les valeurs voulues à un fichier CSV
	 * 
	 * @param nomFichier
	 * @param valeur
	 */
	private static void ajoutValeurCSV(String nomFichier, String[] valeur) {
		// On récupére le fichier contenu dans nos ressources
		URL resource = App.class.getResource(Main.PATH_DATA + nomFichier + ".csv");

		try {
			CSVWriter writer = new CSVWriter(new FileWriter(resource.getPath(), true), CSVWriter.DEFAULT_SEPARATOR,
					CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

			writer.writeNext(valeur);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Cette méthode permet de réécrire un fichier depuis le début
	 * 
	 * @param nomFichier
	 * @param valeur
	 */
	private static void reecritureCSV(String nomFichier, String[] valeur) {

		// On récupére le fichier contenu dans nos ressources
		URL resource = App.class.getResource(Main.PATH_DATA + nomFichier + ".csv");

		try {
			CSVWriter writer = new CSVWriter(new FileWriter(resource.getPath()), CSVWriter.DEFAULT_SEPARATOR,
					CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

			writer.writeNext(valeur);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Cette méthode permet simplement de réécrire le fichier CSV validationue, afin
	 * de repartir sur un fichier vierge ne comportant que le nom des colonnes
	 */
	public static void reecritureUEValide() {
		String[] colonneReecriture = { "codeUE", "numEtudiant", "Annnee", "Semestre", "Valider", "EnCours" };
		reecritureCSV("validationue", colonneReecriture);
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
		String[] etudiant = { e.getNum(), e.getNom(), e.getPrenom(), e.getMention().getNomMention() };
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
		String[] ueInscrit = { u.getUEValidation().getCodeIdentification(), u.getEtudiantValidation().getNum(),
				String.valueOf(u.getAnnneeValidation()), String.valueOf(u.isSemestre()), String.valueOf(u.isValider()),
				String.valueOf(u.isEnCours()) };
		ajoutValeurCSV("validationue", ueInscrit);
	}

}
