package fr.miage.toulouse.ProjetL3.Class.technique.csv;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import fr.miage.toulouse.ProjetL3.Main;
import fr.miage.toulouse.ProjetL3.Class.metier.*;

/**
 * Cette classe permet d'avoir à porté de main différentes méthodes qui
 * permettent d'instancier des objets, des collections d'objets de différentes
 * classes en chargeant les fichiers CSV qui correspondent
 *
 */
public class chargementCSV {

	/**
	 * Cette fonction permet de <i>charger un fichier CSV</i> donné en argument et
	 * de retourner par la suite une ArrayList contenant chacune des lignes de ce
	 * même fichier
	 * 
	 * @param nomFichier Nom du fichier qui devra être lue
	 * @return Un tableau à deux dimensions, la première dimension correspond au
	 *         ligne, et la seconde au colonne de cette ligne
	 */
	private static ArrayList<String[]> returnTabCsv(String nomFichier) {
		ArrayList<String[]> tabCsv = new ArrayList<>();
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(new FileInputStream(Main.PATH_DATA + "\\" + nomFichier + ".csv"), "UTF-8"));
			try (CSVReader reader = new CSVReader(in)) {
				List<String[]> r = reader.readAll();
				for (String[] a : r) {
					tabCsv.add(a);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (CsvException e1) {
				e1.printStackTrace();
			}
		} catch (IllegalStateException | UnsupportedEncodingException | FileNotFoundException e) {
			e.printStackTrace();
		} finally {
		}
		return tabCsv;
	}

	/**
	 * Cette fonctin permet de charger entièrement une collection des étudiants en
	 * chargeant les différentes données à partir du fichier CSV
	 * 
	 * @see Etudiant
	 * @return Une liste d'objet Etudiant
	 */
	public static ArrayList<Etudiant> collectionEtudiant() {
		ArrayList<Etudiant> collectionEtudiant = new ArrayList<Etudiant>();
		ArrayList<String[]> contenuFichier = returnTabCsv("etudiants");
		boolean firstLine = true;
		for (String[] colonne : contenuFichier) {
			if (firstLine) {
				firstLine = !firstLine;
			} else {
				Mention mentionEtudiant = rechercheMention(colonne[3]);
				collectionEtudiant.add(new Etudiant(colonne[0], colonne[1], colonne[2], mentionEtudiant));
			}
		}

		return collectionEtudiant;
	}

	/**
	 * Cette fonction permet de retourner un étudiant, en fonction du numéro
	 * d'étudiant qui aura été fourni en paramètre
	 * 
	 * @see Etudiant
	 * @param num Numéro d'étudiant recherché
	 * @return Objet Etudiant correspondant à l'étudiant recherché
	 */
	public static Etudiant getEtudiant(String num) {
		ArrayList<Etudiant> collectionEtudiant = collectionEtudiant();
		for (Etudiant a : collectionEtudiant) {
			if (a.getNum().equals(num)) {
				return a;
			}
		}
		return null;
	}

	/**
	 * Fonction permettant de charger récupérer les parcours et mention auquel un
	 * étudiant sera inscrits en chargeant les fichiers CSV correspondant
	 * 
	 * @see Mention
	 * @param nomMention Correspond au nom de la mention recherché
	 * @return Objet Mention recherché
	 */
	private static Mention rechercheMention(String nomMention) {
		Mention returnMention;
		boolean firstLine = true;
		ArrayList<String[]> contenuFichier = returnTabCsv("mention");
		for (String[] a : contenuFichier) {
			if (firstLine) {
				firstLine = !firstLine;
			} else {
				if (a[0].equals(nomMention)) {
					return new Mention(a[0], rechercheParcours(a[1]));
				}
			}
		}
		return null;
	}

	/**
	 * Cette fonction permet de retourner un parcours via le nom qui aura été fourni
	 * lors de l'appel de cette fonction
	 * 
	 * @see Parcours
	 * @param nomParcours Correspond au nom du parcours recherché
	 * @return Objet Parcours de la classe Parcours
	 */
	private static Parcours rechercheParcours(String nomParcours) {
		boolean firstLine = true;
		ArrayList<String[]> contenuFichier = returnTabCsv("parcours");
		for (String[] a : contenuFichier) {
			if (firstLine) {
				firstLine = !firstLine;
			} else {
				if (a[0].equals(nomParcours)) {
					return new Parcours(a[0], Integer.valueOf(a[1]), Integer.valueOf(a[2]));
				}
			}
		}
		return null;
	}

