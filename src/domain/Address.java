package domain;

public class Address implements IAddress {

    private long id;
    private String street;
    private String city;
    private String zip;
    private String country;

    public Address() {
    }

    public Address(String country, String city, String street, String zip) {
    	
        this.country = country;
        this.city = city;
        this.street = street;
        this.zip = zip;
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
	public String getStreet() {
        return street;
    }

    @Override
	public void setStreet(String street) {
        this.street = street;
    }

    @Override
	public String getCity() {
        return city;
    }

    @Override
	public void setCity(String city) {
        this.city = city;
    }

    @Override
	public String getZip() {
        return zip;
    }

    @Override
	public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
	public String getCountry() {
        return country;
    }

    @Override
	public void setCountry(String country) {
        this.country = country;
    }
}

