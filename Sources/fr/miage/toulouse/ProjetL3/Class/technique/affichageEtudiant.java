package fr.miage.toulouse.ProjetL3.Class.technique;

import fr.miage.toulouse.ProjetL3.Class.metier.Etudiant;
import fr.miage.toulouse.ProjetL3.Class.metier.Mention;

/**
 * Classe héritant de la classe Etudiant, cette classe à pour objectif
 * d'<i>ajouter des éléments</i> dans notre liste d'affichage comme des
 * checkBox, ect...
 *
 */
public class affichageEtudiant extends Etudiant {

	// Attribut privé de la classe qui seront nécessaires lors de la génération des
	// liste en JavaFX
	private String nomMention;
	private String nomParcours;

	/**
	 * Constructeur de la classe affichageEtudiant, cette méthode ne prend en
	 * paramètre qu'un simple objet Etudiant
	 * 
	 * @see Etudiant
	 * @param a Objet Etudiant
	 */
	public affichageEtudiant(Etudiant a) {
		super(a.getNum(), a.getNom(), a.getPrenom(), a.getMention());
		this.nomMention = a.getMention().getNomMention();
		this.nomParcours = a.getMention().getParcoursMention().getNomParcours();
	}

	/**
	 * Méthode <i>Get</i> permettant de retourner le nom de la mention de l'étudiant
	 * 
	 * @see Mention
	 * @return String correspondant au nom de la mention
	 */
	public String getNomMention() {
		return nomMention;
	}

	/**
	 * Méthode <i>Get</i> permettant de récupérer le nom du parcours
	 * 
	 * @see Parcours
	 * @return String correspondant au nom du parcours
	 */
	public String getNomParcours() {
		return nomParcours;
	}

}
