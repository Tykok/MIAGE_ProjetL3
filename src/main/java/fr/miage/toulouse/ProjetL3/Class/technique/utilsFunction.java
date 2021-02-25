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
	 * 
	 * @param e
	 * @return
	 */
	private static ArrayList<UEValide> ueValideEtudiant(Etudiant e) {
		ArrayList<UEValide> collectionUEValide = chargementCSV.collectionUEValide();
		ArrayList<UEValide> ueValideReturn = new ArrayList<UEValide>();

		for (UEValide a : collectionUEValide) {
			if (a.getEtudiantValidation().getNum().equals(e.getNum())) {
				ueValideReturn.add(a);
			}
		}
		return ueValideReturn;
	}

	public static ArrayList<UE> ueInscriptionPossible(Etudiant e) {
		ArrayList<UE> listUeReturn = new ArrayList<UE>();
		ArrayList<UE> ensembleUE = chargementCSV.collectionUE();
		ArrayList<UEValide> ensembleUEValider = ueValideEtudiant(e);

		return listUeReturn;
	}

	private static boolean inscriptionPossible(ArrayList<UE> uePrerequis, ArrayList<UE> UEValider) {
		// TODO Méthode à construire !!!
	}

}
