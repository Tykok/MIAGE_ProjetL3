package fr.miage.toulouse.ProjetL3.Class.technique.fonction;

import java.util.ArrayList;
import java.util.Date;

import fr.miage.toulouse.ProjetL3.Class.metier.Etudiant;
import fr.miage.toulouse.ProjetL3.Class.metier.UE;
import fr.miage.toulouse.ProjetL3.Class.metier.UEValide;
import fr.miage.toulouse.ProjetL3.Class.technique.affichageEtudiant;
import fr.miage.toulouse.ProjetL3.Class.technique.csv.ajoutCSV;
import fr.miage.toulouse.ProjetL3.Class.technique.csv.chargementCSV;

public class utilsFunctionEtudiant {

	/**
	 * Cette méthode permet de retourner l'ensemble des étudiants qui ont l'UE en
	 * cours
	 * 
	 * @param ue
	 * @return
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
	 * 
	 * @param e
	 * @param ueClic
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
	 * Cette méthode permet de passer l'UE ou l'étudiant est inscrit à un UE qu'il a
	 * validé
	 * 
	 * @param e
	 * @param ueClic
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

		// On remet le fichier à 0
		ajoutCSV.reecritureUEValide();

		// On réécrit maintenant l'ensemble des UE
		for (UEValide u : listUeValide) {
			ajoutCSV.ajoutUeValidation(u);
		}

	}

}
