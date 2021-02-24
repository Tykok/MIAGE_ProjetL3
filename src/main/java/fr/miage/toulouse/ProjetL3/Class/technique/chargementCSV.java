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
import fr.miage.toulouse.ProjetL3.Class.metier.*;

/**
 * Cette interface pouvant être implémenter par les contrôleurs, leurs permet
 * d'avoir une collection d'objet pouvant être exploités
 *
 */
public interface chargementCSV {

	/**
	 * Cette méthode permet de charger un fichier CSV donné en argument et de
	 * retourner par la suite une ArrayList contenant chacune des lignes de ce même
	 * fichier
	 * 
	 * @param nomFichier
	 * @return
	 */
	private static ArrayList<String[]> returnTabCsv(String nomFichier) {
		ArrayList<String[]> tabCsv = new ArrayList<>();
		try {
			URL resource = App.class.getResource(Main.PATH_DATA + nomFichier + ".csv");

			try (CSVReader reader = new CSVReader(new FileReader(resource.getPath()))) {
				List<String[]> r = reader.readAll();
				for(String[] a : r) {
					tabCsv.add(a);
				}			
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (CsvException e1) {
				e1.printStackTrace();
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return tabCsv;
	}

	/**
	 * Cette méthode permet de charger entièrement une collection des étudiants en
	 * chargeant les différentes données à partir du fichier CSV
	 * 
	 * @return
	 * @throws FileNotFoundException
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
	 * Méthode permettant de charger récupérer les parcours et mention auquel un
	 * étudiant sera inscrits en chargeant les fichiers CSV correspondant
	 * 
	 * @param nomMention
	 * @return
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
	 * Cette méthode permet de retourner un parcours via le nom qui aura été fourni
	 * en argumentf
	 * 
	 * @param nomParcours
	 * @return
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
	 * Méthode permettant de retourner une collection des différentes mentions
	 * présent dans le fichier CSV
	 * 
	 * @return
	 * @throws FileNotFoundException
	 */
	public static ArrayList<Mention> collectionMention() throws FileNotFoundException {
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
	 * @param collectionParcours
	 * @throws FileNotFoundException
	 */
	private static void addMention_Parcours(ArrayList<Parcours> collectionParcours) throws FileNotFoundException {
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
	 * @return
	 * @throws FileNotFoundException
	 */
	public static ArrayList<Parcours> collectionParcours() throws FileNotFoundException {
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
		return collectionParcours;
	}

	/**
	 * Cette méthode permet d'instancier une collection des différents personnes
	 * ayant accès à l'application
	 * 
	 * @return
	 * @throws FileNotFoundException
	 */
	public static ArrayList<Connexion> collectionRole() throws FileNotFoundException {
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
	 * Cette méthode permet de retourner les différentes UE contenues au sein du
	 * fichiers collectionUE_Prerequiss
	 * 
	 * @return
	 * @throws FileNotFoundException
	 */
	public static ArrayList<UE> collectionUE() throws FileNotFoundException {
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
	 * @param collectionUE
	 * @throws FileNotFoundException
	 */
	private static void getCollectionUEPrerequis(ArrayList<UE> collectionUE) throws FileNotFoundException {
		ArrayList<String[]> contenuFichier = returnTabCsv("prerequis");

		boolean firstLine = true;
		for (String[] a : contenuFichier) {
			if (firstLine) {
				firstLine = !firstLine;
			} else {
				UE UESup = null;
				UE UEPre = null;
				for (UE e : collectionUE) {
					if (e.getCodeIdentification().equals(a[0])) {
						UESup = e;
					} else if (e.getCodeIdentification().equals(a[0])) {
						UEPre = e;
					}

					if (UESup != null && UEPre != null) {
						break;
					}
				}
				UESup.ajouterUEPrerequis(UEPre);
			}
		}

	}

	/**
	 * Cette méthode permet de renvoyer les différents validation effectué par
	 * l'ensemble des étudiants que l'on possède dans notre fichier CSV
	 * 
	 * @return
	 * @throws FileNotFoundException
	 */
	public static ArrayList<UEValide> collectionUEValide() throws FileNotFoundException {
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
						collectionUEValide.add(new UEValide(Integer.valueOf(a[2]), Boolean.valueOf(a[3]),
								Boolean.valueOf(a[4]), Double.valueOf(a[5]), ueValide, etudiantValidation));
					}
				}
		return collectionUEValide;
	}
}
