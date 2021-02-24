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

	// Attribut privé de la classe qui seront nécessaires lors de la génération des
	// liste en JavaFX
	private String nomMention;
	private String nomParcours;

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
		this.nomMention = nomM.getNomMention();
		this.nomParcours = nomM.getParcoursMention().getNomParcours();
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

	/**
	 * @return the nomMention
	 */
	public String getNomMention() {
		return nomMention;
	}

	/**
	 * @param nomMention the nomMention to set
	 */
	public void setNomMention(String nomMention) {
		this.nomMention = nomMention;
	}

	/**
	 * @return the nomParcours
	 */
	public String getNomParcours() {
		return nomParcours;
	}

	/**
	 * @param nomParcours the nomParcours to set
	 */
	public void setNomParcours(String nomParcours) {
		this.nomParcours = nomParcours;
	}

}
