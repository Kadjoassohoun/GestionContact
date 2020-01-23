package domain;

public interface IPhoneNumber {

	long getId();

	void setId(long id);

	String getPhoneKind();

	void setPhoneKind(String phoneKind);

	String getPhoneNumber();

	void setPhoneNumber(String phoneNumber);

	IContact getContact();

	void setContact(IContact contact);

}