package fr.miage.toulouse.ProjetL3.Class.technique;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import fr.miage.toulouse.ProjetL3.App;
import fr.miage.toulouse.ProjetL3.Main;
import fr.miage.toulouse.ProjetL3.Class.metier.Etudiant;

/**
 * Cette interface pouvant être implémenter par les contrôleurs, leurs permet
 * d'avoir une collection d'objet pouvant être exploités
 *
 */
public interface chargementCSV {

	/**
	 * Cette méthode permet de charger entièrement une collection des étudiants en
	 * chargeant les différentes données à partir du fichier CSV
	 * 
	 * @return
	 * @throws FileNotFoundException
	 */
	public static ArrayList<Etudiant> collectionEtudiant() throws FileNotFoundException {
		ArrayList<Etudiant> collectionEtudiant = null;
		try {

			URL resource = App.class.getResource(Main.PATH_DATA + "etudiants.csv");

			try (CSVReader reader = new CSVReader(new FileReader(resource.getPath()))) {
				List<String[]> r = reader.readAll();
				boolean firstLine = true;
				for (String[] a : r) {
					if (firstLine) {
						firstLine = !firstLine;
					} else {
						collectionEtudiant.add(new Etudiant(a[0], a[1], a[2]));
					}
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (CsvException e1) {
				e1.printStackTrace();
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		return collectionEtudiant;
	}

}
