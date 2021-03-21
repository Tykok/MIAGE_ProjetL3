package fr.miage.toulouse.ProjetL3.Class.metier;

/**
 * Classe UEValide. <br/>
 * Cette classe est la plus complexe de toute, elle permet avec un
 * <i>Etudiant</i> et un <i>UE</i> de savoir si oui ou non cet étudiant à validé
 * cet UE, s'il est toujours en cours de validation. <br/>
 * Cette classe est la classe centrale qui permettra de trier l'ensemble des UE,
 * en recherchant si l'étudiant à : <br/>
 * <ul>
 * <li>Valider ou non un UE</li>
 * <li>S'il est inscrit en ce moment à l'UE</li>
 * <li>De savoir si cet UE est validé, et permet donc à l'étudiant d'en valider
 * un autre</li>
 * </ul>
 * 
 * @see Etudiant
 * @see UE
 *
 */
public class UEValide {

	private int annneeValidation;
	private boolean semestre;
	private boolean valider;
	private boolean enCours;
	private UE UEValidation;
	private Etudiant EtudiantValidation;

	/**
	 * Constructeur de la classe UEValide, cette méthode permet d'<i>instancier</i>
	 * un nouvel objet UEValide
	 * 
	 * @see UEValide
	 * 
	 * @param anneeValidation    Correspond à l'année lors de laquel l'étudiant à
	 *                           valider ou non son UE
	 * @param semestre           Correspond au semestre de l'UE
	 * @param valider            Correspond à la validation ou non-validation de
	 *                           l'UE
	 * @param UEValidation       Correspond à l'UE qui est en cours de validation,
	 *                           ou valider par l'étudiant
	 * @param EtudiantValidation Correspond à l'étudiant qui a effectué l'ensemble
	 *                           des validations d'UE
	 */
	public UEValide(int anneeValidation, boolean semestre, boolean valider, boolean enCours, UE UEValidation,
			Etudiant EtudiantValidation) {
		this.annneeValidation = anneeValidation;
		this.setSemestre(semestre);
		this.setValider(valider);
		this.setEnCours(enCours);
		this.setUEValidation(UEValidation);
		this.setEtudiantValidation(EtudiantValidation);
	}

	/**
	 * Fonction <i>Get</i> qui permet de retourner l'année de validation de l'UE
	 * 
	 * @return Un entier qui correspond à l'année de validation de l'UE
	 */
	public int getAnnneeValidation() {
		return annneeValidation;
	}

	/**
	 * Méthode <i>Set</i> qui permet de mettre à jour l'année de validation de l'UE
	 * 
	 * @param annneeValidation
	 */
	public void setAnnneeValidation(int annneeValidation) {
		this.annneeValidation = annneeValidation;
	}

	/**
	 * Fonction <i>Get</i> qui permet de retourner le semestre dans lequel l'UE a
	 * été validé
	 * 
	 * @return Boléen correspondant au semestre, true = semestre 2 et false =
	 *         semestre 1.
	 */
	public boolean isSemestre() {
		return semestre;
	}

	/**
	 * Méthode <i>Set</i> qui permet de modifier le semestre de validaton de l'UE
	 * 
	 * @param semestre Modifie le semestre d'obtention de l'UE via le booléen donné
	 *                 en paramètre
	 */
	public void setSemestre(boolean semestre) {
		this.semestre = semestre;
	}

	/**
	 * Fonction <i>Get</i> qui permet de retourner si l'UE a été validé ou non par
	 * l'étudiant
	 * 
	 * @see Etudiant
	 * @return Booléen correspondant à la validation ou non-validation de l'UE
	 */
	public boolean isValider() {
		return valider;
	}

	/**
	 * Méthode <i>Set</i> qui permet de modifier la réussite de l'étudiant à cet UE
	 * 
	 * @param valider Booléen correspondant à la validation ou non-validation de
	 *                l'UE
	 */
	public void setValider(boolean valider) {
		this.valider = valider;
	}

	/**
	 * Fonction <i>Get</i> qui permet de retourner la moyenne obtenu à cet UE par
	 * l'étudiant
	 * 
	 * @return Booléen correspondant à l'UE qui est en cours ou non
	 */
	public boolean isEnCours() {
		return this.enCours;
	}

	/**
	 * Méthode <i>Set</i> qui permet de mettre à jour la moyenne que l'étudiant à
	 * obtenu à cet UE
	 * 
	 * @param moyenne
	 */
	public void setEnCours(boolean enCours) {
		this.enCours = enCours;
	}

	/**
	 * Fonction <i>Get</i> qui permet de retourner l'UE que l'étudiant aura validé
	 * 
	 * @see UE
	 * @return Objet UE correspondant à l'UE validé par l'étudiant
	 */
	public UE getUEValidation() {
		return UEValidation;
	}

	/**
	 * Méthode <i>Set</i> qui permet de modifier l'UE que l'étudiant aura validé
	 * 
	 * @see UE
	 * @param uEValidation Permet de modifier l'UE qu'aura validé un étudiant
	 */
	public void setUEValidation(UE uEValidation) {
		UEValidation = uEValidation;
	}

	/**
	 * Fonction <i>Get</i> qui permet de retourner l'objet Etudiant, soit l'étudiant
	 * qui aura validé cet UE
	 * 
	 * @see Etudiant
	 * @return Objet Etudiant de la classe Etudiant, correspondant à l'Etudiant qui
	 *         aura validé l'UE
	 */
	public Etudiant getEtudiantValidation() {
		return EtudiantValidation;
	}

	/**
	 * Méthode <i>Set</i> qui permet de modifier l'étudiant qui aura validé cet UE
	 * 
	 * @see Etudiant
	 * @param etudiantValidation Objet Etudiant, correspondant à l'Etudiant qui aura
	 *                           validé l'UE
	 */
	public void setEtudiantValidation(Etudiant etudiantValidation) {
		EtudiantValidation = etudiantValidation;
	}

}
