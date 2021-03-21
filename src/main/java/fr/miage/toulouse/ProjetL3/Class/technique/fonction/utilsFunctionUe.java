package fr.miage.toulouse.ProjetL3.Class.technique.fonction;

import java.util.ArrayList;

import fr.miage.toulouse.ProjetL3.Class.metier.Etudiant;
import fr.miage.toulouse.ProjetL3.Class.metier.UE;
import fr.miage.toulouse.ProjetL3.Class.metier.UEValide;
import fr.miage.toulouse.ProjetL3.Class.technique.csv.chargementCSV;

/**
 * Classe permettant d'utiliser des fonctions utiles pour les différents
 * contrôleurs
 */
public class utilsFunctionUe {

	/**
	 * Cette fonction permet de récupérer l'ensemble des UE auquel un étudiant peut
	 * être inscrits ou ré-inscrits
	 * 
	 * @see UE
	 * @see Etudiant
	 * @see UEValide
	 * @param e Etudiant sur lequel on effectue les tests
	 * @return
	 */
	public static ArrayList<UE> getAllInscriptionPossible(Etudiant e) {

		/**
		 * Ici on commence par récupérer l'ensemble UE sans prérequis que la personne
		 * peut potentiellement passé
		 */
		ArrayList<UE> allUEInscription = new ArrayList<UE>();
		boolean dejaPresent;
		for (UE a : getUeWithoutPrerequis(e)) {
			dejaPresent = false;
			for (UE b : ueNonEtudiant(e)) {
				if (a.getCodeIdentification().equals(b.getCodeIdentification())) {
					dejaPresent = true;
					break;
				}
			}
			if (!dejaPresent) {
				allUEInscription.add(a);
			}
		}

		/**
		 * Par la suite, on récupère les UE avec prérequis que la personne peut passer
		 */
		getUEPossible(ueEtudiant(e), allUEInscription, e);

		return allUEInscription;
	}

	/**
	 * Cette fonction void permet de <i>récupérer l'ensemble des UE pouvant être
	 * passé</i> suite à l'UE qui aura été fourni en paaramètre. La liste qui est
	 * fournie en second permet de regarder directement si cet UE n'a pas déjà été
	 * ajouté (permet d'éviter les doublons)
	 * 
	 * @see UE
	 * @see Etudiant
	 * @see UEValide
	 * @param listUeObtenu   Liste des UE obtenu par l'étudiant
	 * @param listUePossible Liste des UE ou l'étudiant peut potentiellement
	 *                       prétendre
	 * @param e              Etudiant qui souhaite être inscrits à certains UE
	 */
	public static void getUEPossible(ArrayList<UE> listUeObtenu, ArrayList<UE> listUePossible, Etudiant e) {
		// On récupére l'ensemble des UE
		for (UE a : chargementCSV.collectionUE()) {
			// TODO Vérifier que l'UE que l'on va ajouter n'est pas en cours
			if (!ueDejaValide(a, listUePossible) && ueDejaValide(listUeObtenu, a.getCollectionUE_Prerequis())
					&& !ueDejaValide(a, e)) {
				listUePossible.add(a);
			}
		}
	}

