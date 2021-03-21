package fr.miage.toulouse.ProjetL3.Class.technique.fonction;

import java.io.IOException;

import fr.miage.toulouse.ProjetL3.App;

/**
 * Classe contenant l'ensemble des fonctions qui sont essentielles à l'ensemble
 * des vues
 *
 */
public class appFonction {

	/**
	 * Méthode permettant à l'utilisateur de ce déconnecter et de retourner à
	 * l'interface de connexion
	 */
	public final static void deco() {
		try {
			App.setRoot("Connexion");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Méthode qui permet d'effectuer un retour vers la page qui aura été donné en
	 * argument
	 * 
	 * @param fxml correspond à la vue ou l'on souhaite aller
	 */
	public final static void retour(String fxml) {
		try {
			App.setRoot(fxml);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
