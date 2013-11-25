package com.facio.business;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.facio.domain.Book;

public class LibraryManagerTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test	
	public void testParameterBookNull() {
		
		exception.expect(NullPointerException.class);
		exception.expectMessage("Book must NOT be null");
		
		LibraryManager lib = new LibraryManager();
		
		lib.addBook(null);
	}

	@Test	
	public void testParameterTitleOfBookNull() {
		
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Title must NOT be null or empty");
		
		LibraryManager lib = new LibraryManager();
		
		lib.addBook(new Book());
	}

	@Test	
	public void testParameterTitleOfBookEmpty() {
		
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Title must NOT be null or empty");
		
		LibraryManager lib = new LibraryManager();
		Book b = new Book();
		b.setTitle("");
		lib.addBook(b);
	}
	
	@Test	
	public void testParameterPriceOfBookNull() {
		
		exception.expect(NullPointerException.class);
		exception.expectMessage("Price must NOT be null");
		
		LibraryManager lib = new LibraryManager();
		
		Book b = new Book();
		b.setTitle("Eu, Robô");
		lib.addBook(b);
	}

	@Test	
	public void testParameterAuthorOfBookNull() {
		
		exception.expect(NullPointerException.class);
		exception.expectMessage("Author must NOT be null");
		
		LibraryManager lib = new LibraryManager();
		
		Book b = new Book();
		b.setTitle("Eu, Robô");
		b.setPrice(10);
		
		lib.addBook(b);
	}
}
