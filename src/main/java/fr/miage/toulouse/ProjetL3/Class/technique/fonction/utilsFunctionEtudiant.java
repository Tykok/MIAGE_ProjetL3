package fr.miage.toulouse.ProjetL3.Class.technique.fonction;

import java.util.ArrayList;
import java.util.Date;

import fr.miage.toulouse.ProjetL3.Class.metier.Etudiant;
import fr.miage.toulouse.ProjetL3.Class.metier.UE;
import fr.miage.toulouse.ProjetL3.Class.metier.UEValide;
import fr.miage.toulouse.ProjetL3.Class.technique.affichageEtudiant;
import fr.miage.toulouse.ProjetL3.Class.technique.csv.ajoutCSV;
import fr.miage.toulouse.ProjetL3.Class.technique.csv.chargementCSV;

/**
 * Classe technique, elle permet d'avoir des fonctions nécessaires à la
 * manipulation des objets et collection de la classe Etudiant
 * 
 * @see Etudiant
 */
public class utilsFunctionEtudiant {

	/**
	 * Cette fonction permet de <i>retourner l'ensemble des étudiants qui ont l'UE
	 * en cours</i>
	 * 
	 * @see Etudiant
	 * @see UE
	 * @param ue Objet UE qu'on souhaite retrouver
	 * @return Une liste d'étudiants ayant l'UE en cours
	 */
	public static ArrayList<affichageEtudiant> etudiantInscrit(UE ue) {
		ArrayList<affichageEtudiant> etudiantListe = new ArrayList<affichageEtudiant>();
		for (Etudiant a : chargementCSV.collectionEtudiant()) {
			if (utilsFunctionUe.verifThisUeEncCours(a, ue)) {
				etudiantListe.add(new affichageEtudiant(a));
			}
		}
		return etudiantListe;
	}

	/**
	 * Cette méthode permet aux contrôleurs ListeEtudiant_BureauExamController
	 * d'inscrire un étudiant et de le sauvegarder au sein du fichier CSV respectif
	 * 
	 * @see ajoutCSV
	 * 
	 * @param e      Correspond à l'étudiant qui doit être enregistrer
	 * @param ueClic Correspond à l'UE ou l'on souhaite inscrire l'étudiant
	 */
	public static void inscriptionEtudiant(affichageEtudiant e, UE ueClic) {
		Etudiant a = new Etudiant(e.getNum(), e.getNom(), e.getPrenom(), e.getMention());
		Date d = new Date();
		UEValide b;
		if (d.getMonth() > 6) {
			b = new UEValide(d.getYear(), false, false, false, ueClic, a);
		} else {
			b = new UEValide(d.getYear(), true, false, false, ueClic, a);
		}
		ajoutCSV.ajoutUeValidation(b);
	}

	/**
	 * Cette méthode permet de passer l'UE qu'un étudiant passé à un état "validé"
	 * 
	 * @see Etudiant
	 * @see UE
	 * @param e      Correspond à l'étudiant qui aura validé l'UE
	 * @param ueClic Correspond à l'UE qu'aura validé l'étudiant
	 */
	public static void validationUeEtudiant(affichageEtudiant e, UE ueClic) {
		ArrayList<UEValide> listUeValide = chargementCSV.collectionUEValide();
		for (UEValide a : listUeValide) {
			if (a.getEtudiantValidation().getNum().equals(e.getNum())
					&& a.getUEValidation().getCodeIdentification().equals(ueClic.getCodeIdentification())) {
				a.setValider(true);
				a.setEnCours(false);
			}
		}

		// On réécrit maintenant l'ensemble des UE
		for (UEValide u : listUeValide) {
			ajoutCSV.ajoutUeValidation(u);
		}

	}

}
