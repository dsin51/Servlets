package com.training.ifaces;

import java.util.ArrayList;
import java.util.HashMap;

import com.training.entity.Book;

public interface DAO<T> {

	public ArrayList<Book> getAllBooks();
	public Book findBookById(long id);
}
