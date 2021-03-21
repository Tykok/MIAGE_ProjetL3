package fr.miage.toulouse.ProjetL3.Class.metier;

import java.util.ArrayList;

/**
 * 
 * Classe Mention, cette classe correspond à une mention que peut suivre un
 * <i>Etudiant</i>dans son cursus Universitaire et qui appartient à un et un
 * seul <i>Parcours</i>
 * 
 * @see Etudiant
 * @see Parcours
 *
 *
 */
public class Mention {

	private String nomMention;
	private ArrayList<UE> UEMention;
	private Parcours parcoursMention;

	/**
	 * Constructeur de la classe Mention, il permet d'<i>instancier</i> un objet
	 * Mention
	 * 
	 * @see Parcours
	 * @param nom Correspond au nom de la mention
	 * @param p   Correspond à l'objet Parcours de la mention, c'est le parcours
	 *            auquel appartient la mention
	 */
	public Mention(String nom, Parcours p) {
		this.setNomMention(nom);
		this.setUEMention(new ArrayList<UE>());
		this.parcoursMention = p;
	}

	/**
	 * Fonction <i>Get</i>, elle permet de retourner le parcours correspondant à la
	 * mention
	 * 
	 * @see Parcours
	 * @return Retourne un objet Parcours
	 */
	public Parcours getParcoursMention() {
		return parcoursMention;
	}

	/**
	 * Permet de modifier le parcours correspondant à la mention du parcours
	 * 
	 * @see Parcours
	 * @param parcoursMention Objet Parcours
	 */
	public void setParcoursMention(Parcours parcoursMention) {
		this.parcoursMention = parcoursMention;
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
	 * Méthode <i>Set</i> qui permet de mettre à jour le nom de la mention
	 * 
	 * @param nomMention Nom de la mention qui sera modifier
	 */
	public void setNomMention(String nomMention) {
		this.nomMention = nomMention;
	}

	/**
	 * Fonction <i>Get</i> qui permet de retourner l'ensemble des UE appartenant à
	 * une mention
	 * 
	 * @see UE
	 * 
	 * @return Une liste des UE, appartenant à la mention qui fait appel à cette
	 *         méthodes
	 */
	public ArrayList<UE> getUEMention() {
		return UEMention;
	}

	/**
	 * Méthode <i>Set</i>, elle permet de modifier la liste des UE qui sont
	 * disponibles dans cette mention
	 * 
	 * @see UE
	 * @param uEMention Prend une ArrayList d'UE en paramètre
	 */
	public void setUEMention(ArrayList<UE> uEMention) {
		UEMention = uEMention;
	}

}
