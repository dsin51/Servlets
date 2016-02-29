package com.training.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import com.training.entity.Book;
import com.training.ifaces.DAO;
import com.training.utils.SqlConnection;

public class BookDAO implements DAO<Book> {

	private Connection con;

	public BookDAO(Connection con) {
		System.out.println("Book DAO INitalized");
		this.con = con;
	}

	public BookDAO() {
		super();
		con = SqlConnection.getOracleConnection();
	}

	@Override
	public ArrayList<Book> getAllBooks() {

		String sql = "Select * from Book";
		ArrayList<Book> bookList = new ArrayList<Book>();
		Book book = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				long bookNumber = rs.getLong("booknumber");
				String bookName = rs.getString("bookname");
				String author = rs.getString("author");
				double price = rs.getDouble("price");
				
				book = new Book(bookNumber, bookName, author, price);
				bookList.add(book);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return bookList;
	}

	@Override
	public Book findBookById(long id) {
		
		String sql = "Select * from Book where booknumber=?";
		Book book = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				long bookNumber = rs.getLong("booknumber");
				String bookName = rs.getString("bookname");
				String author = rs.getString("author");
				double price = rs.getDouble("price");
				
				book = new Book(bookNumber, bookName, author, price);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return book;
	}

}
