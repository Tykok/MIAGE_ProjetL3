package fr.miage.toulouse.ProjetL3;

/**
 * Classe <i>Main</i> qui permet de lancer l'application <br/>
 * Elle contient par ailleurs certaines variables qui sont à porté de
 * l'application entière
 * 
 * @see App
 */
public class Main {

	/**
	 * Constante permettant de récupérer le chemin des images
	 */
	public final static String PATH_IMAGE = "Images/";
	/**
	 * Constante permettant de récupérer le PATH choisi par le USER
	 */
	public static String PATH_DATA;

	/**
	 * Méthode main, elle appartient à la <b>classe principale</b> de l'application
	 * 
	 * @param args Argument du main
	 */
	public static void main(String[] args) {
		App.launchApp();
	}
}
