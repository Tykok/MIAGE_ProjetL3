package fr.miage.toulouse.ProjetL3.Class.metier;

/**
 * Classe Connexion, permet d'instancier les différentes personnes qui auront le
 * droit de ce connecter à l'application
 * 
 * @see Personne
 * @author ElieTreport
 *
 */
public class Connexion extends Personne {

	private String identifiant;
	private String mdp;
	private String droit;

	/**
	 * Constructeur de la classe Connexion
	 * 
	 * @see Personne
	 * @param num
	 * @param nom
	 * @param prenom
	 * @param numP
	 * @param identifiant
	 * @param mdp
	 * @param droit
	 */
	public Connexion(String num, String nom, String prenom, String identifiant, String mdp, String droit) {
		super(num, nom, prenom);
		this.identifiant = identifiant;
		this.mdp = mdp;
		this.droit = droit;
	}

	/**
	 * Fonction Get de l'identifiant
	 * 
	 * @return
	 */
	public String getIdentifiant() {
		return identifiant;
	}

	/**
	 * Méthode Set de l'identifiant
	 * 
	 * @param identifiant
	 */
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	/**
	 * Fonction Get du Mot de Passe
	 * 
	 * @return
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * Méthode Set du Mot de Passe
	 * 
	 * @param mdp
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * Fonction Get du rôle (droit) de la personne
	 * 
	 * @return
	 */
	public String getDroit() {
		return droit;
	}

	/**
	 * Méthode Set du rôle (droit) de la personne
	 * 
	 * @param droit
	 */
	public void setDroit(String droit) {
		this.droit = droit;
	}

}
