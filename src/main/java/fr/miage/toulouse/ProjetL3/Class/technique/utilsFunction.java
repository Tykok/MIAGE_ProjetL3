package fr.miage.toulouse.ProjetL3.Class.technique;

import java.util.ArrayList;

import fr.miage.toulouse.ProjetL3.Class.metier.Etudiant;
import fr.miage.toulouse.ProjetL3.Class.metier.UE;
import fr.miage.toulouse.ProjetL3.Class.metier.UEValide;

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

		for (UE a : ueEtudiant(e)) {
			getUEPossible(a, allUEInscription);
		}

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
	public static void getUEPossible(UE u, ArrayList<UE> listUePossible) {
		// On récupére l'ensemble des UE pouvant être passé
		ArrayList<UE> allUePossible = chargementCSV.getUEForThisUE(u);
		boolean uePresent;

		// On parcourt l'ensemble des UE ou l'étudiant peut étudier
		for (UE b : allUePossible) {
			uePresent = false;
			// On regarde s'il n'est pas déjà présent dans notre ArrayList
			for (UE a : listUePossible) {
				if (a.getCodeIdentification().equals(b.getCodeIdentification())) {
					uePresent = true;
					break;
				}
			}

			// Si il n'est pas présent, on l'ajoute
			if (!uePresent) {
				listUePossible.add(b);
			}
		}
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
