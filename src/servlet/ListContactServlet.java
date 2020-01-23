package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOContact;
import domain.Contact;

public class ListContactServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		DAOContact dao = new DAOContact();
		List listeContacte = new ArrayList<>();
		List<Contact> listContact = dao.getAllContacts();

		for (int i = 0; i < listContact.size(); i++) {
			
			Long id = listContact.get(i).getId();
			String firstName = listContact.get(i).getFirstName();
			String lastName = listContact.get(i).getLastName();
			String email = listContact.get(i).getEmail();
			
			List c = new ArrayList<>();
			c.add(id);
			c.add(firstName);
			c.add(lastName);
			c.add(email);

			listeContacte.add(c);

		}

		request.setAttribute("contactList", listeContacte);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListContact.jsp");
		dispatcher.forward(request, response);
	}

}