	/**
	 * Cette fonction permet de vérifier qu'un étudiant n'a pas déjà validé l'UE que
	 * l'on aura donné en paramètre mais aussi de savoir si l'étudiant n'est pas en
	 * cours d'inscription dans cet UE
	 * 
	 * @see UE
	 * @see Etudiant
	 * @see UEValide
	 * @param u Correspond un l'objet UE de la classe UE
	 * @param e Correspond un l'objet Etudiant de la classe Etudiant
	 * @return Booléen permettant de savoir si oui ou non l'étudiant n'a pas déjà
	 *         validé cet UE
	 */
	public static boolean ueDejaValide(UE u, Etudiant e) {
		for (UEValide a : allPassageUeEtudiant(e)) {
			if (a.getUEValidation().getCodeIdentification().equals(u.getCodeIdentification())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Cette fonction permet à partir de deux listes d'UE, de savoir si tout les UE
	 * requis ont été validé et sont bien présents
	 * 
	 * @see UE
	 * @see Etudiant
	 * @see UEValide
	 * @param listUE   Liste des UE qu'un étudiant à validé
	 * @param ueRequis Liste des UE Requis pour validé un UE
	 * @return Booléen permettant de savoir si oui ou non un étudiant à la
	 *         possibilité de passer cet UE
	 */
	public static boolean ueDejaValide(ArrayList<UE> listUE, ArrayList<UE> ueRequis) {
		boolean requis;
		for (UE a : ueRequis) {
			requis = false;
			for (UE b : listUE) {
				if (a.getCodeIdentification().equals(b.getCodeIdentification())) {
					requis = true;
				}
			}
			if (!requis) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Permet de retourner vrai ou faux en fonction de la présence de l'UE dans la
	 * liste d'UE qu'on aura donné en paramètre
	 * 
	 * @see UE
	 * @see Etudiant
	 * @see UEValide
	 * @param ue     Objet UE qui permet de vérifier si l'UE a ou non été ajouté
	 * @param listUe Liste des UE que l'on aura mit dans notre la liste des UE
	 *               Possible
	 * @return Booléen correspondant à la présence ou non de l'UE
	 */
	public static boolean ueDejaValide(UE ue, ArrayList<UE> listUe) {
		boolean uePresent = false;
		// On regarde s'il n'est pas déjà présent dans notre ArrayList
		for (UE d : listUe) {
			if (d.getCodeIdentification().equals(ue.getCodeIdentification())) {
				uePresent = true;
				break;
			}
		}
		return uePresent;
	}

	/**
	 * Cette fonction permet de récupérer l'ensemble des UE qu'un étudiant peut
	 * passer sans pour autant avoir besoin de prérequis
	 * 
	 * @see UE
	 * @see Etudiant
	 * @see UEValide
	 * @param e Objet Etudiant de la classe Etudiant
	 * @return Une liste d'objet UE
	 */
	public static ArrayList<UE> getUeWithoutPrerequis(Etudiant e) {
		ArrayList<UE> listUEValide = ueEtudiant(e);
		ArrayList<UE> uePossible = chargementCSV.collectionUE();
		ArrayList<UE> listUEReturn = new ArrayList<UE>();
		boolean dejaValider;

		for (UE a : uePossible) {
			dejaValider = false;
			if (a.getCollectionUE_Prerequis().size() <= 0) {
				for (UE b : listUEValide) {
					if (a.getCodeIdentification().equals(b.getCodeIdentification())) {
						dejaValider = true;
						break;
					}
				}
				if (!dejaValider) {
					listUEReturn.add(a);
				}
			}
		}

		return listUEReturn;
	}

	/**
	 * Cette fonction permet de retourner l'ensemble des UE qu'un étudiant à validé
	 * 
	 * @see UE
	 * @see Etudiant
	 * @see UEValide
	 * @param e Correspond à l'objet
	 * @return Une liste d'objet UE
	 */
	public static ArrayList<UE> ueEtudiant(Etudiant e) {
		ArrayList<UEValide> listValide = ueValideEtudiant(e);
		ArrayList<UE> UEValideEtudiant = new ArrayList<UE>();
		for (UEValide u : listValide) {
			UEValideEtudiant.add(chargementCSV.getUE(u.getUEValidation().getCodeIdentification()));
		}
		return UEValideEtudiant;
	}

	/**
	 * Cette fonction permet de récupérer l'ensemble des UE qui n'ont pas été validé
	 * par un étudiant
	 * 
	 * @see UE
	 * @see Etudiant
	 * @see UEValide
	 * @param e Objet Etudiant
	 * @return Une liste d'UE
	 */
	public static ArrayList<UE> ueNonEtudiant(Etudiant e) {
		ArrayList<UEValide> listValide = ueNonValideEtudiant(e);
		ArrayList<UE> UEValideEtudiant = new ArrayList<UE>();
		for (UEValide u : listValide) {
			UEValideEtudiant.add(chargementCSV.getUE(u.getUEValidation().getCodeIdentification()));
		}
		return UEValideEtudiant;
	}

	/**
	 * Cette fonction permet de retourner l'ensemble des UE en cours d'un étudiant
	 * 
	 * @see UE
	 * @see Etudiant
	 * @see UEValide
	 * @param e Objet Etudiant de la classe Etudiant
	 * @return Liste d'objets UE
	 */
	public static ArrayList<UE> ueEtudiantEnCours(Etudiant e) {
		ArrayList<UEValide> listValide = ueEnCours(e);
		ArrayList<UE> UEValideEtudiant = new ArrayList<UE>();
		for (UEValide u : listValide) {
			UEValideEtudiant.add(chargementCSV.getUE(u.getUEValidation().getCodeIdentification()));
		}
		return UEValideEtudiant;
	}

	/**
	 * Cette fonction permet avec un étudiant de savoir si l'UE est toujours en
	 * cours
	 * 
	 * @see UE
	 * @see Etudiant
	 * @see UEValide
	 * @param e  Objet Etudiant de la classe Etudiant
	 * @param ue Objet UE de la classe UE
	 * @return Vrai ou faux si l'ue est en cours ou non pour cet étudiant
	 */
	public static boolean verifThisUeEncCours(Etudiant e, UE ue) {
		ArrayList<UEValide> listValide = ueEnCours(e);
		for (UEValide u : listValide) {
			if (u.getEtudiantValidation().getNum().equals(e.getNum())
					&& u.getUEValidation().getCodeIdentification().equals(ue.getCodeIdentification())) {
				if (!u.isEnCours()) {
					return false;
				} else {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Cette fonction permet de retourner l'ensemble des UEValide qui n'ont pas été
	 * validé par l'étudiant
	 * 
	 * @see UE
	 * @see Etudiant
	 * @see UEValide
	 * @param e Etudiant de la classe Etudiant
	 * @return Une liste d'objet UEValide
	 */
	private static ArrayList<UEValide> ueNonValideEtudiant(Etudiant e) {
		ArrayList<UEValide> allValidation = chargementCSV.collectionUEValide();
		ArrayList<UEValide> validationEtudiant = new ArrayList<UEValide>();
		for (UEValide u : allValidation) {
			if (u.getEtudiantValidation().getNum().equals(e.getNum()) && !u.isValider()) {
				validationEtudiant.add(u);
			}
		}
		return validationEtudiant;
	}

	/**
	 * Cette fonction permet de retourner l'ensemble des UE validés par l'étudiant
	 * passé en paramètre (UEValide) et renvoie une ArrayList d'UEValide
	 * 
	 * @see UEValide
	 * @see UE
	 * @see Etudiant
	 * @param e Etudiant sur lequel on travail
	 * @return Une liste d'objet UEValide
	 */
	private static ArrayList<UEValide> ueValideEtudiant(Etudiant e) {
		ArrayList<UEValide> allValidation = chargementCSV.collectionUEValide();
		ArrayList<UEValide> validationEtudiant = new ArrayList<UEValide>();
		for (UEValide u : allValidation) {
			if (u.getEtudiantValidation().getNum().equals(e.getNum()) && u.isValider()) {
				validationEtudiant.add(u);
			}
		}
		return validationEtudiant;
	}

	/**
	 * Cette fonction permet de récupérer l'ensemble des UEValide, même si
	 * l'étudiant ne l'a pas validé Elle permet de faire des vérifications par la
	 * sutie
	 * 
	 * @see UE
	 * @see Etudiant
	 * @see UEValide
	 * @param e Objet Etudiant sur lequel on travail
	 * @return Une liste d'objets UEValide
	 */
	private static ArrayList<UEValide> allPassageUeEtudiant(Etudiant e) {
		ArrayList<UEValide> allValidation = chargementCSV.collectionUEValide();
		ArrayList<UEValide> validationEtudiant = new ArrayList<UEValide>();
		for (UEValide u : allValidation) {
			if (u.getEtudiantValidation().getNum().equals(e.getNum())) {
				validationEtudiant.add(u);
			}
		}
		return validationEtudiant;
	}

	/**
	 * Cette fonction permet de récupérer l'ensemble des UEValide en cours par
	 * l'étudiant
	 * 
	 * @see UE
	 * @see Etudiant
	 * @see UEValide
	 * @param e Objet Etudiant sur lequel on travail
	 * @return Une liste d'objet UEValide
	 */
	private static ArrayList<UEValide> ueEnCours(Etudiant e) {
		ArrayList<UEValide> allValidation = chargementCSV.collectionUEValide();
		ArrayList<UEValide> ueEnCours = new ArrayList<UEValide>();
		for (UEValide u : allValidation) {
			if (u.getEtudiantValidation().getNum().equals(e.getNum()) && u.isEnCours()) {
				ueEnCours.add(u);
			}
		}
		return ueEnCours;
	}

	public static ArrayList<UE> getPrerequisForThisUe(UE u) {
		return chargementCSV.getAllUEPrerequis(u);
	}

}
