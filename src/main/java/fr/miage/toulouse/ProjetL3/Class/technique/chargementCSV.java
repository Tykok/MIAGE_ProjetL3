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

	/**
	 * Méthode permettant de retourner une collection des différentes mentions
	 * présent dans le fichier CSV
	 * 
	 * @return
	 * @throws FileNotFoundException
	 */
	public static ArrayList<Mention> collectionMention() throws FileNotFoundException {
		ArrayList<Mention> collectionMention = null;
		try {

			URL resource = App.class.getResource(Main.PATH_DATA + "mention.csv");

			try (CSVReader reader = new CSVReader(new FileReader(resource.getPath()))) {
				List<String[]> r = reader.readAll();
				boolean firstLine = true;
				for (String[] a : r) {
					if (firstLine) {
						firstLine = !firstLine;
					} else {
						collectionMention.add(new Mention(a[0]));
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
		try {

			URL resource = App.class.getResource(Main.PATH_DATA + "mention.csv");

			try (CSVReader reader = new CSVReader(new FileReader(resource.getPath()))) {
				List<String[]> r = reader.readAll();
				boolean firstLine = true;
				for (String[] a : r) {
					if (firstLine) {
						firstLine = !firstLine;
					} else {
						for (Parcours p : collectionParcours) {
							p.addMention(new Mention(a[0]));
						}
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
	}

	/**
	 * Cette méthode permet de retourner une collection de parcours
	 * 
	 * @return
	 * @throws FileNotFoundException
	 */
	public static ArrayList<Parcours> collectionParcours() throws FileNotFoundException {
		ArrayList<Parcours> collectionParcours = null;
		try {

			URL resource = App.class.getResource(Main.PATH_DATA + "parcours.csv");

			try (CSVReader reader = new CSVReader(new FileReader(resource.getPath()))) {
				List<String[]> r = reader.readAll();
				boolean firstLine = true;
				for (String[] a : r) {
					if (firstLine) {
						firstLine = !firstLine;
					} else {
						collectionParcours.add(new Parcours(a[0], Integer.valueOf(a[1]), Integer.valueOf(a[2])));
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
		addMention_Parcours(collectionParcours);
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
		ArrayList<Connexion> collectionRole = null;
		try {

			URL resource = App.class.getResource(Main.PATH_DATA + "role.csv");

			try (CSVReader reader = new CSVReader(new FileReader(resource.getPath()))) {
				List<String[]> r = reader.readAll();
				boolean firstLine = true;
				for (String[] a : r) {
					if (firstLine) {
						firstLine = !firstLine;
					} else {
						collectionRole.add(new Connexion(a[0], a[1], a[2], a[3], a[4], a[5]));
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
		ArrayList<UE> collectionUE = null;
		try {

			URL resource = App.class.getResource(Main.PATH_DATA + "ue.csv");

			try (CSVReader reader = new CSVReader(new FileReader(resource.getPath()))) {
				List<String[]> r = reader.readAll();
				boolean firstLine = true;
				for (String[] a : r) {
					if (firstLine) {
						firstLine = !firstLine;
					} else {
						collectionUE.add(new UE(a[0], a[1], Integer.valueOf(a[2])));
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
		try {

			URL resource = App.class.getResource(Main.PATH_DATA + "prerequis.csv");

			try (CSVReader reader = new CSVReader(new FileReader(resource.getPath()))) {
				List<String[]> r = reader.readAll();
				boolean firstLine = true;
				for (String[] a : r) {
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
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (CsvException e1) {
				e1.printStackTrace();
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
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
		ArrayList<UEValide> collectionUEValide = null;
		ArrayList<Etudiant> collectionEtudiant = collectionEtudiant();
		ArrayList<UE> collectionUE = collectionUE();
		try {

			URL resource = App.class.getResource(Main.PATH_DATA + "validationue.csv");

			try (CSVReader reader = new CSVReader(new FileReader(resource.getPath()))) {
				List<String[]> r = reader.readAll();
				boolean firstLine = true;
				for (String[] a : r) {
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
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (CsvException e1) {
				e1.printStackTrace();
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return collectionUEValide;
	}
}
