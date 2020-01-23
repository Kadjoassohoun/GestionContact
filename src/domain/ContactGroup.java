package domain;

import java.util.HashSet;
import java.util.Set;

public class ContactGroup implements IContactGroup {

    private long groupId;
    private String groupName;
    private Set<Contact> contacts = new HashSet<>();

    public ContactGroup() {
    	
    }
	public ContactGroup(long groupId) {
		this.groupId = groupId;
	}

    public ContactGroup(long groupId, String groupName, Set<Contact> contacts) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.contacts = contacts;
    }

    @Override
	public long getGroupId() {
        return groupId;
    }

    @Override
	public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    @Override
	public String getGroupName() {
        return groupName;
    }

    @Override
	public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
	public Set<Contact> getContacts() {
    	return this.contacts;
    }

	@Override
	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public void removeContact(long contactId) {
		this.contacts.removeIf(contact -> contact.getId() == contactId);
	}

	@Override
	public Boolean hasContact(IContact contact) {
		return contacts.contains(contact);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contacts == null) ? 0 : contacts.hashCode());
		result = prime * result + (int) (groupId ^ (groupId >>> 32));
		result = prime * result + ((groupName == null) ? 0 : groupName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactGroup other = (ContactGroup) obj;
		if (contacts == null) {
			if (other.contacts != null)
				return false;
		} else if (!contacts.equals(other.contacts))
			return false;
		if (groupId != other.groupId)
			return false;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		return true;
	}
	

    @Override
	public IContactGroup copy(IContactGroup contactGroup) {
    	this.groupName = contactGroup.getGroupName();
    	this.contacts = contactGroup.getContacts();
    	return this;

    }
}

