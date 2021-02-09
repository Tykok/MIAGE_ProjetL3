package fr.miage.toulouse.ProjetL3.Class.metier;

import java.util.ArrayList;

/**
 * Classe Mention, correspond à une mention que peut suivre un étudiant dans son
 * cursus Universitaire
 * 
 * @see Etudiant
 *
 */
public class Mention {

	private String nomMention;
	private ArrayList<UE> UEMention;

	/**
	 * Constructeur de la classe Mention
	 * 
	 * @param nom
	 */
	public Mention(String nom) {
		this.setNomMention(nom);
		this.setUEMention(new ArrayList<UE>());
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

	/**
	 * @return the uEMention
	 */
	public ArrayList<UE> getUEMention() {
		return UEMention;
	}

	/**
	 * @param uEMention the uEMention to set
	 */
	public void setUEMention(ArrayList<UE> uEMention) {
		UEMention = uEMention;
	}

}
