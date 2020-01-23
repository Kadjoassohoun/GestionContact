package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOContact;

public class DeleteContactServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DAOContact dao = new DAOContact();
		long id = Long.parseLong(request.getParameter("id"));
        dao.deleteContact(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ListContact.jsp");
		dispatcher.forward(request, response);
	}

}
