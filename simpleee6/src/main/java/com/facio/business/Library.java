package com.facio.business;

import javax.ejb.Remote;

import com.facio.domain.Book;

@Remote
public interface Library {
	
	public void addBook(Book b);
	
	

}