	/**
	 * Fonction permettant de retourner une collection des différentes mentions
	 * présent dans le fichier CSV
	 * 
	 * @see Mention
	 * @return Une liste d'objet Mention
	 */
	public static ArrayList<Mention> collectionMention() {
		ArrayList<Mention> collectionMention = new ArrayList<Mention>();
		boolean firstLine = true;
		ArrayList<String[]> contenuFichier = returnTabCsv("mention");
		for (String[] a : contenuFichier) {
			if (firstLine) {
				firstLine = !firstLine;
			} else {
				collectionMention.add(new Mention(a[0], rechercheParcours(a[1])));
			}
		}
		return collectionMention;
	}

	/**
	 * Cette méthode permet grâce à la collection donner en paramètre, ajouter à
	 * chacun des parcours les mentions qui lui correspondent
	 * 
	 * @param collectionParcours Correspond à l'ensemble des parcours
	 */
	private static void addMention_Parcours(ArrayList<Parcours> collectionParcours) {
		boolean firstLine = true;
		ArrayList<String[]> contenuFichier = returnTabCsv("mention");
		for (String[] a : contenuFichier) {
			if (firstLine) {
				firstLine = !firstLine;
			} else {
				for (Parcours p : collectionParcours) {
					p.addMention(new Mention(a[0], p));
				}
			}
		}
	}

	/**
	 * Cette méthode permet de retourner une collection de parcours
	 * 
	 * @see Parcours
	 * @return Une liste de Parcours
	 */
	public static ArrayList<Parcours> collectionParcours() {
		ArrayList<Parcours> collectionParcours = new ArrayList<Parcours>();
		ArrayList<String[]> contenuFichier = returnTabCsv("parcours");
		boolean firstLine = true;
		for (String[] a : contenuFichier) {
			if (firstLine) {
				firstLine = !firstLine;
			} else {
				collectionParcours.add(new Parcours(a[0], Integer.valueOf(a[1]), Integer.valueOf(a[2])));
			}
		}
		addMention_Parcours(collectionParcours);
		return collectionParcours;
	}

	/**
	 * Cette fonction permet d'instancier une collection des différents personnes
	 * ayant accès à l'application
	 * 
	 * @see Connexion
	 * @return Une liste d'objets connexion
	 */
	public static ArrayList<Connexion> collectionConnexion() {
		ArrayList<Connexion> collectionRole = new ArrayList<Connexion>();
		ArrayList<String[]> contenuFichier = returnTabCsv("role");
		boolean firstLine = true;
		for (String[] a : contenuFichier) {
			if (firstLine) {
				firstLine = !firstLine;
			} else {
				collectionRole.add(new Connexion(a[0], a[1], a[2], a[3], a[4], a[5]));
			}
		}
		return collectionRole;
	}

	/**
	 * Cette fonction permet de retourner les différentes UE contenues au sein du
	 * fichiers collectionUE_Prerequiss
	 * 
	 * @see UE
	 * @return Une liste d'objet UE
	 */
	public static ArrayList<UE> collectionUE() {
		ArrayList<UE> collectionUE = new ArrayList<UE>();
		ArrayList<String[]> contenuFichier = returnTabCsv("ue");

		boolean firstLine = true;
		for (String[] a : contenuFichier) {
			if (firstLine) {
				firstLine = !firstLine;
			} else {
				collectionUE.add(new UE(a[0], a[1], Integer.valueOf(a[2])));
			}
		}

		getCollectionUEPrerequis(collectionUE);
		return collectionUE;
	}

	/**
	 * Cette méthode permet d'ajouter à la collection donné, les UE qui sont
	 * prérequis aux différentes UE donné dans cette collection
	 * 
	 * @see UE
	 * @param collectionUE Ensemble des UE nécessitant d'avoir des prérequis
	 */
	private static void getCollectionUEPrerequis(ArrayList<UE> collectionUE) {
		ArrayList<String[]> contenuFichier = returnTabCsv("prerequis");

		boolean firstLine = true;
		for (String[] a : contenuFichier) {
			if (firstLine) {
				firstLine = !firstLine;
			} else {
				for (UE e : collectionUE) {
					if (e.getCodeIdentification().equals(a[0])) {
						e.ajouterUEPrerequis(getUE(a[1]));
						break;
					}
				}
			}
		}

	}

