package fr.miage.toulouse.ProjetL3.Class.metier;

/**
 * Classe <i>Etudiant</i> héritant de la classe abstraite <i>Personne</i> <br/>
 * Cette classe permet d'instancier un <b>étudiant</b>
 * 
 * @see Personne
 *
 */
public class Etudiant extends Personne {

	/**
	 * Mention de l'étudiant
	 * @see Mention
	 */
	private Mention MentionEtudiant;

	/**
	 * Constructeur de la classe Etudiant, cette méthode permet d'<i>instancier</i>
	 * un objet Etudiant
	 * 
	 * @see Etudiant
	 * 
	 * @see Personne
	 * @param numEtudiant Numéro unique de l'étudiant
	 * @param nom         Nom de l'étudiant
	 * @param prenom      Prénom de l'étudiant
	 * @param nomM        Mention de l'étudiant, dans laquelle il est actuellement
	 *                    inscrit
	 */
	public Etudiant(String numEtudiant, String nom, String prenom, Mention nomM) {
		super(numEtudiant, nom, prenom);
		this.MentionEtudiant = nomM;
	}

	/**
	 * Fonction <i>Get</i> permettant de retourner la mention de l'étudiant
	 * 
	 * @return Un objet Mention, correspondant à la mention de l'étudiant
	 */
	public Mention getMention() {
		return MentionEtudiant;
	}

	/**
	 * Méthode <i>Set</i> qui permet de modifier la mention de l'étudiant
	 * 
	 * @see Mention
	 * @param MentionEtudiant Prend en compte la nouvelle mention de l'étudiant, le
	 *                        paramètre doit être un objet Mention
	 */
	public void setMention(Mention MentionEtudiant) {
		this.MentionEtudiant = MentionEtudiant;
	}

}
