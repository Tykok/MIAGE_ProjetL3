package classe.metier;

public class Connexion extends Personne {

	private int numPersonnel;
	private String identifiant;
	private String mdp;
	private String droit;

	protected Connexion(String nom, String prenom, int numP, String identifiant, String mdp, String droit) {
		super(nom, prenom);
		this.numPersonnel = numP;
		this.identifiant = identifiant;
		this.mdp = mdp;
		this.droit = droit;
	}

	/**
	 * Cette méthode permet de vérifier que l'identifiant et le mot de passe fourni
	 * sont bel et bien correct
	 * 
	 * @param identifiant Identifiant entré par l'utiliser
	 * @param mdp         Mot de passe entré par l'utiliser
	 * @return Une valeur booléenne
	 */
	public boolean verifConnexion(String identifiant, String mdp) {
		String idTest = "Admin";
		String mdpTest = "Admin";
		return (identifiant.equals(idTest) && mdp.equals(mdpTest));
	}

	public int getNumPersonnel() {
		return numPersonnel;
	}

	public void setNumPersonnel(int numPersonnel) {
		this.numPersonnel = numPersonnel;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getDroit() {
		return droit;
	}

	public void setDroit(String droit) {
		this.droit = droit;
	}

	public static void main(String[] args) {

	}

}
