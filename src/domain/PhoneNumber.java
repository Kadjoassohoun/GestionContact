package domain;


public class PhoneNumber implements IPhoneNumber {
	
    private long id;
    private String phoneKind;
    private String phoneNumber;
    private IContact contact;

    public PhoneNumber() {
    	
    }

    public PhoneNumber(IContact contact) {
        phoneKind = null;
        phoneNumber = null;
        this.contact = contact;
    }

    public PhoneNumber(long id, String phoneNumber, String phoneKind) {
        this.id = id;
        this.phoneKind = phoneKind;
        this.phoneNumber = phoneNumber;
        this.contact = null;
    }

    public PhoneNumber(long id, String phoneNumber, String phoneKind, IContact contact) {
        this.id = id;
        this.phoneKind = phoneKind;
        this.phoneNumber = phoneNumber;
        this.contact = contact;
    }

    @Override
	public long getId() {
        return id;
    }

    @Override
	public void setId(long id) {
        this.id = id;
    }

    @Override
	public String getPhoneKind() {
        return phoneKind;
    }

    @Override
	public void setPhoneKind(String phoneKind) {
        this.phoneKind = phoneKind;
    }

    @Override
	public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
	public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
	public IContact getContact() {
        return contact;
    }

    @Override
	public void setContact(IContact contact) {
        if (contact != null) {
            this.contact = contact;
        }
    }

}
