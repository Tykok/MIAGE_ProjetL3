package fr.miage.toulouse.ProjetL3.Class.metier;

/**
 * Classe Etudiant héritant de la classe abstraite Personne, elle permet
 * d'instancier un étudiant
 * 
 * @see Personne
 * @author ElieTreport
 *
 */
public class Etudiant extends Personne {

	/**
	 * Constructeur de la classe Etudiant
	 * @see Personne
	 * @param numEtudiant
	 * @param nom
	 * @param prenom
	 * @param numE
	 */
	public Etudiant(int numEtudiant, String nom, String prenom, String numE) {
		super(numEtudiant, nom, prenom);
	}

}
