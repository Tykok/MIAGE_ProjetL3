package fr.miage.toulouse.ProjetL3.Class.metier;

/**
 * Classe abstraite Personne, cette classe est la classe mére des classes
 * <i>Connexion</i> et <i>Etudiant</i>
 * 
 * @see Connexion
 * @see Etudiant
 *
 */
public abstract class Personne {

	protected String num;
	protected String nom;
	protected String prenom;

	/**
	 * Constructeur protéger de la classe Personne, il a pour vocation d'être
	 * réutilisé au sein des classes <i>Connexion</i> et <i>Etudiant</i>.
	 * 
	 * @param num    Correspond au numéro identifiant la personne
	 * @param nom    Correspond au nom de la personne
	 * @param prenom Correspond au prénom de la personne
	 */
	protected Personne(String num, String nom, String prenom) {
		this.num = num;
		this.nom = nom;
		this.prenom = prenom;
	}

	/**
	 * Fonction <i>Get</i> permettant de récupérer le numéro de la personne
	 * 
	 * @return String correspond au numéro unique de la personne
	 */
	public String getNum() {
		return num;
	}

	/**
	 * Méthode <i>Set</i> permettant de mettre à jour le numéro de la personne
	 * 
	 * @param num Nouveau String correspondant au numéro de la personne
	 */
	public void setNum(String num) {
		this.num = num;
	}

	/**
	 * Fonction <i>Get</i> qui permet de récupérer le nom de la personne
	 * 
	 * @return Un String correspondant au nom de la personne
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Méthode <i>Set</i> qui permet de mettre à jour le nom de la personne
	 * 
	 * @param nom Nouveau String correspondant au nouveau nom de la personne
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Méthode <i>Get</i> qui permet de récupérer le prénom de la personne
	 * 
	 * @return Un String qui correspond au prénom de la personne
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Méthode <i>Set</i> qui permet de mettre à jour le prénom de la personne
	 * 
	 * @param prenom Correspond au nouveau prénom de la personne
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Personne [num=" + num + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

}
