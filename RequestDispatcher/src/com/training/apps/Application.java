package com.training.apps;

import java.util.ArrayList;
import java.util.Iterator;

import com.training.daos.BookDAO;
import com.training.entity.Book;

public class Application {

	public static void main(String[] args) {
		BookDAO dao = new BookDAO();
		ArrayList<Book> bookList = dao.getAllBooks();
		for (Iterator<Book> iterator = bookList.iterator(); iterator.hasNext();) {
			Book book = (Book) iterator.next();
			System.out.println(book.toString());
		}

	}

}
