package fr.miage.toulouse.ProjetL3.Class.metier;

/**
 * Classe abstraite Personne, classe mére des classes Connexion et Etudiant
 * 
 * @see Connexion
 * @see Etudiant
 * @author ElieTreport
 *
 */
public abstract class Personne {

	protected int num;
	protected String nom;
	protected String prenom;

	/**
	 * Constructeur protéger de la classe Personne
	 * 
	 * @param num
	 * @param nom
	 * @param prenom
	 */
	protected Personne(int num, String nom, String prenom) {
		this.num = num;
		this.nom = nom;
		this.prenom = prenom;
	}

	/**
	 * Fonction Get permettant de récupérer le numéro de la personne
	 * 
	 * @return
	 */
	protected int getNum() {
		return num;
	}

	/**
	 * Méthode Set permettant de mettre à jour le numéro de la personne
	 * 
	 * @param num
	 */
	protected void setNum(int num) {
		this.num = num;
	}

	/**
	 * Fonction Get qui permet de récupérer le nom de la personne
	 * 
	 * @return
	 */
	protected String getNom() {
		return nom;
	}

	/**
	 * Méthode Set qui permet de mettre à jour le nom de la personne
	 * 
	 * @param nom
	 */
	protected void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Méthode Get qui permet de récupérer le prénom de la personne
	 * 
	 * @return
	 */
	protected String getPrenom() {
		return prenom;
	}

	/**
	 * Méthode Set qui permet de mettre à jour le prénom de la personne
	 * 
	 * @param prenom
	 */
	protected void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
