package edu.mum.cs.wap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.mum.cs.wap.model.Address;
import edu.mum.cs.wap.model.Person;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Address address = new Address("Iowa, US");
		Person p = new Person();
		p.setId(100001);
		p.setName("Tina");
		p.setAddress(address);

		request.setAttribute("person", p);

		Address address2 = new Address("Texas, US");
		Person p2 = new Person();
		p2.setId(100002);
		p2.setName("Rujuan");
		p2.setAddress(address2);
		request.getSession().setAttribute("person2", p2);

		response.addCookie(new Cookie("User.Cookie", "User1"));
		getServletContext().setAttribute("User.Cookie", "User1");

		request.getRequestDispatcher("home.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
