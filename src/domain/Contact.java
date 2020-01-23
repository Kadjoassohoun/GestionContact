package domain;

import java.util.HashSet;
import java.util.Set;

public class Contact implements IContact {

	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private IAddress address;
	private Set<PhoneNumber> phones = new HashSet<PhoneNumber>();
	private Set<ContactGroup> groups = new HashSet<ContactGroup>();


	public Contact() {
		// TODO Auto-generated constructor stub
	}


	public Contact(String lastName, String firstName, String email, IAddress address, Set<PhoneNumber> phones, Set<ContactGroup> groups) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.address = address;
		this.phones=phones;
		this.groups = groups;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String string) {
		email = string;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long l) {
		id = l;
	}

	@Override
	public Set<PhoneNumber> getPhones() {
		return phones;
	}

	@Override
	public void setPhones(Set<PhoneNumber> phoneNumbers) {
		if (phoneNumbers != null)
			phones = phoneNumbers;
	}

	@Override
	public void addPhoneNumber(PhoneNumber phone) {
		if (phone != null) {
			this.phones.add(phone);
			phone.setContact(this);
		}
	}

	@Override
	public IAddress getAddress() {
		return address;
	}

	@Override
	public void setAddress(IAddress address) {
		this.address = address;
	}


	@Override
	public Set<ContactGroup> getGroups() {
		return groups;
	}


	@Override
	public void setGroups(Set<ContactGroup> groups) {
		this.groups = groups;
	}

	


}
