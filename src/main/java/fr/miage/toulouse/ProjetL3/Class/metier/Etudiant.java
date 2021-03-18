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

	private Mention MentionEtudiant;



	/**
	 * Constructeur de la classe Etudiant
	 * 
	 * @see Personne
	 * @param numEtudiant
	 * @param nom
	 * @param prenom
	 * @param numE
	 */
	public Etudiant(String numEtudiant, String nom, String prenom, Mention nomM) {
		super(numEtudiant, nom, prenom);
		this.MentionEtudiant = nomM;
	}

	/**
	 * @return the nomMention
	 */
	public Mention getMention() {
		return MentionEtudiant;
	}

	/**
	 * @param nomMention the nomMention to set
	 */
	public void setMention(Mention MentionEtudiant) {
		this.MentionEtudiant = MentionEtudiant;
	}

	/**
	 * @return the mentionEtudiant
	 */
	public Mention getMentionEtudiant() {
		return MentionEtudiant;
	}

	/**
	 * @param mentionEtudiant the mentionEtudiant to set
	 */
	public void setMentionEtudiant(Mention mentionEtudiant) {
		MentionEtudiant = mentionEtudiant;
	}




}
