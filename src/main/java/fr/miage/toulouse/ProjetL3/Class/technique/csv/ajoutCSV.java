package fr.miage.toulouse.ProjetL3.Class.technique.csv;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import com.opencsv.CSVWriter;

import fr.miage.toulouse.ProjetL3.App;
import fr.miage.toulouse.ProjetL3.Main;
import fr.miage.toulouse.ProjetL3.Class.metier.Etudiant;
import fr.miage.toulouse.ProjetL3.Class.metier.UEValide;

/**
 * Classe ajoutCSV, elle permet d'avoir accès à différentes méthodes qui
 * permettent l'écriture au sein d'un fichier CSV
 *
 * @see CSVWriter
 * @see FileWriter
 */
public class ajoutCSV {

	/**
	 * Cette méthode permet d'<i>ajouter les valeurs</i> voulues à un fichier CSV
	 * 
	 * @param nomFichier Nom du fichier ou l'on souhaite écrire
	 * @param valeur     Ensemble des valeurs (sous formes de tableau) qui seront
	 *                   insérer
	 */
	private static void ajoutValeurCSV(String nomFichier, String[] valeur) {
		// On récupére le fichier contenu dans nos ressources

		try {
			CSVWriter writer = new CSVWriter(new FileWriter(Main.PATH_DATA + "\\" + nomFichier + ".csv", true),
					CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER,
					CSVWriter.DEFAULT_LINE_END);

			writer.writeNext(valeur);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Cette méthode permet de <i>réécrire un fichier</i> depuis le début, elle
	 * écrase le contenu du fichier pour pouvoir réécrire les valeurs
	 * 
	 * @param nomFichier Nom du fichier ou l'on souhaite écrire
	 * @param valeur     Ensemble des valeurs (sous formes de tableau) qui seront
	 *                   insérer
	 */
	private static void reecritureCSV(String nomFichier, String[] valeur) {
		try {
			CSVWriter writer = new CSVWriter(new FileWriter(Main.PATH_DATA + "\\" + nomFichier + ".csv"),
					CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER,
					CSVWriter.DEFAULT_LINE_END);

			writer.writeNext(valeur);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Cette méthode permet simplement de <i>réécrire le fichier CSV
	 * validationue</i>, afin de repartir sur un fichier vierge ne comportant que le
	 * nom des colonnes
	 */
	public static void reecritureUEValide() {
		String[] colonneReecriture = { "codeUE", "numEtudiant", "Annnee", "Semestre", "Valider", "EnCours" };
		reecritureCSV("validationue", colonneReecriture);
	}

	/**
	 * Méthode appelé en passant en paramètre l'objet <i>Etudiant</i>, elle permet
	 * de ne pas avoir à refaire la manipulation de "rangement" des différentes
	 * valeurs à implémenter dans le fichier CSV dans un tableau
	 * 
	 * @see Etudiant
	 * 
	 * @param e Objet Etudiant
	 */
	public static void ajoutEtudiant(Etudiant e) {
		String[] etudiant = { e.getNum(), e.getNom(), e.getPrenom(), e.getMention().getNomMention() };
		ajoutValeurCSV("etudiants", etudiant);
	}

	/**
	 * Méthode permettant de <i>rajotuer une ligne à notre fichier CSV
	 * validationue</i>, permettant donc d'inscrire un étudiant ou d'entrer la
	 * validation d'une matière à un semestre d'un étudiant dans ce fichier CSV
	 * 
	 * @see UEValidation
	 * 
	 * @param u Objet UEValide
	 */
	public static void ajoutUeValidation(UEValide u) {
		String[] ueInscrit = { u.getUEValidation().getCodeIdentification(), u.getEtudiantValidation().getNum(),
				String.valueOf(u.getAnnneeValidation()), String.valueOf(u.isSemestre()), String.valueOf(u.isValider()),
				String.valueOf(u.isEnCours()) };
		ajoutValeurCSV("validationue", ueInscrit);
	}

}
