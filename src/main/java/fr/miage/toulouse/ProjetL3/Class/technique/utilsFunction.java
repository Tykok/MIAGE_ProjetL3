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
public interface utilsFunction {

	/**
	 * Méthode qui permet de récupérer SEULEMENT les UE validés par un étudiant
	 * qu'on aura renseigné dans le fichier CSV
	 * 
	 * @param e
	 * @return
	 */
	private static ArrayList<UEValide> ueValideEtudiant(Etudiant e) {
		ArrayList<UEValide> collectionUEValide = chargementCSV.collectionUEValide();
		ArrayList<UEValide> ueReturn = new ArrayList<UEValide>();

		for (UEValide a : collectionUEValide) {
			/**
			 * On vérifie que l'étudiant à bien valider cet UE et qu'il correspond bien à
			 * notre étudiant
			 */
			if (a.getEtudiantValidation().getNum().equals(e.getNum()) && a.isValider()) {
				ueReturn.add(a);
			}
		}
		return ueReturn;
	}

	/**
	 * Cette fonction permet de retourner l'ensemble des UE ou un étudiant peut
	 * s'inscrire. On exclue par ailleurs les UE qu'il a déjà validé ainsi que les
	 * UE ou il n'aura pas les prérequis pour pouvoir s'y inscrire
	 * 
	 * @param e
	 * @return
	 */
	public static ArrayList<UE> ueInscriptionPossible(Etudiant e) {
		ArrayList<UE> listUeReturn = new ArrayList<UE>();
		ArrayList<UE> allListeUePossible = new ArrayList<UE>();
		ArrayList<UE> allUE = chargementCSV.collectionUE();
		ArrayList<UEValide> allUEValiderEtudiant = ueValideEtudiant(e);

		/*
		 * Pour commencer on récupére TOUT les UE ou l'étudiant peut être inscrits (même
		 * ceux qu'il a déjà validé)
		 */
		for (UE ueAValider : allUE) {
			// On vérifie que pour cet UE l'étudiant possède tout les prérequis
			if (inscriptionPossible(ueAValider, allUEValiderEtudiant)) {
				// Si c'est le cas on l'ajoute à notre collection
				allListeUePossible.add(ueAValider);
			}
		}

		/*
		 * Ensuite on reboucle les UE afin de supprimer ceux qu'il a déjà validé
		 */
		listUeReturn = (ArrayList<UE>) allListeUePossible.clone();
		for (UE a : allListeUePossible) {
			for (UEValide b : allUEValiderEtudiant) {
				if (a.getCodeIdentification().equals(b.getUEValidation().getCodeIdentification()) && b.isValider()) {
					listUeReturn.remove(a);
				}
			}
		}

		return listUeReturn;
	}

	/**
	 * Méthode qui retourne VRAI ou FAUX si l'étudiant à ou non l'ensemble des
	 * prérequis pour un UE
	 * 
	 * @param uePrerequis
	 * @param UEValider
	 * @return
	 */
	private static boolean inscriptionPossible(UE uePrerequis, ArrayList<UEValide> UEValider) {

		// On initialise à true si aucun prérequis n'est nécessaire
		boolean allPrerequis = true;
		for (UE prerequis : uePrerequis.getCollectionUE_Prerequis()) {
			allPrerequis = false;
			for (UEValide valider : UEValider) {
				if (valider.getUEValidation().getCodeIdentification().equals(prerequis.getCodeIdentification())) {
					allPrerequis = true;
					break;
				}
			}
			if (!allPrerequis) {
				return allPrerequis;
			}
		}

		return allPrerequis;
	}

}
