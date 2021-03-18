package fr.miage.toulouse.ProjetL3.Class.technique;

import fr.miage.toulouse.ProjetL3.Class.metier.Etudiant;
import fr.miage.toulouse.ProjetL3.Class.metier.Mention;

public class affichageEtudiant extends Etudiant {

	// Attribut privé de la classe qui seront nécessaires lors de la génération des
	// liste en JavaFX
	private String nomMention;
	private String nomParcours;

	public affichageEtudiant(Etudiant a) {
		super(a.getNum(), a.getNom(), a.getPrenom(), a.getMention());
		this.nomMention = a.getMention().getNomMention();
		this.nomParcours = a.getMention().getParcoursMention().getNomParcours();
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
