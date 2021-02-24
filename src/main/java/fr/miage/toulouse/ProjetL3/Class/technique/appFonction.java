package fr.miage.toulouse.ProjetL3.Class.technique;

import java.io.IOException;

import fr.miage.toulouse.ProjetL3.App;

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
	 * @param fxml
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
