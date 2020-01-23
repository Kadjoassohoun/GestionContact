package domain;

import java.util.Set;

public interface IContactGroup {

	long getGroupId();

	void setGroupId(long groupId);

	String getGroupName();

	void setGroupName(String groupName);

	Set<Contact> getContacts();

	void setContacts(Set<Contact> contacts);

	void removeContact(long contactId);

	Boolean hasContact(IContact contact);

	int hashCode();

	boolean equals(Object obj);

	IContactGroup copy(IContactGroup contactGroup);

}