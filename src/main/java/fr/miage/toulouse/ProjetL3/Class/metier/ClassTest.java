package fr.miage.toulouse.ProjetL3.Class.metier;

import com.opencsv.bean.CsvBindByName;

public class ClassTest {
	@CsvBindByName(column = "First Name", required = true)
	private String firstName;

	 @CsvBindByName(column = "Last Name", required = true)
	private String lastName;

	 @CsvBindByName(column = "1 visit only")
	private int visitsToWebsite;

	@Override
	public String toString() {
		return "ClassTest [firstName=" + firstName + ", lastName=" + lastName + ", visitsToWebsite=" + visitsToWebsite
				+ "]";
	}

	protected String getFirstName() {
		return firstName;
	}

	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	protected String getLastName() {
		return lastName;
	}

	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}

	protected int getVisitsToWebsite() {
		return visitsToWebsite;
	}

	protected void setVisitsToWebsite(int visitsToWebsite) {
		this.visitsToWebsite = visitsToWebsite;
	}

	public ClassTest(String firstName, String lastName, int visitsToWebsite) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.visitsToWebsite = visitsToWebsite;
	}
}