	/**
	 * Cette fonction permet de retourner une collection de l'ensemble des UE
	 * prérequis pour un UE donné
	 * 
	 * @see UE
	 * @param ue Objet UE ou l'on sougaite obtenir l'ensemble des prérequis
	 * @return Une liste d'objet prérequis
	 */
	public static ArrayList<UE> getAllUEPrerequis(UE ue) {
		ArrayList<String[]> contenuFichier = returnTabCsv("prerequis");
		ArrayList<UE> listUE = new ArrayList<UE>();

		boolean firstLine = true;
		for (String[] a : contenuFichier) {
			if (firstLine) {
				firstLine = !firstLine;
			} else if (ue.getCodeIdentification().equals(a[0])) {
				listUE.add(getUE(a[1]));
			}
		}

		return listUE;
	}

	/**
	 * Cette fonction, permet de récupérer l'ensemble des UE qui peuvent être passé
	 * grâce à l'UE qui est donné en paramètre
	 * 
	 * @see UE
	 * @param u
	 * @return
	 */
	public static ArrayList<UE> getUEForThisUE(UE u) {
		ArrayList<String[]> contenuFichier = returnTabCsv("prerequis");
		ArrayList<UE> listUE = new ArrayList<UE>();

		boolean firstLine = true;
		for (String[] a : contenuFichier) {
			if (firstLine) {
				firstLine = !firstLine;
			} else if (u.getCodeIdentification().equals(a[0])) {
				listUE.add(getUE(a[1]));
			}
		}

		return listUE;
	}

	/**
	 * Cette fonction permet de récupérer un UE en particulier et de retourner
	 * l'objet après l'avoir instancier
	 * 
	 * @see UE
	 * @param nomUE Nom de l'UE que l'on recherche
	 * @return Objet UE de la classe UE
	 */
	public static UE getUE(String nomUE) {
		ArrayList<String[]> contenuFichier = returnTabCsv("ue");

		boolean firstLine = true;
		for (String[] a : contenuFichier) {
			if (firstLine) {
				firstLine = !firstLine;
			} else if (a[0].equals(nomUE)) {
				return new UE(a[0], a[1], Integer.valueOf(a[2]));
			}
		}
		return null;
	}

	/**
	 * Cette méthode permet de renvoyer les différents validation effectué par
	 * l'ensemble des étudiants que l'on possède dans notre fichier CSV
	 * 
	 * @see UEValide
	 * @return Une liste d'objets UEValide de la classe UEValide
	 */
	public static ArrayList<UEValide> collectionUEValide() {
		ArrayList<UEValide> collectionUEValide = new ArrayList<UEValide>();
		ArrayList<Etudiant> collectionEtudiant = collectionEtudiant();
		ArrayList<UE> collectionUE = collectionUE();
		ArrayList<String[]> contenuFichier = returnTabCsv("validationue");
		boolean firstLine = true;
		for (String[] a : contenuFichier) {
			if (firstLine) {
				firstLine = !firstLine;
			} else {
				Etudiant etudiantValidation = null;
				UE ueValide = null;

				// On cherche tout d'abord l'étudiant qui correspond à cette ligne
				for (Etudiant e : collectionEtudiant) {
					if (e.getNum().equals(a[1])) {
						etudiantValidation = e;
						break;
					}
				}

				// Ensuite on recherche l'UE corespondant à cette ligne
				for (UE u : collectionUE) {
					if (u.getCodeIdentification().equals(a[0])) {
						ueValide = u;
						break;
					}
				}

				// On crée enfin notre objet UEValide
				collectionUEValide.add(new UEValide(Integer.valueOf(a[2]), Boolean.valueOf(a[3]), Boolean.valueOf(a[4]),
						Boolean.valueOf(a[5]), ueValide, etudiantValidation));
			}
		}
		return collectionUEValide;
	}
}
