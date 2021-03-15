package fr.miage.toulouse.ProjetL3.Class.technique.fonction;

import java.util.ArrayList;

import fr.miage.toulouse.ProjetL3.Class.metier.Etudiant;
import fr.miage.toulouse.ProjetL3.Class.metier.UE;
import fr.miage.toulouse.ProjetL3.Class.metier.UEValide;
import fr.miage.toulouse.ProjetL3.Class.technique.csv.chargementCSV;

/**
 * Interface permettant d'utiliser des fonctions utiles pour les différents
 * contrôleurs
 * 
 * @author ElieTreport
 *
 */
public class utilsFunction {

	/**
	 * Cette fonction permet de récupérer l'ensemble des UE auquel un étudiant peut
	 * être inscrits ou ré-inscrits
	 * 
	 * @param e
	 * @return
	 */
	public static ArrayList<UE> getAllInscriptionPossible(Etudiant e) {
		ArrayList<UE> allUEInscription = ueNonEtudiant(e);
		boolean dejaPresent;
		for (UE a : getUeWithoutPrerequis(e)) {
			dejaPresent = false;
			for (UE b : allUEInscription) {
				if (a.getCodeIdentification().equals(b.getCodeIdentification())) {
					dejaPresent = true;
					break;
				}
			}
			if (!dejaPresent) {
				allUEInscription.add(a);
			}
		}

		getUEPossible(ueEtudiant(e), allUEInscription, e);

		return allUEInscription;
	}

	/**
	 * Cette méthode void permet de récupérer l'ensemble des UE pouvant être passé
	 * suite à l'UE qui aura été fourni en paaramètre. La liste qui est fournie en
	 * second permet de regarder directement si cet UE n'a pas déjà été ajouté
	 * (permet d'éviter les doublons)
	 * 
	 * @param u
	 * @param listUePossible
	 */
	public static void getUEPossible(ArrayList<UE> listUeObtenu, ArrayList<UE> listUePossible, Etudiant e) {
		// On récupére l'ensemble des UE
		for (UE a : chargementCSV.collectionUE()) {
			if (!ueDejaValide(a, listUePossible) && ueDejaValide(listUeObtenu, a.getCollectionUE_Prerequis()) && !ueDejaValide(a, e)) {
				listUePossible.add(a);
			}
		}
	}

	/**
	 * Cette méthode permet de vérifier qu'un étudiant n'a pas déjà validé l'UE que
	 * l'on aura donné en paramètre
	 * 
	 * @param u
	 * @param e
	 * @return
	 */
	public static boolean ueDejaValide(UE u, Etudiant e) {
		for (UE a : ueEtudiant(e)) {
			if (a.getCodeIdentification().equals(u.getCodeIdentification())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Cette méthode permet à partir de deux listes d'UE, de savoir si tout les UE
	 * requis ont été validé et sont bien présents
	 * 
	 * @param listUE
	 * @param ueRequis
	 * @return
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
	 * @param listUe
	 * @return
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
	 * Cette méthode permet de récupérer l'ensemble des UE qu'un étudiant peut
	 * passer sans pour autant avoir besoin de prérequis
	 * 
	 * @param e
	 * @return
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
	 * Cette méthode permet de retourner l'ensemble des UE qu'un étudiant à validé
	 * 
	 * @param listValide
	 * @return
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
	 * @param e
	 * @return
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
	 * Cette méthode permet de retourner l'ensemble des UE en cours d'un étudiant
	 * 
	 * @param listValide
	 * @return
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
	 * Cette fonction permet de retourner l'ensemble des UEValide qui n'ont pas été
	 * validé par l'étudiant
	 * 
	 * @param e
	 * @return
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
	 * Cette méthode permet de retourner l'ensemble des UE validés par l'étudiant
	 * passé en paramètre (UEValide) et renvoie une ArrayList d'UEValide
	 * 
	 * @see UEValide
	 * @param e
	 * @return
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
	 * Cette fonction permet de récupérer l'ensemble des UEValide en cours par
	 * l'étudiant
	 * 
	 * @param e
	 * @return
	 */
	private static ArrayList<UEValide> ueEnCours(Etudiant e) {
		ArrayList<UEValide> allValidation = chargementCSV.collectionUEValide();
		ArrayList<UEValide> ueEnCours = new ArrayList<UEValide>();
		for (UEValide u : allValidation) {
			if (u.getEtudiantValidation().getNum().equals(e.getNum()) && u.getMoyenne() == -1) {
				ueEnCours.add(u);
			}
		}
		return ueEnCours;
	}

}
