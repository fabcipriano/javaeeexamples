package com.facio.business.ws;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import com.facio.business.LibraryManager;
import com.facio.domain.Author;
import com.facio.domain.Book;

@Stateless
@WebService(name="LibraryWS",
		targetNamespace="http://www.facio.com.br")
public class LibraryService implements LibraryWS{
	
	@EJB
	private LibraryManager library;

	@Override
	public Long createBook(String title, Integer price, String author) {
		
		Book b = new Book();
		Author a = new Author();
		
		a.setName(author);
		
		b.setTitle(title);
		b.setPrice(price);
		
		a.addBook(b);
		
		library.addBook(b);
		
		return b.getId();
	}

}
