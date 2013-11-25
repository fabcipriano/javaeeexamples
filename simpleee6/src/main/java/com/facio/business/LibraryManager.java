package com.facio.business;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.facio.dao.AuthorDAO;
import com.facio.domain.Author;
import com.facio.domain.Book;

@Stateless
public class LibraryManager implements Library{

	@EJB
	AuthorDAO aDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(LibraryManager.class);

	@Override
	public void addBook(Book b) {
		
		logger.info("begin addBook()");
		
		checkNotNull(b, "Book must NOT be null");
		checkArgument(!isNullOrEmpty(b.getTitle()), "Title must NOT be null or empty");
		checkNotNull(b.getPrice(), "Price must NOT be null");
		
		Author author = checkNotNull(b.getAuthor(), "Author must NOT be null");
		
		checkArgument(!isNullOrEmpty(author.getName()), "Author name cannot be null or empty");
		
		Author authorFound = aDAO.findByName(author.getName());
		
		if (authorFound != null) {
			/*add Book*/
		}
		
		logger.debug("end addBook()");
	}

}
