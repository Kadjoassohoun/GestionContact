package domain;

public interface IAddress {

	long getId();

	void setId(long id);

	String getStreet();

	void setStreet(String street);

	String getCity();

	void setCity(String city);

	String getZip();

	void setZip(String zip);

	String getCountry();

	void setCountry(String country);

}