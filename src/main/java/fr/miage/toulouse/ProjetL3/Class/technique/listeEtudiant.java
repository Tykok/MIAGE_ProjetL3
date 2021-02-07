package fr.miage.toulouse.ProjetL3.Class.technique;

import fr.miage.toulouse.ProjetL3.Class.metier.Etudiant;
import fr.miage.toulouse.ProjetL3.Class.metier.Mention;
import fr.miage.toulouse.ProjetL3.Class.metier.Parcours;

public class listeEtudiant {

	private String numEtudiant;
	private String nom;
	private String prenom;
	private String mention;
	private String parcours;

	public listeEtudiant(Etudiant e, Mention m, Parcours p) {
		this.setNumEtudiant(e.getNum());
		this.setNom(e.getNom());
		this.setPrenom(e.getPrenom());
		this.setMention(m.getNomMention());
		this.setParcours(p.getNomParcours());
	}

	/**
	 * @return the numEtudiant
	 */
	public String getNumEtudiant() {
		return numEtudiant;
	}

	/**
	 * @param numEtudiant the numEtudiant to set
	 */
	public void setNumEtudiant(String numEtudiant) {
		this.numEtudiant = numEtudiant;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the mention
	 */
	public String getMention() {
		return mention;
	}

	/**
	 * @param mention the mention to set
	 */
	public void setMention(String mention) {
		this.mention = mention;
	}

	/**
	 * @return the parcours
	 */
	public String getParcours() {
		return parcours;
	}

	/**
	 * @param parcours the parcours to set
	 */
	public void setParcours(String parcours) {
		this.parcours = parcours;
	}

}
