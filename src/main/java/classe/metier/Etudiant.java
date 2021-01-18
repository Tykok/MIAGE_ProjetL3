package classe.metier;

public class Etudiant extends Personne {

	private String numEtudiant;

	public Etudiant(String nom, String prenom, String numE) {
		super(nom, prenom);
		this.numEtudiant = numE;
	}

	public String getNumEtudiant() {
		return numEtudiant;
	}

	public void setNumEtudiant(String numEtudiant) {
		this.numEtudiant = numEtudiant;
	}

	public static void main(String[] args) {

	}

}
