package fr.miage.toulouse.ProjetL3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import fr.miage.toulouse.ProjetL3.Class.metier.ClassTest;

/**
 * Classe Main, c'est ici que l'on lance l'application
 * 
 *
 */
public class Main {

	// Constantes qui peuvent être utilisés dans l'ensemble des classes
	public final static String PATH_IMAGE = "Images/";
	public final static String PATH_DATA = "Data/";

	/**
	 * Méthode Main qui permet de faire appel à la classe App qui lancera
	 * l'application JavaFX
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// App.main(args);
		collectionPersonne();
	}

	public static List<ClassTest> collectionPersonne() {
		List<ClassTest> beans = null;
		try {
			InputStream path = Main.class.getResourceAsStream(PATH_DATA + "test.csv");
			beans = new CsvToBeanBuilder(new FileReader(path.getClass().getName()))).withType(ClassTest.class).build().parse();
		} catch (IllegalStateException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return beans;
	}

}
