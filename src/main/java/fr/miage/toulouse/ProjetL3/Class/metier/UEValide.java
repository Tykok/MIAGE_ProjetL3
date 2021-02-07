package fr.miage.toulouse.ProjetL3.Class.metier;

/**
 * Classe UEValide, elle permet avec un de définir pour un Etudiant, un UE, une
 * année et un semestre si celui-ci l'a validé ou non
 * 
 * @see Etudiant
 * @see UE
 *
 */
public class UEValide {

	private int annneeValidation;
	private boolean semestre;
	private boolean valider;
	private double moyenne;
	private UE UEValidation;
	private Etudiant EtudiantValidation;

	/**
	 * Constructeur de la classe UEValide
	 * 
	 * @see UEValide
	 * 
	 * @param anneeValidation
	 * @param semestre
	 * @param valider
	 * @param moyenne
	 * @param UEValidation
	 * @param EtudiantValidation
	 */
	public UEValide(int anneeValidation, boolean semestre, boolean valider, double moyenne, UE UEValidation,
			Etudiant EtudiantValidation) {
		this.annneeValidation = anneeValidation;
		this.setSemestre(semestre);
		this.setValider(valider);
		this.setMoyenne(moyenne);
		this.setUEValidation(UEValidation);
		this.setEtudiantValidation(EtudiantValidation);
	}

	/**
	 * Fonction Get qui permet de retourner l'année de validation de l'UE
	 * 
	 * @return
	 */
	public int getAnnneeValidation() {
		return annneeValidation;
	}

	/**
	 * Méthode Set qui permet de mettre à jour l'année de validation de l'UE
	 * 
	 * @param annneeValidation
	 */
	public void setAnnneeValidation(int annneeValidation) {
		this.annneeValidation = annneeValidation;
	}

	/**
	 * Fonction Get qui permet de retourner le semestre dans lequel l'UE a été
	 * validé
	 * 
	 * @return
	 */
	public boolean isSemestre() {
		return semestre;
	}

	/**
	 * Méthode Set qui permet de modifier le semestre de validaton de l'UE
	 * 
	 * @param semestre
	 */
	public void setSemestre(boolean semestre) {
		this.semestre = semestre;
	}

	/**
	 * Fonction Get qui permet de retourner si l'UE a été validé ou non par
	 * l'étudiant
	 * 
	 * @see Etudiant
	 * @return
	 */
	public boolean isValider() {
		return valider;
	}

	/**
	 * Méthode Set qui permet de modifier la réussite de l'étudiant à cet UE
	 * 
	 * @param valider
	 */
	public void setValider(boolean valider) {
		this.valider = valider;
	}

	/**
	 * Fonction Get qui permet de retourner la moyenne obtenu à cet UE par
	 * l'étudiant
	 * 
	 * @return
	 */
	public double getMoyenne() {
		return moyenne;
	}

	/**
	 * Méthode Set qui permet de mettre à jour la moyenne que l'étudiant à obtenu à
	 * cet UE
	 * 
	 * @param moyenne
	 */
	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}

	/**
	 * Fonction Get qui permet de retourner l'UE que l'étudiant aura validé
	 * 
	 * @see UE
	 * @return
	 */
	public UE getUEValidation() {
		return UEValidation;
	}

	/**
	 * Méthode Set qui permet de modifier l'UE que l'étudiant aura validé
	 * 
	 * @see UE
	 * @param uEValidation
	 */
	public void setUEValidation(UE uEValidation) {
		UEValidation = uEValidation;
	}

	/**
	 * Fonction Get qui permet de retourner l'objet Etudiant, soit l'étudiant qui
	 * aura validé cet UE
	 * 
	 * @see Etudiant
	 * @return
	 */
	public Etudiant getEtudiantValidation() {
		return EtudiantValidation;
	}

	/**
	 * Méthode Set qui permet de modifier l'étudiant qui aura validé cet UE
	 * 
	 * @see Etudiant
	 * @param etudiantValidation
	 */
	public void setEtudiantValidation(Etudiant etudiantValidation) {
		EtudiantValidation = etudiantValidation;
	}

}
