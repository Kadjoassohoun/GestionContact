package domain;

import java.util.Set;

public interface IContact {

	String getFirstName();

	void setFirstName(String firstName);

	String getLastName();

	void setLastName(String lastName);

	String getEmail();

	void setEmail(String string);

	long getId();

	void setId(long l);

	Set<PhoneNumber> getPhones();

	void setPhones(IPhoneNumber pn);

	void addPhoneNumber(PhoneNumber phone);

	IAddress getAddress();

	void setAddress(IAddress address);

	Set<ContactGroup> getGroups();

	void setGroups(Set<ContactGroup> groups);

}