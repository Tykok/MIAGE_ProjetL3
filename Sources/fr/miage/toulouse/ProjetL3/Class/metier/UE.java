package fr.miage.toulouse.ProjetL3.Class.metier;

import java.util.ArrayList;

import fr.miage.toulouse.ProjetL3.Class.technique.csv.chargementCSV;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

/**
 * Classe UE, elle fait référence à l'ensemble des UE (Cours) contenues dans une
 * ou plusieurs <i>Mentions</i> (objet Mention de la classe Mention).<br/>
 * Un UE est suivi par un ou plusieurs étudiants qui peuvent le valider ou non,
 * y être inscrits ou non en fonction des prérequis nécessaires.
 * 
 * @see Etudiant
 * @see Mention
 * @see UEValide
 */
public class UE {

	private String codeIdentification;
	private String nomUE;
	private int creditECT;
	private ArrayList<UE> collectionUE_Prerequis;

	/**
	 * Constructeur de la classe UE, permet d'<i>instancier</i> un objet UE.
	 * 
	 * @param codeId Correspond au code identifiant un UE
	 * @param nomUE  Correspond au nom basiquede l'UE
	 * @param credit Correspond au nombre de crédits qu'un étudiant peut obtenir
	 *               après avoir validé cet UE
	 */
	public UE(String codeId, String nomUE, int credit) {
		this.codeIdentification = codeId;
		this.nomUE = nomUE;
		this.creditECT = credit;
		this.collectionUE_Prerequis = new ArrayList<UE>();
	}

	@Override
	public String toString() {
		return "UE [codeIdentification=" + codeIdentification + ", nomUE=" + nomUE + ", creditECT=" + creditECT + "]";
	}

	/**
	 * Fonction <i>Get</i> qui permet de récupérer le code d'identification de l'UE.
	 * 
	 * @return Un String correspondant au code d'identification de l'UE
	 */
	public String getCodeIdentification() {
		return codeIdentification;
	}

	/**
	 * Méthode <i>Set</i> qui permet de mettre à jour le code d'identification le
	 * code de l'UE.
	 * 
	 * @param codeIdentification Nouveau String correspondant au code
	 *                           d'identification de l'UE
	 */
	public void setCodeIdentification(String codeIdentification) {
		this.codeIdentification = codeIdentification;
	}

	/**
	 * Fonction <i>Get</i> qui permet de retourner les crédits pouvant être obtenus
	 * par un étudiant dans cet UE.
	 * 
	 * @see Etudiant
	 * @return Un Entier correspondant au nombre d'ECT qu'un étudiant peut obtenir
	 */
	public int getCreditECT() {
		return creditECT;
	}

	/**
	 * Méthode <i>Set</i> qui permet de mettre à jour le nombre de crédits pouvant
	 * être obtenus par un étudiant au sein de cet UE
	 * 
	 * @see Etudiant
	 * 
	 * @param creditECT Correspond au nouvel Entier
	 */
	public void setCreditECT(int creditECT) {
		this.creditECT = creditECT;
	}

	/**
	 * Fonction <i>Get</i>, elle permet de retourner l'ensemble des UE prérequis
	 * pour qu'un étudiant puisse participer à cet UE. <br/>
	 * Cette méthode retourne une liste (ArrayList) d'ibjet UE.
	 * 
	 * @see Etudiant
	 * @return Une ArrayList d'objet UE
	 */
	public ArrayList<UE> getCollectionUE_Prerequis() {
		if (collectionUE_Prerequis.contains(null)) {
			collectionUE_Prerequis.remove(null);
		}
		return collectionUE_Prerequis;
	}

	/**
	 * Méthode <i>Set</i>, elle permet de mettre à jour l'ensemble des UE qui
	 * doivent être validés par un étudiant avant de participer à cet UE. <br/>
	 * Cette liste attend en paramètre la valeur null (pour aucun prérequis) ou une
	 * liste de prérequis si l'UE en question nécessite des UE prérequis.
	 * 
	 * @see Etudiant
	 * 
	 * @param collectionUE_Prerequis Prend en paramètre une ArrayList d'objet UE, ou
	 *                               la valeur null pour signifier qu'il n'y a aucun
	 *                               prérequis nécessaires
	 */
	public void setCollectionUE_Prerequis(ArrayList<UE> collectionUE_Prerequis) {
		this.collectionUE_Prerequis = collectionUE_Prerequis;
	}

	/**
	 * Méthode qui permet d'effectuer un <i>ajout d'un UE</i> dans la liste des
	 * prérequis à l'UE. <br/>
	 * <b>Attention</b>, un UE ne peut pas être son propre prérequis.
	 * 
	 * @see UE
	 * @param m Correspond à l'UE qui sera le prérequis de cet objet
	 */
	public void ajouterUEPrerequis(UE m) {
		this.collectionUE_Prerequis.add(m);
	}

	/**
	 * Méthode qui permet d'<i>enlever un UE</i> qui ne sera plus prérequis pour cet
	 * UE.
	 * 
	 * @param m Correspond à l'objet UE qui ne sera plus le prérequis de notre objet
	 *          UE appelant la méthode
	 */
	public void enleverUEPrerequis(UE m) {
		this.collectionUE_Prerequis.remove(m);
	}

	/**
	 * Fonction <i>Get</i>, qui retourne le nom de l'UE
	 * 
	 * @return Un String correspondant au nom de l'UE
	 */
	public String getNomUE() {
		return nomUE;
	}

	/**
	 * Méthode <i>Set</i>, elle permet de mettre à jour le nom de l'UE.
	 * 
	 * @param nomUE String correspondant au nouveau nom de l'UE
	 */
	public void setNomUE(String nomUE) {
		this.nomUE = nomUE;
	}

}
