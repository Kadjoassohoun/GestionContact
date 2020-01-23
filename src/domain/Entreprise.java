package domain;

import java.util.Set;

public class Entreprise extends Contact {

	private String numSiret;
	
	public Entreprise() {
		
	}
	
	public Entreprise(String lastName, String firstName, String email, IAddress address, 
			Set<PhoneNumber> phones, Set<ContactGroup> groups, String numSiret) {
		
		super(lastName,firstName,email ,address, phones, groups );
		this.numSiret = numSiret;
	}

	@Override
	public String toString() {
		return "Entreprise [numSiret=" + numSiret + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getEmail()=" + getEmail() + ", getId()=" + getId() + ", getPhones()=" + getPhones()
				+ ", getAddress()=" + getAddress() + ", getGroups()=" + getGroups() + "]";
	}

	public String getNumSiret() {
		return numSiret;
	}

	public void setNumSiret(String numSiret) {
		this.numSiret = numSiret;
	}
	
	
		
}
