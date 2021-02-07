package fr.miage.toulouse.ProjetL3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

	// Attribut privé qui définit notre interface (fenêtre)
	private static Scene scene;

	@Override
	public void start(Stage stage) throws IOException {
		scene = new Scene(loadFXML("Connexion"), 640, 480);

		stage.setScene(scene);
		stage.setResizable(false);
		// stage.getIcons().add(new Image("Logo_UT3.jpg"));
		stage.setTitle("Université");
		stage.show();
	}

	/**
	 * Méthode qui permet de charger l'interface avec un nouveau fichier fxml
	 * 
	 * @param fxml Nom du fichier fxml sans extension
	 * @throws IOException
	 */
	public static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	/**
	 * Fonction qui permet de charger un fichier .fxml donné et de le retourner
	 * 
	 * @param fxml Nom du fichier fxml sans extension
	 * @return
	 * @throws IOException
	 */
	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	/**
	 * Méthode Main, elle permet de charger l'applicaiton JavaFX
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch();
	}

}