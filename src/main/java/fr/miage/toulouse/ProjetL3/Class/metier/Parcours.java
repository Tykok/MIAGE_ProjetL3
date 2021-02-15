package fr.miage.toulouse.ProjetL3.Class.metier;

import java.util.ArrayList;

/**
 * Classe Parcours, correspond aux parcours auquel un étudiant s'est inscrit est
 * suit des études. Ce parcours est composé de plusieurs Mentions
 * 
 * @see Etudiant
 * @see Mention
 */
public class Parcours {

	private String nomParcours;
	private int dureeParcours;
	private int niveauParcours;
	private ArrayList<Mention> CollectionMention;

	/**
	 * Constructeur de la classe Parcours
	 * 
	 * @param nom
	 * @param duree
	 * @param niveauParcours
	 */
	public Parcours(String nom, int duree, int niveauParcours) {
		this.setNomParcours(nom);
		this.setDureeParcours(duree);
		this.setNiveauParcours(niveauParcours);
		this.setCollectionMention(new ArrayList<Mention>());
	}

	/**
	 * @return Fonction Get qui permet de récupérer le niveau du parcours
	 */
	public int getNiveauParcours() {
		return niveauParcours;
	}

	/**
	 * @param Méthode Set qui permet de mettre à jour le niveau du parcours
	 */
	public void setNiveauParcours(int niveauParcours) {
		this.niveauParcours = niveauParcours;
	}

	/**
	 * @return Fonction Get qui permet de récupérer le nom du parcours
	 */
	public String getNomParcours() {
		return nomParcours;
	}

	/**
	 * @param Méthode Set qui permet de mettre à jour le nom du parcours
	 */
	public void setNomParcours(String nomParcours) {
		this.nomParcours = nomParcours;
	}

	/**
	 * @return Fonction Get qui permet de retourner la durée du parcours
	 */
	public int getDureeParcours() {
		return dureeParcours;
	}

	/**
	 * @param Méthode Set qui permet de mettr eà jour la durée du parcours
	 */
	public void setDureeParcours(int dureeParcours) {
		this.dureeParcours = dureeParcours;
	}

	/**
	 * @return Fonction Get, cette méthode retourne la collection des différentes
	 *         Mentions présentes dans ce parcours
	 */
	public ArrayList<Mention> getCollectionMention() {
		return CollectionMention;
	}

	/**
	 * @param Méthode Set, cette méthode permet de mettre à jour l'ensemble des
	 *                Mentions présentes dans un parcours
	 */
	public void setCollectionMention(ArrayList<Mention> collectionMention) {
		CollectionMention = collectionMention;
	}

	/**
	 * Cette méthode permet d'ajouter un objet Mention correspondant à une mention à
	 * notre objet Parcours correspondant à un parcours de l'université
	 * 
	 * @param m
	 */
	public void addMention(Mention m) {
		this.CollectionMention.add(m);
	}

}
