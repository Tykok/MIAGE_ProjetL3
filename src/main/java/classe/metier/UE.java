package classe.metier;

import java.util.ArrayList;

public class UE {

	private String codeIdentification;
	private int creditECT;
	private ArrayList<Mention> collectionMention_Prerequis;

	public UE(String codeId, int credit) {
		this.codeIdentification = codeId;
		this.creditECT = credit;
		this.collectionMention_Prerequis = new ArrayList<Mention>();
	}

	public String getCodeIdentification() {
		return codeIdentification;
	}

	public void setCodeIdentification(String codeIdentification) {
		this.codeIdentification = codeIdentification;
	}

	public int getCreditECT() {
		return creditECT;
	}

	public void setCreditECT(int creditECT) {
		this.creditECT = creditECT;
	}

	public ArrayList<Mention> getCollectionMention_Prerequis() {
		return collectionMention_Prerequis;
	}

	public void setCollectionMention_Prerequis(ArrayList<Mention> collectionMention_Prerequis) {
		this.collectionMention_Prerequis = collectionMention_Prerequis;
	}

	public void ajouterMentionPrerequis(Mention m) {
		this.collectionMention_Prerequis.add(m);
	}

	public void enleverMentionPrerequis(Mention m) {
		this.collectionMention_Prerequis.remove(m);
	}

	public static void main(String[] args) {

	}

}
