package fr.miage.toulouse.ProjetL3.Class.metier;

import java.util.ArrayList;

/**
 * Classe Parcours, correspond aux parcours auquel un étudiant s'est inscrit est
 * suit des études. <br>
 * Ce parcours est composé de plusieurs Mentions
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
	 * Constructeur de la classe Parcours, cette méthode est appelé lorsque l'on
	 * souhaite <i>instancier</i> un objet Parcours
	 * 
	 * @param nom            Correspond au nom du parcours, ce nom est unique
	 * @param duree          Correspond à la durée du parcours en année
	 * @param niveauParcours Correspond au niveau maximum qu'un étudiant peut
	 *                       atteindre en suivant ce parcours
	 */
	public Parcours(String nom, int duree, int niveauParcours) {
		this.setNomParcours(nom);
		this.setDureeParcours(duree);
		this.setNiveauParcours(niveauParcours);
		this.setCollectionMention(new ArrayList<Mention>());
	}

	/**
	 * Cette méthode <i>Get</i> permet de retourner le niveau du parcours
	 * 
	 * @return Un entier correspondant au niveau du parcours
	 */
	public int getNiveauParcours() {
		return niveauParcours;
	}

	/**
	 * Méthode <i>Set</i> qui permet de modifier le niveau du parcours
	 * 
	 * @param niveauParcours Correspond au nouveau niveau du parcours
	 */
	public void setNiveauParcours(int niveauParcours) {
		this.niveauParcours = niveauParcours;
	}

	/**
	 * Cette fonction <i>Get</i> permet de retourner le nom du parcours
	 * 
	 * @return Un String correspondant au nom du parcours
	 */
	public String getNomParcours() {
		return nomParcours;
	}

	/**
	 * Méthode <i>Set</i> qui permet de mettre à jour le nom du parcours
	 * 
	 * @param nomParcours Nouveau String qui correspond au nouveau nom du parcours
	 */
	public void setNomParcours(String nomParcours) {
		this.nomParcours = nomParcours;
	}

	/**
	 * Fonction <i>Get</i> qui permet de récupérer la durée du parcours
	 * 
	 * @return Un entier correspondant à la durée du parcours, exemple 5 = Bac+5
	 */
	public int getDureeParcours() {
		return dureeParcours;
	}

	/**
	 * Méthode <i>Set</i> qui permet de mettre à jour le niveau du parcours <br/>
	 * Exemple 5 = Bac+5
	 * 
	 * @param dureeParcours Entier correspondant à la durée du parcours
	 */
	public void setDureeParcours(int dureeParcours) {
		this.dureeParcours = dureeParcours;
	}

	/**
	 * Fonction <i>Get</i> qui permet de récupérer l'ensemble des <b>Mentions</b> qui
	 * sont présentes dans ce parcours. <br/>
	 * Retourne une liste (ArrayList) d'objets Mentions
	 * 
	 * @see Mention
	 * @return Une ArrayList d'objet Mention
	 */
	public ArrayList<Mention> getCollectionMention() {
		return CollectionMention;
	}

	/**
	 * Méthode <i>Set</i>, cette méthode permet de mettre à jour l'ensemble des
	 * Mentions présentes dans un parcours.
	 * 
	 * @see Mention
	 * @param collectionMention Correspond à la nouvelle liste des mentions que
	 *                          prendra le parcours
	 */
	public void setCollectionMention(ArrayList<Mention> collectionMention) {
		CollectionMention = collectionMention;
	}

	/**
	 * Cette méthode permet d'<i>ajouter</i> un objet Mention correspondant à une
	 * mention à notre liste de mention, présent dans l'objet Parcours correspondant
	 * à un parcours de l'université.
	 * 
	 * @see Mention
	 * @param m Correspond à un objet Mention, qui sera ajouté dans notre liste de
	 *          Mention
	 */
	public void addMention(Mention m) {
		this.CollectionMention.add(m);
	}

}
