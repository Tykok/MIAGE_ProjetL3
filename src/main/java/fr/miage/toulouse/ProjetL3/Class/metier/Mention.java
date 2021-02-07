package fr.miage.toulouse.ProjetL3.Class.metier;

/**
 * Classe Mention, correspond à une mention que peut suivre un étudiant dans son
 * cursus Universitaire
 * 
 * @see Etudiant
 *
 */
public class Mention {

	private String nomMention;

	/**
	 * Constructeur de la classe Mention
	 * 
	 * @param nom
	 */
	public Mention(String nom) {
		this.setNomMention(nom);
	}

	/**
	 * Fonction Get qui permet de récupérer le nom de la mention
	 * 
	 * @return
	 */
	public String getNomMention() {
		return nomMention;
	}

	/**
	 * Fonction Set qui permet de mettre à jour le nom de la mention
	 * 
	 * @param nomMention
	 */
	public void setNomMention(String nomMention) {
		this.nomMention = nomMention;
	}

}
