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

	protected String num;
	protected String nom;
	protected String prenom;

	/**
	 * Constructeur protéger de la classe Personne
	 * 
	 * @param num
	 * @param nom
	 * @param prenom
	 */
	protected Personne(String num, String nom, String prenom) {
		this.num = num;
		this.nom = nom;
		this.prenom = prenom;
	}

	/**
	 * Fonction Get permettant de récupérer le numéro de la personne
	 * 
	 * @return
	 */
	public String getNum() {
		return num;
	}

	/**
	 * Méthode Set permettant de mettre à jour le numéro de la personne
	 * 
	 * @param num
	 */
	public void setNum(String num) {
		this.num = num;
	}

	/**
	 * Fonction Get qui permet de récupérer le nom de la personne
	 * 
	 * @return
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Méthode Set qui permet de mettre à jour le nom de la personne
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Méthode Get qui permet de récupérer le prénom de la personne
	 * 
	 * @return
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Méthode Set qui permet de mettre à jour le prénom de la personne
	 * 
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Personne [num=" + num + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

}
