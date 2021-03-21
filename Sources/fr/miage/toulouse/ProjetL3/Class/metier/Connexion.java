package fr.miage.toulouse.ProjetL3.Class.metier;

/**
 * Classe Connexion, permet d'instancier les différentes <i>personnes</i> qui
 * auront le droit de ce connecter à l'application. <br/>
 * <br/>
 * Cette classe hérite de la classe <b>Personne</b>
 * 
 * @see Personne
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
	 * @param num         Numéro permettant d'<i>identifier</i> de manière distincte
	 *                    la personne qui souhaite ce connecter
	 * @param nom         Nom de la personne qui ce connecte
	 * @param prenom      Prénom de la personne qui ce connecte
	 * @param identifiant Identifiant (login) de la personne, cet identifiant lui
	 *                    permet de ce connecter
	 * @param mdp         Mot de passe de la personne, lui permettant de
	 *                    s'authentifier
	 * @param droit       Droit d'accès à l'application, une personne n'a le droit
	 *                    d'accèder qu'à une partie des vues
	 */
	public Connexion(String num, String nom, String prenom, String identifiant, String mdp, String droit) {
		super(num, nom, prenom);
		this.identifiant = identifiant;
		this.mdp = mdp;
		this.droit = droit;
	}

	/**
	 * Fonction <i>Get</i> de l'identifiant
	 * 
	 * @return L'dientifiant de la personne
	 */
	public String getIdentifiant() {
		return identifiant;
	}

	/**
	 * Méthode <i>Set</i> de l'identifiant
	 * 
	 * @param identifiant Prend en compte le nouvel identifiant afin de le mettre à
	 *                    jour
	 */
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	/**
	 * Fonction <i>Get</i> du Mot de Passe
	 * 
	 * @return Le mot de passe de l'objet appelant cette méthode
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * Méthode <i>Set</i> du Mot de Passe
	 * 
	 * @param mdp Prend en compte le nouveau mot de passe pour écraser l'ancien mot
	 *            de passe
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * Fonction <i>Get</i> du rôle (droit) de la personne qui souhaite ce connecter
	 * 
	 * @return Retourne le droit que la personne a obtenu sur l'application
	 */
	public String getDroit() {
		return droit;
	}

	/**
	 * Méthode <i>Set</i> du rôle (droit) de la personne qui souhaite ce connecter
	 * 
	 * @param droit Permet de mettre à jour le droit de cette personne
	 */
	public void setDroit(String droit) {
		this.droit = droit;
	}

}
