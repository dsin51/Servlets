package com.training.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Authenticate
 */
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Authenticate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("username");
		String pass = request.getParameter("pass");

		request.setAttribute("name", name);
		request.setAttribute("pass", pass);
		
		HttpSession session = request.getSession();
		session.setAttribute("user", name);

		RequestDispatcher dispatcher = request.getRequestDispatcher("Welcome.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("username");
		String pass = request.getParameter("pass");

		request.setAttribute("name", name);
		request.setAttribute("pass", pass);
		
		HttpSession session = request.getSession();
		session.setAttribute("user", name);

		response.sendRedirect("Welcome.jsp");
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("Welcome.jsp");
//		dispatcher.forward(request, response);
		
	}

}
