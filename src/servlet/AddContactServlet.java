package servlet;

import java.io.IOException;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOContact;
import domain.Address;
import domain.Contact;
import domain.ContactGroup;
import domain.Entreprise;
import domain.IAddress;
import domain.PhoneNumber;

public class AddContactServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DAOContact dao = new DAOContact();
		
		// contact
		
		String lastName = request.getParameter("LASTNAME");
		String firstName = request.getParameter("FIRSTNAME");
		String email = request.getParameter("EMAIL");

		// address
		
		String street = request.getParameter("STREET");
		String country = request.getParameter("COUNTRY");
		String city = request.getParameter("CITY");
		String zip = request.getParameter("ZIP");
		
		
		//phones
		
		String phoneKind = request.getParameter("PHONEKIND");
		String phoneNumber = request.getParameter("PHONENUMBER");

		IAddress address = new Address(street, city, zip, country);

		HashSet<PhoneNumber> pn = new HashSet<PhoneNumber>();

		PhoneNumber phonenumber = new PhoneNumber();
		phonenumber.setPhoneKind(phoneKind);
		phonenumber.setPhoneNumber(phoneNumber);
		pn.add(phonenumber);
		
		// groups
		
		String group = request.getParameter("GROUPNAME");

		HashSet<ContactGroup> gp = new HashSet<ContactGroup>();
		
		ContactGroup groups = new ContactGroup();
		groups.setGroupName(group);
		gp.add(groups);
		
		String numSiret = request.getParameter("NUMSIRET");

		Contact contact = new Contact(lastName, firstName, email, address, pn, gp);
		
		Entreprise e = new Entreprise();
		
		e.setLastName(lastName);
		e.setFirstName(firstName);
		e.setEmail(email);
		e.setAddress(address);
		e.setNumSiret(numSiret);
		
		if(numSiret != "" && !numSiret.isEmpty()) {
			
			dao.addEntreprise(e, pn, gp, numSiret);
			
		}else {
			dao.addContact(contact,pn,gp);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListContact.jsp");
		dispatcher.forward(request, response);

	}
}
