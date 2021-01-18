package classe.metier;

public abstract class Personne {

	protected String nom;
	protected String prenom;

	protected Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	protected String getNom() {
		return nom;
	}

	protected void setNom(String nom) {
		this.nom = nom;
	}

	protected String getPrenom() {
		return prenom;
	}

	protected void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
