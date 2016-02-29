package com.training.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.daos.BookDAO;
import com.training.domains.BookManager;
import com.training.entity.Book;
import com.training.utils.SqlConnection;



/**
 * Servlet implementation class BookServlet
 */
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		  InputStream inStream =this.getClass().getClassLoader().getResourceAsStream("DBConnection.properties");
		  System.out.println("instream "+inStream);
		   Connection con= SqlConnection.getOracleConnection(inStream);	
		   
		   System.out.println("Connnection ======"+con);
		      
		BookDAO dao = new BookDAO(con);
		ArrayList<Book> bookList = dao.getAllBooks();

		request.setAttribute("foundBooks", bookList);

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ShowBooks.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
